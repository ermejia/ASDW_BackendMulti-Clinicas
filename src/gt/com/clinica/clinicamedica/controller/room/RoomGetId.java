package gt.com.clinica.clinicamedica.controller.room;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.RoomEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/getRoom")
public class RoomGetId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Retorna una habitacion en base a un id enviado por el frontend
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        RoomEntity room = new RoomEntity();
        RoomDao dao = new RoomDao();
        System.out.println(request.getParameter("id"));
        room.setIdRoom(Integer.parseInt(request.getParameter("id")));
        RoomEntity roomn = dao.getById(room.getIdRoom());
        try (PrintWriter out = response.getWriter()) {
            if (roomn != null) {
                json.add(gson.toJson(roomn));
                System.out.println(json);
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
