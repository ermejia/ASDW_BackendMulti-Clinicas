package com.clinica.clinicamedica.dao;

import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.service.ConectionService;
import gt.com.clinica.clinicamedica.service.ICrudEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDao implements ICrudEmployee {
    final String selectAllEmployee = "SELECT * FROM Empleados";
    @Override
    public List<EmployeeEntity> listAll() {
        Date date = null;
        List<EmployeeEntity> listEmployee = new LinkedList<>();
        EmployeeEntity emp = new EmployeeEntity();
        Connection conexion = null;

        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement(selectAllEmployee);
            ResultSet consulta=statement.executeQuery();
            while (consulta.next()) {
                emp = new EmployeeEntity();
                emp.setIdEmpmloyee(consulta.getInt("IdEmpleado"));
                emp.setDpi(consulta.getInt("DPI"));
                emp.setName(consulta.getString("Nombre"));
                emp.setSurname(consulta.getString("Apellido"));
                emp.setAddress(consulta.getString("Direccion"));
                emp.setPhone(consulta.getInt("Telefono"));
                emp.setBirthdate(consulta.getDate("FechaNacimiento"));
                emp.setContactphone(consulta.getInt("TelefonoContacto"));
                emp.setIdJob(consulta.getInt("IdPuesto"));
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

    @Override
    public int deleteemployee(int id) {
        return 0;
    }

    @Override
    public int updateemployee(EmployeeEntity emp) {
        return 0;
    }

    @Override
    public int addemployee(EmployeeEntity emp) {
        final String addEmployee = "INSERT INTO Empleados(DPI,Nombre,Apellido,Direccion,Telefono,FechaNacimiento,TelefonoContacto,IdPuesto) VALUES(?,?,?,?,?,?,?,?);";
       int status = 0;
            Connection conexion = null;
            try {
                ConectionService con = ConectionService.getInstance();
                conexion = con.getConnection();
                PreparedStatement parametro;
                parametro = conexion.prepareStatement(addEmployee);
                parametro.setInt(1, emp.getDpi());
                parametro.setString(2, emp.getName());
                parametro.setString(3, emp.getSurname());
                parametro.setString(4, emp.getAddress());
                parametro.setInt(5, emp.getPhone());
                String date = String.valueOf(emp.getBirthdate());
                java.sql.Date datecast = java.sql.Date.valueOf(date);
                parametro.setDate(6,datecast);
                parametro.setInt(7, emp.getContactphone());
                parametro.setInt(8, emp.getIdJob());
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
