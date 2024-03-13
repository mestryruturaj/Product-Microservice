package com.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "") //TODO: Provide table name'
@Data
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private Integer age;

    @Override
    public String toString() {
        return String.format("[id:%d, firstName:%s, lastName:%s, age:%d]",
                this.getId(), this.getFirstName(), this.getLastName(), this.getAge());
    }
}
