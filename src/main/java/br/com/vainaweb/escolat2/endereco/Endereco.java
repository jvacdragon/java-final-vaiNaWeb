package br.com.vainaweb.escolat2.endereco;

import br.com.vainaweb.escolat2.aluno.Aluno;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Embeddable
//@AttributeOverrides({
//        @AttributeOverride(name="nomeLogradouro", column = @Column(name = "nome_logradouro")),
//        @AttributeOverride(name="numero", column = @Column(name = "numero")),
//        @AttributeOverride(name="complementoLogradouro", column = @Column(name = "complemento_logradouro")),
//        @AttributeOverride(name="cidade", column = @Column(name = "cidade")),
//        @AttributeOverride(name="estado", column = @Column(name = "estado"))
//}
//)
public class Endereco {

    private String nomeLogradouro;
    private int numero;
    private String complementoLogradouro;

    private String cidade;
    private String estado;
    private String bairro;
    private String cep;

    public Endereco(){};

    public Endereco(String nomeLogradouro, int numero, String complementoLogradouro, String cidade, String estado, String bairro, String cep) {
        this.nomeLogradouro = nomeLogradouro;
        this.numero = numero;
        this.complementoLogradouro = complementoLogradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplementoLogradouro() {
        return complementoLogradouro;
    }

    public void setComplementoLogradouro(String complementoLogradouro) {
        this.complementoLogradouro = complementoLogradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
