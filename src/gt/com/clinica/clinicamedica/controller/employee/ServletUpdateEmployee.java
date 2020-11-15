package gt.com.clinica.clinicamedica.controller.employee;

import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.service.EmployeeService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateEmployee")
public class ServletUpdateEmployee extends HttpServlet {
    /**
     * Métod post para obtener los datos
     * @param request contiene los datos enviados por el frontend
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeService employee = new EmployeeService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(employee.updateData(br) == 0){
                out.println("Se produjo un error al actualizar los datos");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
