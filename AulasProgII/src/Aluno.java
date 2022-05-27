
public class Aluno extends Pessoa {

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", curso=" + curso + ", nome="
				+ nome + ", sexo=" + sexo + ", idade=" + idade + "]";
	}
	int matricula;
	String curso;

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
}
