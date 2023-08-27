package implementacao;

public class Aluno extends Pessoa{
    public int Matricula;

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }

    public int getMatricula() {
        return Matricula;
    }

    public boolean realizarMatricula(){
        return true;
    }

    public boolean cancelarMatricula(){
        return true;
    }
}
