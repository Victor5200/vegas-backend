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
public class ModCaixa  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCaixa;
    private String data;
    private Double totalCaixa;


}