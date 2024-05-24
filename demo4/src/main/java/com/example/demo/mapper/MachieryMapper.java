package com.example.demo.mapper;

import com.example.demo.pojo.FarmingMachinery;
import com.example.demo.pojo.Temperatureandhumiditysensordata;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/15:24
 * @Description:
 */
@Repository
@Mapper
public interface MachieryMapper {
    List<FarmingMachinery> queryAll();
    List<FarmingMachinery> queryById(Integer oId);
    List<FarmingMachinery> queryByOwnerId(Integer ownerId);

    void insert(FarmingMachinery machinery);
    void update(FarmingMachinery machinery);
    void delete(Integer id);
    void updateInfo(FarmingMachinery machinery);

}
