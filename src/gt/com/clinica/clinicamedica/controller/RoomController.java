package gt.com.clinica.clinicamedica.controller;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.entity.PersonEntity;
import gt.com.clinica.clinicamedica.entity.RoomEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudRoom")

public class RoomController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomEntity room = new RoomEntity();
        RoomDao daor = new RoomDao();
        room.setIdRoom(Integer.parseInt(request.getParameter("idRoom")));
        room.setNuBed(Integer.parseInt(request.getParameter("nuBed")));
        room.setDescription(request.getParameter("description"));
        room.setState(request.getParameter("state"));
        try (PrintWriter out = response.getWriter()) {

            if ("create".equals(request.getParameter("btn_create"))) {
                if (daor.addRoom(room) > 0) {
                    out.println("success");
                }
            }
            if ("update".equals(request.getParameter("btn_update"))) {
                if (daor.updateRoom(room) > 0) {
                    out.println("success");
                }
            }
            if ("delete".equals(request.getParameter("btn_delete"))) {
                if (daor.deleteRoom(room.getIdRoom()) > 0) {
                    out.println("success");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDao daor = new RoomDao();
        List<RoomEntity> listRoom = daor.listAllRooms();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            if (listRoom != null) {
                for (RoomEntity room : listRoom) {
                    json.add(gson.toJson(request));
                }
                out.println(json);
            } else {
                out.println("error");
            }
        }
        }
}
