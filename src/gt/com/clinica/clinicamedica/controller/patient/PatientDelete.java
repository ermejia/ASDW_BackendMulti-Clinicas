package gt.com.clinica.clinicamedica.controller.patient;

import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.MedicineDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.MedicineEntity;
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

@WebServlet("/deletePatient")
public class PatientDelete extends HttpServlet {
    /**
     * Obtiene los datos del paciente enviados por el frontend para ser eliminado
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        PatientService patient = new PatientService();
        try (PrintWriter out = response.getWriter()) {
            if(patient.deleteData(br)!=0){
            }else{
                out.println("[error]");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           }
}
