package com.barvegas.backend.Service;

import com.barvegas.backend.Model.Membro_CanditatoModel;
import com.barvegas.backend.Repository.Membro_CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.el.MethodNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class Membro_CandidatoService {

    @Autowired
    Membro_CandidatoRepository membroCandidatoRepository;

    //Buscar todos
    public List<Membro_CanditatoModel> getAllMembCandi(){
        return membroCandidatoRepository.findAll();
    }

    //Buscar Membro/Candidato por id
    public Membro_CanditatoModel getMembCandiById(@PathVariable Long id){
        Optional<Membro_CanditatoModel> optionalMembro_canditatoModel =
                                        membroCandidatoRepository.findById(id);

        if(!optionalMembro_canditatoModel.isPresent())
            throw new MethodNotFoundException("Produto não encontrado...");

        return optionalMembro_canditatoModel.get();
    }

    //Alterar Membro/Candidato (Todos os campos)
    public Membro_CanditatoModel updateMembCandi(@PathVariable Long id ,
                                                @RequestBody Membro_CanditatoModel upMemCan){

        upMemCan.setId(id);
        return membroCandidatoRepository.save(upMemCan);
    }

    //Salvar novo produto
    public Membro_CanditatoModel saveMembCandi(@RequestBody Membro_CanditatoModel newMemCan){

        return membroCandidatoRepository.save(newMemCan);
    }

    //Deletar Produto por código
    public void deleteMembCandiById(@PathVariable Long id){
        membroCandidatoRepository.deleteById(id);
    }
}
