package com.lastSoftware.FirstProfessionalProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
        name="Firma",
        uniqueConstraints = @UniqueConstraint(
                name = "sicilNo_unique",
                columnNames = "sicilNo"
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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Adres adres;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Reklam> reklam;
}
