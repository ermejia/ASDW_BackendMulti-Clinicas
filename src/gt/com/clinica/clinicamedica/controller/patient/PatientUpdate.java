package gt.com.clinica.clinicamedica.controller.patient;

import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
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

@WebServlet("/updatePatient")
public class PatientUpdate extends HttpServlet {
    /**
     * Obtiene los datos del paciente enviados por el frontend
     * @param request contiene los datos del paciente
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
            String a = str.substring(1, str.length() -1);
            sb.append(a);
            System.out.println(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());

        pat.setIdPerson(Integer.parseInt(jObj.getString("idPerson")));
        pat.setAddress(((jObj.getString("address"))));
        pat.setBirthdate((jObj.getString("birthdate")));
        pat.setContactphone((jObj.getInt("contactphone")));
        pat.setDpi((jObj.getInt("dpi")));
        pat.setName(((jObj.getString("name"))));
        pat.setPhone(Integer.parseInt((jObj.getString("phone"))));
        pat.setSurname(((jObj.getString("surname"))));


        try (PrintWriter out = response.getWriter()) {
            dao.updatepatient(pat);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
