package implementacao;

import java.util.List;

public class Universidade {

    public String localizacao;
    public String nome;
    public String contato;
    public List<Curso> cursos;

    public Universidade(String nome, String localizacao, String contato) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.contato = contato;
    }

    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }
    
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
    public String getContato() {
        return contato;
    }
    
    public void setContato(String contato) {
        this.contato = contato;
    }
    
}