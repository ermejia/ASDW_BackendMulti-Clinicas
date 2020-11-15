package gt.com.clinica.clinicamedica.controller.stall;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.StallDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.StallEntity;

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
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        StallEntity stall = new StallEntity();
        StallDao dao = new StallDao();
        System.out.println(request.getParameter("id"));
        stall.setIdStall(Integer.parseInt(request.getParameter("id")));
        StallEntity stall1 = dao.getById(stall.getIdStall());
        try (PrintWriter out = response.getWriter()) {
            if (stall1 != null) {
                json.add(gson.toJson(stall1));
                System.out.println(json);
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
