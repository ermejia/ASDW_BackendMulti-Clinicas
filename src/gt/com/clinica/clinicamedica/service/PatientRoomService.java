package gt.com.clinica.clinicamedica.service;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.PatientRoomDao;
import gt.com.clinica.clinicamedica.entity.PatientRoomEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class PatientRoomService implements ICrudService {
    /**
     * obtiene el id enviado por el controlador y retorna los datos de la habitacon solicitada
     * @param id
     * @return
     */
    @Override
    public List<String> getDatabyId(int id) {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        PatientRoomDao dao = new PatientRoomDao();
        PatientRoomEntity pr1 = dao.getById(id);
        if (pr1 != null) {
            json.add(gson.toJson(pr1));
            return (json);
        } else {
            return null;
        }
    }

    /**
     * Obtiene los datos enviados por el controlador y luego los envia al dao para añadir una nueva habitacion
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int addData(BufferedReader br) throws IOException {
        PatientRoomEntity ptr = new PatientRoomEntity();
        PatientRoomDao dao = new PatientRoomDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        ptr.setDpi(jObj.getInt("dpi"));
        ptr.setIdRoom(jObj.getInt("idRoom"));
        ptr.setDateIn(Date.valueOf(jObj.getString("dateIn")));
           return dao.addPtr(ptr);
    }

    @Override
    public int deleteData(BufferedReader br) throws IOException {
        return 0;
    }

    /**
     * Obtiene la informacion de la habitacion para enviarlas al dao y actualizar la habitacion
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int updateData(BufferedReader br) throws IOException {
        PatientRoomEntity pr = new PatientRoomEntity();
        PatientRoomDao dao = new PatientRoomDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
            System.out.println(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());

        pr.setDateIn(Date.valueOf((jObj.getString("FechaIngreso"))));
        pr.setDateOut(Date.valueOf(((jObj.getString("FechaSalida")))));
        pr.setDpi((jObj.getInt("DPI")));
        pr.setIdPatientRoom((jObj.getInt("IdPacienteHabitacion")));
        pr.setIdRoom((jObj.getInt("IdHabitacion")));
            return 0;
    }

    /**
     * Retorna una lista con las habitaciones y los pacientes que se encuentran enc ada una
     * @return
     */
    @Override
    public List<String> listData() {
        PatientRoomDao daopr = new PatientRoomDao();
        List<PatientRoomEntity> listPre = daopr.listAllRoomsP();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
            if (listPre != null) {
                for (PatientRoomEntity pre : listPre) {
                    json.add(gson.toJson(pre));
                }
                System.out.println(json);
                return(json);
            } else {
                return null;
            }
          }
}
