package my.work.multitenencydatabase.demo.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import my.work.multitenencydatabase.demo.dto.EmployeeDto;
import my.work.multitenencydatabase.demo.mapper.EmployeeMapper;

import java.util.List;

// @RequiredArgsConstructor
@Repository
public class EmployeeRepository {

    private final EmployeeMapper mapper;

    public EmployeeRepository(@Qualifier("tenantSqlSession") SqlSession sqlSession) {
        mapper = sqlSession.getMapper(EmployeeMapper.class);
    }

    public List<EmployeeDto> findAll() {
        List<EmployeeDto> list = mapper.findAll();
        return list;
    }
}
