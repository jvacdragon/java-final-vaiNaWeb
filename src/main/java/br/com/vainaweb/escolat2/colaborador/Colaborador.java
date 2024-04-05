package br.com.vainaweb.escolat2.colaborador;

import br.com.vainaweb.escolat2.endereco.Endereco;
import br.com.vainaweb.escolat2.enuns.Cargo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

@JsonIgnoreProperties(value = {
        "id",
        "endereco",
        "cpf"
})
@Entity
public class Colaborador {

    @NotNull
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Column(unique = true)
    @Email
    private String email;
    @Column(unique = true)
    @NotNull
    @CPF
    private String cpf;
    @NotNull
    private Cargo cargo;
    @Embedded
    private Endereco endereco;

    public Colaborador(){};

    public Colaborador(String name, String email, String cpf, Cargo cargo, Endereco endereco) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.cargo = cargo;
        this.endereco = endereco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
