package com.clinica.clinicamedica.dao;
import gt.com.clinica.clinicamedica.entity.RoomEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;
import gt.com.clinica.clinicamedica.dao.ICrudRoom;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RoomDao implements ICrudRoom {

    final String selectAllRooms ="SELECT * FROM Rooms";
    @Override
    public RoomDao() {
    }

    /**public void selectAllRooms;
    
    public void addRoom;
   
    public void updateRoom;
  
    public void deleteRoom;
    * */
    
    public List<RoomEntity> listAllRooms() {
        
         List<RoomEntity> listRooms = new LinkedList<>();
        RoomEntity room;
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement(selectAllRooms);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                room = new RoomEntity();
                room.setIdRoom(consulta.getInt("IdRoom"));
                room.setINoBed(consulta.getInt("NoBed"));
                room.setDescription(consulta.getInt("Description"));
                room.setState(consulta.getString("State"));
                
                listRooms.add(room);
            }
            consulta.close();
            return listRooms;
        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
            return null;
        }finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("Existe  conexion o esta presenta problemas");
                    return null;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    } 
        
        
       final String addRoom = "INSERT INTO Room(IdRoom,NoBed,Description,State) VALUES(?,?,?);";
        @Override
    public int addRoom(RoomEntity room) {
        
           int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            parametro = conexion.prepareStatement(addRoom);
            parametro.setInt(1, room.getIdRoom());
            parametro.setInt(2, room.getNoBed());
            parametro.setString(3, room.getDescription());
            parametro.setString(4, room.getState());
            status = parametro.executeUpdate();
            conexion.close();

        } catch (SQLException e) {
            System.err.println("Error en conexion :( ");
            System.err.println(e.getMessage());
        } finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("no hay conexion y no se cierra");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }
    
    final String updateRoom = "UPDATE Rooms set IdRoom=?,NoBed=?,Description,State=? WHERE Idroom=?;";
     @Override
    public int updateRoom(RoomEntity room) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            parametro = conexion.prepareStatement(updateRoom);
            parametro.setInt(1, room.getIdRoom());
            parametro.setInt(2, room.getNoBed());
            parametro.setString(3, room.getDescription());
            parametro.setInt(4, room.getState());
            status = parametro.executeUpdate();
            conexion.close();

        } catch (SQLException e) {
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        } finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("Error de conexion:(");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }

      final String deleteRoom = "DELETE FROM MRoom WHERE IdMRoom=";
      @Override
    public int deleteRoom(int id) {
       
          int status = 0;
        Connection conexion = null;

        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro= conexion.prepareStatement(deleteRoom+id);
            status = parametro.executeUpdate();
            conexion.close();

        } catch (SQLException e) {
            System.err.println("Error :( ");
            System.err.println(e.getMessage());
        } finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("Error de conexion :(");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }
    
}