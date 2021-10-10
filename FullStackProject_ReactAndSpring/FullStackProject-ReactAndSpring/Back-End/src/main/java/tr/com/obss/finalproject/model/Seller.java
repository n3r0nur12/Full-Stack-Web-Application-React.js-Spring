package tr.com.obss.finalproject.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @ManyToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="blacklist_ids")
    private Set<BlackList> blackList=new HashSet<BlackList>();


    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    public Seller(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object rhs){
        return ((Seller)rhs).getName().equals(this.name) &&
                ((Seller)rhs).getId().equals(this.id) &&
                ((Seller)rhs).getAddress().equals(this.address);
    }

    @Override
    public String toString(){
        return "[" + name.toUpperCase() + " / " + address + "]";
    }
}
