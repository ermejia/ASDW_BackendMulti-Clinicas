package gt.com.clinica.clinicamedica.entity;

import java.util.*;

/**
 * 
 */
public class ClinicEntity {

    /**
     * Default constructor
     */
    public ClinicEntity() {
    }

    /**
     * 
     */
    private int idClinic;

    /**
     * 
     */
    private String nameClinic;

    /**
     * 
     */
    private String description;

    public int getIdClinic() {
        return idClinic;
    }

    public void setIdClinic(int idClinic) {
        this.idClinic = idClinic;
    }

    public String getNameClinic() {
        return nameClinic;
    }

    public void setNameClinic(String nameClinic) {
        this.nameClinic = nameClinic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}