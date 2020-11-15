package gt.com.clinica.clinicamedica.controller.medicine;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.dao.MedicineDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import gt.com.clinica.clinicamedica.entity.MedicineEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/getMedicine")
public class MedicineGetId extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Retorna una medicina especifica segun el id
     * @param request Contiene el id de la medicina
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        MedicineEntity med = new MedicineEntity();
        MedicineDao dao = new MedicineDao();
        System.out.println(request.getParameter("id"));
        med.setIdMedicine(Integer.parseInt(request.getParameter("id")));
        MedicineEntity listMed = dao.getById(med.getIdMedicine());
        try (PrintWriter out = response.getWriter()) {
            if (listMed != null) {
                json.add(gson.toJson(listMed));
                System.out.println(json);
                out.println(json);
            } else {
                out.println("error");
            }
        }
    }
}