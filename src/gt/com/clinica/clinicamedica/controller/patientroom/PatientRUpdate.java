package gt.com.clinica.clinicamedica.controller.patientroom;

import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.dao.PatientRoomDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.PatientRoomEntity;
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

@WebServlet("/updatePatientRoom")
public class PatientRUpdate extends HttpServlet {
    /**
     * Obtiene los datos del frontend para actualizar los pacientes en una habitaicon
     * @param request Contiene los datos para actualizar la tabla
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientRoomService pr = new PatientRoomService();
        BufferedReader br = request.getReader();
          try (PrintWriter out = response.getWriter()) {
            //dao.(pr);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
