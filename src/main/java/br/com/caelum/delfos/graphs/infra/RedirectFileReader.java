package br.com.caelum.delfos.graphs.infra;

import java.util.*;

public class RedirectFileReader extends FileReader {

    private final Map<Integer, Integer> courses = new HashMap<>();

    public RedirectFileReader(String file) {
        super(file);
    }

    public Map<Integer, Integer> arquivoDePara() {
        Scanner scanner = getScanner();

        while (scanner.hasNext()) {
            String line = scanner.next();
            String[] destinations = extractDestinations(line);
            getLinks(destinations);
        }
        return courses;
    }

    private void getLinks(String... destinations) {
        for(int i = 0; i < destinations.length - 1; i++) {
            Integer from = Integer.parseInt(destinations[i]);
            Integer to = Integer.parseInt(destinations[i + 1]);

            courses.put(from,to);
        }
    }

}
