package gt.com.clinica.clinicamedica.controller.clinic;

import gt.com.clinica.clinicamedica.dao.AppointmentDao;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.service.ClinicService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateClinic")
public class ClinicUpdate extends HttpServlet {
    /**
     * Método post para obtener los datos del frontend para actualizar una clinica
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicService clinic = new ClinicService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(clinic.updateData(br) !=1){
                out.println("Ha ocurriod un error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
