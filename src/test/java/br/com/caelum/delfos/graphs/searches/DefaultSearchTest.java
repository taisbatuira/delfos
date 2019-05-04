package br.com.caelum.delfos.graphs.searches;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DefaultSearchTest {

    private Integer from;
    private Integer to;
    private LinkedList<Integer> path;

    void setUp() {
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
}