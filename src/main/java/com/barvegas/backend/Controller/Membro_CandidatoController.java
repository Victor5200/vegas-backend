package com.barvegas.backend.Controller;

import com.barvegas.backend.Model.Membro_CanditatoModel;
import com.barvegas.backend.Service.Membro_CandidatoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@Api(value = "API REST MEMBRO_CANDIDATO")
@CrossOrigin(origins = "*")
public class Membro_CandidatoController {

    @Autowired
    Membro_CandidatoService membroCandidatoService;

    @PostMapping(path = "/membro")
    @ApiOperation(value = "Salva um novo membro ou candidato.")
    public Membro_CanditatoModel saveMembCandi(@RequestBody Membro_CanditatoModel newMemCan){
        return membroCandidatoService.saveMembCandi(newMemCan);
    }


}
