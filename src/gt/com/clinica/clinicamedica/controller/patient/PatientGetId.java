package gt.com.clinica.clinicamedica.controller.patient;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.PersonEntity;
import org.omg.CORBA.PERSIST_STORE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/getPatient")
public class PatientGetId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Retorna los datos del paciente segun el id enviado por el frontend
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        PersonEntity pat = new PersonEntity();
        PatientDao dao = new PatientDao();
        System.out.println(request.getParameter("id"));
        pat.setDpi(Integer.parseInt(request.getParameter("id")));
        PersonEntity patient = dao.getById(pat.getDpi());
        try (PrintWriter out = response.getWriter()) {
            if (patient != null) {
                json.add(gson.toJson(patient));
                System.out.println(json);
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
