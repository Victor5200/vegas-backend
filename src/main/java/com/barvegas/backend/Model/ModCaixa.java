package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_CAIXA")
public class ModCaixa  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCaixa;

    private String data;

    private Double totalCaixa;


}