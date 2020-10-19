package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudAppointment {

    /**
     * @return
     */
    public List<AppointmentEntity> listAllAppointments();

    /**
     * @param clinic 
     * @return
     */
    public int addAppointment(AppointmentEntity clinic);

    /**
     * @param clinic 
     * @return
     */
    public int updateAppointment(AppointmentEntity clinic);

    /**
     * @param id 
     * @return
     */
    public int deleteAppointment(int id);

}