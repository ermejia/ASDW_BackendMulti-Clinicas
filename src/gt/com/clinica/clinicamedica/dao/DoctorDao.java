package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DoctorDao implements ICrudDoctor {
    final String selectAllDoctors = "SELECT * FROM Medicos";
    @Override
    public List<DoctorEntity> listAllDoctors() {
        List<DoctorEntity> listDoctors = new LinkedList<>();
        DoctorEntity doc;
        Connection conexion = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement(selectAllDoctors);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                doc = new DoctorEntity();
                doc.setIdDoctor(consulta.getInt("IdMedico"));
                doc.setIdEmpmloyee(consulta.getInt("IdEmpleado"));
                doc.setNoCollegiate(consulta.getInt("NoColegiado"));
                doc.setSpeciality(consulta.getString("Especialidad"));
                listDoctors.add(doc);
            }
            consulta.close();
            return listDoctors;
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

    final String deleteDoctor = "DELETE FROM Medicos WHERE IdMedico=";
    @Override
    public int deleteDoctor(int id) {
        int status = 0;
        Connection conexion = null;

        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro= conexion.prepareStatement(deleteDoctor+id);
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

    final String updateDoctor = "UPDATE Medicos set IdEmpleado=?,NoColegiado=?,Especialidad=? WHERE IdMedico=?;";
    @Override
    public int updateDoctor(DoctorEntity doc) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            parametro = conexion.prepareStatement(updateDoctor);
            parametro.setInt(1, doc.getIdEmpmloyee());
            parametro.setInt(2, doc.getNoCollegiate());
            parametro.setString(3, doc.getSpeciality());
            parametro.setInt(4, doc.getIdDoctor());
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

    final String addDoctor = "INSERT INTO Medicos(IdEmpleado,NoColegiado,Especialidad) VALUES(?,?,?);";
    @Override
    public int addDoctor(DoctorEntity doc) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro;
            parametro = conexion.prepareStatement(addDoctor);
            parametro.setInt(1, doc.getIdEmpmloyee());
            parametro.setInt(2, doc.getNoCollegiate());
            parametro.setString(3, doc.getSpeciality());
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
