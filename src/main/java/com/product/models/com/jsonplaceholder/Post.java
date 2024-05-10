package com.product.models.com.jsonplaceholder;

import lombok.Data;

@Data
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;

    @Override
    public String toString() {
        return String.format("[id = %d, userId = %d, title = %s, body = %s]", this.id, this.userId, this.title, this.body);
    }
}
