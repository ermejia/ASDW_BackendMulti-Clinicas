package gt.com.clinica.clinicamedica.controller;

import com.google.gson.Gson;
import com.sun.org.apache.regexp.internal.RE;
import gt.com.clinica.clinicamedica.dao.AppointmentDao;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.PatientDao;
import gt.com.clinica.clinicamedica.dao.RecordDao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.PersonEntity;
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


        RecordEntity recordEntity = new RecordEntity();
        RecordDao daor = new RecordDao();
        recordEntity.setIdRecord(Integer.parseInt(request.getParameter("idRecord")));
        recordEntity.setIdAppointment(Integer.parseInt(request.getParameter("idAppointment")));
        recordEntity.setIdDiagnostic(Integer.parseInt(request.getParameter("idDiagnostic")));
        recordEntity.setIdPatientRoom(Integer.parseInt(request.getParameter("idPatientRomm")));

        try (PrintWriter out = response.getWriter()) {


            if ("create".equals(request.getParameter("btn_create"))) {
                if (daor.addRecord(recordEntity) > 0) {
                    out.println("success");
                }
            }
            if ("update".equals(request.getParameter("btn_update"))) {
                if (daor.updateRecord(recordEntity) > 0) {
                    out.println("success");
                }
            }
            if ("delete".equals(request.getParameter("btn_delete"))) {
                if (daor.deleteRecord(recordEntity.getIdAppointment()) > 0) {
                    out.println("success");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecordDao daor = new RecordDao();
        List<RecordEntity> listRecords = daor.listAllRecords();
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
