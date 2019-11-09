package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public interface PatientDAO {
    void add(Patient p);

    List getAllPatient();

    Patient getPatientById(int id);

    int getPatientIdByNameAndDob(String name, Date dob);

    void updatePatient(Patient p);

    void deletePatient(Patient p);

    void addFacility(Patient p, MedicalFacility f);

}
