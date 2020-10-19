package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudClinic {

    /**
     * @return
     */
    public List<ClinicEntity> listAllClinics();

    /**
     * @param clinic 
     * @return
     */
    public int addClinic(ClinicEntity clinic);

    /**
     * @param clinic 
     * @return
     */
    public int updateClinic(ClinicEntity clinic);

    /**
     * @param id 
     * @return
     */
    public int deleteAppointment(int id);

}