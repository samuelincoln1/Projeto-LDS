package implementacao;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private List<Aluno> alunosInscritos;
    private boolean status;

    public Disciplina (String nome) {
        this.nome = nome;
        alunosInscritos = new ArrayList<Aluno>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aluno> getAlunosInscritos() {
        return this.alunosInscritos;
    }

    public void setAlunosInscritos(List<Aluno> alunosInscritos) {
        this.alunosInscritos = alunosInscritos;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void adicionarAluno(Aluno aluno) {
        alunosInscritos.add (aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunosInscritos.remove(aluno);
    }

    public boolean ativar() {
        if (alunosInscritos.size()>=3) {
            setStatus(true);
            return status;
        } else {
            System.out.println("A disciplina precisa ter pelo menos 3 alunos inscritos");
            return status;
        }
    }
   

    @Override
    public String toString() {
        return "Nome: " + getNome() + 
            " | Quantidade de alunos matriculados:" + getAlunosInscritos().size() + 
            "| Status da disciplina:" + isStatus() 
           ;
    }

}
