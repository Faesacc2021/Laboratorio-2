import java.util.Scanner;

public class PrincipalEscola {
    static Scanner ler = new Scanner(System.in);
    public static int autoIncrement = -1;

    public static void main(String[] args) {
        menuAluno();
    }

    public static void menuAluno(){
        int continuar = 7;
        String entrada = "";
        int valorMenu = 0;

        while (continuar != 0){

            System.out.println("Escolha uma opção");
            System.out.println("1 - Incluir Dados do Aluno ");
            System.out.println("2 - Consultar Nota");
            System.out.println("3 - Média Aritimética");
            System.out.println("0 - Finalizar operações");
            entrada = ler.next();

            try{
                valorMenu = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                continue;
            }

            switch(valorMenu) {
                case 0:
                    System.out.println("Programa Encerrado ");
                    continuar = 0;
                    break;
                case 1:
                    incluirAluno();
                    break;
                case 2:
                    consultaNota();
                    break;
                case 3:
                    consultaMedia();
                    break;
                default:
                    System.out.println("Opção Inválida!" );
            }
        }
    }

    private static void incluirAluno() {
        Alunos aluno = new Alunos();

        System.out.println("Digite o nome do Aluno: ");
        ler.nextLine();
        aluno.setNome(ler.nextLine());

        System.out.println("Digite o Nota 01: ");
        aluno.setNota01(ler.nextDouble());

        System.out.println("Digite o Nota 02: ");
        aluno.setNota02(ler.nextDouble());

        autoIncrement = autoIncrement + 1;
        aluno.setMatricula(autoIncrement);
        AlunosVet.incluirAlunos(aluno, autoIncrement);
    }

    private static void consultaNota() {

        System.out.println("por vafor informe a nota de corte: ");
        double nota = ler.nextDouble();

        Alunos.consultarAlunos(nota, autoIncrement);
    }

    private static void consultaMedia() {
        Alunos.consultarMedia(autoIncrement);
    }

}