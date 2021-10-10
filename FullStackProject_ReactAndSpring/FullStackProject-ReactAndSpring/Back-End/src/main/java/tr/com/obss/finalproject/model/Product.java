package tr.com.obss.finalproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @ManyToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="favoritesList_id")
    private Set<FavoriteList> favorites = new HashSet<FavoriteList>();


    @Column(name="name")
    private String name;

    @Column(name="price")
    private Long price;

    public Product(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object rhs){
        return ((Product)rhs).getName().equals(this.name) &&
                ((Product)rhs).getPrice().equals(this.price) &&
                ((Product)rhs).getId().equals(id);
    }

    @Override
    public String toString(){
        return "[" + this.price + " X " + this.name + "]";
    }
}
