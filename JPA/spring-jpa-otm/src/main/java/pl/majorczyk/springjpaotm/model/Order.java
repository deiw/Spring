package pl.majorczyk.springjpaotm.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;
    @Column(nullable = false)
    private String product;
    @Column(name = "details",length = 512)
    private String productDetails;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    Order(){}

    public Order(String product, String productDetails) {
        this.product = product;
        this.productDetails = productDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", product=" + product
                + ", orderDetails=" + productDetails + ", "
                + client.getFirstName() + " " +client.getLastName()+ "]";
    }
}
