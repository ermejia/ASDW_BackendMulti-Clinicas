package gt.com.clinica.clinicamedica.entity;

import java.util.*;

/**
 * 
 */
public class RecordEntity {

    /**
     * Default constructor
     */
    public RecordEntity() {
    }

    /**
     * 
     */
    private int idRecord;

    /**
     * 
     */
    private int idAppointment;

    /**
     * 
     */
    private int idDiagnostic;

    /**
     * 
     */
    private int idPatientRoom;

    public int getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(int idRecord) {
        this.idRecord = idRecord;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public int getIdDiagnostic() {
        return idDiagnostic;
    }

    public void setIdDiagnostic(int idDiagnostic) {
        this.idDiagnostic = idDiagnostic;
    }

    public int getIdPatientRoom() {
        return idPatientRoom;
    }

    public void setIdPatientRoom(int idPatientRoom) {
        this.idPatientRoom = idPatientRoom;
    }
}