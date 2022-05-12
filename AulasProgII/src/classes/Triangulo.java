package classes;

public class Triangulo {
	Ponto pontoUm;
	Ponto pontoDois;
	Ponto pontoTres;
	double base;
	double altura;
	
	public Ponto getPontoUm() {
		return pontoUm;
	}
	public void setPontoUm(Ponto pontoUm) {
		this.pontoUm = pontoUm;
	}
	public Ponto getPontoDois() {
		return pontoDois;
	}
	public void setPontoDois(Ponto pontoDois) {
		this.pontoDois = pontoDois;
	}
	public Ponto getPontoTres() {
		return pontoTres;
	}
	public void setPontoTres(Ponto pontoTres) {
		this.pontoTres = pontoTres;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	@Override
	public String toString() {
		return "Triangulo [pontoUm=" + pontoUm + ", pontoDois=" + pontoDois
				+ ", pontoTres=" + pontoTres + ", base=" + base + ", altura="
				+ altura + "]";
	}
}
