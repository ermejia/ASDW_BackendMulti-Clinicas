package gt.com.clinica.clinicamedica.controller.patientroom;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.*;
import gt.com.clinica.clinicamedica.entity.*;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudPatientRooms")
public class PatientRoomController extends HttpServlet {
    /**
     * Crea una nueva habitacion con pacientes
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PatientRoomEntity ptr = new PatientRoomEntity();
        PatientRoomDao dao = new PatientRoomDao();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        ptr.setDpi(jObj.getInt("dpi"));
        ptr.setIdRoom(jObj.getInt("idRoom"));
        ptr.setDateIn(Date.valueOf(jObj.getString("dateIn")));
        try (PrintWriter out = response.getWriter()) {
            dao.addPtr(ptr);
        }

    }

    /**
     * Retorna una lista con los pacientes que se encuentran en las habitacionoes
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientRoomDao daopr = new PatientRoomDao();
        List<PatientRoomEntity> listPre = daopr.listAllRoomsP();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            if (listPre != null) {
                for (PatientRoomEntity pre : listPre) {
                    json.add(gson.toJson(pre));
                }
                System.out.println(json);
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
