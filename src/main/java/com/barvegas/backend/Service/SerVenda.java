package com.barvegas.backend.Service;

import com.barvegas.backend.Model.*;
import com.barvegas.backend.Repository.*;
import com.barvegas.backend.exception.BadRequestException;
import com.barvegas.backend.exception.ServerErrorException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class SerVenda {
    private final RepVenda repVenda;
    private final RepProduto repProduto;
    private final RepCliente repCliente;
    private final SerProduto serProduto;

    //Buscar Todos
    public List<ModVenda> getAllVenda() {
        return repVenda.findAll();
    }

    //Buscar por id
    public ModVenda getByIDVenda(Long idVenda) {
        Optional<ModVenda> optionalModVenda = repVenda.findById(idVenda);
        if (!optionalModVenda.isPresent()) {
            throw new BadRequestException("Venda não encontrada.");
        }
        return optionalModVenda.get();
    }

    //Salvar novo Venda
    public ModVenda saveVenda(ModVenda newVenda) throws Exception {
        dimEstoqueList(newVenda.getItens());


        return repVenda.save(newVenda);
    }

    //Deletar Venda por ID
    public void delVendaById(Long idVenda) {
        Optional<ModVenda> oldVenda = repVenda.findById(idVenda);
        if (oldVenda.isEmpty()) {
            throw new ServerErrorException("A venda que deseja deletar não existe.");
        }
        aumEstoque(oldVenda.get().getItens());
        repVenda.deleteById(idVenda);
    }

    //Diminuir estoque
    public void dimEstoqueList(List<ModItems> idItem_Venda) throws Exception {
        for (ModItems item : idItem_Venda) {
            if (isNull(item.getId())) {
                ModProduto produto = serProduto.getByIDProdutos(item.getProduto().getId());
                Long qtd = produto.getQuantidade();

                if (item.getQuantidade() > qtd) {
                    throw new BadRequestException("Verificar estoque de " + produto.getNome());
                }

                produto.setQuantidade(qtd - item.getQuantidade());
                repProduto.save(produto);
            }
        }
    }

    //Aumentar estoque
    public void aumEstoque(List<ModItems> idItem_Venda) {
        for (ModItems item : idItem_Venda) {
            ModProduto produto = serProduto.getByIDProdutos(item.getProduto().getId());
            Long qtd = produto.getQuantidade();
            produto.setQuantidade(qtd + item.getQuantidade());
            repProduto.save(produto);
        }
    }

    //Buscar por ID membro
    public ModVenda findVendaByIdCliente(Long id) {
        if (repCliente.findById(id).isEmpty()) {
            throw new BadRequestException("O Cliente procurado não existe.");
        }
        return repVenda.findModVendaByCliente_Id(id);
    }

    //Buscar Lista
    public List<ModVenda> findListVendaDateNow() {
        return repVenda.retornaTodasAsComandasDoDia();
    }
}
