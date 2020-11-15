package gt.com.clinica.clinicamedica.service;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.DoctorDao;
import gt.com.clinica.clinicamedica.entity.DoctorEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class DoctorService implements ICrudService{
    @Override
    public int addData(BufferedReader br) throws IOException {
        return 0;
    }

    /**
     * Obtiene los datos que se envia del controlador y luego los envia al dao para que se elimine
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int deleteData(BufferedReader br) throws IOException {
        DoctorEntity doctor = new DoctorEntity();
        DoctorDao dao = new DoctorDao();
        doctor.setIdDoctor(1);
        return dao.deleteDoctor(doctor.getIdDoctor());
    }

    /**
     * obteine los datos enviados por le controlador y los envia al dao para actualizar la informacion del doctor
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int updateData(BufferedReader br) throws IOException {
        DoctorEntity doctor = new DoctorEntity();
        DoctorDao dao = new DoctorDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        /*
        doctor.setIdDoctor(Integer.parseInt(jObj.getString("idClinic")));
        doctor.setNoCollegiate(Integer.parseInt((jObj.getString("nocollege"))));
        doctor.setSpeciality((jObj.getString("speciality")));
        doctor.setAddress((jObj.getString("address")));
        doctor.setBirthdate((jObj.getString("birthdate")));
        doctor.setContactphone(Integer.parseInt((jObj.getString("contactphone"))));
        doctor.setDpi(Integer.parseInt((jObj.getString("dpi"))));
        */

           return dao.updateDoctor(doctor);

    }

    /**
     * retorna una lista con los doctores
     * @return
     */
    @Override
    public List<String> listData() {
        DoctorDao daod = new DoctorDao();
        List<DoctorEntity> listDocs = daod.listAllDoctors();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
            if (listDocs != null) {
                for (DoctorEntity doc : listDocs) {
                    json.add(gson.toJson(doc));
                }
                return (json);
            } else {
                return null;
            }

    }

    /**
     * obtiene el id enviado por el controlador y retorna los datos del doctor solicitado
     * @param id
     * @return
     */
    @Override
    public List<String> getDatabyId(int id) {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        DoctorDao dao = new DoctorDao();
        DoctorEntity clinic = dao.getById(id);
            if (clinic != null) {
                json.add(gson.toJson(clinic));
                return(json);
            } else {
                return null;
            }
    }
}
