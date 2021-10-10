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
@Table(name="blackList")
public class BlackList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private Long userid;

    @ManyToMany(cascade=CascadeType.ALL,mappedBy="blackList")
    private Set<Seller> sellers = new HashSet<Seller>();

    @OneToOne(mappedBy="blackList")
    private User user;

    public BlackList(User user){
        this.user = user;
    }

    @Override
    public boolean equals(Object rhs){
        return ((BlackList)rhs).getUserid().equals(userid) &&
                ((BlackList)rhs).getId().equals(id);
    }
}
