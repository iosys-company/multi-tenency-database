package my.work.multitenencydatabase.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import my.work.multitenencydatabase.demo.domain.Employee;
import my.work.multitenencydatabase.demo.dto.EmployeeDto;
import my.work.multitenencydatabase.demo.service.EmployeeService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeService.save(employee));
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> add(@RequestBody EmployeeDto employee) {
        return ResponseEntity.ok().body(employeeService.add(employee));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(employeeService.findAll());
    }
}
