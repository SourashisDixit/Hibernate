package com.jspider.main;

import com.jspider.Audi;
import com.jspider.Movie;
import com.jspider.MovieMetadata;
import com.jspider.MovieStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;

public class OneToOneDemo2 {


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




        public static void addMovie(){
           Session session= sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();

            Movie movie=new Movie();
            movie.setTitle("K.G.F");
            movie.setLanguage("Hindi");
            movie.setCertification("U/A");
            movie.setDuration(120);
            movie.setStatus(MovieStatus.AVAILABLE);
            movie.setCreatedAt(LocalDate.now());
            movie.setCreatedBy(123l);

            MovieMetadata movieMetadata=new MovieMetadata();//set meta data

            movieMetadata.setGenre("Sci-fi");
            movieMetadata.setFormat("i-max");
            movieMetadata.setRating(4.5);
            movieMetadata.setReleaseDate(LocalDate.of(2010,03,21));

            movie.setMetadata(movieMetadata);

            session.persist(movie);
            transaction.commit();
            session.close();

            System.out.println("Connection closed");

        }

        public static void getMovie(Long id){
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

            System.out.println("Finding the movie details with id"+id);
            Movie movie1 = session.find(Movie.class,id);

            System.out.println(movie1);
            transaction.commit();
            session.close();
            System.out.println("Session closed");

        }

        public static void updateMovie(Long id){

        }

    public static void main(String[] args) {

        //addMovie();
getMovie(1L);


    }
}
