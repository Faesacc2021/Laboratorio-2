package classes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		iniciar();
	}
	
	public static void iniciar(){
		retangulo();
		circulo();
	}

	public static void retangulo(){
		Retangulo retangulo = new Retangulo();
		Ponto ponto = new Ponto();
		ponto.setX(1);
		ponto.setY(1);
		double base = 15.5;
		double altura = 25.80;
		
		double area = 0.0;
		double perimetro = 0.0;
		area = retangulo.areaRetangulo(ponto, base, altura);
		perimetro = retangulo.perimetroRetangulo(ponto, base, altura);
		
		System.out.printf("A área do retângulo = %.2f\n",  area);
		System.out.printf("O perímetro do retângulo = %.2f\n\n", perimetro);		
	}

	public static void circulo(){
		Circulo circulo = new Circulo();
		Ponto ponto = new Ponto();
		ponto.setX(1);
		ponto.setY(1);
		double raio = 15.5;

		double area = 0.0;
		double perimetro = 0.0;
		area = circulo.areaRetangulo(ponto, raio);
		perimetro = circulo.perimetroRetangulo(ponto, raio);
		
		System.out.printf("A área do circulo = %.2f\n",  area);
		System.out.printf("O perímetro do circulo = %.2f\n", perimetro);
	}

	public static void triangulo(){
	}
}
