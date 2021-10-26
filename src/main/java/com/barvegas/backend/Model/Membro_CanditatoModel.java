package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Membro_CanditatoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String nome;
    public String relevancia;
    public boolean inadimplente;
}
