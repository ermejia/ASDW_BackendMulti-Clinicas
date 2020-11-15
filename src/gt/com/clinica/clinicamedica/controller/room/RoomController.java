package gt.com.clinica.clinicamedica.controller.room;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.entity.RoomEntity;
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

@WebServlet("/crudRooms")

public class RoomController extends HttpServlet {
    /**
     * Obtiene los datos del frontend para agregar una nueva habitacion
     * @param request Contiene los datos de la habitacion nueva
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomEntity room = new RoomEntity();
        RoomDao daor = new RoomDao();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        room.setState((jObj.getString("state")));
        room.setNuBed(jObj.getInt("nuBed"));
        room.setDescription(jObj.getString("description"));
        try (PrintWriter out = response.getWriter()) {
            daor.addRoom(room);
        }
    }

    /**
     * Retorna una lista con todas las habitaciones
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDao daoe = new RoomDao();
        List<RoomEntity> listEm = daoe.listAllRooms();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        try (PrintWriter out = response.getWriter()) {
            if (listEm != null) {
                for (RoomEntity emp : listEm) {
                    json.add(gson.toJson(emp));
                }
                System.out.println(json);
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}