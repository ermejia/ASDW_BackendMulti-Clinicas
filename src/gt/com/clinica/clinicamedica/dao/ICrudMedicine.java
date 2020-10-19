package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudMedicine {

    /**
     * @return
     */
    public List<MedicineEntity> listAllMedicines();

    /**
     * @param med 
     * @return
     */
    public int addMedicine(MedicineEntity med);

    /**
     * @param clinic 
     * @return
     */
    public int updateMedicine(ClinicEntity clinic);

    /**
     * @param id 
     * @return
     */
    public int deleteMedicine(int id);

}