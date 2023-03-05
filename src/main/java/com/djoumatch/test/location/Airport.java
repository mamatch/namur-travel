package com.djoumatch.test.location;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @ManyToOne
    private City city;
}
