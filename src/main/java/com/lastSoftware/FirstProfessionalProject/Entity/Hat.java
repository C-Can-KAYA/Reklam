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
        name="Hat"
)
public class Hat {
    @Id
    @SequenceGenerator(
            name= "hat_sequence",
            sequenceName = "hat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hat_sequence"
    )
    private Long id;
    private String hatAdi;
    @Column(
            name = "plakaKod"
    )
    private Integer plakaKod;
}
