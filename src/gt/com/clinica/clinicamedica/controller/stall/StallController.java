package gt.com.clinica.clinicamedica.controller.stall;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.dao.StallDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.PersonEntity;
import gt.com.clinica.clinicamedica.entity.RoomEntity;
import gt.com.clinica.clinicamedica.entity.StallEntity;
import gt.com.clinica.clinicamedica.service.StallService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudStalls")
public class StallController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * Método get que retorna la lista de los puestos
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StallService daos = new StallService();
        List<String> json = daos.listData();
        try (PrintWriter out = response.getWriter()) {
            if (json != null) {
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
