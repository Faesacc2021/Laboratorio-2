import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AlteraArquivoTexto {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("/Users/742166/Faesa/AlteraArquivoTexto/professores.txt");
		List<String> linhas = Files.readAllLines(path);
		String linha, novoConteudo;
		String[] valorComSplit;
		int i=0, matricula=2;
		boolean achou=false;
		int numLinhas=linhas.size();

		while(i<numLinhas && !achou)
		{
			linha = linhas.get(i);
			valorComSplit = linha.split("-");
			if(Integer.parseInt(valorComSplit[0])==matricula) {
				novoConteudo = valorComSplit[0]+"-Franz-"+valorComSplit[2]+"-"+valorComSplit[3]+"-"+valorComSplit[4];
				linhas.remove(i);
				linhas.add(i, novoConteudo);
				System.out.println("Professor passando com sucesso!");
				achou=true;
			}
			i++;
		}

		Files.write(path, linhas);
	}
}