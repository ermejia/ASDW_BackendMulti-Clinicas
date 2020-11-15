package gt.com.clinica.clinicamedica.service;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.ClinicDao;
import gt.com.clinica.clinicamedica.entity.ClinicEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class ClinicService implements ICrudService{
    /**
     * Obtiene los datos del controlador, luego los envia al dao y añade la nueva Clinica
     * @param br Contiene los datos de la clinica
     * @return
     * @throws IOException
     */
    @Override
    public int addData(BufferedReader br) throws IOException {
        ClinicEntity clinicEntity = new ClinicEntity();
        ClinicDao daoc = new ClinicDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
            System.out.println(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        clinicEntity.setNameClinic((jObj.getString("nameClinic")));
        clinicEntity.setDescription(jObj.getString("description"));
          return daoc.addClinic(clinicEntity);

    }

    /**
     * Obtienen los datos del controlador para luego eliminar la clinica
     * @param br Contiene los datos de la clinica que se eliminará
     * @return
     * @throws IOException
     */
    @Override
    public int deleteData(BufferedReader br) throws IOException {
        ClinicEntity clinic = new ClinicEntity();
        ClinicDao dao = new ClinicDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
            System.out.println(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        clinic.setIdClinic(jObj.getInt("idClinic"));
        return dao.deleteClinic(clinic.getIdClinic());
    }

    /**
     * Obtiene los datos del controlador y los envia al dao para actualizar los datos de la clinica
     * @param br Contiene los datos que se deben actualizar
     * @return
     * @throws IOException
     */
    @Override
    public int updateData(BufferedReader br) throws IOException {
        ClinicEntity clinic = new ClinicEntity();
        ClinicDao dao = new ClinicDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
            System.out.println(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        clinic.setIdClinic(jObj.getInt("idClinic"));
        clinic.setDescription((jObj.getString("description")));
        clinic.setNameClinic((jObj.getString("nameClinic")));
           return dao.updateClinic(clinic);

    }

    /**
     * Retorna al controlador la lista de las clinicas
     * @return
     */
    @Override
    public List<String> listData() {
        ClinicDao daoc = new ClinicDao();
        List<ClinicEntity> listClinic = daoc.listAllClinic();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
            if (listClinic != null) {
                for (ClinicEntity cli : listClinic) {
                    json.add(gson.toJson(cli));
                }
                return(json);
            } else {
               return null;
            }
    }

    /**
     * Obtiene el id enviado por el controlador y luego retorna los datos de la clinica solicitada
     * @param id
     * @return
     */
    @Override
    public List<String> getDatabyId(int id) {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        ClinicDao dao = new ClinicDao();
        ClinicEntity clinic = dao.getById(id);
            if (clinic != null) {
                json.add(gson.toJson(clinic));
                return(json);
            } else {
                return null;
            }

    }
}
