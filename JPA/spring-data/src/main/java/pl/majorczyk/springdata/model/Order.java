package pl.majorczyk.springdata.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Column(name = "description")
    private String desc;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "book_orders",
    joinColumns = {@JoinColumn(name = "id_order",referencedColumnName = "order_id")},
    inverseJoinColumns ={@JoinColumn(name = "id_book",referencedColumnName = "book_id")})
    private List<Book> books=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


    Order(){}

    public Order(String desc) {
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", books=" + books +
                '}';
    }
}
