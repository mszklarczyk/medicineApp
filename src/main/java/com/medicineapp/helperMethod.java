package com.medicineapp;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public  class helperMethod {
    //    public static String getPersonID(String personName) {
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//
//        PersonDAO personDAO = ctx.getBean("personDAO", PersonDAO.class);
//
//        MongoDatabase db = DBconnection.DBconnect();
//        MongoCollection<Document> collection = db.getCollection("PersonInfo");
//
//        MongoCursor<Document> cursor = collection.find(eq("personName", personName)).iterator();
//
//        //System.out.println(cursor.next().toJson());
//            System.out.println();
//            String personN = cursor.next().get("_id").toString();
//            System.out.println(personN);
//            return personN;
//    }
    public static int getDayNumber(Date date){
        // return integer representing elapsed days since Jan. 1, 1970
        // millisec * sec * min * hours =1000 * 60 * 60 * 24 = 86400000
        long milisec =86400000L;

        //  convert a date to an integer and back again
        long currentTime=date.getTime();
        currentTime=currentTime/ milisec;
        return (int) currentTime;
    }


    public static Date dateAdd(Date currentDate, int plusDays) {
        //Helper class to return date in proper format
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //ISO_LOCAL_DATE
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, plusDays);
        Date currentDatePlusOne = c.getTime();
        //return dateFormat.format(currentDatePlusOne);
        return currentDatePlusOne;
    }
}
