package com.barvegas.backend.Service;

import com.barvegas.backend.Model.ModCaixa;
import com.barvegas.backend.Repository.RepCaixa;
import com.barvegas.backend.exception.BadRequestException;
import com.barvegas.backend.exception.ServerErrorException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.el.MethodNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.prefs.BackingStoreException;


@Component
@RequiredArgsConstructor
public class SerCaixa {
    private final RepCaixa repCaixa;

    //Buscar Todos
    public List<ModCaixa> getAllCaixa(){
        return repCaixa.findAll();
    }

    //Buscar por id
    public ModCaixa getByIDCaixa(Long id){
        Optional<ModCaixa> optionalModCaixa = repCaixa.findById(id);
        if(!optionalModCaixa.isPresent()){
            throw new BadRequestException("Caixa não encontrado ...");
        }
        return optionalModCaixa.get();
    }

    //Salvar novo Caixa
    private ModCaixa saveCaixa(ModCaixa newCaixa){

        return repCaixa.save(newCaixa);
    }

    //Deletar caixa por ID
    public void delByIdCaixa(Long id){
        if(repCaixa.findById(id).isEmpty())
            throw new ServerErrorException("O Caixa que deseja deletar não existe");
        repCaixa.deleteById(id);
    }


}