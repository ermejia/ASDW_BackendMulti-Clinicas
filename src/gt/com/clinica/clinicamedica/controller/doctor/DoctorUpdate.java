package gt.com.clinica.clinicamedica.controller.doctor;

import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateDoctor")
public class DoctorUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DoctorEntity doctor = new DoctorEntity();
        DoctorDao dao = new DoctorDao();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        /*
        doctor.setIdDoctor(Integer.parseInt(jObj.getString("idClinic")));
        doctor.setNoCollegiate(Integer.parseInt((jObj.getString("nocollege"))));
        doctor.setSpeciality((jObj.getString("speciality")));
        doctor.setAddress((jObj.getString("address")));
        doctor.setBirthdate((jObj.getString("birthdate")));
        doctor.setContactphone(Integer.parseInt((jObj.getString("contactphone"))));
        doctor.setDpi(Integer.parseInt((jObj.getString("dpi"))));
        */

        try (PrintWriter out = response.getWriter()) {
            dao.updateDoctor(doctor);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
