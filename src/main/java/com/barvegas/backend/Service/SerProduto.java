package com.barvegas.backend.Service;

import com.barvegas.backend.Model.ModItems;
import com.barvegas.backend.Model.ModProduto;
import com.barvegas.backend.Repository.RepItens;
import com.barvegas.backend.Repository.RepProduto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.el.MethodNotFoundException;
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
        Optional<ModProduto> optionalModProduto = repProduto.findById(idProduto);
        if(!optionalModProduto.isPresent()){
            throw new MethodNotFoundException("Produto não encontrado...");
        }
        return optionalModProduto.get();
    }

    //Salvar novo Produto
    public ModProduto saveProduto(ModProduto newProduto){
        return repProduto.save(newProduto);
    }

    //Deletar produto por ID
    public void delByIdProduto(Long idProduto){
        repProduto.deleteById(idProduto);
    }

    //Buscar ITEM por ID
    public ModItems getByIdItem(Long idVenda) {
        Optional<ModItems> optionalModItems = repItens.findById(idVenda);
        if (!optionalModItems.isPresent()) {
            throw new MethodNotFoundException("Venda não encontrada...");
        }
        return optionalModItems.get();
    }

}




