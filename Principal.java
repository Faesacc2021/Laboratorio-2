import java.util.Scanner;


public class Principal {
	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		menuAluno();
	}
	
	public static void menuAluno(){
		int continuar = 1;
		int valorMenu = 0;

		while (continuar != 6){

			System.out.println("Escolha uma op��o");
			System.out.println("1 - Cadastrar um aluno ");
			System.out.println("2 - Mostrar todos os dados do aluno");
			System.out.println("3 - Verificar se o aluno est� reprovado por falta");
			System.out.println("4 - Mostrar a m�dia do aluno");
			System.out.println("5 - Mostrar situa��o de aprova��o ou reprova��o");
			System.out.println("6 - Finalizar opera��es");
			valorMenu = ler.nextInt();


			switch(valorMenu) {
			  case 6:
				System.out.println("Programa Encerrado ");
				continuar = 6;
				break;
			  case 1:
			     cadastrarAluno();
				    break;
			  case 2:
				 mostrarTodosDados();
				    break;
			  case 3:
				 reprovadoFalta();
				    break;
			  case 4:
				 madiaAluno();
				    break;
			  case 5:
				 situacaoAluno();
				    break;
			  default:
				  System.out.println("Op��o Inv�lida!" );
			}

		}
	}

	private static void cadastrarAluno() {
		
	}

	private static void mostrarTodosDados() {
		
	}

	private static void reprovadoFalta() {
		
	}

	private static void madiaAluno() {
		
	}

	private static void situacaoAluno() {
		
	}
}
