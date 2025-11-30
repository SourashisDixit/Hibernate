package com.jspider.main;


import com.jspider.Address;
import com.jspider.Audi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {
    private static SessionFactory sessionFactory = null;

    static
    {
        //load configuration
        System.out.println("1.Load Configuration");
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        //create sessionfactory
        System.out.println("2.Create SessionFactory");
        sessionFactory = config.buildSessionFactory();
    }

    public static void saveAudi()
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Creating Audi data");
        Audi a1 = new Audi();
        a1.setName("AUDI-2");
        a1.setSeatRows(21);
        a1.setSeatColumns(31);

        System.out.println("Creating Address data");
        Address adr1 = new Address();
        adr1.setStreet("Street-2");
        adr1.setArea("Marathali");
        adr1.setCity("BLR");

        System.out.println("Linking Audi to Address ");
        a1.setAddress(adr1);//link Audi to Address

        session.persist(a1);

        System.out.println("Audi and Address saved!!");

        transaction.commit();
        session.close();
        System.out.println("Session closed");
    }

    public static void deleteAudi(Long id)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Finding Audi data with id : "+id);
        Audi a1 = session.find(Audi.class,id);
        session.remove(a1);
        System.out.println("Audi and Address deleted!!");
        transaction.commit();
        session.close();
        System.out.println("Session closed");
    }

    public static void getAudiDetails(Long id)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        System.out.println("Finding Audi data with id : "+id);
        Audi a1 = session.find(Audi.class,id);

        System.out.println();
        System.out.println("============================");
        System.out.println("ID: "+a1.getId());
        System.out.println("Name :"+a1.getName());
        System.out.println("Column Seat:"+a1.getSeatColumns());
        System.out.println("Rows Seat "+a1.getSeatRows());

        System.out.println("Area :"+a1.getAddress().getArea());
        System.out.println("City :"+a1.getAddress().getCity());
        System.out.println("Steet :"+a1.getAddress().getStreet());




        System.out.println("============================");


        //System.out.println(a1);

        transaction.commit();
        session.close();
        System.out.println("Session closed");
    }




    public static void getAddressDetails(Long id)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("Finding Audi data with id : "+id);
        Address ad1 = session.find(Address.class,id);

        System.out.println();
        System.out.println("===========AddressDetails=================");


        System.out.println(ad1.getId());
        System.out.println(ad1.getArea());
        System.out.println(ad1.getCity());
        System.out.println(ad1.getStreet());
        System.out.println();
        System.out.println("--------Audi details...---------");

        System.out.println(ad1.getAudi().getName());
        System.out.println(ad1.getAudi().getSeatColumns());
        System.out.println(ad1.getAudi().getSeatRows());
        System.out.println(ad1.getAudi().getId());
        System.out.println("============================");


        //System.out.println(a1);

        transaction.commit();
        session.close();
        System.out.println("Session closed");
    }


//    public static void setAudiProperties(){
//
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        System.out.println("Creating Audi data");
//        Audi a1 = new Audi();
//        a1.setName("AUDI-2");
//        a1.setSeatRows(21);
//        a1.setSeatColumns(31);
//
//        System.out.println("Creating Address data");
//        Address adr1 = new Address();
//        adr1.setStreet("Street-2");
//        adr1.setArea("Marathali");
//        adr1.setCity("BLR");
//
//        System.out.println("Linking Audi to Address ");
//        a1.setAddress(adr1);//link Audi to Address
//
//        session.persist(a1);
//
//        System.out.println("Audi and Address saved!!");
//
//        transaction.commit();
//        session.close();
//        System.out.println("Session closed");
//
//    }

    public static void main(String[] args) {

        System.out.println("Program starts...");

      //  saveAudi();
      //  saveAudi();
         // deleteAudi(5l);

   //getAudiDetails(2L);
      // getAddressDetails(1L);



        System.out.println("4.Close Session Factory");
        sessionFactory.close();

        System.out.println("Program ends...");

    }
}