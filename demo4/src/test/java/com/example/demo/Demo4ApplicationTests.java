package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@SpringBootTest
class Demo4ApplicationTests {

    @Test
    void contextLoads() {
        //处理当前时间
        long currentTime = System.currentTimeMillis();

// 获取当日零点的时间戳
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long midnightTime = calendar.getTimeInMillis();

// 计算当前时间与当日零点的时间差
        long timeDifference = currentTime - midnightTime;

        double ok = timeDifference / (1000.0 * 60 * 60 * 24);
        System.out.println(ok);
    }

}
