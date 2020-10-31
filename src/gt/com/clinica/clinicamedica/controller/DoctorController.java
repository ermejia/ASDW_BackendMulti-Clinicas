package com.clinica.clinicamedica.controller;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt. com .clinica.clinicamedica.dao.DoctorDao;
import java.io.PrintWriter;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/crudDoctor")

public class DoctorController extends HttpServlet {

            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 DoctorEntity doctor = new DoctorEntity();
                 DoctorDao daod = new DoctorDao();
                doctor.setIdDoctor(Integer.parseInt(request.getParameter("idDoctor")));
                doctor.setNoCollegiate(Integer.parseInt(request.getParameter("noCollegiate")));
                doctor.setSpeciality(request.getParameter("speciality"));
                
                 try (PrintWriter out = response.getWriter()) {
                             if ("create".equals(request.getParameter("btn_create"))) {
                                 if (daod.addDoctor(doctor) > 0) {
                                  out.println("success");
                                     } 
                             }
                
                            if ("update".equals(request.getParameter("btn_update"))) {
                                  if (daod.updateDoctor(doctor) > 0) {
                                  out.println("success");
                                         }
                                    }
                
                              if ("delete".equals(request.getParameter("btn_delete"))) {
                                 if (daod.deleteDoctor (doctor.getidDoctor()) > 0) {
                                 out.println("success");
                                         }
                                }         
                 }
            }
                       
                             
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       DoctorDao daod = new DoctorDao();
        List<DoctorEntity> listDoctors = daod.listAllDoctors();
        List <String> json = new LinkedList<>();
        Gson gson = new Gson();
           try (PrintWriter out = response.getWriter()){
                   if(listDoctors !=null) {
                             for(DoctorEntity emp : listDoctors) {
                                 json.add(gson.toJson(emp));
                               }
                                 out.println(json);
                    }else {
                     out.println("error");
                   }
            }
       }
}