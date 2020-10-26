package gt.com.clinica.clinicamedica.controller;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.AppointmentDao;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.entity.RoomEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudAppointment")
public class AppointmentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AppointmentEntity appointment = new AppointmentEntity();
        AppointmentDao daoa = new AppointmentDao();
        appointment.setIdAppointment(Integer.parseInt(request.getParameter("idAppointment")));
        appointment.setIdClinic(Integer.parseInt(request.getParameter("idClinic")));
        appointment.setIdPattient(Integer.parseInt(request.getParameter("idPatient")));
        appointment.setDateAppointment(request.getParameter("dateAppointment"));
        appointment.setReason(request.getParameter("reason"));

        try (PrintWriter out = response.getWriter()) {


            if ("create".equals(request.getParameter("btn_create"))) {
                if (daoa.addAppointment(appointment) > 0) {
                    out.println("success");
                }
            }
            if ("update".equals(request.getParameter("btn_update"))) {
                if (daoa.updateAppointment(appointment) > 0) {
                    out.println("success");
                }
            }
            if ("delete".equals(request.getParameter("btn_delete"))) {
                if (daoa.deleteAppointment(appointment.getIdAppointment()) > 0) {
                    out.println("success");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AppointmentDao daoa = new AppointmentDao();
        List<AppointmentEntity> listAppointment = daoa.listAllAppointments();
        List <String> json = new LinkedList<>();
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()){
            if(listAppointment !=null) {
                for(AppointmentEntity roms : listAppointment) {
                    out.println(gson.toJson(roms));
                }
            }else {
                out.println("Error");
            }
        }
    }
}
