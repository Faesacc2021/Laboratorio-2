
public class exercicios2804 {

	public static void main(String[] args) {
		//Soma valores
		somaValores(15.5, 18.5);
		
		//Altura Ideal
		alturaIdeal(1.8, 'M');
		alturaIdeal(1.6, 'F');
		
		//Existe Letra
		System.out.printf("Existe a letra que você digitou? " + procuraLetra('D'));
		
		// Imprime Frase
		imprimeFrase("Ultra");
	}

	static void somaValores(double valor01, double valor02){
		double resultado = valor01 + valor02;
		System.out.printf("A soma de dois valores é: %2f\n", resultado );
	}
	
	static void alturaIdeal(double altura, char sexo){
		double resultado = 0;
		
		if (sexo == 'M'){
			resultado = (72.7 * altura) - 58;
			System.out.printf("A altura ideal para um Homen de:" + altura + "m é : %.2f \n", resultado );
		}
		if (sexo == 'F'){
			resultado = (62.1 * altura) - 47.7;
			System.out.printf("A altura ideal para um Mulher de:" + altura + "m é: %.2f \n", resultado );
		}
	}
	
	static char letras[] = {'A','B','C','D','E'};
	static boolean procuraLetra(char letra){
		boolean existeLetra = false;
		for (int i = 0; i < 4; i ++){
			if (letras[i] == letra){
				existeLetra = true;
			}
		}
		return existeLetra;
	}
	
	
	static String fraseInicial = "\nEste programa foi desenvolvido pelo grupo "; 
	static String fraseFinal = ". Todos os direitos reservados - Copyright. Obrigado por utilizá-lo!"; 

	static void imprimeFrase(String nomeGrupo){
		
		System.out.println(fraseInicial + nomeGrupo + fraseFinal );
	}
	
}
