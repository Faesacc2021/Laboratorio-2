import java.util.Scanner;


public class CalcuradoraFBX {

	static Scanner ler = new Scanner(System.in);
	static double resultado = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menuCalcuradora();
	}
	
	public static void menuCalcuradora(){
		int continuar = 1;
		int valorMenu = 0;
		int valorUm = 0;
		int valorDois = 0;

		while (continuar != 0){

			System.out.println("Escolha a Operação Matemática");
			System.out.println("1 - Soma ");
			System.out.println("2 - Subtração");
			System.out.println("3 - Dividsao");
			System.out.println("4 - Multiplicação");
			System.out.println("0(zero) para sair");
			valorMenu = ler.nextInt();

			if (valorMenu != 0){
				System.out.println("Digite o primeiro valor: ");
				valorUm = ler.nextInt();

				System.out.println("Digite o Segundo valor: ");
				valorDois = ler.nextInt();
			}

			switch(valorMenu) {
			  case 0:
				System.out.println("Programa Encerrado ");
				continuar = 0;
				break;
			  case 1:
			     somar(valorUm, valorDois);
				    break;
			  case 2:
				 subtrair(valorUm, valorDois);
				    break;
			  case 3:
				 multiplicar(valorUm, valorDois);
				    break;
			  case 4:
				 dividir(valorUm, valorDois);
				    break;
			  default:
				  System.out.println("Opção Inválida!" );
			}
			imprimeResultado(resultado);
			resultado = 0.0;
		}
	}
	
	public static void imprimeResultado(double resultado){
		System.out.println("O resultado da operação: " + resultado);
	}

	public static double somar(double valorUm, double valorDois){
		resultado = (valorUm + valorDois);
		return resultado;
	}
	
	public static double subtrair(double valorUm, double valorDois){
		resultado = (valorUm - valorDois);
		return resultado;
	}
	
	public static double dividir(double valorUm, double valorDois){
		if (valorUm != 0 || valorDois != 0){
			resultado = (valorUm / valorDois);
		}
		return resultado;
	}
	
	public static double multiplicar(double valorUm, double valorDois){
		if (valorUm != 0 || valorDois != 0){
			resultado = (valorUm * valorDois);
		}
		return resultado;
	}
}


