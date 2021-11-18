package com.barvegas.backend.Service;

import com.barvegas.backend.Model.ModCliente;
import com.barvegas.backend.Repository.RepCliente;
import com.barvegas.backend.exception.BadRequestException;
import com.barvegas.backend.exception.ServerErrorException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.el.MethodNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SerCliente {
    private final RepCliente repCliente;

    //Buscar todos
    public List<ModCliente> getAllClientes(){
        return repCliente.findAll();
    }

    //Buscar Membro/Candidato por id
    public ModCliente getClienteById(Long id){
        Optional<ModCliente> optionalMembro_canditatoModel =
                                        repCliente.findById(id);
        if(!optionalMembro_canditatoModel.isPresent())
            throw new BadRequestException("Produto não encontrado...");
        return optionalMembro_canditatoModel.get();
    }

    //Alterar Membro/Candidato (Todos os campos)
    public ModCliente updateClienteById(Long id , ModCliente upCliente){
        if(repCliente.findById(id).isEmpty()){
            throw new BadRequestException("O cliente procurado não existe");
        }
        upCliente.setId(id);
        return repCliente.save(upCliente);
    }

    //Salvar novo produto
    public ModCliente saveMembCandi(ModCliente newMemCan){

        return repCliente.save(newMemCan);
    }

    //Deletar Produto por código
    public void deleteClienteById(Long id){
        if(repCliente.findById(id).isEmpty()){
            throw new ServerErrorException("O cliente que deseja deletar não existe.");
        }
        repCliente.deleteById(id);
    }



}
