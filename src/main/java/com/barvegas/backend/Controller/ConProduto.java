package com.barvegas.backend.Controller;


import com.barvegas.backend.Model.ModProduto;
import com.barvegas.backend.Service.SerProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "/api/produtos")
public class ConProduto {

    @Autowired
    SerProduto serProduto;

    @PostMapping
    public ResponseEntity<ModProduto> saveProduto(@RequestBody ModProduto newProduto){
        return ResponseEntity.ok(serProduto.saveProduto(newProduto));
    }

    @GetMapping
    public ResponseEntity<List<ModProduto>> getAllProdutos(){
        return ResponseEntity.ok(serProduto.getAllProdutos());
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<ModProduto> getByIdProduto(@PathVariable Long idProduto){
        return ResponseEntity.ok(serProduto.getByIDProdutos(idProduto));
    }

    @DeleteMapping("/{idProdutos}")
    public void  delByIdProduto(@PathVariable Long idProduto){
        serProduto.delByIdProduto(idProduto);
    }
}
