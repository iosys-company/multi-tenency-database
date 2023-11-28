package my.work.multitenencydatabase.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import my.work.multitenencydatabase.demo.domain.Employee;
import my.work.multitenencydatabase.demo.dto.EmployeeDto;
import my.work.multitenencydatabase.demo.mapper.EmployeeMapper;
import my.work.multitenencydatabase.demo.repository.EmployeeRepository;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<EmployeeDto> findAll() {
        return employeeMapper.findAll();
    }
}
