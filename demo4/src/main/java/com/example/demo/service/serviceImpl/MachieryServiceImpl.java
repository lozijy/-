package com.example.demo.service.serviceImpl;

import com.example.demo.mapper.MachieryMapper;
import com.example.demo.pojo.FarmingMachinery;
import com.example.demo.service.MachineryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/15:56
 * @Description:
 */
@Service
public class MachieryServiceImpl implements MachineryService {
    @Autowired
    private MachieryMapper mapper;
    @Override
    public List<FarmingMachinery> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public List<FarmingMachinery> queryById(Integer ownerId) {
        return mapper.queryById(ownerId);
    }

    @Override
    public List<FarmingMachinery> queryByOwnerId(Integer ownerId) {
        return mapper.queryByOwnerId(ownerId);
    }

    @Override
    public void insert(FarmingMachinery machinery) {
        mapper.insert(machinery);
    }

    @Override
    public void update(FarmingMachinery machinery) {
        mapper.update(machinery);
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }

    @Override
    public void updateInfo(FarmingMachinery machinery) {
        mapper.updateInfo(machinery);
    }
}
