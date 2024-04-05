package br.com.vainaweb.escolat2.aluno;

import br.com.vainaweb.escolat2.endereco.Endereco;
import br.com.vainaweb.escolat2.enuns.Curso;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@JsonIgnoreProperties({
        "id",
        "endereco",
        "cpf",
        "telefone"
})
public class Aluno {
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
    private Curso curso;
    @Pattern(regexp = "\\(\\d{2}\\)9\\d{4}-\\d{4}", message = "Favor utilizar padrão (xx)9xxxx-xxxx para telefone")
    private String telefone;
    @Embedded
    private Endereco endereco;

    public Aluno(){};

    public Aluno(String name, String email, String cpf, String curso, String telefone, Endereco endereco) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.cpf = cpf;
        this.curso = Curso.fromString(curso);
        this.telefone = telefone;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
