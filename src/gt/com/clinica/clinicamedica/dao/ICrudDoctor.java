package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudDoctor {

    /**
     * @return
     */
    public List<DoctorEntity> listAllDoctors();

    /**
     * @param doc 
     * @return
     */
    public int addDoctor(DoctorEntity doc);

    /**
     * @param doc 
     * @return
     */
    public int updateDoctor(DoctorEntity doc);

    /**
     * @param id 
     * @return
     */
    public int deleteAppointment(int id);

}