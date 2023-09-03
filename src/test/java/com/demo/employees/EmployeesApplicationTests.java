package com.demo.employees;

import com.demo.employees.controllers.EmployeeController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeesApplicationTests {

  @Autowired
  EmployeeController employeeController;

  @Test
  public void contextLoads() {
    Assertions.assertThat(employeeController).isNotNull();
  }
}
