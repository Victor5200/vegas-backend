package com.barvegas.backend.Controller;

import com.barvegas.backend.Model.ModVenda;
import com.barvegas.backend.Service.SerCaixa;
import com.barvegas.backend.Service.SerVenda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "/api/vendas")
@Api(value = "API REST VENDA")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class VendaController {
    private final SerVenda serVenda;
    private final SerCaixa serCaixa;

    @PostMapping
    @ApiOperation(value = "Salva nova venda")
    public ResponseEntity<ModVenda> saveVenda(@RequestBody ModVenda newVenda) throws Exception {
        return new ResponseEntity<>(serVenda.saveVenda(newVenda), HttpStatus.CREATED);
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
    public ResponseEntity<Void> delVendaById(@PathVariable Long idVenda){
        serVenda.delVendaById(idVenda);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/membro/{idCliente}")
    @ApiOperation(value = "Buscar venda de membro por id do Cliente.")
    public ResponseEntity<ModVenda> findVendaByIdCliente(@PathVariable("idCliente")Long id) {
        return ResponseEntity.ok(serVenda.findVendaByIdCliente(id));
    }

    @GetMapping(value = "/daylist")
    @ApiOperation(value = "Buscar lista de vendas to dia atual.")
    public ResponseEntity<List<ModVenda>> findListVendaDateNow(){
        return ResponseEntity.ok(serVenda.findListVendaDateNow());
    }
}
