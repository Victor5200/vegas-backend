package com.barvegas.backend.Controller;

import com.barvegas.backend.Model.ModCaixa;
import com.barvegas.backend.Service.SerCaixa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class ConCaixa {

    @Autowired
    SerCaixa serCaixa;

    @GetMapping("/caixa")
    public ResponseEntity<List<ModCaixa>> getAllCaixa(){
        return ResponseEntity.ok(serCaixa.getAllCaixa());
    }

    @GetMapping("/caixa/{idCaixa}")
    public ResponseEntity<ModCaixa> getByIdCaixa(@PathVariable Long idCaixa){
        return ResponseEntity.ok(serCaixa.getByIDCaixa(idCaixa));
    }

    @DeleteMapping("/caixa/{idCaixa}")
    public void  delByIdCaixa(@PathVariable Long idCaixa){
        serCaixa.delByIdCaixa(idCaixa);
    }



}