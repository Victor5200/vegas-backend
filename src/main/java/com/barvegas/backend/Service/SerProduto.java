package com.barvegas.backend.Service;

import com.barvegas.backend.Model.ModItems;
import com.barvegas.backend.Model.ModProduto;
import com.barvegas.backend.Repository.RepItens;
import com.barvegas.backend.Repository.RepProduto;
import com.barvegas.backend.exception.BadRequestException;
import com.barvegas.backend.exception.ServerErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SerProduto {
    private final RepProduto repProduto;
    private final RepItens repItens;

    //Buscar Todos
    public List<ModProduto> getAllProdutos(){
        return repProduto.findAll();
    }

    //Buscar por id
    public ModProduto getByIDProdutos(Long idProduto){
        Optional<ModProduto> optionalProduto = repProduto.findById(idProduto);
        if(optionalProduto.isEmpty()){
            throw new BadRequestException("Produto não encontrado.");
        }
        return optionalProduto.get();
    }

    //Salvar novo Produto
    public ModProduto saveProduto(ModProduto newProduto){
        return repProduto.save(newProduto);
    }

    //Deletar produto por ID
    public void delByIdProduto(Long idProduto){
        if(repProduto.findById(idProduto).isEmpty()){
            throw new ServerErrorException("O produto que deseja deletar não existe.");
        }
        repProduto.deleteById(idProduto);
    }

    //Buscar ITEM por ID
    public ModItems getByIdItem(Long idVenda) {
        Optional<ModItems> optionalModItems = repItens.findById(idVenda);
        if (!optionalModItems.isPresent()) {
            throw new BadRequestException("Venda não encontrada...");
        }
        return optionalModItems.get();
    }

}




