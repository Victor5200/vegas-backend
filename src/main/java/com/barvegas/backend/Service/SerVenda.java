package com.barvegas.backend.Service;

import com.barvegas.backend.Model.ModCaixa;
import com.barvegas.backend.Model.ModProduto;
import com.barvegas.backend.Model.ModVenda;
import com.barvegas.backend.Repository.RepCaixa;
import com.barvegas.backend.Repository.RepProduto;
import com.barvegas.backend.Repository.RepVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.el.MethodNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class SerVenda {


    @Autowired
    RepVenda repVenda;
    @Autowired
    RepProduto repProduto;
    @Autowired
    RepCaixa repCaixa;
    @Autowired
    SerCaixa serCaixa;
    @Autowired
    SerProduto serProduto;

    //Buscar Todos
    public List<ModVenda> getAllVenda() {
        return repVenda.findAll();
    }

    //Buscar por id
    public ModVenda getByIDVenda(Long id) {
        Optional<ModVenda> optionalModVenda = repVenda.findById(id);
        if (!optionalModVenda.isPresent()) {
            throw new MethodNotFoundException("Venda não encontrada...");
        }
        return optionalModVenda.get();
    }

    //Salvar novo Venda
    public ModVenda saveVenda(ModVenda newVenda, Long idProduto, Long idCaixa) {

        Long qtdComprada = newVenda.getQtd();

        //Diminui a quantidade de estoque
        dimEstoque(idProduto, qtdComprada);

        Long idVenda = newVenda.getIdVenda();

        //Aumentar caixa
        aumCaixa(idVenda, idCaixa);

        return repVenda.save(newVenda);
    }

    //Deletar Venda por ID
    public void delVendaById(Long idVenda, Long idCaixa) {

        Optional<ModVenda> oldVenda = repVenda.findById(idVenda);
        Long qtdComprada = oldVenda.get().getQtd();
        ModProduto produto = oldVenda.get().getProdutos();
        Long idProduto = produto.getIdProduto();

        aumEstoque( idProduto, qtdComprada);

        //Diminuir Caixa
        dimCaixa( idVenda, idCaixa);

        repVenda.deleteById(idVenda);
    }

    //Venda paga
    public ModVenda pagVendaById(Long idVenda) {

        ModVenda vendaPaga = getByIDVenda(idVenda);
        vendaPaga.setPago(true);
        return vendaPaga;
    }

    //Diminuir estoque
    public void dimEstoque(Long idProduto, Long qtdComprada) {

        ModProduto produto = serProduto.getByIDProdutos(idProduto);
        Long qtd = produto.getQuantidade();

        if (qtd >= qtdComprada) {
            produto.setQuantidade(qtd - qtdComprada);
        } else {
            throw new MethodNotFoundException("Não existe a quantidade de produtos para realizar a venda...");
        }

        repProduto.save(produto);
    }

    //Aumentar estoque
    public void aumEstoque(Long idProduto, Long qtdComprada) {

        ModProduto produto = serProduto.getByIDProdutos(idProduto);
        Long qtd = produto.getQuantidade();

        produto.setQuantidade(qtd + qtdComprada);

        repProduto.save(produto);
    }

    //Aumentar Caixa
    public void aumCaixa(Long idVenda, Long idCaixa) {

        ModCaixa caixa = serCaixa.getByIDCaixa(idCaixa);
        String dataCaixa = caixa.getData();

        ModVenda oldVenda = getByIDVenda(idVenda);
        String dataVenda = oldVenda.getData();

        if (dataVenda.equals(dataCaixa)) {
            Double totalCaixa = caixa.getTotalCaixa();
            totalCaixa += oldVenda.getValorTotal();
            caixa.setTotalCaixa(totalCaixa);
        } else {
            throw new MethodNotFoundException("Datas incompativeis");
        }
        repCaixa.save(caixa);
    }

    //Diminuir Caixa
    public void dimCaixa(Long idVenda, Long idCaixa) {

        ModCaixa caixa = serCaixa.getByIDCaixa(idCaixa);
        String dataCaixa = caixa.getData();

        //Venda q vai ser deletada
        ModVenda oldVenda = getByIDVenda(idVenda);
        String dataVenda = oldVenda.getData();

        if (dataVenda.equals(dataCaixa)) {
            Double totalCaixa = caixa.getTotalCaixa();
            totalCaixa -= oldVenda.getValorTotal();
            caixa.setTotalCaixa(totalCaixa);
        } else {
            throw new MethodNotFoundException("Datas incompativeis");
        }
        repCaixa.save(caixa);


    }
}
