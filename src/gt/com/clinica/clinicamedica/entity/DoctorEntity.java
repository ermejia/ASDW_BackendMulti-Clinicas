<<<<<<< HEAD
package com.clinica.clinicamedica.entity;
=======
package gt.com.clinica.clinicamedica.entity;
>>>>>>> feature/AF-9-15_CompleteEntity

import java.util.*;

/**
 * 
 */
public class DoctorEntity extends EmployeeEntity {

    /**
     * Default constructor
     */
    public DoctorEntity() {
    }

    /**
     * 
     */
    private int idDoctor;

    /**
     * 
     */
    private int noCollegiate;

    /**
     * 
     */
    private String speciality;

<<<<<<< HEAD
=======
    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getNoCollegiate() {
        return noCollegiate;
    }

    public void setNoCollegiate(int noCollegiate) {
        this.noCollegiate = noCollegiate;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
>>>>>>> feature/AF-9-15_CompleteEntity
}