package classes;

public class Circulo {
   Ponto ponto;
   double raio;
   
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}

	public Ponto getPonto() {
		return ponto;
	}
	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	@Override
	public String toString() {
		return "Circulo [ponto=" + ponto + ", raio=" + raio + "]";
	}
	
	public static double areaRetangulo(Ponto ponto, double raio){
		double area = Math.PI * (raio * raio);
		return area;
	}
	
	public static double perimetroRetangulo(Ponto ponto, double raio){
		double perimetro = 2 * Math.PI *  raio; 
		return perimetro;
	}
}
