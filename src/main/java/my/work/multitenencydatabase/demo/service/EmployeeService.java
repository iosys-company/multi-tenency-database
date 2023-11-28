package my.work.multitenencydatabase.demo.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import my.work.multitenencydatabase.demo.domain.Employee;
import my.work.multitenencydatabase.demo.repository.EmployeeRepository;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
}
