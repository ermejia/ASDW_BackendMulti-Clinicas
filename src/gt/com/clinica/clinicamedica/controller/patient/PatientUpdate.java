package gt.com.clinica.clinicamedica.controller.patient;

import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
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

@WebServlet("/updatePatient")
public class PatientUpdate extends HttpServlet {
    /**
     * Obtiene los datos del paciente enviados por el frontend
     * @param request contiene los datos del paciente
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService pat = new PatientService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(pat.updateData(br)!=1){
                out.println("error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
