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
            System.out.println("0 - Deslogar");
            op = entrada.nextInt();

            switch(op) {
                case 1:
                    aluno.realizarMatricula();
                    break;
                case 2:
                    aluno.cancelarMatricula();
                    break;
                case 3:
                    // acessarMatriculaAtual();
                    break;
                case 4:
                    System.out.println(aluno.obterDados());
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
        System.out.println("Menu de professores");
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
                        // System.out.println(cursoAtual.toString());
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
