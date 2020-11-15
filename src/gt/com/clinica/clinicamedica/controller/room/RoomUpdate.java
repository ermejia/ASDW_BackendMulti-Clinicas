package gt.com.clinica.clinicamedica.controller.room;

import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.dao.StallDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.RoomEntity;
import gt.com.clinica.clinicamedica.entity.StallEntity;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateRoom")
public class RoomUpdate extends HttpServlet {
    /**
     * Método post que obtiene los datos nuevos de la habitacion
     * @param request Contiene los datos actualizados de la habitacion
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomEntity room = new RoomEntity();
        RoomDao dao = new RoomDao();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());

        room.setIdRoom(Integer.parseInt(jObj.getString("idClinic")));
        room.setDescription(String.valueOf(Integer.parseInt((jObj.getString("nocollege")))));
        room.setNuBed(Integer.parseInt((jObj.getString("speciality"))));
        room.setState((jObj.getString("address")));

        try (PrintWriter out = response.getWriter()) {
            dao.updateRoom(room);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
