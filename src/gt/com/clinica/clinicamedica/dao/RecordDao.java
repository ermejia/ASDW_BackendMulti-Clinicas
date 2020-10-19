package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public class RecordDao implements ICrudRecord {

    /**
     * Default constructor
     */
    public RecordDao() {
    }

    /**
     * 
     */
    public void selectAllRecords;

    /**
     * 
     */
    public void addRecord;

    /**
     * 
     */
    public void updateRecord;

    /**
     * 
     */
    public void deleteRecord;

    /**
     * @return
     */
    public List<RecordEntity> listAllRecords() {
        // TODO implement here
        return null;
    }

    /**
     * @param record 
     * @return
     */
    public int addRecord(RecordEntity record) {
        // TODO implement here
        return 0;
    }

    /**
     * @param record 
     * @return
     */
    public int updateRecord(RecordEntity record) {
        // TODO implement here
        return 0;
    }

    /**
     * @param id 
     * @return
     */
    public int deleteRecord(int id) {
        // TODO implement here
        return 0;
    }

}