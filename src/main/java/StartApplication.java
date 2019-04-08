import br.com.caelum.delfos.graphs.GraphDTO;
import br.com.caelum.delfos.graphs.infra.GraphFileReader;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartApplication {

    public static void main(String[] args) {
        try {
            GraphDTO graphDTO = new GraphFileReader("data/sample.txt").read();
            File imgFile = new File("data//graph.png");
            imgFile.createNewFile();

            Graph<Integer, DefaultWeightedEdge> graph = graphDTO.getGraph();

            System.out.println(graph);

//            JGraphXAdapter<String, DefaultWeightedEdge> graphAdapter =
//                    new JGraphXAdapter<String, DefaultWeightedEdge>(graph);
//            mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
//            layout.execute(graphAdapter.getDefaultParent());
//
//            BufferedImage image =
//                    mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
//            File img = new File("src/test/resources/graph.png");
//            ImageIO.write(image, "PNG", img);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
