package implementacao;

public class Pessoa {
    private String nome;
    private String codPessoa;
    private String senha;

    public Pessoa(String nome, String senha, String codPessoa) {
        this.nome = nome;
        this.senha = senha;
        this.codPessoa = codPessoa;
    }

    public String getSenha() {
        return senha;
    }

    public String getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(String codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", codPessoa='" + getCodPessoa() + "'" +
            ", senha='" + getSenha() + "'" +
            "}";
    }

   
}
