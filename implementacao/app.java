package implementacao;


import java.util.Scanner;

public class app {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Universidade universidade = new Universidade("PUC");       
        menu(universidade);
    }

    public static void menu(Universidade u) {
        int op;
        do {
            System.out.println("Selecione a opcao desejada: ");
            System.out.println("1 - Fazer login");
            System.out.println("0 - Sair");
            op = entrada.nextInt();

            switch (op) {
                case 1: 
                    fazerLogin(u);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente");
            }

        } while (op != 0);
       
    }

    public static void menuAluno(Universidade u, Aluno aluno) {
        int op;
        do {
            System.out.println();
            System.out.println("Bem vindo de volta, " + aluno.getNome() + "!");
            System.out.println("Selecione a opcao desejada");
            System.out.println();
            System.out.println("1 - Realizar matricula");
            System.out.println("2 - Cancelar matricula");
            System.out.println("3 - Acessar matricula atual");
            System.out.println("4 - Ver meus dados");
            System.out.println("5 - Adicionar disciplina");
            System.out.println("6 - Remover disciplina");
            System.out.println("0 - Deslogar");
            op = entrada.nextInt();

            switch(op) {
                case 1:
                    entrada.nextLine();
                    System.out.println("Matricular-se em qual curso?");
                    Curso cursoAtual = u.getCursos().get(entrada.nextLine());
                    if (cursoAtual == null) {
                        System.out.println("Curso nao encontrado!");
                        break;
                    }
                    aluno.realizarMatricula(cursoAtual);
                    
                    break;
                case 2:
                    System.out.println("Cancelar matricula de qual curso?");
                    entrada.nextLine();
                    cursoAtual = u.getCursos().get(entrada.nextLine());
                    if (cursoAtual == null) {
                        System.out.println("Curso nao encontrado!");
                        break;
                    }
                    aluno.cancelarMatricula(cursoAtual);
                    break;
                case 3:
                    for (int i = 0; i < aluno.getDisciplinas().size(); i++){
                        System.out.println(aluno.getDisciplinas().get(i));
                    }
                    break;
                case 4:
                    System.out.println(aluno.obterDados());
                    break;

                case 5:
                    entrada.nextLine();
                    Curso cursoAux = aluno.getCurso();
                    //cursoAux.adicionarDisciplina(new Disciplina("Direito Penal"));
                    System.out.println("O curso de " + cursoAux.getNome() + " possui as seguintes disciplinas:");
                    for (int i = 0; i < cursoAux.getDisciplinas().size(); i++) {
                        System.out.println(cursoAux.getDisciplinas().get(i));
                    }
                    System.out.println("Digite o nome de qual deseja adicionar: ");
                    String opt = entrada.nextLine();
                    Disciplina add =  new Disciplina(opt);

                    for (int i = 0; i < cursoAux.getDisciplinas().size(); i++) {
                        if (cursoAux.getDisciplinas().get(i).getNome().equals(opt)){
                            add = cursoAux.getDisciplinas().get(i);
                        }
                    }

                    if (aluno.adicionarDisciplina(add) == true){
                        System.out.println("Adicionado com sucesso!");
                        for (int i = 0; i < cursoAux.getDisciplinas().size(); i++) {
                            if (cursoAux.getDisciplinas().get(i).getNome().equals(opt)){
                               cursoAux.getDisciplinas().get(i).adicionarAluno(aluno);
                            }
                        }
                        
                    }
                    
                    else
                       System.out.println("Falha ao adicionar disciplina, tente novamente."); 

                    break;

                    case 6:
                    entrada.nextLine();
                    Curso cursoAux2 = aluno.getCurso();
                    if (aluno.getDisciplinas().size() == 0){
                        System.out.println("O aluno nao esta matriculado em nenhuma disciplina!");
                    }

                    else{

                        System.out.println("Selecione a disciplina matriculada para remover: ");

                        for (int i = 0; i < aluno.getDisciplinas().size(); i++){
                            System.out.println(aluno.getDisciplinas().get(i));
                        }

                        opt = entrada.nextLine();
                        Disciplina remove = new Disciplina("aux");

                        for (int i = 0; i < aluno.getDisciplinas().size(); i++) {
                            if (aluno.getDisciplinas().get(i).getNome().equals(opt))
                                remove = aluno.getDisciplinas().get(i);
                        }

                        if (aluno.removerDisciplina(remove) == true) {
                            System.out.println("Disciplina removida com sucesso!");
                            for (int i = 0; i < cursoAux2.getDisciplinas().size(); i++) {
                                if (cursoAux2.getDisciplinas().get(i).getNome().equals(opt)){
                                   cursoAux2.getDisciplinas().get(i).removerAluno(aluno);
                                }
                            }
                            
                        }

                        else
                           System.out.println("Erro ao remover disciplina, tente novamente."); 
                    }


                    break;

                case 0:
                    System.out.println("Deslogado com sucesso");
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente");
            }
        } while (op != 0);
    }

    public static void menuProfessor(Universidade u, Professor professor) {
          int op;
        do {
                System.out.println();
                System.out.println("Bem vindo de volta professor " + professor.getNome() + "!");
                System.out.println("Selecione a opcao desejada");
                System.out.println();
                System.out.println("1 - Visualizar disciplinas");
                System.out.println("2 - Visualizar alunos");
                System.out.println("0 - Deslogar");
                op = entrada.nextInt();

                switch(op) {
                    case 1:
                        entrada.nextLine();
                        System.out.println("Visualizar disciplinas de qual curso?");
                        Curso cursoAtual = u.getCursos().get(entrada.nextLine());
                        if (cursoAtual == null) {
                            System.out.println("Curso nao encontrado!");
                            break;
                        }
                        cursoAtual.mostrarDisciplinas(cursoAtual);
                        
                        break;
                    case 2:
                        entrada.nextLine();
                        System.out.println("Visualizar alunos de qual curso?");
                        Curso curso = u.getCursos().get(entrada.nextLine());
                        professor.visualizarAlunos(curso);
                        break;
                case 0:
                    System.out.println("Deslogado com sucesso");
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente");
            }
               
            } while(op !=0);
    }


    public static void menuSecretaria(Universidade u, Secretaria secretaria) {
            int op;
            do {
                System.out.println();
                System.out.println("Bem vindo de volta, " + secretaria.getNome() + "!");
                System.out.println("Selecione a opcao desejada");
                System.out.println();
                System.out.println("1 - Visualizar cursos");
                System.out.println("2 - Visualizar disciplinas de um curso");
                System.out.println("3 - Ativar uma disciplina");
                System.out.println("4 - Visualizar dados de usuarios");
                System.out.println("0 - Deslogar");
                op = entrada.nextInt();

                switch(op) {
                    case 1:
                        secretaria.acessarDadosCursos(u);
                        break;
                    case 2:
                        entrada.nextLine();
                        System.out.println("Visualizar disciplinas de qual curso?");
                        Curso cursoAtual = u.getCursos().get(entrada.nextLine());
                        if (cursoAtual == null) {
                            System.out.println("Curso nao encontrado!");
                            break;
                        }
                        secretaria.gerarCurriculo(cursoAtual);
                        break;
                    case 3:
                        entrada.nextLine();
                        System.out.println("Ativar disciplina de qual curso?");
                        cursoAtual = u.getCursos().get(entrada.nextLine());
                        if (cursoAtual == null) {
                            System.out.println("Curso nao encontrado!");
                            break;
                        }
                        System.out.println("Qual disciplina você deseja ativar?");
                        String input = entrada.nextLine();
                        secretaria.ativarDisciplina(cursoAtual, input);
                        break;
                    case 4:
                        // Visualizar usuarios
                        break;
                        
                case 0:
                    System.out.println("Deslogado com sucesso");
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente");
            }
               
            } while(op !=0);
    }


     public static void fazerLogin(Universidade u) {
        entrada.nextLine();
        System.out.print("Codigo de pessoa: ");
        String codPessoa = entrada.nextLine();     
        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        Pessoa logado = u.login(codPessoa, senha);
       
        if (logado == null) {
            System.out.println("Tente novamente");
       } else {
            if (logado instanceof Aluno) {
                menuAluno(u, (Aluno) logado);
            } else if (logado instanceof Professor) {
                menuProfessor(u, (Professor) logado);
            } else {
                menuSecretaria(u, (Secretaria) logado);
            }
       }
    }
}
