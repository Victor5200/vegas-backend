package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ModCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_compras")
    @SequenceGenerator(name = "seq_compras", sequenceName = "seq_compras")
    private Long id;

    private long quantidade;

    @ManyToOne
     private ModProduto produto;

    @CreationTimestamp
    private LocalDate dataCompra;
}
