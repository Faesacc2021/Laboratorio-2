package classes;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		iniciar();
	}
	
	public static void iniciar(){
		Circulo circulo = new Circulo();
		Ponto ponto = new Ponto();
		ponto.setX(55.5);
		ponto.setY(66.6);
		circulo.setPonto(ponto);
		circulo.setRaio(44.4);
		System.out.println(circulo.toString());
	}
}
