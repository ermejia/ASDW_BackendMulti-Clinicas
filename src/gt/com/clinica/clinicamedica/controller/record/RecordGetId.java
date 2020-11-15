package gt.com.clinica.clinicamedica.controller.record;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.RecordDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.RecordEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/getRecord")
public class RecordGetId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Retorna el historial del paciente en base al dpi
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        RecordEntity record = new RecordEntity();
        RecordDao dao = new RecordDao();
        System.out.println(request.getParameter("id"));
        record.setIdRecord(Integer.parseInt(request.getParameter("id")));
        RecordEntity record1 = dao.getById(record.getIdRecord());
        try (PrintWriter out = response.getWriter()) {
            if (record1 != null) {
                json.add(gson.toJson(record1));
                System.out.println(json);
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
