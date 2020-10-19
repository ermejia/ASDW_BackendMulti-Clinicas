<<<<<<< HEAD
package com.clinica.clinicamedica.entity;
=======
package gt.com.clinica.clinicamedica.entity;
>>>>>>> feature/AF-9-15_CompleteEntity

import java.util.*;

/**
 * 
 */
public class AppointmentEntity {

    /**
     * Default constructor
     */
    public AppointmentEntity() {
    }

    /**
     * 
     */
<<<<<<< HEAD
    private void idAppointment;
=======
    private int idAppointment;
>>>>>>> feature/AF-9-15_CompleteEntity

    /**
     * 
     */
    private int idClinic;

    /**
     * 
     */
    private int idPatient;

    /**
     * 
     */
    private Date dateAppointment;

    /**
     * 
     */
    private String reason;

<<<<<<< HEAD
=======
    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public int getIdClinic() {
        return idClinic;
    }

    public void setIdClinic(int idClinic) {
        this.idClinic = idClinic;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
>>>>>>> feature/AF-9-15_CompleteEntity
}