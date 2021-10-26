package com.barvegas.backend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//EndPoint que não precisa de validaçãp de usuario e senha pra poder ser acessado
@RestController
public class Index {

    @RequestMapping("/")
    public String index(){
        return "INDEX";
    }

}
