package com.barvegas.backend.Service;

import com.barvegas.backend.Model.ProdutoModel;
import com.barvegas.backend.Model.VendaModel;
import com.barvegas.backend.Repository.Membro_CandidatoRepository;
import com.barvegas.backend.Repository.ProdutoRepository;
import com.barvegas.backend.Repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.el.MethodNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;
    ProdutoRepository produtoRepository;
    Membro_CandidatoRepository membroCandidatoRepository;

    //Buscar todos
    public List<VendaModel> getAllVendas(){
        return vendaRepository.findAll();
    }

    //Buscar venda por ID
    public VendaModel getVendaPorId(@PathVariable Long id){
        Optional<VendaModel> optionalVendaModel = vendaRepository.findById(id);
        if(!optionalVendaModel.isPresent())
            throw new MethodNotFoundException("Produto não encontrado...");

        return optionalVendaModel.get();
    }

    //UpDate venda
    public VendaModel updateVenda(@PathVariable Long id,
                                  @RequestBody VendaModel upVenda){
        upVenda.setId(id);

        return vendaRepository.save(upVenda);
    }


}
