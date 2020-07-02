package com.drugsDB.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.drugsDB.DAO.PersonDAO;
import com.drugsDB.model.Person;

public class SpringApp {
    public static void main(String[] args) {

        addPerson();
    }

    public static void addPerson(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        PersonDAO personDAO = ctx.getBean("personDAO", PersonDAO.class);
//String id, String name, String address,int morning, int noon, int evening
        //Person p3 = new Person(null, "Jacek", "Wrocław, PL",9,13,20);
        Person p = new Person( "PankajKr",8,12,19);
        personDAO.create(p);
        System.out.println("Generated ID="+p.getId());

        Person p1 = new Person( "Tomek",8,12,18);
        personDAO.create(p1);
        Person p2 = new Person( "Marcin",7,14,21);
        personDAO.create(p2);
        Person p3 = new Person( "Jacek",9,13,20);
        personDAO.create(p3);

        //read
        Person p1read = personDAO.readById(p.getId());
        System.out.println("Retrieved Person="+p1read);

        ctx.close();
    }

//    public static void test(){
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//
//        PersonDAO personDAO = ctx.getBean("personDAO", PersonDAO.class);
//
//        Person p = new Person(null, "PankajKr", "Bangalore, India",8,12,19);
//
//        //create
//        personDAO.create(p);
//        System.out.println("Generated ID="+p.getId());
//
//        //read
//        Person p1 = personDAO.readById(p.getId());
//        System.out.println("Retrieved Person="+p1);
//
//        //update
//        p1.setName("David");p1.setAddress("SFO, USA");
//        personDAO.update(p1);
//        Person temp = personDAO.readById(p1.getId());
//        System.out.println("Retrieved Person after update="+temp);
//
//        //delete
//        int count = personDAO.deleteById(p1.getId());
//        System.out.println("Number of records deleted="+count);
//
//        ctx.close();
//    }
}
