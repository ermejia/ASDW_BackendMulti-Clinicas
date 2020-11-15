package gt.com.clinica.clinicamedica.controller.stall;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.StallDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
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

@WebServlet("/getStall")
public class StallGetId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Método get que retorna los datos solicitados en base al id
     * @param request Contiene el id del pueeto que se desea obtener
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StallService stall = new StallService();
        List<String> json = stall.getDatabyId(Integer.parseInt(request.getParameter("id")));
        try (PrintWriter out = response.getWriter()) {
            if (json != null) {
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
