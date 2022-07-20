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
public class Firma {
    @Id
    @SequenceGenerator(
            name= "firma_sequence",
            sequenceName = "firma_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "firma_sequence"
    )
    private Long id;
    private String firmaAd;
    private String sicilNo;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Reklam> reklam;
}
