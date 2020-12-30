package com.orm.bootstrap;

import com.orm.entity.Address;
import com.orm.entity.Person;
import com.orm.repo.AddressReepo;
import com.orm.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

public class DataGenerator implements CommandLineRunner {
    @Autowired
    PersonRepo personRepo;
    @Autowired
    AddressReepo addressReepo;

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person("Mike","Doe");
        Person p2 = new Person("Kari","Doe");
        Person p3 = new Person("Joe","Doe");
        Person p5 = new Person("Mark","Vlady");

        Address a1 = new Address("Kind ST","200009");
        Address a2 = new Address("16th ST","200009");
        Address a3 = new Address("29 ST","200009");
        Address a4 = new Address("Florida ST","200009");
        Address a5 = new Address("Howard ST","200009");
        //p1.setAddress(Arrays.asList(a1,a2));    case1
//case1
        personRepo.save(p1);

        a1.setPerson(p1);
        a2.setPerson(p1);
        a3.setPerson(p1);
        addressReepo.save(a1);
        addressReepo.save(a2);
        addressReepo.save(a3);

    }
}
