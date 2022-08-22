package com.lastSoftware.FirstProfessionalProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name="Minibus",
        uniqueConstraints = @UniqueConstraint(
                name = "plaka_unique",
                columnNames = "plaka"
        )
)
public class Minibus {
    @Id
    @SequenceGenerator(
            name= "minibus_sequence",
            sequenceName = "minibus_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "minibus_sequence"
    )
    private Long id;
    private String marka;
    private String model;
    private String hat;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Sofor> soforList;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Reklam> reklam;
    @Column(
            name = "plaka",
            nullable = false
    )
    private String plaka;
}
