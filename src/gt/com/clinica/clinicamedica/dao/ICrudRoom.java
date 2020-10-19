package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudRoom {

    /**
     * @return
     */
    public List<RoomEntity> listAllRooms();

    /**
     * @param room 
     * @return
     */
    public int addRoom(RoomEntity room);

    /**
     * @param room 
     * @return
     */
    public int updateRoom(RoomEntity room);

    /**
     * @param id 
     * @return
     */
    public int deleteRoom(int id);

}