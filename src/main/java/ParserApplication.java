import model.Person;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class ParserApplication {

    private File outputFile;
    private File inputFile;

    void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    void parse() {
        getFileSetFromInputFile()
                .forEach(file -> {
                    Parser parser = new CsvParser();
                    parser.linkWith(new XMLParser())
                            .linkWith(new JsonParser())
                            .linkWith(new TxtParser()); //chain of repository
                    printToOutputFile(parser.parse(file));
                });
    }


    private Set<File> getFileSetFromInputFile() {
        Set<File> files = new LinkedHashSet<>();
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                files.add(new File(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    private void printToOutputFile(List<Person> personList) {
        try (FileWriter fw = new FileWriter(outputFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
