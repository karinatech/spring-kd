package com.cybertek.services;

import com.cybertek.interfaces.Cource;
import com.cybertek.interfaces.ExtraSesssion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Java implements Cource {
    @Value("${master}")
    private String master;


    public Java(ExtraSesssion extraSesssion) {
        this.extraSesssion = extraSesssion;
    }

    @Override
    public int getTeachingHours() {
        return 20+extraSesssion.getExtraHours();
    }
    private final ExtraSesssion extraSesssion;
}
