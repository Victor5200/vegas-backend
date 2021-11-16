package com.barvegas.backend.Controller;

import com.barvegas.backend.Model.ModCaixa;
import com.barvegas.backend.Service.SerCaixa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/caixa")
@Api(value = "API REST CAIXA")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CaixaController {
    private final SerCaixa serCaixa;

    @GetMapping
    @ApiOperation(value = "Recupera lista de todos os caixas.")
    public ResponseEntity<List<ModCaixa>> getAllCaixa(){
        return ResponseEntity.ok(serCaixa.getAllCaixa());
    }

    @GetMapping("/{idCaixa}")
    @ApiOperation(value = "Recupera lista de caixa por ID.")
    public ResponseEntity<ModCaixa> getByIdCaixa(@PathVariable Long idCaixa){
        return ResponseEntity.ok(serCaixa.getByIDCaixa(idCaixa));
    }

    @DeleteMapping("/{idCaixa}")
    @ApiOperation(value = "Deleta caixa por ID selecionado")
    public ResponseEntity<Void>  delByIdCaixa(@PathVariable Long idCaixa){
        serCaixa.delByIdCaixa(idCaixa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}