package br.com.caelum.delfos.graphs.searches;

import br.com.caelum.delfos.graphs.infra.GraphFileReader;
import br.com.caelum.delfos.graphs.infra.GraphFileReaderFactory;
import br.com.caelum.delfos.graphs.infra.StringsFile;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultSearchTest {

    private GraphFileReader reader;
    private Integer from;
    private Integer to;
    private LinkedList<Integer> path;

    void setUp() {
        reader = GraphFileReaderFactory.from(StringsFile.DEFAULT_DATA_FILE);
        from = 605;
        to = 289;
    }

    void tearDown(String search) {
        System.out.println("Found path in " + search + " search: " + path);
    }

    void shouldTakeThePathOfADefaultGraphWhenTwoVertexAreSet(GraphSearch<Integer> searcher) {

        path = searcher.findPath(from, to);

        assertNotNull(path);

        Integer first = path.getFirst();
        assertEquals(from, first);

        Integer last = path.getLast();
        assertEquals(to, last);

        System.out.print("Default Graph: ");

    }

    void shouldTakeThePathOfAWeightedGraphWhenTwoVertexAreSet(GraphSearch<Integer> searcher) {

        path = searcher.findPath(from, to);

        assertNotNull(path);

        Integer first = path.getFirst();
        assertEquals(from, first);

        Integer last = path.getLast();
        assertEquals(to, last);

        System.out.print("Weighted Graph: ");
    }

    public GraphFileReader getReader() {
        return reader;
    }
}