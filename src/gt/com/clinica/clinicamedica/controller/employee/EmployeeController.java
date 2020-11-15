package gt.com.clinica.clinicamedica.controller.employee;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.service.EmployeeService;
import org.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;


@WebServlet("/EmployeeServlets")
public class EmployeeController extends HttpServlet {
    /**
     * Métod* post para obtener los datos
     * @param request  contiene los datos enviados por el frontend
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        EmployeeService employee = new EmployeeService();
        try (PrintWriter out = response.getWriter()) {
            if (employee.addData(br) != 1) {
                out.println("Hubo un error al ingresar la informacion");
            }
        }
    }

    /**
     * Retorna una lista con los datos de los empleados
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeService employee = new EmployeeService();
        try (PrintWriter out = response.getWriter()) {
            if (employee.listData() != null) {
                out.println(employee.listData());
            } else {
                out.println("Hubo un error al listar los datos");
            }
        }
    }
}
