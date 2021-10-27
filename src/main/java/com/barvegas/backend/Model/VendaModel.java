package com.barvegas.backend.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data

@Entity
@Table(name = "TB_VENDA")
public class VendaModel{

    @Id
    private Long id;
    private List<ProdutoModel>;
    private String descricao;
    private Long qtd;
    private Float valorTotal;
    private Date dataCompra;
    private Boolean pago;


    public VendaModel vendaFeita(VendaModel){



    }




}
