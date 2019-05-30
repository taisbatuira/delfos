package br.com.caelum.delfos.graphs.infra;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public abstract class FileReader {

    private final Scanner scanner;

    public FileReader(String file) {
        Path path = Paths.get(file);
        try {
            scanner = new Scanner(path);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + path, e);
        }
        scanner.useDelimiter("(\\s)?](\n)?");
    }

    public String[] extractDestinations(String line) {
        return line.replaceAll("(\\[\\s*|\\[\\d)|(\\n?])", "")
                .replaceAll("(\\s+)|(\\n\\s?)", " ")
                .replaceAll("\\s{2,}", " ")
                .split(" ");
    }

    public Scanner getScanner() {
        return scanner;
    }
}
