package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public class MedicineDao implements ICrudMedicine {

    /**
     * Default constructor
     */
    public MedicineDao() {
    }

    /**
     * 
     */
    public void selectAllMedicines;

    /**
     * 
     */
    public void addMedicine;

    /**
     * 
     */
    public void updateMedicine;

    /**
     * 
     */
    public void deleteMedicine;

    /**
     * @return
     */
    public List<MedicineEntity> listAllMedicines() {
        // TODO implement here
        return null;
    }

    /**
     * @param med 
     * @return
     */
    public int addMedicine(MedicineEntity med) {
        // TODO implement here
        return 0;
    }

    /**
     * @param clinic 
     * @return
     */
    public int updateMedicine(ClinicEntity clinic) {
        // TODO implement here
        return 0;
    }

    /**
     * @param id 
     * @return
     */
    public int deleteMedicine(int id) {
        // TODO implement here
        return 0;
    }

}