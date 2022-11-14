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
        name="Sofor"
)
public class Sofor {
        @Id
        @SequenceGenerator(
                name= "sofor_sequence",
                sequenceName = "sofor_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "sofor_sequence"
        )
        private Long id;
        private String ad;
        private String soyad;
        @Column(
                name = "tckn",
                nullable = false
        )
        private Long tckn;
        private Long tel;

}
