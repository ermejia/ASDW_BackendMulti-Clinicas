package gt.com.clinica.clinicamedica.service;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.EmployeeDao;
import gt.com.clinica.clinicamedica.entity.EmployeeEntity;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class EmployeeService implements ICrudService {
    /**
     * Añade un empleado nuevo a la base de datos
     * @param br Contiene los datos del empleado enviados del frontend
     * @return
     * @throws IOException
     */
    @Override
    public int addData(BufferedReader br) throws IOException {
        EmployeeEntity employee = new EmployeeEntity();
        EmployeeDao dao = new EmployeeDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        /**
         * Se obtienen los datos del buffer
         */
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        /**
         * los datos se convierten a JSON
         */
        JSONObject jObj = new JSONObject(sb.toString());
        /**
         * Se almacenan los datos en la variable employee
         */
        employee.setDpi((jObj.getInt("dpi")));
        employee.setName(jObj.getString("name"));
        employee.setSurname(jObj.getString("surname"));
        employee.setAddress(jObj.getString("address"));
        employee.setPhone(jObj.getInt("phone"));
        employee.setBirthdate(jObj.getString("birthdate"));
        employee.setContactphone(jObj.getInt("contactphone"));
        employee.setIdJob(Integer.parseInt(jObj.getString("idJob")));
        employee.setGender(jObj.getString("gender"));
        if(dao.addemployee(employee) !=1) {
            return 0;
        }else{
            return 1;
        }

    }

    /**
     * Elimina un empleado de la base de datos
     * @param br contiene los datos del empleado que se desea eliminar
     * @return
     * @throws IOException
     */
    @Override
    public int deleteData(BufferedReader br) throws IOException {
        EmployeeEntity employee = new EmployeeEntity();
        EmployeeDao dao = new EmployeeDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        /**
         * Se obtienen los datos del buffer y se almacenan en un json
         */
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        employee.setIdEmpmloyee(jObj.getInt("idEmpmloyee"));
        return dao.deleteemployee(employee.getIdEmpmloyee());

    }

    /**
     * Actualiza un empleado en la bse de datos
     * @param br Contiene los datos actualizados enviado por el frontend
     * @return
     * @throws IOException
     */
    @Override
    public int updateData(BufferedReader br) throws IOException {
        EmployeeEntity employee = new EmployeeEntity();
        EmployeeDao dao = new EmployeeDao();
        StringBuilder sb = new StringBuilder();
        String str = null;
        /**
         * Se obtienen los datos del buffer
         */
        while ((str = br.readLine()) != null) {
            String a = str.substring(1, str.length() -1);
            sb.append(a);
        }
        /**
         * Convertimos los datos en un JSON
         */
        JSONObject jObj = new JSONObject(sb.toString());
        /**
         * Se agregan los datos al entity
         */
        employee.setIdEmpmloyee(jObj.getInt("idEmpmloyee"));
        employee.setDpi(jObj.getInt("dpi"));
        employee.setName(jObj.getString("name"));
        employee.setSurname(jObj.getString("surname"));
        employee.setAddress(jObj.getString("address"));
        employee.setPhone(jObj.getInt("phone"));
        employee.setBirthdate(jObj.getString("birthdate"));
        employee.setContactphone(jObj.getInt("contactphone"));
        employee.setIdJob(jObj.getInt("idJob"));
        employee.setGender(jObj.getString("gender"));

        return dao.updateemployee(employee);
    }

    /**
     * Retorna una lista con los empleados
     * @return
     */
    @Override
    public List<String> listData() {
        EmployeeDao daoe = new EmployeeDao();
        List<String> json = new LinkedList<>();
        /**
         * obtenemos la lista de Empleados
         */
        List<EmployeeEntity> listEm = daoe.listAll();
        Gson gson = new Gson();
            if (listEm != null) {
                /**
                 * recorremos el array y lo convertimos a JSON
                 */
                for (EmployeeEntity emp : listEm) {
                    json.add(gson.toJson(emp));
                }
                return (json);
            } else {
                return (null);
            }
    }

    /**
     * Retorna un empleado bado por el id enviado por el frontend
     * @param id
     * @return
     */
    @Override
    public List<String> getDatabyId(int id) {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        EmployeeDao dao = new EmployeeDao();
        /**
         * obtenemos los datos del dao
         */
        EmployeeEntity listEm = dao.getById(id);
            if (listEm != null) {
                /**
                 * Se convierten a JSON y lo retornamos al controlador
                 */
                json.add(gson.toJson(listEm));
                return json;
            } else {
                return null;
            }
    }
}
