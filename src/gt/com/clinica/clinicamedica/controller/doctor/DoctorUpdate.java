package gt.com.clinica.clinicamedica.controller.doctor;

import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.service.DoctorService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateDoctor")
public class DoctorUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorService doctor = new DoctorService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(doctor.updateData(br)!=1){
                out.println("error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
