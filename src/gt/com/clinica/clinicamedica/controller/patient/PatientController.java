package gt.com.clinica.clinicamedica.controller.patient;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.entity.PatientRoomEntity;
import gt.com.clinica.clinicamedica.entity.PersonEntity;
import gt.com.clinica.clinicamedica.service.PatientService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudPatients")
public class PatientController extends HttpServlet {
    /**
     * Obtiene los datos para añadir un paciente nuevo
     * @param request Contiene los datos del paciente nuevo
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService pat = new PatientService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(pat.addData(br)!=1){
                out.println("Error");
            }
        }
    }

    /**
     * Retorna una lista con los pacientes
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService daopr = new PatientService();
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
