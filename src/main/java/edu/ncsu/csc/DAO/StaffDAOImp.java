package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.ServiceDept;
import edu.ncsu.csc.model.Staff;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffDAOImp extends AbstractDAO implements TemplateDAO<Staff> {

    public Staff getStaffByNameAndDob(String lastName, Date dob) {
        Staff staff = null;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from STAFFS where last_name = ? and dob = ?");
            preparedStatement.setString(1, lastName);
            preparedStatement.setDate(2, new java.sql.Date(dob.getTime()));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                staff = new Staff(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getBoolean("is_medical"),
                        resultSet.getDate("dob"),
                        resultSet.getDate("hire_date"),
                        resultSet.getString("primary_dept_code")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return staff;
    }
    public List<Staff> getWorkmates(Staff staff) {
        List<Staff> mates = null;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from STAFFS where primary_dept_code=? " +
                            "UNION select * from STAFFS where employee_id in (select employee_id from staff_seco_works_dept where dept_code=? )");
            preparedStatement.setString(1, staff.getPrimaryDeptCode());
            preparedStatement.setString(2, staff.getPrimaryDeptCode());
            resultSet = preparedStatement.executeQuery();
//            if(resultSet.next())
//            {
//                int facilityId=resultSet.getInt("facility_id");
//            }
            while (resultSet.next()) {
                staff = new Staff(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getBoolean("is_medical"),
                        resultSet.getDate("dob"),
                        resultSet.getDate("hire_date"),
                        resultSet.getString("primary_dept_code")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return mates;
    }

    public List<Staff> getReferralList(Staff staff) {
        List<Staff> mates = new ArrayList<Staff>();
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from STAFFS where primary_dept_code=? " +
                            "UNION select * from STAFFS where employee_id in (select employee_id from staff_seco_works_dept where dept_code=? )");
            preparedStatement.setString(1, staff.getPrimaryDeptCode());
            preparedStatement.setString(2, staff.getPrimaryDeptCode());
            resultSet = preparedStatement.executeQuery();
//            if(resultSet.next())
//            {
//                int facilityId=resultSet.getInt("facility_id");
//            }
            while (resultSet.next()) {
                mates.add(new Staff(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getBoolean("is_medical"),
                        resultSet.getDate("dob"),
                        resultSet.getDate("hire_date"),
                        resultSet.getString("primary_dept_code"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return mates;
    }

    public List<BodyPart> getBodysCanTreatByStaff(Staff staff){
    	List<BodyPart> bodys=new ArrayList<BodyPart>();
    	try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from body_parts where body_code in "
                    		+ "(select body_code from dept_has_body_part where dept_code in "
                    		+ "(select primary_dept_code from Staffs S where S.employee_id=? UNION select dept_code from staff_seco_works_dept where employee_id=?)"
                    		+ ")");
            preparedStatement.setInt(1, staff.getEmployeeId());
            preparedStatement.setInt(2, staff.getEmployeeId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            	bodys.add(new BodyPart(resultSet.getString("body_code"),resultSet.getString("body_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return bodys;
    }
    public boolean staffInFacility(int facilityId,Staff staff){
        boolean rest = false;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("(select STAFFS.employee_id from STAFFS,facility_has_dept where STAFFS.primary_dept_code= ? and facility_has_dept.facility_id = ? and STAFFS.primary_dept_code = facility_has_dept.dept_code)" +
                            "UNION (select s.employee_id from STAFFS s, staff_seco_works_dept sd, facility_has_dept f where s.employee_id = sd.employee_id " +
                            "and sd.dept_code = f.dept_code and f.facility_id = ? and s.employee_id = ?)");
            preparedStatement.setString(1, staff.getPrimaryDeptCode());
            preparedStatement.setInt(2, facilityId);
            preparedStatement.setInt(3, facilityId);
            preparedStatement.setInt(4, staff.getEmployeeId());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
            	rest=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return rest;
    }

    /**
     * Get all depts a staff belongs to.
     **/
    public List<ServiceDept> getAllDepts(Staff s) {
        List<ServiceDept> secondaryDepts = getAllSecondaryDepts(s);
        ServiceDept primaryDept = getPrimaryDept(s);
        secondaryDepts.add(primaryDept);
        return secondaryDepts;
    }

    public ServiceDept getPrimaryDept(Staff s) {
        ServiceDeptDAOImp deptDao = new ServiceDeptDAOImp();
        return deptDao.getOneById(s.getPrimaryDeptCode());
    }

    public List<ServiceDept> getAllSecondaryDepts(Staff s) {
        List<ServiceDept> depts = new ArrayList<>();
        List<String> codes = new ArrayList<>();
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select dept_code from staff_seco_works_dept where employee_id = ?");
            preparedStatement.setInt(1, s.getEmployeeId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String dept_code = resultSet.getString("dept_code");
                codes.add(dept_code);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        /* Find all ServiceDept corresponding to code. */
        ServiceDeptDAOImp deptDao = new ServiceDeptDAOImp();
        for (String code : codes) {
            ServiceDept dept = deptDao.getOneById(code);
            depts.add(dept);
        }
        return depts;
    }

    @Override
    public boolean addOneValue(Staff p) {
        return false;
    }

    @Override
    public List<Staff> getAllValues() {
        List<Staff> mates=new ArrayList<Staff>();
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from STAFFS ");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mates.add(new Staff(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getBoolean("is_medical"),
                        resultSet.getDate("dob"),
                        resultSet.getDate("hire_date"),
                        resultSet.getString("primary_dept_code")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return mates;
    }

    @Override
    public List<Staff> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public Staff getOneByQuery(String queryStr) {
        Staff staff = null;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from STAFFS where "+queryStr);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                staff = new Staff(
                        resultSet.getInt("employee_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getBoolean("is_medical"),
                        resultSet.getDate("dob"),
                        resultSet.getDate("hire_date"),
                        resultSet.getString("primary_dept_code")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return staff;
    }

    @Override
    public Staff getOneById(int id) {
        return null;
    }

    @Override
    public Staff getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(Staff p) {
        return false;
    }

    @Override
    public boolean deleteRecord(Staff p) {
        return false;
    }
}
