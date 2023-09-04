package implementacao;

public class Secretaria extends Pessoa{
    public Secretaria(String nome, String senha, String codPessoa) {
        super(nome, senha, codPessoa);
    }
    

    public void gerarCurriculo(Curso curso){
        System.out.println("O curso de " + curso.getNome() + " possui as seguintes disciplinas:");
        for (int i=0; i<curso.getDisciplinas().size(); i++) {
            System.out.println(curso.getDisciplinas().get(i));
        }
        
    }

    public void acessarDadosCursos(Universidade u) {
        System.out.println();
        System.out.println("Cursos disponiveis na universidade:");
        for (String key : u.getCursos().keySet()) {
            System.out.println(key);
        }
        
    }

    public boolean ativarDisciplina(Curso curso, String disciplina) {
        for (int i=0; i<curso.getDisciplinas().size(); i++) {
            Disciplina disciplinaAtual = curso.getDisciplinas().get(i);
            if (disciplinaAtual.getNome().equals(disciplina)) {
                disciplinaAtual.ativar();
                return true;
            }
        }
        System.out.println("Disciplina nao encontrada");
        return false;
       
    }
}