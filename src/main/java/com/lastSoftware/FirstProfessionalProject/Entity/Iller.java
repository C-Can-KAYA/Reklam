package com.lastSoftware.FirstProfessionalProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name="Iller",
        uniqueConstraints = @UniqueConstraint(
                name = "plaka_unique",
                columnNames = "plakaKod"
        )
)
public class Iller {
    @SequenceGenerator(
            name= "iller_sequence",
            sequenceName = "iller_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "iller_sequence"
    )
    @Id
    private Long id;
    private String ilAdi;
    @Column(
            name = "plakaKod"
    )
    private Integer plakaKod;
}
