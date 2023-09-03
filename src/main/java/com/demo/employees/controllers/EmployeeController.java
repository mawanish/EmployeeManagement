package com.demo.employees.controllers;

import com.demo.employees.model.Employee;
import com.demo.employees.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@RestController
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @RequestMapping("/test")
  public String hello() {
    return "Hello User, Welcome to Spring Boot world!, This is modified configuration";
  }

  @PostMapping("/employee")
  Employee create(@RequestBody Employee employee)  {
    return employeeService.save(employee);
  }

  @GetMapping("/employee")
  Iterable<Employee> read() {
    return employeeService.findAll();
  }

  @PutMapping("/employee")
  Employee update(@RequestBody Employee employee) {
    return employeeService.save(employee);
  }

  @DeleteMapping("/employee/{id}")
  void delete(@PathVariable Integer id) {
	  employeeService.deleteById(id);
  }

  @GetMapping("/wrong")
  Employee somethingIsWrong() {
    throw new ValidationException("Something is wrong");
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ValidationException.class)
  String exceptionHandler(ValidationException e) {
    return e.getMessage();
  }
}
