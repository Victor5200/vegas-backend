package com.barvegas.backend.Controller;

import com.barvegas.backend.Service.Membro_CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Membro_CandidatoController {

    @Autowired
    Membro_CandidatoService membroCandidatoService;

    
}
