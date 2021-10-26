package com.barvegas.backend.Controller;


import com.barvegas.backend.Model.ProdutoModel;
import com.barvegas.backend.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    public ProdutoModel saveProduto(@RequestBody ProdutoModel newProduto){

        return produtoService.saveProduto(newProduto);
    }
}
