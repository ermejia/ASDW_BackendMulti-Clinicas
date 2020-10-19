package gt.com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.MedicineEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MedicineDao implements ICrudMedicine {
    final String selectAllMedicine = "SELECT * FROM Medicamentos";
    final String deleteMedicine = "DELETE FROM Medicamentos WHERE IdMedicamento =";
    final String updateMedicine = "UPDATE Medicamentos set Nombre=?,Laboratorio=?,ViaAdministracion=?,Descripcion=?,FechaVencimiento=?,Lote=? WHERE IdMedicamento=?;";
    final String addMedicine = "INSERT INTO Medicamentos(Nombre,Laboratorio,ViaAdministracion,Descripcion,FechaVencimiento,Lote) VALUES(?,?,?,?,?,?);";
    @Override
    public List<MedicineEntity> listAll() {
        Date date = null;
        List<MedicineEntity> listMedicine = new LinkedList<>();
        MedicineEntity med = new MedicineEntity();
        Connection conexion = null;

        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement(selectAllMedicine);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                med = new MedicineEntity();
                med.setIdMedicine(consulta.getInt("IdMedicamento"));
                med.setName(consulta.getString("Nombre"));
                med.setLab(consulta.getString("Laboratorio"));
                med.setAdminway(consulta.getString("ViaAdministracion"));
                med.setDescription(consulta.getString("Descripcion"));
                med.setExpirationdate(consulta.getDate("FechaVencimiento"));
                med.setLots(consulta.getInt("Lote"));
                listMedicine.add(med);
            }
            consulta.close();
            return listMedicine;
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

    @Override
    public int deletemedicine(int id) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro= conexion.prepareStatement(deleteMedicine+id);
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

    @Override
    public int updatemedicine(MedicineEntity med) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro = conexion.prepareStatement(updateMedicine);
            parametro.setString(1, med.getName());
            parametro.setString(2, med.getLab());
            parametro.setString(3, med.getAdminway());
            parametro.setString(4, med.getDescription());
            parametro.setDate(5, (java.sql.Date) med.getExpirationdate());
            parametro.setInt(6,med.getLots());
            parametro.setInt(7,med.getIdMedicine());
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

    @Override
    public int addmedicine(MedicineEntity med) {
        int status = 0;
        Connection conexion = null;
        try {
            ConectionService con = ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement parametro = conexion.prepareStatement(addMedicine);
            parametro.setString(1, med.getName());
            parametro.setString(2, med.getLab());
            parametro.setString(3, med.getAdminway());
            parametro.setString(4, med.getDescription());
            parametro.setDate(5, (java.sql.Date) med.getExpirationdate());
            parametro.setInt(6,med.getLots());
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
