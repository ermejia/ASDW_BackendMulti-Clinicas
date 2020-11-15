package gt.com.clinica.clinicamedica.controller.stall;

import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.dao.StallDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import gt.com.clinica.clinicamedica.entity.StallEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteStall")
public class StallDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*
        StallEntity doctor = new StallEntity();
        StallDao dao = new StallDao();
        doctor.setIdStall(Integer.parseInt(request.getParameter("idStall")));
        int a = dao.delete(doctor.getIdStall());
        try (PrintWriter out = response.getWriter()) {
            if(a!=0){
            }else{
                out.println("[error]");
            }
        }

       */
    }

}
