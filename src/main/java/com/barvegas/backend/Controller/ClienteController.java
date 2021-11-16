package com.barvegas.backend.Controller;

import com.barvegas.backend.Model.ModCliente;
import com.barvegas.backend.Service.SerCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/membro")
@Api(value = "API REST MEMBRO_CANDIDATO")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClienteController {
    private final SerCliente serCliente;

    //Salvar Novo Cliente
    @PostMapping
    @ApiOperation(value = "Salva um novo membro ou candidato.")
    public ResponseEntity<ModCliente> saveMembCandi(@RequestBody ModCliente newMemCan){
        return ResponseEntity.ok(serCliente.saveMembCandi(newMemCan));
    }

    //Buscar todos
    @GetMapping
    @ApiOperation(value = "Busca todos os cliente.")
    public ResponseEntity<List<ModCliente>> getAllClientes(){
        return ResponseEntity.ok(serCliente.getAllClientes());
    }

    //Buscar  por id
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Busca cliente por id.")
    public ResponseEntity<ModCliente> getClienteById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok(serCliente.getClienteById(id));
    }

    //Alterar Membro/Candidato (Todos os campos)
    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Altera cliente.")
    public ResponseEntity<ModCliente> updateClienteById(@PathVariable(value = "id") Long id ,
                                                        @RequestBody ModCliente upCliente){
        return ResponseEntity.ok(serCliente.updateClienteById(id,upCliente));
    }

    //Deletar Produto por código
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta cliente")
    public ResponseEntity<Void> deleteClienteById(@PathVariable Long id){
        serCliente.deleteClienteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    }


