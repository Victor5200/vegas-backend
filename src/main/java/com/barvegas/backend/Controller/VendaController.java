package com.barvegas.backend.Controller;

import com.barvegas.backend.Model.ModVenda;
import com.barvegas.backend.Service.SerCaixa;
import com.barvegas.backend.Service.SerVenda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/vendas")
@Api(value = "API REST VENDA")
@CrossOrigin(origins = "*")
public class VendaController {

    @Autowired
    SerVenda serVenda;
    @Autowired
    SerCaixa serCaixa;

    @PostMapping
    @ApiOperation(value = "Salva nova venda")
    public ResponseEntity<ModVenda> saveVenda(@RequestBody ModVenda newVenda){
        return ResponseEntity.ok(serVenda.saveVenda(newVenda));
    }

    @PostMapping
    @ApiOperation(value = "Adicona 1 item a uma venda")
    public ResponseEntity<ModVenda> addItens (Long idVenda, Long idItem, Long qtd)
            throws Exception{
            return ResponseEntity.ok(serVenda.addItens(idVenda,idItem,qtd));
    }

    @GetMapping
    @ApiOperation(value = "Recupera lista de vendas.")
    public ResponseEntity<List<ModVenda>> getAllVenda(){
        return ResponseEntity.ok(serVenda.getAllVenda());
    }

    @GetMapping("/{idVenda}")
    @ApiOperation(value = "Recupera lista por ID.")
    public ResponseEntity<ModVenda> getByIDVenda(@PathVariable Long idVenda){
        return ResponseEntity.ok(serVenda.getByIDVenda(idVenda));
    }

    @DeleteMapping("/{idVenda}")
    @ApiOperation(value = "Deleta venda por ID.")
    public void delVendaById(@PathVariable Long idVenda, Long idProduto, Long idCaixa){
        serVenda.delVendaById(idVenda,idCaixa);
    }

    @PostMapping("/{idVenda}")
    @ApiOperation(value = "Informa que a venda solicitada por ID está paga.")
    public ResponseEntity<ModVenda> pagVendaById(Long idVenda){
        return ResponseEntity.ok(serVenda.pagVendaById(idVenda));
    }
}
