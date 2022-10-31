package com.nitin.rws.service;

import com.nitin.rws.entity.Employee;
import com.nitin.rws.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepo empRepo;

    public void addEmp(Employee employee){
        empRepo.save(employee);
    }

    public List<Employee> getAllEmp(){
        return empRepo.findAll();
    }

    public Employee getEmpById(int id){
        Optional<Employee> employee= empRepo.findById(id);
        if (employee.isPresent())
        {
            return employee.get();
        }
        return null;
    }

    public void deleteEmp(int id){
        empRepo.deleteById(id);
    }
    public Page<Employee> getEMpByPaginate(int currentPage, int size) {
        Pageable p = PageRequest.of(currentPage, size);
        return empRepo.findAll(p);
    }

}
