package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public class PatientDao implements ICrudPatient {

    /**
     * Default constructor
     */
    public PatientDao() {
    }

    /**
     * 
     */
    public void selectAllPatients;

    /**
     * 
     */
    public void addPatient;

    /**
     * 
     */
    public void updatePatient;

    /**
     * 
     */
    public void deletePatient;

    /**
     * @return
     */
    public List<PatientEntity> listAllPatients() {
        // TODO implement here
        return null;
    }

    /**
     * @param patient 
     * @return
     */
    public int addPatient(PersonEntity patient) {
        // TODO implement here
        return 0;
    }

    /**
     * @param patient 
     * @return
     */
    public int updatePatient(PersonEntity patient) {
        // TODO implement here
        return 0;
    }

    /**
     * @param dpi 
     * @return
     */
    public int deletePatient(int dpi) {
        // TODO implement here
        return 0;
    }

}