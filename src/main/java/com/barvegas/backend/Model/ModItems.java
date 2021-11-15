package com.barvegas.backend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "TB_ITENS")
public class ModItems {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_items")
    @SequenceGenerator(name = "seq_items", sequenceName = "seq_items")
    private Long id;

    @ManyToOne
    private ModProduto produto;

    @Column(precision = 5, scale = 2)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal valor;

    private Long quantidade;

}
