package com.cybertek.services;

import com.cybertek.interfaces.ExtraSesssion;
import org.springframework.stereotype.Component;

@Component
public class OfficeHours implements ExtraSesssion {
    @Override
    public int getExtraHours() {
        return 3;
    }
}
