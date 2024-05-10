package com.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product extends BaseEntity {
    private String title;
    private String description;
    private Double price;

    @Override
    public String toString() {
        return String.format("[id:%d, title:%s, description:%s, age:%.2f]",
                this.getId(), this.getTitle(), this.getDescription(), this.getPrice());
    }
}
