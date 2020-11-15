package gt.com.clinica.clinicamedica.controller.medicine;

import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.MedicineDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.MedicineEntity;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateMedicine")
public class MedicineUpdate extends HttpServlet {
    /**
     * Obtiene los datos actualizados del frontend
     * @param request Datos actualizados
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MedicineEntity med = new MedicineEntity();
        MedicineDao dao = new MedicineDao();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
            System.out.println(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());

        med.setIdMedicine(jObj.getInt("idMedicine"));
        med.setDescription(((jObj.getString("description"))));
        med.setAdminway((jObj.getString("adminway")));
        med.setLab((jObj.getString("lab")));
        med.setName((jObj.getString("name")));
        med.setLots(jObj.getInt("lots"));
        med.setExpirationdate(((jObj.getString("expirationdate"))));

        try (PrintWriter out = response.getWriter()) {
            dao.updatemedicine(med);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
