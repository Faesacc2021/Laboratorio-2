
public class exercicios2804 {

	public static void main(String[] args) {
		//Soma valores
		somaValores(15.5, 18.5);
		
		//Altura Ideal
		alturaIdeal(1.8, 'M');
		alturaIdeal(1.6, 'F');
	}

	static void somaValores(double valor01, double valor02){
		double resultado = valor01 + valor02;
		System.out.printf("A soma de dois valores �: %2f\n", resultado );
	}
	
	static void alturaIdeal(double altura, char sexo){
		double resultado = 0;
		
		if (sexo == 'M'){
			resultado = (72.7 * altura) - 58;
			System.out.printf("A altura ideal para um Homen de:" + altura + "m � : %2f \n", resultado );
		}
		if (sexo == 'F'){
			resultado = (62.1 * altura) - 47.7;
			System.out.printf("A altura ideal para um Mulher de:" + altura + "m �: %2f \n", resultado );
		}
	}
}
