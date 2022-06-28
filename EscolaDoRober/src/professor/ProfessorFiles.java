package professor;
import filePath.PathFilesTxt;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ProfessorFiles {

        static ArrayList<Professor> professores = new ArrayList<Professor>();
    static Path path = Paths.get( PathFilesTxt.pathFilesTxt + "professores.txt");

    public static ArrayList<Professor> readProfessor() throws IOException {
        List<String> linhas = Files.readAllLines(path);
        int i = 0;
        String linha;
        String[] valorComSplit;

        while( i < (linhas.size())) {
            linha = linhas.get(i);
            valorComSplit = linha.split("-");
            professores.add(new Professor(Integer.parseInt(valorComSplit[0]),
                                                           valorComSplit[1],
                                                           valorComSplit[2],
                                                           valorComSplit[3],
                                                           valorComSplit[4]));
            i++;
        }
        return professores;
    }

    public static void gravaProfessor(ArrayList<Professor> professores) throws IOException {
        FileWriter myWriter = new FileWriter(String.valueOf(path));

        for (int i = 0; i < professores.size(); i++) {
            myWriter.write(professores.get(i).getMatricula() + "-" +
                       professores.get(i).getNome() + "-" +
                       professores.get(i).getEndereco() + "-" +
                       professores.get(i).getSetor() + "-" +
                       professores.get(i).getData() + "\n");

        }
        myWriter.close();
    }
}

