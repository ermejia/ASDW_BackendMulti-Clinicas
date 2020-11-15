package gt.com.clinica.clinicamedica.controller.clinic;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.AppointmentDao;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.PersonEntity;
import gt.com.clinica.clinicamedica.service.ClinicService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudClinics")

public class ClinicController extends HttpServlet {
    /**
     * Método post para obtener los datos de una nueva clinca
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicService clinic = new ClinicService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(clinic.addData(br) !=1){
                out.println("Ha ocurrido un error al ingresar la informacion");
            }
        }
    }

    /**
     * Método Get para listar las clinicas
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClinicService daoc = new ClinicService();
        List<String> json = daoc.listData();
        try (PrintWriter out = response.getWriter()) {
            if (json != null) {
                out.println(json);
            } else {
                out.println("Ha ocurrido un error al listar la informacion");
            }
        }

    }
}
