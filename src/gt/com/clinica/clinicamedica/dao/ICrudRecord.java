package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudRecord {

    /**
     * @return
     */
    public List<RecordEntity> listAllRecords();

    /**
     * @param record 
     * @return
     */
    public int addRecord(RecordEntity record);

    /**
     * @param record 
     * @return
     */
    public int updateRecord(RecordEntity record);

    /**
     * @param id 
     * @return
     */
    public int deleteRecord(int id);

}