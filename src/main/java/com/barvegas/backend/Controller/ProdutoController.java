package com.barvegas.backend.Controller;


import com.barvegas.backend.Model.ProdutoModel;
import com.barvegas.backend.Service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping(path = "/produtos")
    @ApiOperation(value = "Salva um novo produto.")
    public ProdutoModel saveProduto(@RequestBody ProdutoModel newProduto){

        return produtoService.saveProduto(newProduto);
    }
}
