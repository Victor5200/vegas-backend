package com.barvegas.backend.Controller;

import com.barvegas.backend.Model.ModCompras;
import com.barvegas.backend.Service.SerCompra;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/compras")
@Api(value = "API REST COMPRAS")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class CompraController {
    @Autowired
    private SerCompra serCompra;

    @PostMapping
    public ResponseEntity<Void> saveCompras(@RequestBody ModCompras idCompra) {
        serCompra.saveCompras(idCompra);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
