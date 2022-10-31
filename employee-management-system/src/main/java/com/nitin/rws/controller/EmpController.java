package com.nitin.rws.controller;
import com.nitin.rws.entity.Employee;
import com.nitin.rws.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmpController
{
    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String home(Model model) {
        return findPaginated(0, model);
    }

//    @GetMapping("/")
//    public String home(Model model) {
//
//        List<Employee> employees=empService.getAllEmp();
//        model.addAttribute("emp",employees);
//        return "index";
//    }
    @GetMapping("/addemp")
    public String addEmpForm() {
        return "add_emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee employee, HttpSession session)
    {
        System.out.println(employee);

        empService.addEmp(employee);
        session.setAttribute("mssg","Employee Added Sucessfully...");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Employee employee=empService.getEmpById(id);
        model.addAttribute("emp",employee);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee employee, HttpSession session)
    {
      empService.addEmp(employee);
      session.setAttribute("mssg","Emp Data Updated Sucessfully....");
      return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session)
    {
        empService.deleteEmp(id);
        session.setAttribute("mssg","Emp Data Deleted Sucessfully....");
        return "redirect:/";
    }

    @GetMapping("/page/{pageno}")
    public String findPaginated(@PathVariable int pageno, Model m) {
        Page<Employee> emplist = empService.getEMpByPaginate(pageno, 10);
        m.addAttribute("emp", emplist);
        m.addAttribute("currentPage", pageno);
        m.addAttribute("totalPages", emplist.getTotalPages());
        m.addAttribute("totalItem", emplist.getTotalElements());
        return "index";
    }
}
