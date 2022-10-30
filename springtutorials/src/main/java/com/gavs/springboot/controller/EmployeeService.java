package com.gavs.springboot.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gavs.springboot.model.Employee;
import com.gavs.springboot.model.SpringDAO;
@RestController
//@RequestMapping(value="/emp")
public class EmployeeService {
	@RequestMapping("/hello")
    public String welcomepage() {
        return "hello to Spring REST Controller";
    }
    @RequestMapping(value="/findEmployee",method= RequestMethod.GET)
    public Employee homepage() {
        Employee emp=new Employee();
        emp.setId(123);
        emp.setName("Jobs");
        return emp;
    }
    @RequestMapping(value="/addEmployee",method= RequestMethod.POST)
    public int addEmployee(@RequestBody Employee emp) {
    	System.out.println(emp.getId()+" "+emp.getName());
      return 0;
    }
   
    @RequestMapping(value="/removeEmployee",method= RequestMethod.DELETE)
    public int removeEmployee(@RequestBody Employee emp) throws SQLException, Exception {
    	SpringDAO.deleteEmployee(emp);
    	System.out.println(emp.getId()+" "+emp.getName());
    	
        return 0;
    }
    @RequestMapping(value="/updateEmp",method=RequestMethod.PUT)
    public int updateEmp(@RequestBody Employee emp) throws Exception {
    	
    	System.out.println(emp.getId()+" "+emp.getName());
    	SpringDAO.modifyEmployee(emp);
    	return 0;
    }
}
