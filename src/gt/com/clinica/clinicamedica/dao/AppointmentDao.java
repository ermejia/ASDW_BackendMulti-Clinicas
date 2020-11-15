package com.clinica.clinicamedica.dao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class AppointmentDao implements ICrudAppointment {

    /**
     * Default constructor
     */
    public AppointmentDao() {
    }

   
    public void selectAllAppointments;
    public void addAppointment;
    public void updateppointment;
    public void deleteAppointment;
    
    final String selectAllAppointments = "SELECT * FROM Appointments";
      @Override
    
    public List<AppointmentEntity> listAllAppointments() {
           List<AppointmentEntity> listAppointments = new LinkedList<>();
        AppointmentEntity ap;
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement(selectAllAppointments);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                ap = new AppointmentEntity();
                ap.setIdAppointment(consulta.getInt("IdAppointment"));
                ap.setIdClinic(consulta.getInt("IdConsulta"));
                ap.setIdPatient(consulta.getInt("IDPatient"));
                ap.setDateAppointment(consulta.getString("DateAppointment"));
                ap.setReason(consulta.getString("Reason"));
                
                listAppointments.add(ap);
            }
            consulta.close();
            return listAppointments;
        }catch (SQLException e){
            System.err.println("Error interno :( ");
            System.err.println(e.getMessage());
            return null;
        }finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("Sin conexión , no close");
                    return null;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
         
       final String addAppointment = "INSERT INTO Appointments(IdAppointment,IdClinic,IdPatient,DateAppointment,Reason) VALUES(?,?,?);"; 
    public int addAppointment(AppointmentEntity clinic) {
      int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            parametro = conexion.prepareStatement(addAppointment);
            parametro.setInt(1, clinic.getIdAppointment());
            parametro.setInt(2, clinic.getIdClinic());
            parametro.setString(3, clinic.getIdPatient());
            parametro.setString(4, clinic.getDateAppointment());
            parametro.setString(5, clinic.getReason());
                        
            status = parametro.executeUpdate();
            conexion.close();

        } catch (SQLException e) {
            System.err.println("Error interno ;( ");
            System.err.println(e.getMessage());
        } finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("No conection, no close :(");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }

  final String updateAppointment = "UPDATE Appointments set IdAppointment=?,IdClinic=?,IdPatient=?,DateAppointment=?,Reason=? WHERE IdAppointment =?;"; 
   @Override
  public int updateAppointment(AppointmentEntity clinic) {
    
       int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            parametro = conexion.prepareStatement(updateAppointment);
             parametro.setInt(1, clinic.getIdAppointment());
            parametro.setInt(2, clinic.getIdClinic());
            parametro.setString(3, clinic.getIdPatient());
            parametro.setString(4, clinic.getDateAppointment());
            parametro.setString(5, clinic.getReason());
            status = parametro.executeUpdate();
            conexion.close();

        } catch (SQLException e) {
            System.err.println("Error interno :( ");
            System.err.println(e.getMessage());
        } finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("No conection no close=;");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }
      
        final String deleteAppointment = "DELETE FROM Appointment WHERE IdAppointment=";
          @Override
     
    public int deleteAppointment(int id) {
        
        int status = 0;
        Connection conexion = null;

        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro= conexion.prepareStatement(deleteAppointment+id);
            status = parametro.executeUpdate();
            conexion.close();

        } catch (SQLException e) {
            System.err.println("Error interno :( ");
            System.err.println(e.getMessage());
        } finally {
            try {
                if(conexion !=null) {
                    conexion.close();
                }else{
                    System.out.println("No conection no close :(");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }
        
   }