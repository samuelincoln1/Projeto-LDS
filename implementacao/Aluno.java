package implementacao;

public class Aluno extends Pessoa{

    private String matricula;

    public Aluno(String nome, String senha, String codPessoa, String matricula) {
        super(nome, senha, codPessoa);
        this.matricula = matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public boolean realizarMatricula(){
        return true;
    }

    public boolean cancelarMatricula(){
        return true;
    }


    @Override
    public String toString() {
        return super.toString() + "{" +
            " matricula='" + getMatricula() + "'" +
            "}";
    }

    public String verDados() {
        return "Codigo de pessoa: " + getCodPessoa() + "\nNumero de matricula: " + getMatricula() + "\nNome: " + getNome();
    }

}
