package my.work.multitenencydatabase.demo.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import my.work.multitenencydatabase.demo.dto.EmployeeDto;
import my.work.multitenencydatabase.demo.mapper.EmployeeMapper;

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
