package com.demo.employees.controllers;

import com.demo.employees.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ValidationException;

@SpringBootTest
public class IntegrationTests {

  @Autowired
  EmployeeController employeeController;

  @Test
  public void testCreateReadDelete() {
    Employee employee = new Employee("Lokesh", "Gupta");

    Employee employeeResult = employeeController.create(employee);

    Iterable<Employee> employees = employeeController.read();
    Assertions.assertThat(employees).first().hasFieldOrPropertyWithValue("firstName", "Lokesh");

    employeeController.delete(employeeResult.getId());
    Assertions.assertThat(employeeController.read()).isEmpty();
  }

  @Test
  public void errorHandlingValidationExceptionThrown() {

    Assertions.assertThatExceptionOfType(ValidationException.class)
        .isThrownBy(() -> employeeController.somethingIsWrong());
  }
}
