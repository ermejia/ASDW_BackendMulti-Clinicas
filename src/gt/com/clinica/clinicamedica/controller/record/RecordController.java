package gt.com.clinica.clinicamedica.controller.record;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.RecordDao;
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

@WebServlet("/crudRecords")
public class RecordController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    /**
     * Retorna el historial del paciente
     * @param request Contiene el dpi del paciente
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecordDao daor = new RecordDao();
        System.out.println(request.getParameter("dpi"));
        List<RecordEntity> listRecords = new LinkedList<>();
        listRecords.add(daor.getRecordbyDpi(Integer.parseInt(request.getParameter("dpi"))));
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            if (listRecords != null) {
                for (RecordEntity rec : listRecords) {
                    json.add(gson.toJson(rec));
                }
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
