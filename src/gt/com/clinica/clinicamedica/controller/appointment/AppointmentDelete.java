package gt.com.clinica.clinicamedica.controller.appointment;

import gt.com.clinica.clinicamedica.dao.AppointmentDao;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.entity.AppointmentEntity;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.service.AppointmentService;
import gt.com.clinica.clinicamedica.service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteApointment")
public class AppointmentDelete extends HttpServlet {
    /**
     * Obtiene el id de la cita desde el frontend que se desea eliminar
     * @param request contiene el id de la cita que se desa eliminar
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AppointmentService appointment = new AppointmentService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if (appointment.deleteData(br) != 1) {
                out.println("Hubo un error al eliminar al empleado");
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
