package com.jspider;


import jakarta.persistence.*;

@Entity
@Table(name="audi_properties")
public class AudiProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

@Column(name="sscreen_type")
   private String ScreenType;

@Column(name="sound")
   private String sound;


    @OneToOne(mappedBy = "audiProperties")
private Audi audi1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreenType() {
        return ScreenType;
    }

    public void setScreenType(String screenType) {
        ScreenType = screenType;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Audi getAudi1() {
        return audi1;
    }

    public void setAudi1(Audi audi1) {
        this.audi1 = audi1;
    }

    @Override
    public String toString() {
        return "AudiProperties{" +
                "id=" + id +
                ", ScreenType='" + ScreenType + '\'' +
                ", sound='" + sound + '\'' +
                ", audi1=" + audi1 +
                '}';
    }
}
