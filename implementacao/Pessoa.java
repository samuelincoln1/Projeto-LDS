package implementacao;

public class Pessoa {
    public String Nome;
    public int CodPessoa;
    public String Senha;

    public String getSenha() {
        return Senha;
    }

    public int getCodPessoa() {
        return CodPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        CodPessoa = codPessoa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
