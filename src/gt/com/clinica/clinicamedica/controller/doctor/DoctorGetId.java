package gt.com.clinica.clinicamedica.controller.doctor;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.service.DoctorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/getDoctor")
public class DoctorGetId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Retorna los datos del doctor solicitado por el frontendc
     * @param request Contiene el id del doctor que busca
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorService doctor = new DoctorService();
        List<String> json = doctor.getDatabyId(Integer.parseInt(request.getParameter("id")));
        try (PrintWriter out = response.getWriter()) {
            if ( json!= null) {
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
