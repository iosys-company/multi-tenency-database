package my.work.multitenencydatabase.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import my.work.multitenencydatabase.demo.dto.EmployeeDto;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDto> findAll();

    int insert(EmployeeDto employeeDto);
}