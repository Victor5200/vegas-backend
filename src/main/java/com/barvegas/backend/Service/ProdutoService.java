package com.barvegas.backend.Service;

import com.barvegas.backend.Model.ProdutoModel;
import com.barvegas.backend.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.el.MethodNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    //Buscar todos
    public List<ProdutoModel> getAllProdutos(){
        return produtoRepository.findAll();
    }

    //Buscar produto por códigio
    public ProdutoModel getProdutoById(@PathVariable Long codigoProduto){
        Optional<ProdutoModel> optionalProdutoModel = produtoRepository.findById(codigoProduto);
        if(!optionalProdutoModel.isPresent())
            throw new MethodNotFoundException("Produto não encontrado...");

        return optionalProdutoModel.get();
    }

    //Alterar produto (Todos os campos)
    public ProdutoModel updateProduto(@PathVariable Long codigoProduto ,
                                      @RequestBody ProdutoModel upProduto){

        upProduto.setCodigoProduto(codigoProduto);
        return produtoRepository.save(upProduto);
    }

    //Salvar novo produto
    public ProdutoModel saveProduto(@RequestBody ProdutoModel newProduto){

        return produtoRepository.save(newProduto);
    }

    //Deletar Produto por código
    public void deleteProdutoById(@PathVariable Long codigoProduto){
        produtoRepository.deleteById(codigoProduto);
    }
}

