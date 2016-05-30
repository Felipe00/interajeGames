package br.com.interaje.interaje01.model;

import com.easyliteorm.annotation.Entity;
import com.easyliteorm.annotation.GenerationType;
import com.easyliteorm.annotation.Id;

/**
 * Created by rayquaza on 15/04/16.
 */

@Entity
public class Category {

    @Id(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
