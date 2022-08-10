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
        name="Adres",
        uniqueConstraints = @UniqueConstraint(
                name = "id_unique",
                columnNames = "id"
        )
)
public class Adres {
    @Id
    @SequenceGenerator(
            name= "adres_sequence",
            sequenceName = "adres_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "adres_sequence"
    )
    private Long id;
    private String il;
    private String ilce;
    private Integer postaKodu;
}
