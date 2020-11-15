package gt.com.clinica.clinicamedica.service;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.RoomDao;
import gt.com.clinica.clinicamedica.entity.RoomEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class RoomService implements ICrudService{
    /**
     * Obtiene la informacion enviada por el controlador para luego enviarla al dao y agregar una nueva habitacion
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int addData(BufferedReader br) throws IOException {
        RoomEntity room = new RoomEntity();
        RoomDao daor = new RoomDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        room.setState((jObj.getString("state")));
        room.setNuBed(jObj.getInt("nuBed"));
        room.setDescription(jObj.getString("description"));
          return  daor.addRoom(room);

    }

    /**
     * Obtiene los datos enviados del controlador para enviarla al dao y eliminar la habitacion
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int deleteData(BufferedReader br) throws IOException {
        RoomEntity room = new RoomEntity();
        RoomDao dao = new RoomDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
            System.out.println(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        room.setIdRoom(jObj.getInt("idRoom"));
        return dao.deleteRoom(room.getIdRoom());
        }

    /**
     * Obtiene la informacion enviada por el controlador para actualizar las habitaciones
     * @param br
     * @return
     * @throws IOException
     */
    @Override
    public int updateData(BufferedReader br) throws IOException {
        RoomEntity room = new RoomEntity();
        RoomDao dao = new RoomDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());

        room.setIdRoom(Integer.parseInt(jObj.getString("idClinic")));
        room.setDescription(String.valueOf(Integer.parseInt((jObj.getString("nocollege")))));
        room.setNuBed(Integer.parseInt((jObj.getString("speciality"))));
        room.setState((jObj.getString("address")));
           return dao.updateRoom(room);
        }

    /**
     * Retorna una lista con los datos
     * @return
     */
    @Override
    public List<String> listData() {
        RoomDao daoe = new RoomDao();
        List<RoomEntity> listEm = daoe.listAllRooms();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
            if (listEm != null) {
                for (RoomEntity emp : listEm) {
                    json.add(gson.toJson(emp));
                }
                return (json);
            } else {
                return null;
            }
        }

    /**
     * Obtenemos el id enviado por el controlador y retornamos los datos solicitados
     * @param id
     * @return
     */
    @Override
    public List<String> getDatabyId(int id) {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        RoomDao dao = new RoomDao();
        RoomEntity roomn = dao.getById(id);
            if (roomn != null) {
                json.add(gson.toJson(roomn));
                return (json);
            } else {
                return null;
            }
        }
}
