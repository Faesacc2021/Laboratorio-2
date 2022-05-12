package classes;

public class Retangulo {
	Ponto ponto;
	double base;
	double altura;
	
	private double getBase() {
		return base;
	}
	private void setBase(double base) {
		this.base = base;
	}
	private double getAltura() {
		return altura;
	}
	private void setAltura(double altura) {
		this.altura = altura;
	}
	public Ponto getPonto() {
		return ponto;
	}
	public void setPonto(Ponto ponto) {
		this.ponto = ponto;
	}
	@Override
	public String toString() {
		return "Retangulo [ponto=" + ponto + ", base=" + base + ", altura="
				+ altura + "]";
	}
}
