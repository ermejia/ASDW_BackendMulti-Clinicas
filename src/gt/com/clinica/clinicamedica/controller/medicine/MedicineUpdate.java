package gt.com.clinica.clinicamedica.controller.medicine;

import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.MedicineDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
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

@WebServlet("/updateMedicine")
public class MedicineUpdate extends HttpServlet {
    /**
     * Obtiene los datos actualizados del frontend
     * @param request Datos actualizados
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MedicineService med = new MedicineService();
        BufferedReader br = request.getReader();
        try (PrintWriter out = response.getWriter()) {
            if(med.updateData(br)!=1){
                out.println("Error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
