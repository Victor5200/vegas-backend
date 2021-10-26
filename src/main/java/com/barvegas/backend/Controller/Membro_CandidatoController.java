package com.barvegas.backend.Controller;

import com.barvegas.backend.Model.Membro_CanditatoModel;
import com.barvegas.backend.Service.Membro_CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/membro")
public class Membro_CandidatoController {

    @Autowired
    Membro_CandidatoService membroCandidatoService;

    @PostMapping
    public Membro_CanditatoModel saveMembCandi(@RequestBody Membro_CanditatoModel newMemCan){
        return membroCandidatoService.saveMembCandi(newMemCan);
    }
}
