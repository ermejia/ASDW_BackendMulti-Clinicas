package gt.com.clinica.clinicamedica.controller.doctor;

import com.google.gson.Gson;
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
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        DoctorEntity doctor = new DoctorEntity();
        DoctorDao dao = new DoctorDao();
        System.out.println(request.getParameter("id"));
        doctor.setIdDoctor(Integer.parseInt(request.getParameter("id")));
        DoctorEntity clinic = dao.getById(doctor.getIdDoctor());
        try (PrintWriter out = response.getWriter()) {
            if (clinic != null) {
                json.add(gson.toJson(clinic));
                System.out.println(json);
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
