package com.example.demo.service.serviceImpl;
import com.example.demo.mapper.fertilizerMapper;
import com.example.demo.pojo.Fertilizers;
import com.example.demo.service.fertilizersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/17:10
 * @Description:
 */
@Service
public class fertilizersServiceImpl implements fertilizersService {
    @Autowired
    private fertilizerMapper mapper;
    @Override
    public List<Fertilizers> queryAll() {
        return mapper.queryAll();
    }

    @Override
    public List<Fertilizers> queryById(Integer Id) {
        return mapper.queryById(Id);
    }

    @Override
    public void insert(Fertilizers fer) {
        mapper.insert(fer);
    }

    @Override
    public void update(Fertilizers fer) {
        mapper.update(fer);
    }

    @Override
    public void delete(Integer id) {
        mapper.delete(id);
    }
}
