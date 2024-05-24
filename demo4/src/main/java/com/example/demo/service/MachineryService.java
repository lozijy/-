package com.example.demo.service;

import com.example.demo.pojo.FarmingMachinery;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/15:55
 * @Description:
 */
public interface MachineryService {
    List<FarmingMachinery> queryAll();
    List<FarmingMachinery> queryByOwnerId(Integer ownerId);
    List<FarmingMachinery> queryById(Integer Id);
    void insert(FarmingMachinery machinery);
    void update(FarmingMachinery machinery);
    void delete(Integer id);
    void updateInfo(FarmingMachinery machinery);
}
