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

			System.out.println("Escolha uma opção");
			System.out.println("1 - Cadastrar um aluno ");
			System.out.println("2 - Mostrar todos os dados do aluno");
			System.out.println("3 - Verificar se o aluno está reprovado por falta");
			System.out.println("4 - Mostrar a média do aluno");
			System.out.println("5 - Mostrar situação de aprovação ou reprovação");
			System.out.println("6 - Finalizar operações");
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
				  System.out.println("Opção Inválida!" );
			}

		}
	}

	private static void cadastrarAluno() {
		Pauta pauta = new Pauta(0, null, 0, 0, 0);
		int matricula;
		String nomeAlulno;
		int	numFalta;
		double	nota1; 
		double	nota2;

		System.out.println("Digite a Matrícula do Aluno: ");
		matricula = ler.nextInt();
		pauta.setMatricula(matricula);
		
		System.out.println("Digite o Nome do Aluno: ");
		nomeAlulno = ler.next();
		pauta.setNomeAlulno(nomeAlulno);

		System.out.println("Digite o Número de Faltas do Aluno: ");
		numFalta = ler.nextInt();
		pauta.setNumFalta(numFalta);
		
		System.out.println("Digite a Nota 01 do Aluno: ");
		nota1 = ler.nextDouble();
		pauta.setNota1(nota1);
		
		System.out.println("Digite a Nota 02 do Aluno: ");
		nota2 = ler.nextDouble();
		pauta.setNota2(nota2);
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
