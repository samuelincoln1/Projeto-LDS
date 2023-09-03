package implementacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Universidade {

    private String nome;
    private HashMap<String, Curso> cursos = new HashMap<String, Curso>();
    // private HashMap<String, Disciplina> disciplinas = new HashMap<String, Disciplina>();
    private HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
    private Pessoa pessoaAtual;

    public Universidade(String nome) throws Exception{
        this.nome = nome;
        carregarPessoas();
        carregarCursos();
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public HashMap<String, Pessoa> getPessoas() {
        return pessoas;
    }

    public HashMap<String, Curso> getCursos() {
        return cursos;
    }

    private void carregarPessoas() throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("implementacao/pessoas.txt"));
            String linha;
            
            while ((linha = reader.readLine()) != null) {
                StringTokenizer str = new StringTokenizer(linha, ";");
                String codPessoa = str.nextToken();
                String senha = str.nextToken();
                String nome = str.nextToken();
                String tipo = str.nextToken();
                if (tipo.equals("a")) {
                    String matricula = str.nextToken();
                    pessoaAtual = new Aluno(nome, senha, codPessoa, matricula);
                } else if (tipo.equals("s")) {
                    pessoaAtual = new Secretaria(nome, senha, codPessoa);
                } else {
                    pessoaAtual = new Professor(nome, senha, codPessoa);
                }
                pessoas.put(pessoaAtual.getCodPessoa(), pessoaAtual);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void carregarCursos() throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("implementacao/cursos.txt"));
            String linha;
            
            while ((linha = reader.readLine()) != null) {
                StringTokenizer str = new StringTokenizer(linha, ";");
                String nome = str.nextToken();
                int creditos = Integer.parseInt(str.nextToken());
                Curso cursoAtual = new Curso(nome, creditos);
                while (str.hasMoreTokens()) {
                    cursoAtual.adicionarDisciplina(new Disciplina(str.nextToken()));
                }
                cursos.put(cursoAtual.getNome(), cursoAtual);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // private void carregarDisciplinas() throws Exception {
    //     try {
    //         BufferedReader reader = new BufferedReader(new FileReader("implementacao/cursos.txt"));
    //         String linha;
            
    //         while ((linha = reader.readLine()) != null) {
    //             StringTokenizer str = new StringTokenizer(linha, ";");
    //             str.nextToken();
    //             str.nextToken();
    //             while (str.hasMoreTokens()) {
    //                 String disciplina = str.nextToken();
    //                 disciplinas.put(disciplina, new Disciplina(disciplina));
    //             }
    //         }
    //         reader.close();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    public Pessoa login(String codPessoa, String senha) {
        pessoaAtual = pessoas.get(codPessoa);
        if (pessoaAtual == null) {
            System.out.println("login incorreto");
            return null;
        }

        if (!senha.equals(pessoaAtual.getSenha())) {
            System.out.println("senha incorreta");
            return null;
        }

        return pessoaAtual;
    }

    public String cursosToString() {
        return "Curso";
    }
    
}