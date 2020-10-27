package gt.com.clinica.clinicamedica.dao;

import com.sun.org.apache.regexp.internal.RE;
import gt.com.clinica.clinicamedica.entity.RecordEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RecordDao implements ICudRecord{

    final String selectAllDoctors = "SELECT * FROM Historial";
    @Override
    public List<RecordEntity> listAllRecords() {
        List<RecordEntity> listRecords= new LinkedList<>();
        RecordEntity rec;
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement(selectAllDoctors);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                rec = new RecordEntity();
                rec.setIdRecord(consulta.getInt("IdHistorial"));
                rec.setIdAppointment(consulta.getInt("IdCitaMedica"));
                rec.setIdDiagnostic(consulta.getInt("IdDiagnostico"));
                rec.setIdDiagnostic(consulta.getInt("IdPacienteHabitacion"));
                listRecords.add(rec);
            }
            consulta.close();
            return listRecords;
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

    final String deleteRecord = "DELETE FROM Historial WHERE IdHistorial=";
    @Override
    public int deleteRecord(int id) {
        int status = 0;
        Connection conexion = null;

        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro= conexion.prepareStatement(deleteRecord+id);
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
                    System.out.println("no hay conexion y no se cierra");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }

    final String updateRecord = "UPDATE Historial set IdCitaMedica=?,IdDiagnostico=?,IdPacienteHabitacion=? WHERE IdHistorial=?;";
    @Override
    public int updateRecord(RecordEntity record) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            parametro = conexion.prepareStatement(updateRecord);
            parametro.setInt(1, record.getIdAppointment());
            parametro.setInt(2, record.getIdDiagnostic());
            parametro.setInt(3, record.getIdPatientRoom());
            parametro.setInt(4, record.getIdRecord());
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
                    System.out.println("no hay conexion y no se cierra");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }

    final String addRecord = "INSERT INTO Historial(IdCitaMedica,IdDiagnostico,IdPacienteHabitacion) VALUES(?,?,?);";
    @Override
    public int addRecord(RecordEntity record) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            parametro = conexion.prepareStatement(addRecord);
            parametro.setInt(1, record.getIdAppointment());
            parametro.setInt(2, record.getIdDiagnostic());
            parametro.setInt(3, record.getIdPatientRoom());
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
                    System.out.println("no hay conexion y no se cierra");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }
}
