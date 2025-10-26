package com.tj330.empmanager.controller;
//mwone nink vendi malyalam comments set akkitu ind chatgpt aa blame chynde if spelling mistake
import com.tj330.empmanager.exception.RNFE;
import com.tj330.empmanager.model.Employee;
import com.tj330.empmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // പുതിയ Employee create ചെയ്യാൻ
    // Name/email empty ആണെങ്കിൽ IllegalArgumentException throw ചെയ്യും
    // Success ആണെങ്കിൽ saved Employee return ചെയ്യും (HTTP 201)
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        if (employee.getName() == null || employee.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }
        if (employee.getEmail() == null || employee.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee email cannot be empty");
        }
        Employee savedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    // എല്ലാ Employee-കളും list ആയി return ചെയ്യാൻ
    // Success ആണെങ്കിൽ HTTP 200 OK status
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    // ID വഴി ഒരു Employee detail fetch ചെയ്യാൻ
    // Employee കാണാനില്ലെങ്കിൽ RNFE (ResourceNotFoundException) throw ചെയ്യും
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            throw new RNFE("Employee not found with ID: " + id);
        }
        return ResponseEntity.ok(employee);
    }

    // Employee update ചെയ്യാൻ
    // Employee exist ചെയ്യില്ലെങ്കിൽ RNFE throw ചെയ്യും
    // Success ആണെങ്കിൽ updated Employee return ചെയ്യും
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        if (updatedEmployee == null) {
            throw new RNFE("Employee not found with ID: " + id);
        }
        return ResponseEntity.ok(updatedEmployee);
    }

    // Employee delete ചെയ്യാൻ
    // Employee exist ചെയ്യില്ലെങ്കിൽ RNFE throw ചെയ്യും
    // Success ആണെങ്കിൽ HTTP 204 No Content return ചെയ്യും
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (!deleted) {
            throw new RNFE("Employee not found with ID: " + id);
        }
        return ResponseEntity.noContent().build();
    }
}
