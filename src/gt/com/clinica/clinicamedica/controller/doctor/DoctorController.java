package gt.com.clinica.clinicamedica.controller.doctor;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.AppointmentDao;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.RoomEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudDoctors")
public class DoctorController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Retorna una lista con los doctores
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorDao daod = new DoctorDao();
        List<DoctorEntity> listDocs = daod.listAllDoctors();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            if (listDocs != null) {
                for (DoctorEntity doc : listDocs) {
                    json.add(gson.toJson(doc));
                }
                out.println(json);
            } else {
                out.println("error");
            }
        }

    }
}
