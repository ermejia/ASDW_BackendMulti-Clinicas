package gt.com.clinica.clinicamedica.controller.patient;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.entity.PatientRoomEntity;
import gt.com.clinica.clinicamedica.entity.PersonEntity;
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
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudPatients")
public class PatientController extends HttpServlet {
    /**
     * Obtiene los datos para añadir un paciente nuevo
     * @param request Contiene los datos del paciente nuevo
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PersonEntity pat = new PersonEntity();
        PatientDao dao = new PatientDao();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        pat.setDpi((jObj.getInt("dpi")));
        pat.setName(jObj.getString("name"));
        pat.setSurname(jObj.getString("surname"));
        pat.setAddress(jObj.getString("address"));
        pat.setPhone(jObj.getInt("phone"));
        pat.setBirthdate(jObj.getString("birthdate"));
        pat.setContactphone(jObj.getInt("contactphone"));
        pat.setGender(jObj.getString("gender"));

        try (PrintWriter out = response.getWriter()) {
            dao.addepatient(pat);
        }
    }

    /**
     * Retorna una lista con los pacientes
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientDao daopr = new PatientDao();
        List<PersonEntity> listPatie = daopr.listAll();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            if (listPatie != null) {
                for (PersonEntity patie : listPatie) {
                    json.add(gson.toJson(patie));
                }
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
