package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeverityDAOImp extends AbstractDAO implements TemplateDAO<Severity> {

  public List<Severity> getAllBySymCode(String symCode) {
    List<Severity> severities = new ArrayList<Severity>();

    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("select * from severities where SYM_CODE = ?");
      preparedStatement.setString(1, symCode);
      resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet.toString());
      while (resultSet.next()) {
        severities.add(new Severity(resultSet.getInt(1), resultSet.getInt(2)
            , resultSet.getString(3), resultSet.getString(4)));
      }

    } catch (SQLException e) {
      System.out.println("SQL Expection");
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return severities;
  }

  public boolean addSeverity(Severity severity) {
    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("INSERT INTO severities (SYM_CODE, SCALE) values (?,?)");

      preparedStatement.setString(1, severity.getName());
      preparedStatement.setString(2, severity.getScale());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      closeConnection();
      e.printStackTrace();
      return false;
    } finally {
      closeConnection();
    }
    return true;
  }

  public boolean setPriority(Severity severity, int value) {
    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("update SEVERITIES set PRIORITY = ?" +
              "where SYM_CODE = ? and scale  = ?");
      preparedStatement.setInt(1, value);
      preparedStatement.setString(2, severity.getName());
      preparedStatement.setString(3, severity.getScale());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      closeConnection();
      e.printStackTrace();
      return false;
    } finally {
      closeConnection();
    }
    return true;
  }

  @Override
  public boolean addOneValue(Severity p) {
    return false;
  }

  @Override
  public List<Severity> getAllValues() {
    List<Severity> severities = new ArrayList<Severity>();

    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("select * from severities");
      resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet.toString());
      while (resultSet.next()) {
        severities.add(new Severity(resultSet.getInt(1), resultSet.getInt(2)
            , resultSet.getString(3), resultSet.getString(4)));
      }

    } catch (SQLException e) {
      System.out.println("SQL Expection");
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return severities;
  }

  @Override
  public List<Severity> getBatchByQuery(String queryStr) {
    return null;
  }

  @Override
  public Severity getOneByQuery(String queryStr) {
    return null;
  }

  @Override
  public Severity getOneById(int id) {
    return null;
  }

  @Override
  public Severity getOneById(String id) {
    return null;
  }

  @Override
  public boolean updateValue(Severity p) {
    return false;
  }

  @Override
  public boolean deleteRecord(Severity p) {
    return false;
  }

  public ArrayList<PatientSymptom> getAllSymPriority() {
    ArrayList<PatientSymptom> symPriorities = new ArrayList<PatientSymptom>();

    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("select * from severities");
      resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet.toString());
      while (resultSet.next()) {
        symPriorities.add(new PatientSymptom(resultSet.getString(3), resultSet.getString(4)));
      }

    } catch (SQLException e) {
      System.out.println("SQL Expection");
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return symPriorities;
  }

  public ArrayList<PatientSymptom> getPatientSymptoms(CheckIn checkIn) {
    ArrayList<PatientSymptom> symPriorities = new ArrayList<PatientSymptom>();

    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("select * from PATIENT_SYM_META " +
              "where DOB = ? and LAST_NAME = ?");
      preparedStatement.setDate(1, (Date) checkIn.getDob());
      preparedStatement.setString(2, checkIn.getLastName());
      resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet.toString());
      while (resultSet.next()) {
        symPriorities.add(new PatientSymptom(resultSet.getString(2), resultSet.getString(3)));
      }

    } catch (SQLException e) {
      System.out.println("SQL Expection");
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return symPriorities;
  }
}
