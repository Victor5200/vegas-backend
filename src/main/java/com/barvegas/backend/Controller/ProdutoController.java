package com.barvegas.backend.Controller;


import com.barvegas.backend.Model.ModProduto;
import com.barvegas.backend.Service.SerProduto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "/api/produtos")
@Api(value = "API REST PRODUTO")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    SerProduto serProduto;

    @PostMapping
    @ApiOperation(value = "Salva um novo produto.")
    public ResponseEntity<ModProduto> saveProduto(@RequestBody ModProduto newProduto){
        return ResponseEntity.ok(serProduto.saveProduto(newProduto));
    }

    @GetMapping
    @ApiOperation(value = "Recupera lista com todos os produtos cadastrados.")
    public ResponseEntity<List<ModProduto>> getAllProdutos(){
        return ResponseEntity.ok(serProduto.getAllProdutos());
    }

    @GetMapping("/{idProduto}")
    @ApiOperation(value = "Recupera produto por ID.")
    public ResponseEntity<ModProduto> getByIdProduto(@PathVariable Long idProduto){
        return ResponseEntity.ok(serProduto.getByIDProdutos(idProduto));
    }

    @DeleteMapping("/{idProduto}")
    @ApiOperation(value = "Deleta produto por id.")
    public void  delByIdProduto(@PathVariable Long idProduto){
        serProduto.delByIdProduto(idProduto);
    }
}
