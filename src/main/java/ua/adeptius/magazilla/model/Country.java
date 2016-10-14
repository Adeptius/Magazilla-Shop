package ua.adeptius.magazilla.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    public Country() {
    }

    public Country(Region region) {
        this.region = region;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "country")
    @Enumerated(EnumType.STRING)
    private Region region;
}
