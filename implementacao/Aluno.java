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

    public boolean realizarMatricula(Curso curso){
        for (int i=0; i<curso.getDisciplinas().size(); i++){
            curso.getDisciplinas().get(i).adicionarAluno(this);
        }
        return true;
    }

    public boolean cancelarMatricula(Curso curso){
        for (int i=0; i<curso.getDisciplinas().size(); i++){
            curso.getDisciplinas().get(i).removerAluno(this);
        }
        return true;
    }


    @Override
    public String toString() {
        return super.toString() + "{" +
            " matricula='" + getMatricula() + "'" +
            "}";
    }

    public String obterDados() {
        return "Codigo de pessoa: " + getCodPessoa() + "\nNumero de matricula: " + getMatricula() + "\nNome: " + getNome();
    }

}
