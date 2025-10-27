package com.tj330.empmanager.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import com.tj330.empmanager.service.EmployeeService;
import com.tj330.empmanager.model.Employee;

import java.util.List;

@ShellComponent
public class EmpShellCommands {

    @Autowired
    private EmployeeService employeeService;

    @ShellMethod("Add a new employee")
    public String addEmployee(String name, String email, String salary) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setSalary(salary);
        employeeService.addEmployee(employee);
        return "Employee added: " + name;
    }

    @ShellMethod("Update an employee")
    public String updateEmployee(Long id, String name, String email, String salary) {
        Employee employee = employeeService.getEmployeeById(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setSalary(salary);
        employeeService.updateEmployee(id, employee);
        return "Employee updated: " + name;
    }

    @ShellMethod("List all employees")
    public List<Employee> listEmployees() {
        return employeeService.getAllEmployees();
    }

    @ShellMethod("Delete an employee by ID")
    public String deleteEmployee(Long id) {
        employeeService.deleteEmployee(id);
        return "Employee deleted with ID: " + id;
    }

    @ShellMethod("Get employee details by ID")
    public String getEmployee(Long id) {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            return "Error: Employee not found with ID " + id;
        }

        return employee.toString();
    }
}