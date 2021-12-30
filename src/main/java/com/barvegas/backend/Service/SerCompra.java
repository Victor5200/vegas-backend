package com.barvegas.backend.Service;

import com.barvegas.backend.Model.ModCompras;
import com.barvegas.backend.Model.ModProduto;
import com.barvegas.backend.Repository.RepCompras;
import com.barvegas.backend.Repository.RepProduto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor

public class SerCompra {
    @Autowired
    private RepCompras repCompras;
    @Autowired
    private RepProduto repProduto;
    @Autowired
    private SerProduto serProduto;

    public  ModCompras saveCompras(ModCompras newCompras  ) {
        ModCompras compraSalva = repCompras.save(newCompras);

        ModProduto produto = serProduto.getByIDProdutos(compraSalva.getProduto().getId());
        long qtd = produto.getQuantidade();
        produto.setQuantidade(qtd + compraSalva.getQuantidade());
        repProduto.save(produto);

        // agora eu preciso buscar o produto, ver a quantidade que ele tem e somar com a quantidade
        // que existe no objeto de ModCompras newCompras.getQuantidade();

        return  compraSalva;
    }
}
