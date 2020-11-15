package gt.com.clinica.clinicamedica.service;

import com.google.gson.Gson;
import gt.com.clinica.clinicamedica.dao.StallDao;
import gt.com.clinica.clinicamedica.entity.StallEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class StallService implements ICrudService{
    /**
     * Retorna al controlador la lista de los puestos
     * @return
     */
    @Override
    public List<String> listData() {
        StallDao daos = new StallDao();
        List<StallEntity> listStall = daos.listAllStalls();
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        if (listStall != null) {
            for (StallEntity stal : listStall) {
                json.add(gson.toJson(stal));
            }
            return (json);
        } else {
            return null;
        }
    }

    /**
     * Obtiene el id que envia el controlador y retorna el puesto solicitado
     * @param id
     * @return
     */
    @Override
    public List<String> getDatabyId(int id) {
        List<String> json = new LinkedList<>();
        Gson gson = new Gson();
        StallDao dao = new StallDao();
        StallEntity stall1 = dao.getById(id);
            if (stall1 != null) {
                json.add(gson.toJson(stall1));
                return (json);
            } else {
                return null;
            }
        }

    @Override
    public int addData(BufferedReader br) throws IOException {
        return 0;
    }

    @Override
    public int deleteData(BufferedReader br) throws IOException {
        return 0;
    }

    @Override
    public int updateData(BufferedReader br) throws IOException {
        return 0;
    }
}
