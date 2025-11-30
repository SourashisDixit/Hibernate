package com.jspider;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="movie_metadata")
public class MovieMetadata extends Object{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Column(name="genre",nullable = false)
    private String genre;

@Column(name="format",nullable = false,length = 100)
    private String format;

@Column(name="rating",nullable = false)
    private Double rating;


    private LocalDate releaseDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "MovieMetadata{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", format='" + format + '\'' +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
