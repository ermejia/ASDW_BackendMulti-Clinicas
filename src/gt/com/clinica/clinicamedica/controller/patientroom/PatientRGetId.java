package gt.com.clinica.clinicamedica.controller.patientroom;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.PatientRoomDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.PatientRoomEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/getPatientRoom")
public class PatientRGetId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Retorna una habitacion y los pacientes que se encuentran en ella
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        PatientRoomEntity pr = new PatientRoomEntity();
        PatientRoomDao dao = new PatientRoomDao();
        System.out.println(request.getParameter("id"));
        pr.setIdPatientRoom(Integer.parseInt(request.getParameter("id")));
        PatientRoomEntity pr1 = dao.getById(pr.getIdPatientRoom());
        try (PrintWriter out = response.getWriter()) {
            if (pr1 != null) {
                json.add(gson.toJson(pr1));
                System.out.println(json);
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
