package edu.ncsu.csc.DAO;

import java.util.Date;
import java.util.List;

public class NegativeExpeDAOImp extends AbstractDAO implements TemplateDAO {
    @Override
    public boolean addOneValue(Object p) {
        return false;
    }

    @Override
    public List getAllValues() {
        return null;
    }

    @Override
    public List getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public Object getOneByQuery(String queryStr) {
        return null;
    }

    public List getAllByNameAndDob(String lastName, Date dob) {
        return null;
    }

    @Override
    public Object getOneById(int id) {
        return null;
    }

    @Override
    public Object getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(Object p) {
        return false;
    }

    @Override
    public boolean deleteRecord(Object p) {
        return false;
    }
}
