package com.clinica.clinicamedica.dao;

import java.util.*;

/**
 * 
 */
public interface ICrudEmployee {

    /**
     * @return
     */
    public List<EmployeeEntity> listAllEmployees();

    /**
     * @param emp 
     * @return
     */
    public int addEmployee(EmployeeEntity emp);

    /**
     * @param emp 
     * @return
     */
    public int updateEmployee(EmployeeEntity emp);

    /**
     * @param id 
     * @return
     */
    public int deleteEmployee(int id);

}