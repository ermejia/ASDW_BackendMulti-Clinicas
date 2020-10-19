package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudStall {

    /**
     * @return
     */
    public List<StallEntity> listAllStalls();

    /**
     * @param stall 
     * @return
     */
    public int addStall(StallEntity stall);

    /**
     * @param stall 
     * @return
     */
    public int updateStall(StallEntity stall);

    /**
     * @param id 
     * @return
     */
    public int deleteAppointment(int id);

}