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
        int op = 0;
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
                    System.out.println(aluno.verDados());
                    break;
                case 0:
                    System.out.println("Deslogado com sucesso\n");
                    break;
                default:
                    System.out.println("Opcao invalida, tente novamente");
            
            }
        } while (op != 0);
    }

    public static void menuProfessor(Universidade u, Pessoa professor) {
        System.out.println("Menu de professores");
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
            } else {
                menuProfessor(u, (Professor) logado);
            }
       }
    }
}
