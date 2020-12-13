package com.zjx.island.biz.junitdemo;

/**
 * JuintDemo的逻辑类
 */
public class EmpBusinessLogic {
    public double getYearSalary(EmployeeDetails employeeDetails) {
        double yearSalary = 0;
        yearSalary = employeeDetails.getMonthlySalary() * 12;
        return yearSalary;
    }

    // Calculate the appraisal amount of employee
    public double calculateAppraisal(EmployeeDetails employeeDetails){
        double appraisal=0;
        if(employeeDetails.getMonthlySalary() < 10000){
            appraisal = 500;
        }else{
            appraisal = 1000;
        }
        return appraisal;
    }
}
