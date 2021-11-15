package com.barvegas.backend.Service;

import com.barvegas.backend.Model.*;
import com.barvegas.backend.Repository.RepCaixa;
import com.barvegas.backend.Repository.RepItens;
import com.barvegas.backend.Repository.RepProduto;
import com.barvegas.backend.Repository.RepVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.el.MethodNotFoundException;
import java.time.LocalDate;
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
    public ModVenda saveVenda(ModVenda newVenda) throws Exception {
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
    public void dimEstoqueList(List<ModItems> idItem_Venda) throws Exception {
        for (ModItems item : idItem_Venda) {
            ModProduto produto = serProduto.getByIDProdutos(item.getProduto().getIdProduto());
            Long qtd = produto.getQuantidade();

            if (item.getQuantidade() > qtd) {
                throw new Exception("Verificar estoque de " + produto.getNome());
            }

            produto.setQuantidade(qtd - item.getQuantidade());
            repProduto.save(produto);
        }
    }

    //Aumentar estoque
    public void aumEstoque (List<ModItems> idItem_Venda) {
        for (ModItems item : idItem_Venda) {
            ModProduto produto = serProduto.getByIDProdutos(item.getProduto().getIdProduto());
            Long qtd = produto.getQuantidade();
            produto.setQuantidade(qtd + item.getQuantidade());
            repProduto.save(produto);
        }
    }

    //Buscar por ID membro
    public ModVenda findVendaByIdCliente(Long id){
        return repVenda.findModVendaByCliente_Id(id);
    }

    //Buscar Lista
    public List<ModVenda> findListVendaDateNow(){
        return repVenda.retornaTodasAsComandasDoDia();
    }
}
