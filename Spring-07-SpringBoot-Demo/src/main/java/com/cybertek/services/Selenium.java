package com.cybertek.services;

import com.cybertek.interfaces.Cource;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Cource {
    @Override
    public int getTeachingHours() {
        return 40;
    }
}
