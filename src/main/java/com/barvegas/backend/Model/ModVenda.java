package com.barvegas.backend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_VENDA")
public class ModVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_venda")
    @SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda")
    private Long id;

    @CreationTimestamp
    private LocalDate data;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ModItems> itens;

    @Column(precision = 5, scale = 2)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal valorTotal;

    private String descricao;

    private Boolean pago;

    @ManyToOne
    private ModCliente membro;


}
