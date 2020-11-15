package gt.com.clinica.clinicamedica.controller.medicine;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.dao.MedicineDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.entity.MedicineEntity;
import gt.com.clinica.clinicamedica.service.MedicineService;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/crudmedicines")
public class MedicineController extends HttpServlet {
    /**
     * Obtinee los datos del frontend para agregar una nueva medicina
     * @param request Contiene los datos de la medicina nueva
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MedicineService employee = new MedicineService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(employee.addData(br)!=1){
                out.println("Ha ocurrido un error el ingrear los datos");
            }
        }
    }

    /**
     * Retorna una lista de las medicinas
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MedicineService daom = new MedicineService();
        List<String> json = daom.listData();
        try (PrintWriter out = response.getWriter()) {
            if (json != null) {
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}
