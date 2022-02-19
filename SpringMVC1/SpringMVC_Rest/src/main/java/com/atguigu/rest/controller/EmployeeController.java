package com.atguigu.rest.controller;

import com.atguigu.rest.bean.Employee;
import com.atguigu.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;



    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        Collection<Employee> employeelist = employeeDao.getAll();
        System.out.println(employeelist);
        model.addAttribute("employeelist",employeelist);
        return "employee_list";

    }
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String add(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";

    }
    @RequestMapping(value="employee/{id}",method = RequestMethod.GET)
    public String getid(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";

    }
    @RequestMapping(value = "/employee")
    public String put(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";

    }
}
