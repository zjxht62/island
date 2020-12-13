package com.zjx.island.biz.junitdemo;

import org.junit.Assert;
import org.junit.Test;

/**
 * 测试Employee
 */
public class TestEmployeeDetails {
    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();
    EmployeeDetails employee = new EmployeeDetails();

    @Test
    public void testCalculateAppriasal() {
        employee.setAge(25);
        employee.setName("John");
        employee.setMonthlySalary(8000);

        double appriasal = empBusinessLogic.calculateAppraisal(employee);
        Assert.assertEquals(500, appriasal, 0.0);
    }

    @Test
    public void testCalculateYearlySalary() {
        employee.setName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);
        double salary= empBusinessLogic.getYearSalary(employee);
        Assert.assertEquals(96000, salary, 0.0);
    }
}
