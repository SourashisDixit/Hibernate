package com.jspider;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "auditorium")
public class Audi extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "audi_name", nullable = false)
    private String name;

    @Column(name = "seat_rows", nullable = false)
    private Integer seatRows;

    @Column(name = "seat_columns", nullable = false)
    private Integer seatColumns;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addrs_id")//FK
    private Address address;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "audipro_id")//FK
    private AudiProperties audiProperties;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "audi_id")//FK
    private List<Shows> shows = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(Integer seatRows) {
        this.seatRows = seatRows;
    }

    public Integer getSeatColumns() {
        return seatColumns;
    }

    public void setSeatColumns(Integer seatColumns) {
        this.seatColumns = seatColumns;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public AudiProperties getAudiProperties() {
        return audiProperties;
    }

    public void setAudiProperties(AudiProperties audiProperties) {
        this.audiProperties = audiProperties;
    }

    public List<Shows> getShows() {
        return shows;
    }

    public void setShows(List<Shows> shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "Audi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seatRows=" + seatRows +
                ", seatColumns=" + seatColumns +
                ", address=" + address +
                ", audiProperties=" + audiProperties +
                ", shows=" + shows +
                '}';
    }
}