package gt.com.clinica.clinicamedica.controller.patientroom;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.*;
import gt.com.clinica.clinicamedica.entity.*;
import gt.com.clinica.clinicamedica.service.PatientRoomService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudPatientRooms")
public class PatientRoomController extends HttpServlet {
    /**
     * Crea una nueva habitacion con pacientes
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PatientRoomService ptr = new PatientRoomService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
           if(ptr.addData(br)!=1){
               out.println("error");
           }
        }

    }

    /**
     * Retorna una lista con los pacientes que se encuentran en las habitacionoes
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientRoomService daopr = new PatientRoomService();
        List<String> json = daopr.listData();
        try (PrintWriter out = response.getWriter()) {
            if (json != null) {
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
