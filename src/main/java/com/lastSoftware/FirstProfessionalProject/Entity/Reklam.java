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
        name="Reklam",
        uniqueConstraints = @UniqueConstraint(
                name = "link_unique",
                columnNames = "link"
        )
)
public class Reklam {
    @Id
    @SequenceGenerator(
            name= "reklam_sequence",
            sequenceName = "reklam_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reklam_sequence"
    )
    private Long id;
    private String link;
    private String ad;
    private String reklamId;
    @ManyToOne
    @JoinColumn(name = "firma_id")
    private Firma firma;
}
