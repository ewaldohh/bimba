package com.bimba.bimba.models.entities;

import java.io.Serializable;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity //menyatakan bahwa kelas ini merupakan Entity
@Table(name = "tbl_product") //cek apakah tbl tersebut ada di db, klo tdk akan dicreate
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id //menyatakan Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    private long id;

    @NotEmpty(message="Name is required") //Not null wajib diisi
    //@Column(name = "product_name", length=100) untuk customize
    private String name;

    //Karena tidak mandatory field bisa di Post tetapi isinya akan menjadi null
    private String description;

    private double price;

    @ManyToOne //Jenis relasi untuk kebutuhan deklarasi foreign key
    private Category category;

    @ManyToMany
    @JoinTable(
        name = "tbl_product_supplier",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private Set<Supplier> suppliers;

    public Product() {
    }

    public Product(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    
    
    

}
