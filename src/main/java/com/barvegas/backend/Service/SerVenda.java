package com.barvegas.backend.Service;

import com.barvegas.backend.Model.ModCaixa;
import com.barvegas.backend.Model.ModItems;
import com.barvegas.backend.Model.ModProduto;
import com.barvegas.backend.Model.ModVenda;
import com.barvegas.backend.Repository.RepCaixa;
import com.barvegas.backend.Repository.RepItens;
import com.barvegas.backend.Repository.RepProduto;
import com.barvegas.backend.Repository.RepVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.el.MethodNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    RepItens repItens;
    @Autowired
    SerCaixa serCaixa;
    @Autowired
    SerProduto serProduto;

    //Buscar Todos
    public List<ModVenda> getAllVenda() {
        return repVenda.findAll();
    }

    //Buscar por id
    public ModVenda getByIDVenda(Long idVenda) {
        Optional<ModVenda> optionalModVenda = repVenda.findById(idVenda);
        if (!optionalModVenda.isPresent()) {
            throw new MethodNotFoundException("Venda não encontrada...");
        }
        return optionalModVenda.get();
    }

    //Salvar novo Venda
    public ModVenda saveVenda(ModVenda newVenda) {
        getByIDVenda(newVenda.getIdVenda());
        String formatterData = String.valueOf(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        newVenda.setData(formatterData);

        return repVenda.save(newVenda);
    }

    //Adicionar itens a Venda por id
    public ModVenda addItens(Long idVenda, Long idItem, Long qtd) throws Exception {
        Optional<ModVenda> optionalModVenda = repVenda.findById(idVenda);
        if (!optionalModVenda.isPresent()) {
            throw new MethodNotFoundException("Venda não encontrada...");
        }
        Optional<ModItems> optionalModItems = repItens.findById(idItem);
        if (!optionalModItems.isPresent()) {
            throw new MethodNotFoundException("Item não encontrado...");
        }

        List<ModItems> itemsList = optionalModVenda.get().getItens();
        ModItems item = optionalModItems.get();
        item.setQtd(qtd);

        if (item.getTamanho() < itemsList.size()) {
            int i = item.getTamanho();
            itemsList.set(item.getTamanho(), item);
            item.setTamanho(i++);
        } else {
            throw new Exception("Não foi possivel adicionar...");
        }
        dimEstoque(idVenda);//Diminui o estoque

        optionalModVenda.get().setValorTotal
                ((optionalModVenda.get().getValorTotal())+(item.getQtd()*item.getValorVenda()));

        return repVenda.save(optionalModVenda.get());
    }

    //Deletar Venda por ID
    public void delVendaById(Long idVenda, Long idCaixa) {

        Optional<ModVenda> oldVenda = repVenda.findById(idVenda);
        Long idItem_Produto = idVenda;

        //Aumentar estoque
        aumEstoque(idItem_Produto);
        //Diminuir Caixa
        //dimCaixa (idItem_Produto);

        repVenda.deleteById(idVenda);
    }

    //Venda paga
    public ModVenda pagVendaById (Long idVenda){

        ModVenda vendaPaga = getByIDVenda(idVenda);
        vendaPaga.setPago(true);
        return vendaPaga;
        }


    //Diminuir estoque
    public void dimEstoque(Long idItem_Produto) {

        ModProduto produto = serProduto.getByIDProdutos(idItem_Produto);
        Long qtd = produto.getQuantidade();

        ModItems item = serProduto.getByIdItem(idItem_Produto);
        Long qtdComprada = item.getQtd();

        if (qtd >= qtdComprada) {
            produto.setQuantidade(qtd - qtdComprada);
        } else {
            throw new MethodNotFoundException("Não existe a quantidade de produtos para realizar a venda...");
        }

        repProduto.save(produto);
    }

    //Aumentar estoque
        public void aumEstoque (Long idItem_Venda){

            ModProduto produto = serProduto.getByIDProdutos(idItem_Venda);
            Long qtd = produto.getQuantidade();

            ModItems item = serProduto.getByIdItem(idItem_Venda);
            Long qtdComprada = item.getQtd();

            produto.setQuantidade(qtd + qtdComprada);

            repProduto.save(produto);
        }


//    //Aumentar Caixa
//    public void aumCaixa (Long idVenda){
//
//        ModVenda venda = getByIDVenda(idVenda);
//        String dataVenda = venda.getData();
//
//        if (dataVenda.equals(dataCaixa)) {
//            Double totalCaixa = caixa.getTotalCaixa();
//            totalCaixa += oldVenda.getValorTotal();
//            caixa.setTotalCaixa(totalCaixa);
//        } else {
//            throw new MethodNotFoundException("Datas incompativeis");
//        }
//        repCaixa.save(caixa);
//    }
//
//        //Diminuir Caixa
//        public void dimCaixa (Long idProduto_Venda){
//
//            ModCaixa caixa = serCaixa.getByIDCaixa(idCaixa);
//            String dataCaixa = caixa.getData();
//
//            //Venda q vai ser deletada
//            ModVenda oldVenda = getByIDVenda(idVenda);
//            String dataVenda = oldVenda.getData();
//
//            if (dataVenda.equals(dataCaixa)) {
//                Double totalCaixa = caixa.getTotalCaixa();
//                totalCaixa -= oldVenda.getValorTotal();
//                caixa.setTotalCaixa(totalCaixa);
//            } else {
//                throw new MethodNotFoundException("Datas incompativeis");
//            }
//            repCaixa.save(caixa);
//
//
//        }
}