package gt.com.clinica.clinicamedica.service;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.MedicineDao;
import gt.com.clinica.clinicamedica.entity.MedicineEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class MedicineService implements ICrudService{
    /**
     * Obtiene los datos enviados por el controlador para luego enviarlos al dao
     * @param br contiene los datos de la nueva medicina
     * @return
     * @throws IOException
     */
    @Override
    public int addData(BufferedReader br) throws IOException {
        MedicineEntity employee = new MedicineEntity();
        MedicineDao dao = new MedicineDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        /**
         * obtenemos los datos del buffer
         */
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        /**
         * convertimos los datos en un JSON
         */
        JSONObject jObj = new JSONObject(sb.toString());
        /**
         * agregamos los datos al entity
         */
        employee.setName(jObj.getString("name"));
        employee.setAdminway(jObj.getString("adminway"));
        employee.setLab(jObj.getString("lab"));
        employee.setDescription(jObj.getString("description"));
        employee.setExpirationdate(jObj.getString("expirationdate"));
        employee.setLots((jObj.getInt("lots")));

           return dao.addmedicine(employee);

    }

    /**
     * Obtenemos los datos del controlador y luego los enviamos al dao para eliminar
     * @param br Contiene la infrmacion de la medicina que se elimina
     * @return
     * @throws IOException
     */
    @Override
    public int deleteData(BufferedReader br) throws IOException {
        MedicineEntity med = new MedicineEntity();
        MedicineDao dao = new MedicineDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        /**
         * obtenemos los datos del buffer
         */
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
            System.out.println(a);
        }
        /**
         * convertimos los datos a un JSON
         */
        JSONObject jObj = new JSONObject(sb.toString());
        /**
         * los ingresamos al entity
         */
        med.setIdMedicine(jObj.getInt("idMedicine"));
        return dao.deletemedicine(med.getIdMedicine());

    }

    /**
     * Obtenemos los datos del controlador y luego lo enviamos al dao
     * @param br Contiene los datos de la medicina que se actualiza
     * @return
     * @throws IOException
     */
    @Override
    public int updateData(BufferedReader br) throws IOException {
        MedicineEntity med = new MedicineEntity();
        MedicineDao dao = new MedicineDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        /**
         * obtenemos los datos del buffer
         */
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
        }
        /**
         * lo convertimos a un Json
         */
        JSONObject jObj = new JSONObject(sb.toString());
/**
 * los añadimos al entity
 */
        med.setIdMedicine(jObj.getInt("idMedicine"));
        med.setDescription(((jObj.getString("description"))));
        med.setAdminway((jObj.getString("adminway")));
        med.setLab((jObj.getString("lab")));
        med.setName((jObj.getString("name")));
        med.setLots(jObj.getInt("lots"));
        med.setExpirationdate(((jObj.getString("expirationdate"))));

           return dao.updatemedicine(med);
        }

    /**
     * Retorna la lista de medicamnetos al controlador
     * @return
     */
    @Override
    public List<String> listData() {
        MedicineDao daom = new MedicineDao();
        List<String> json = new LinkedList<>();
        /**
         * obtenemos la lista del dao
         */
        List<MedicineEntity> listMedi = daom.listAll();
        Gson gson = new Gson();
            if (listMedi != null) {
                /**
                 * recorremos el array y convertimos los datos a JSON
                 */
                for (MedicineEntity medi : listMedi) {
                    json.add(gson.toJson(medi));
                }
                return (json);
            } else {
                return null;
        }
    }

    /**
     * Obtenemos el id enviado por el controladro y retornamos los datos solicitados
     * @param id
     * @return
     */
    @Override
    public List<String> getDatabyId(int id) {
        List<String> json = new LinkedList<>();
        MedicineDao dao = new MedicineDao();
        Gson gson = new Gson();
        /**
         * obtenemos los datos del dao
         */
        MedicineEntity listMed = dao.getById(id);
            if (listMed != null) {
                json.add(gson.toJson(listMed));
                return (json);
            } else {
                return null;
            }
        }
}
