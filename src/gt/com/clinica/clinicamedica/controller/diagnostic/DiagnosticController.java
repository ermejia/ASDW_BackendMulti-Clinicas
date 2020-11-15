package gt.com.clinica.clinicamedica.controller.diagnostic;

import gt.com.clinica.clinicamedica.dao.AppointmentDao;
import gt.com.clinica.clinicamedica.dao.DiagnosticDao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.entity.DiagnosticEntity;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/crudDiagnostic")
public class DiagnosticController extends HttpServlet {
    /**
     * Obitnene los datos para un nuevo diagnostico
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiagnosticEntity diagnostic = new DiagnosticEntity();
        DiagnosticDao dao = new DiagnosticDao();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        diagnostic.setDescription((jObj.getString("Description")));
        diagnostic.setIdMedic(jObj.getInt("idMedic"));
        diagnostic.setIdMedicine(jObj.getInt("idMedicine"));
        diagnostic.setProcedure(jObj.getString("Procedure"));
        diagnostic.setDpi(jObj.getString("dpi"));


        try (PrintWriter out = response.getWriter()) {
            dao.addDiagnostic(diagnostic);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
