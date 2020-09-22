package eu.europa.ec.workshop.ut.pub.beer.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "beer", schema = "beer")
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beer_id")
    @SequenceGenerator(name = "beer_id", allocationSize = 1)
    private Long id;
    private String name;
    private Long stock;

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

    public Long getStock() {
        return stock;
    }

    public void setStock(Long storage) {
        this.stock = storage;
    }

    @Override
    public boolean equals(Object otherBeer) {
        return this == otherBeer
                || (otherBeer != null
                && getClass() == otherBeer.getClass()
                && Objects.equals(id, ((Beer) otherBeer).getId()));
    }

    @Override
    public int hashCode() {
        return 13;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }

}
