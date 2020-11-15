package gt.com.clinica.clinicamedica.controller.room;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.entity.RoomEntity;
import gt.com.clinica.clinicamedica.service.RoomService;
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
        RoomService room = new RoomService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(room.addData(br)!=1){
                out.println("Error");
            }
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
        RoomService daoe = new RoomService();
        List<String> json =daoe.listData();
        try (PrintWriter out = response.getWriter()) {
            if (json != null) {
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}