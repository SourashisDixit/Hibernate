package com.jspider.main;

import com.jspider.Audi;
import com.jspider.Shows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class OneToMany {
    private static SessionFactory sessionFactory = null;
    static
    {
        //load configuration
        System.out.println("1.Load Configuration");
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        System.out.println("2.Create SessionFactory");
        sessionFactory = config.buildSessionFactory();




    }


    public static void getAudiAndShow(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Created Auditorium");
        Audi a1=new Audi();
        a1.setName("Audi-20");
        a1.setSeatColumns(50);
        a1.setSeatRows(30);

        System.out.println("creating show 1");
        Shows s1=new Shows();
        s1.setEndTime(LocalDate.now());
        s1.setShowTime(LocalDate.now());
        s1.setStatus("Available");

        System.out.println("creating show 2");
        Shows s2 =new Shows();
        s2.setEndTime(LocalDate.now());
        s2.setShowTime(LocalDate.now());
        s2.setStatus("Available");


        System.out.println("Linking to audi");
        a1.getShows().add(s1);
        a1.getShows().add(s2);
        session.persist(a1);
        transaction.commit();
        session.close();
    }

    public static void getShowsByAudiId(Long audiId){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        System.out.println("Finding audi id "+audiId);
        Audi audi=session.find(Audi.class,audiId);
        List<Shows>shows=audi.getShows();
        System.out.println("-------------Show deatails-----");
        for(int i=0;i<shows.size();i++){
            System.out.println();
            System.out.println(shows.get(i).getShowTime());
            System.out.println(shows.get(i).getEndTime());
            System.out.println(shows.get(i).getStatus());
        }
        System.out.println("------show details----------");

        transaction.commit();
        session.close();

    }
//    public static void addShows(Long audiId){
//        Session session=sessionFactory.openSession();
//        Transaction transaction=session.beginTransaction();
//
//        System.out.println("createing shows..");
//        Shows shows=new Shows();
//        shows.setEndTime();
//        shows.setShowTime();
//
//
//        System.out.println("Finding audi id "+audiId);
//
//    }

    public static void deleteShow(Long audiId,Long showId)
    {
        System.out.println("Delete auditorium by id and Audi id: "+audiId);
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        System.out.println("Finding Audi with id : "+audiId);
        Audi audi = session.find(Audi.class,audiId);

        List<Shows> shows = audi.getShows();

       for(int i=0;i<=shows.size()-1;i++){
           if(shows.get(i).getId()==showId){
               System.out.println("show found with id "+showId);
               shows.remove(i);
               break;
           }
       }
        session.merge(audi);

           transaction.commit();
        System.out.println("Show with given id deleted "+showId);
        session.close();
    }

    public static void main(String[] args) {

        System.out.println("Program starts..");


        //getAudiAndShow();
        //getShowsByAudiId(7L);
        deleteShow(7l,1l);


        System.out.println("4.Close Session Factory");
        sessionFactory.close();


        System.out.println("program ends...");
    }
}
