package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_MembroCandidato")
public class Membro_CanditatoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false, length = 50)
    public String nome;

    @Column(nullable = false, length = 50)
    public String relevancia;

    @Column(nullable = false, length = 50)
    public boolean inadimplente;
}
