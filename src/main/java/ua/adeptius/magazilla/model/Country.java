package ua.adeptius.magazilla.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    public Country() {
    }

    public Country(String region) {
        this.region = region;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "country")
    private String region;

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", region=" + region +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getId() {

        return id;
    }

    public String getRegion() {
        return region;
    }
}
