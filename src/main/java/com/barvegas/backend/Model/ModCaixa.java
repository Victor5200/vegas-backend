package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @Column(precision = 5, scale = 2)
    private BigDecimal totalCaixa;


}
