package implementacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Professor extends Pessoa{
    public Professor(String nome, String senha, String codPessoa) {
        super(nome, senha, codPessoa);
    }

    public void visualizarAlunos(Curso curso){
      List<Aluno> lista = new ArrayList<Aluno>();

        List<Aluno> alunos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("implementacao/pessoas.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length >= 6 && partes[3].endsWith("a")) {
                    String senha = partes[1];
                    String nome = partes[2];
                    String codPessoa = partes[0];
                    String matricula = partes[4];
                    Curso cursoatual = Aluno.converterStringParaCurso(partes[5]);
                    alunos.add(new Aluno(nome, senha, codPessoa, matricula, cursoatual));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Aluno> todosOsAlunos = alunos;
        
        lista = todosOsAlunos.stream()
                .filter(aluno -> aluno.getCurso().equals(curso))
                .collect(Collectors.toList());

        System.out.println(lista);
    }
}
