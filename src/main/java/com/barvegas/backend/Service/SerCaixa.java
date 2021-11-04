package com.barvegas.backend.Service;

import com.barvegas.backend.Model.ModCaixa;
import com.barvegas.backend.Repository.RepCaixa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.el.MethodNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Component
public class SerCaixa {

    @Autowired
    RepCaixa repCaixa;

    //Buscar Todos
    public List<ModCaixa> getAllCaixa(){
        return repCaixa.findAll();
    }

    //Buscar por id
    public ModCaixa getByIDCaixa(Long id){
        Optional<ModCaixa> optionalModCaixa = repCaixa.findById(id);
        if(!optionalModCaixa.isPresent()){
            throw new MethodNotFoundException("Caixa não encontrado ...");
        }
        return optionalModCaixa.get();
    }

    //Salvar novo Caixa
    private ModCaixa saveCaixa(ModCaixa newCaixa){

        return repCaixa.save(newCaixa);
    }

    //Deletar caixa por ID
    public void delByIdCaixa(Long id){
        repCaixa.deleteById(id);
    }


}