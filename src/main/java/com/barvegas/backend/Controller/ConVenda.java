package com.barvegas.backend.Controller;

import com.barvegas.backend.Model.ModVenda;
import com.barvegas.backend.Service.SerCaixa;
import com.barvegas.backend.Service.SerVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ConVenda {

    @Autowired
    SerVenda serVenda;
    @Autowired
    SerCaixa serCaixa;

    @PostMapping("/vendas")
    public ResponseEntity<ModVenda> saveVenda(@RequestBody ModVenda newVenda,
                                              @RequestBody Long idProduto,
                                              @RequestBody Long idCaixa){

        return ResponseEntity.ok(serVenda.saveVenda(newVenda,idProduto,idCaixa));
    }

    @GetMapping("/venda")
    public ResponseEntity<List<ModVenda>> getAllVenda(){
        return ResponseEntity.ok(serVenda.getAllVenda());
    }

    @GetMapping("/venda/{idVenda}")
    public ResponseEntity<ModVenda> getByIDVenda(@PathVariable Long idVenda){
        return ResponseEntity.ok(serVenda.getByIDVenda(idVenda));
    }

    @DeleteMapping("/venda")
    public void delVendaById(@RequestBody Long idVenda, Long idProduto, Long idCaixa){
        serVenda.delVendaById(idVenda,idProduto,idCaixa);
    }

    @PostMapping("venda/{idVenda}")
    public ResponseEntity<ModVenda> pagVendaById(Long idVenda){
        return ResponseEntity.ok(serVenda.pagVendaById(idVenda));
    }
}