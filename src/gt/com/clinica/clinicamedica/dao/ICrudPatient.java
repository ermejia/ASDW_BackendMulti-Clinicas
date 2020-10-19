package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudPatient {

    /**
     * @return
     */
    public List<PatientEntity> listAllPatients();

    /**
     * @param patient 
     * @return
     */
    public int addPatient(PersonEntity patient);

    /**
     * @param patient 
     * @return
     */
    public int updatePatient(PersonEntity patient);

    /**
     * @param dpi 
     * @return
     */
    public int deletePatient(int dpi);

}