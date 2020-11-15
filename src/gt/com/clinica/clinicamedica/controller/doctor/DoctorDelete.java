package gt.com.clinica.clinicamedica.controller.doctor;

import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteDoctor")
public class DoctorDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorEntity doctor = new DoctorEntity();
        DoctorDao dao = new DoctorDao();
        doctor.setIdDoctor(Integer.parseInt(request.getParameter("idDoctor")));
        int a = dao.deleteDoctor(doctor.getIdDoctor());
        try (PrintWriter out = response.getWriter()) {
            if(a!=0){
            }else{
                out.println("[error]");
            }
        }
    }
}
