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

import static java.util.Objects.isNull;

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
        if (isNull(newVenda.getIdVenda())) {
            dimEstoqueList(newVenda.getItens());
        }

        return repVenda.save(newVenda);
    }

    //Deletar Venda por ID
    public void delVendaById(Long idVenda) {
        Optional<ModVenda> oldVenda = repVenda.findById(idVenda);
        aumEstoque(oldVenda.get().getItens());
        repVenda.deleteById(idVenda);
    }

    //Diminuir estoque
    public void dimEstoqueList(List<ModItems> idItem_Venda){
        idItem_Venda.forEach(item -> {
            ModProduto produto = serProduto.getByIDProdutos(item.getProduto().getIdProduto());
            Long qtd = produto.getQuantidade();
            produto.setQuantidade(qtd - item.getProduto().getQuantidade());
            repProduto.save(produto);
        });
    }

    //Aumentar estoque
    public void aumEstoque (List<ModItems> idItem_Venda){
        idItem_Venda.forEach(item -> {
            ModProduto produto = serProduto.getByIDProdutos(item.getProduto().getIdProduto());
            Long qtd = produto.getQuantidade();
            produto.setQuantidade(qtd + item.getProduto().getQuantidade());
            repProduto.save(produto);
        });
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
