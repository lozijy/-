package com.example.demo.service;

import com.example.demo.pojo.Fertilizers;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/20/17:08
 * @Description:
 */

@Service
public interface fertilizersService {
    List<Fertilizers> queryAll();
    List<Fertilizers> queryById(Integer Id);

    void insert(Fertilizers fer);
    void update(Fertilizers fer);
    void delete(Integer id);
}
