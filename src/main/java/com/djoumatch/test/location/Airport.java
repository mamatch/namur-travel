package com.djoumatch.test.location;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @NotNull
    private String name;
    @ManyToOne
    @NotNull
    private City city;

    public Airport(String name, City city) {
        this.name = name;
        this.city = city;
    }
}
