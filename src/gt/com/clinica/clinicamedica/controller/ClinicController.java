package gt.com.clinica.clinicamedica.controller;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.AppointmentDao;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.PersonEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudClinic")
public class ClinicController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicEntity clinicEntity = new ClinicEntity();
        ClinicDao daoc = new ClinicDao();
        clinicEntity.setIdClinic(Integer.parseInt(request.getParameter("idClinic")));
        clinicEntity.setNameClinic(request.getParameter("nameClinic"));
        clinicEntity.setDescription(request.getParameter("description"));

        try (PrintWriter out = response.getWriter()) {
            if ("create".equals(request.getParameter("btn_create"))) {
                if (daoc.addClinic(clinicEntity) > 0) {
                    out.println("success");
                }
            }
            if ("update".equals(request.getParameter("btn_update"))) {
                if (daoc.updateClinic(clinicEntity) > 0) {
                    out.println("success");
                }
            }
            if ("delete".equals(request.getParameter("btn_delete"))) {
                if (daoc.deleteClinic(clinicEntity.getIdClinic()) > 0) {
                    out.println("success");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicDao daoc = new ClinicDao();
        List<ClinicEntity> listClinic = daoc.listAllClinic();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            if (listClinic != null) {
                for (ClinicEntity cli : listClinic) {
                    json.add(gson.toJson(cli));
                }
                out.println(json);
            } else {
                out.println("error");
            }
        }

    }
}
