package gt.com.clinica.clinicamedica.controller.medicine;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.dao.MedicineDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudmedicines")
public class MedicineController extends HttpServlet {
    /**
     * Obtinee los datos del frontend para agregar una nueva medicina
     * @param request Contiene los datos de la medicina nueva
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MedicineEntity employee = new MedicineEntity();
        MedicineDao dao = new MedicineDao();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        employee.setName(jObj.getString("name"));
        employee.setAdminway(jObj.getString("adminway"));
        employee.setLab(jObj.getString("lab"));
        employee.setDescription(jObj.getString("description"));
        employee.setExpirationdate(jObj.getString("expirationdate"));
        employee.setLots((jObj.getInt("lots")));
        try (PrintWriter out = response.getWriter()) {
            dao.addmedicine(employee);
        }
    }

    /**
     * Retorna una lista de las medicinas
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MedicineDao daom = new MedicineDao();
        List<MedicineEntity> listMedi = daom.listAll();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            if (listMedi != null) {
                for (MedicineEntity medi : listMedi) {
                    json.add(gson.toJson(medi));
                }
                System.out.println(json);
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
