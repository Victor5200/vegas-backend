package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_VENDA")
public class ModVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVenda;

    @CreationTimestamp
    private LocalDate data;

    @OneToMany
    private List<ModItems> itens;

    private Double valorTotal;

    private String descricao;

    private Boolean pago;

    @ManyToOne
    private ModCliente cliente;


}
