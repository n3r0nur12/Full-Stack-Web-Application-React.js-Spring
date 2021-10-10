package tr.com.obss.finalproject.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="favoriteList_id",referencedColumnName = "id")
    private FavoriteList favoriteList;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="blackList_id",referencedColumnName = "id")
    private BlackList blackList;


    public User(String name, String surname, String address, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Override
    public boolean equals(Object rhs){
        return ((User)rhs).getName().equals(this.name) &&
                ((User)rhs).getSurname().equals(this.surname) &&
                ((User)rhs).getId().equals(this.id) &&
                ((User)rhs).getAddress().equals(this.address) &&
                ((User)rhs).getEmail().equals(this.email) &&
                ((User)rhs).getPassword().equals(this.password);
    }
}
