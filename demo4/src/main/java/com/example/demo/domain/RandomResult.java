package com.example.demo.domain;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: lozijy
 * @Date: 2024/05/21/10:49
 * @Description:
 */
public class RandomResult {
    private final double mean;
    private final double stdDev;



    public double result(){
        Random random=new Random();
        return random.nextGaussian() * stdDev + mean;
    }

    public RandomResult(double mean, double stdDev) {
        this.mean=mean;
        this.stdDev=stdDev;
    }
}
