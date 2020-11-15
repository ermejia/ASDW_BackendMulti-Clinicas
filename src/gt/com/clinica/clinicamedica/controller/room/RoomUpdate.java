package gt.com.clinica.clinicamedica.controller.room;

import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.dao.StallDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.RoomEntity;
import gt.com.clinica.clinicamedica.entity.StallEntity;
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
        RoomService room = new RoomService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(room.updateData(br)!=1){
                out.println("Error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
