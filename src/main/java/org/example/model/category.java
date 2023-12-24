package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class category {
    int id;
    String name;

    public category(String name) {
        this.name = name;
    }
}
