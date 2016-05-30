package br.com.interaje.interaje01.model;

import com.easyliteorm.annotation.Entity;
import com.easyliteorm.annotation.GenerationType;
import com.easyliteorm.annotation.Id;

/**
 * Created by rayquaza on 15/04/16.
 */
@Entity
public class Product {

    @Id(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private byte[] photo;
    private Category category;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
