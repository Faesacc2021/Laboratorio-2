
public class Pauta {

	public Pauta(int matricula, String nomeAlulno, int numFalta, double nota1,
			double nota2) {
		super();
		this.matricula = matricula;
		this.nomeAlulno = nomeAlulno;
		this.numFalta = numFalta;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	int matricula;
	String nomeAlulno;
	int	numFalta;
	double	nota1; 
	double	nota2;
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNomeAlulno() {
		return nomeAlulno;
	}
	public void setNomeAlulno(String nomeAlulno) {
		this.nomeAlulno = nomeAlulno;
	}
	public int getNumFalta() {
		return numFalta;
	}
	public void setNumFalta(int numFalta) {
		this.numFalta = numFalta;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		if(nota1 >= 0 && nota1 <= 10) {
		   this.nota1 = nota1;
		}
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		if(nota2 >= 0 && nota2 <= 10) {
			   this.nota2 = nota2;
		}
	}
	
	@Override
	public String toString() {
		return "Pauta [matricula=" + matricula + ", nomeAlulno=" + nomeAlulno
				+ ", numFalta=" + numFalta + ", nota1=" + nota1 + ", nota2="
				+ nota2 + "]";
	}	
}
