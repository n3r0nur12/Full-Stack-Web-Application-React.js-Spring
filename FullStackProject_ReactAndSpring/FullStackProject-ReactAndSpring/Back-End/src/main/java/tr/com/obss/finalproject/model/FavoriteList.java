package tr.com.obss.finalproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="favoriteList")
public class FavoriteList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private Long userid;

    @ManyToMany(mappedBy="favorites")
    private Set<Product> products = new HashSet<Product>();

    @OneToOne(mappedBy="favoriteList")
    private User user;

    public FavoriteList(User user){
        this.user = user;
    }

    @Override
    public boolean equals(Object rhs){
        return ((FavoriteList)rhs).getUserid().equals(this.userid) &&
                ((FavoriteList)rhs).getId().equals(this.id);
    }
}
