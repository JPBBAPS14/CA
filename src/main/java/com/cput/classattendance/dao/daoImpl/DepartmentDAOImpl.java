/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cput.classattendance.dao.daoImpl;

import com.cput.classattendance.dao.DepartmentDAO;
import com.cput.classattendance.domain.Department;
import com.cput.classattendance.repository.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Bradz
 */
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private DepartmentRepository departmentRepository;

    public static ApplicationContext ctx;
    private Long id;

    @Override
    public List<Department> getAllRecords() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getRecord(Long id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public void updateRecord(Long old, Department updated) {
        id = old;
        departmentRepository = ctx.getBean(DepartmentRepository.class);
        Department eOld = departmentRepository.findOne(old);
        Department updatedDepartment = updated;
        eOld = updated;
        departmentRepository.save(eOld);
    }

    @Override
    public void deleteRecord(Department s) {
        departmentRepository.delete(s);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department find(Long id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public Department persist(Department entity) {
        return departmentRepository.save(entity);
    }

    @Override
    public Department merge(Department entity) {
        if (entity.getId() != null) {
            return departmentRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Department entity) {
        departmentRepository.delete(entity);
    }

    @Override
    public void create() {

    }

}
