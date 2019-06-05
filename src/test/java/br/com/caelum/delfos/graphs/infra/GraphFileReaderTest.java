package br.com.caelum.delfos.graphs.infra;


import br.com.caelum.delfos.graphs.DefaultGraph;
import br.com.caelum.delfos.graphs.WeightedGraph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


class GraphFileReaderTest {

    private static GraphFileReader reader;


    @BeforeAll
    static void setup() {
        reader = GraphFileReaderFactory.from(StringsFile.DEFAULT_DATA_FILE);
    }

    @Test
    void shouldCreateADefaultGraph() {
        DefaultGraph graph = reader.readDefaultGraph();

        assertNotNull(graph);
    }

    @Test
    void shouldCreateAWeightedGraph() {
        WeightedGraph graph = reader.readWeightedGraph();

        assertNotNull(graph);
    }

    @Test
    void shouldParseFile() {
        String[] strings = reader.extractDestinations("[       49     126          127        289       ]\n");
        String[] expected = {"49", "126", "127", "289"};
        assertArrayEquals(expected, strings);
    }
}
