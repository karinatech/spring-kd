package com.cybertek.services;
import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
    @Autowired
private ExtraSessions extraSessions;


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : "+ (30+ extraSessions.getHours()));
    }
//@Autowired
//    public Java(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }
//@Autowired
//    public void setOfficeHours(OfficeHours officeHours) {
//        this.officeHours = officeHours;
//    }


}
