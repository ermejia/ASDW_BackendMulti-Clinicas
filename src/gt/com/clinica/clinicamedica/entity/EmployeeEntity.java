<<<<<<< HEAD
package com.clinica.clinicamedica.entity;

import java.util.*;

/**
 * 
 */
public class EmployeeEntity extends PersonEntity {

    /**
     * Default constructor
     */
    public EmployeeEntity() {
    }

    /**
     * 
     */
    private int idEmployee;

    /**
     * 
     */
    private int idJob;

}
=======
package gt.com.clinica.clinicamedica.entity;

public class EmployeeEntity extends PersonEntity{
    private int idEmpmloyee;
    private int idJob;

    public int getIdEmpmloyee() {
        return idEmpmloyee;
    }

    public void setIdEmpmloyee(int idEmpmloyee) {
        this.idEmpmloyee = idEmpmloyee;
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }
}
>>>>>>> feature/AF-9-15_CompleteEntity
