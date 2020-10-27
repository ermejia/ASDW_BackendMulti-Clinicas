package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.RoomEntity;
import gt.com.clinica.clinicamedica.entity.StallEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class StallDao implements ICrudStall {

    final String selectAllStalls = "SELECT * FROM Puestos;";
    @Override
    public List<StallEntity> listAllStalls() {
        List<StallEntity> listStall = new LinkedList<>();
        StallEntity stall ;
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement(selectAllStalls);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                stall = new StallEntity();
                stall.setIdStall(consulta.getInt("IdPuesto"));
                stall.setStall(consulta.getString("Puesto"));
                listStall.add(stall);
            }
            consulta.close();
            return listStall;
        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
            return null;
        }finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("no hay conexion y no se cierra");
                    return null;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
