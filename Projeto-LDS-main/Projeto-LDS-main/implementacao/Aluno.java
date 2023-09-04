package implementacao;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{

    private String matricula;
    private Curso curso;
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Aluno(String nome, String senha, String codPessoa, String matricula, Curso curso) {
        super(nome, senha, codPessoa);
        this.matricula = matricula;
        this.curso = curso;
    }

    public Boolean adicionarDisciplina(Disciplina disciplina){
        boolean existe = false;
        for (int i = 0; i < this.curso.getDisciplinas().size(); i++){
            if (curso.getDisciplinas().get(i).getNome().equals(disciplina.getNome()))
                existe = true;
        }

        if (existe == false)
            return false;
        
        else{
            this.disciplinas.add(disciplina);
        }

        return true;

    }

    public Boolean removerDisciplina(Disciplina disciplina){
        boolean exit;
        for (int i = 0; i < this.curso.getDisciplinas().size(); i++){
            if (disciplinas.get(i).getNome().equals(disciplina.getNome())){
                disciplinas.remove(i);
                return exit = true;
            }
        }

        return exit = false;

    }

    public List<Disciplina> getDisciplinas(){
        return this.disciplinas;
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
    

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public static Curso converterStringParaCurso(String nomeCurso) {
        return new Curso(nomeCurso);
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
            " matricula='" + getMatricula() + "'" +
            "}";
    }

    public String obterDados() {
        return "Codigo de pessoa: " + getCodPessoa() + "\nNumero de matricula: " + getMatricula() + "\nNome: " + getNome() + "\nCursos matriculados " + getCurso() ;
    }

}
