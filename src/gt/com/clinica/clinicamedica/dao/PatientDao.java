package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.PersonEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PatientDao implements ICrudPatient {
    final String selectAllPatients = "SELECT * FROM Pacientes";



    @Override
    public List<PersonEntity> listAll() {
        Date date = null;
        List<PersonEntity> listEmployee = new LinkedList<>();
        PersonEntity emp;
        Connection conexion = null;

        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement(selectAllPatients);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                emp = new PersonEntity();
                emp.setIdPerson(consulta.getInt("idPaciente"));
                emp.setDpi(consulta.getInt("DPI"));
                emp.setName(consulta.getString("Nombre"));
                emp.setSurname(consulta.getString("Apellido"));
                emp.setAddress(consulta.getString("Direccion"));
                emp.setPhone(consulta.getInt("Telefono"));
                emp.setBirthdate(consulta.getDate("FechaNacimiento"));
                emp.setContactphone(consulta.getInt("TelefonoContacto"));
                listEmployee.add(emp);
            }
            consulta.close();
            return listEmployee;
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

    final String deletePatient = "DELETE FROM Pacientes WHERE IdPaciente =";
    @Override
    public int deletepatient(int dpi) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro= conexion.prepareStatement(deletePatient+dpi);
            status = parametro.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }

    final String updatePatient = "UPDATE Pacientes set DPI=?,Nombre=?,Apellido=?,Direccion=?,Telefono=?,FechaNacimiento=?,TelefonoContacto=? WHERE IdPaciente=?;";
    @Override
    public int updatepatient(PersonEntity patient) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro = conexion.prepareStatement(updatePatient);
            parametro.setInt(1, patient.getDpi());
            parametro.setString(2, patient.getName());
            parametro.setString(3, patient.getSurname());
            parametro.setString(4, patient.getAddress());
            parametro.setInt(5, patient.getPhone());
            parametro.setDate(6, (java.sql.Date) patient.getBirthdate());
            parametro.setInt(7,patient.getContactphone());
            parametro.setInt(8,patient.getIdPerson());
            status = parametro.executeUpdate();
            conexion.close();
        } catch (SQLException e) {
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }

    final String addPatient = "INSERT INTO Pacientes(DPI,Nombre,Apellido,Direccion,Telefono,FechaNacimiento,TelefonoContacto) VALUES(?,?,?,?,?,?,?);";
    @Override
    public int addepatient(PersonEntity patient) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro = conexion.prepareStatement(addPatient);
            parametro.setInt(1, patient.getDpi());
            parametro.setString(2, patient.getName());
            parametro.setString(3, patient.getSurname());
            parametro.setString(4, patient.getAddress());
            parametro.setInt(5, patient.getPhone());
            parametro.setDate(6, (java.sql.Date) patient.getBirthdate());
            parametro.setInt(7,patient.getContactphone());
            status = parametro.executeUpdate();
            conexion.close();

        } catch (SQLException e) {
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return status;
    }
}
