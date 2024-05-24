package com.example.demo.mapper;

import com.example.demo.pojo.FarmingMachinery;
import com.example.demo.pojo.Fertilizers;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/17:00
 * @Description:
 */
@Repository
@Mapper
public interface fertilizerMapper {
    List<Fertilizers> queryAll();
    List<Fertilizers> queryById(Integer Id);
    void insert(Fertilizers fer);
    void update(Fertilizers fer);
    void delete(Integer id);
}
