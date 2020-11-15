package gt.com.clinica.clinicamedica.controller.appointment;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.AppointmentDao;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.entity.RoomEntity;
import gt.com.clinica.clinicamedica.service.AppointmentService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudAppointments")
public class AppointmentController extends HttpServlet {
    /**
     * Clase encargada de obtener los parametros para ingresar una nueva cita
     * @param request Contiene los datos de la cita
     * @param response
     * @throws ServletException Muestra los errores en caso de que existan
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        AppointmentService appointment = new AppointmentService();
        try (PrintWriter out = response.getWriter()) {
            if(appointment.addData(br) ==0){
                out.println("Ha ocurrido un error al ingresar los datos");
            }
        }
    }

    /**
     * Retorna la lista de las citas al frontend
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> json = new LinkedList<>();
        AppointmentService listAppointment = new AppointmentService();
        json = listAppointment.listData();
        try (PrintWriter out = response.getWriter()) {
            if (json != null) {
                out.println(json);
            } else {
                out.println("Ha ocurrido un error al consultar la informacion");
            }
        }

    }

}
