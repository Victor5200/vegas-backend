package com.barvegas.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_CLIENTE")
public class ModCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(nullable = false, length = 50)
    public String nome;

    @Column(nullable = false, length = 50)
    public String cpf;

    @Column(nullable = false, length = 20)
    public String telefone;

    @Column(nullable = false, length = 50)
    public String relevancia;

    @Column(nullable = false, length = 50)
    public boolean inadimplente;
}
