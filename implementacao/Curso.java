package implementacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Curso {

    private String nome;
    private int creditos;
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Curso(String nome, int creditos) {
        this.nome = nome;
        this.creditos = creditos;
    }

    public Curso(String nome) {
        this.nome = nome;
        this.creditos = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCreditos() {
        return this.creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void mostrarDisciplinas(Curso curso) {
        System.out.println("O curso de " + curso.getNome() + " possui as seguintes disciplinas:");
        for (int i = 0; i < curso.getDisciplinas().size(); i++) {
            System.out.println(curso.getDisciplinas().get(i));
        }
    }


    @Override
    public String toString() {
        return "{" +
                " nome='" + getNome() + "'" +
                ", creditos='" + getCreditos() + "'" +
                ", disciplinas='" + getDisciplinas() + "'" +
                "}";
    }

}
