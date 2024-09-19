package com.llz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.llz.dao.po.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Test1Dao extends BaseMapper<Student> {
}
