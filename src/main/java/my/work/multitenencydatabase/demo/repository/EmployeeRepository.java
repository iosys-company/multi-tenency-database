package my.work.multitenencydatabase.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.work.multitenencydatabase.demo.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
