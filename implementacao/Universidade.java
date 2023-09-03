package implementacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Universidade {

    private String nome;
    private List<Curso> cursos;
    private HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
    private Pessoa pessoaAtual;

    public Universidade(String nome) throws Exception{
        this.nome = nome;
        carregarDados();
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


    private void carregarDados() throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("implementacao/pessoas.txt"));
            String linha;
            // reader.readLine();
            
            while ((linha = reader.readLine()) != null) {
                StringTokenizer str = new StringTokenizer(linha, ";");
                String codPessoa = str.nextToken();
                String senha = str.nextToken();
                String nome = str.nextToken();
                String tipo = str.nextToken();
                if (tipo.equals("a")) {
                    String matricula = str.nextToken();
                    pessoaAtual = new Aluno(nome, senha, codPessoa, matricula);
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

   
    
}