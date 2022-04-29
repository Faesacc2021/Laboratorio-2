import java.util.Scanner;

public class Exercicio100 {

	public static void main(String[] args) {

		Scanner meuTeclado;
		meuTeclado = new Scanner(System.in);

		int indSalario = 0;
		double[] valSalario = new double[20];
		double[] oldList = new double[20];

		while (indSalario < 20) {
			System.out.println("Informe valor do Sal�rio N�: " + indSalario);
			valSalario[indSalario] = meuTeclado.nextInt();
			oldList[indSalario] = valSalario[indSalario];
			indSalario++;
		}

		//M�todo Bolha

		int countBolha = 0;
		int countInsercao = 0;
		double aux;

		for (int i = 0; i < valSalario.length - 1; i++) {
			countBolha++;
			for (int j = 0; j < valSalario.length - 1 - i; j++) {
				countBolha++;
				if (valSalario[j] > valSalario[j + 1]) {
					aux = valSalario[j];
					valSalario[j] = valSalario[j + 1];
					valSalario[j + 1] = aux;
				}
			}
		}

		int i = 0;
		int j = 0;
		double temp = 0;

		// Inser��o Direta


		for (i = 1; i < oldList.length; i++) {
			countInsercao++;
			temp = oldList[i];
			j = i - 1;
			while ((j >= 0) && (oldList[j] > temp)) {
				oldList[j + 1] = oldList[j--];
				countInsercao++;
			}
			oldList[j + 1] = temp;
		}

		System.out.println("Ordena��o M�todo Bolha " + countBolha);
		System.out.println("Ordena��o Inser��o Direta " + countInsercao);

		int contadorLinear = 0;
		int contadorBinario = 0;
		int continuaPesquisa = 1;
		double salario = 0;

		while (continuaPesquisa == 1) {

			contadorLinear = 0;
			contadorBinario = 0;

			System.out.print("\nDigite un numero para pesquisar na lista: ");
			System.out.println("\nDigite 0 (zero) para encerrar.\n");
			salario = meuTeclado.nextDouble();

			if (salario == 0) {
				continuaPesquisa = 0;
				System.out.println("Voc� escolheu sair\n ");
				break;
			}

			// CONTADOR LINEAR

			i = 0;

			while (i < valSalario.length) {
				contadorLinear++;
				if (salario == valSalario[i]) {
					break;
				}
				i++;
			}

			//CONTADOR BINARIO

			int inicio = 0;
			int fim = valSalario.length - 1;
			int meio;

			while (inicio <= fim) {
				meio = (inicio + fim) / 2;
				if (salario == valSalario[meio]) {
					contadorBinario++;
					break;
				}

				if (salario < valSalario[meio]) {
					contadorBinario++;
					fim = meio - 1;
				} else {
					contadorBinario++;
					inicio = meio + 1;
				}
			}


			if (i == valSalario.length) {
				System.out.println("n�o achou");
			} else {
				System.out.println("Achou e est� na posi��o " + i);
				System.out.println("Vezes Pesquisa Linear: " + contadorLinear);
				System.out.println("Vezes Pesquisa Bin�ria " + contadorBinario);
				System.out.println("Ordena��o M�todo Bolha " + countBolha);
				System.out.println("Ordena��o Inser��o Direta " + countInsercao);
			}
			meuTeclado.close();

		}
	}
}





