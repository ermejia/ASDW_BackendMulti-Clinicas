package gt.com.clinica.clinicamedica.entity;

import java.util.*;

/**
 * 
 */
public class RoomEntity {

    /**
     * Default constructor
     */
    public RoomEntity() {
    }

    /**
     * 
     */
    private int idRoom;

    /**
     * 
     */
    private int noBed;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private String state;

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getNoBed() {
        return noBed;
    }

    public void setNoBed(int noBed) {
        this.noBed = noBed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}