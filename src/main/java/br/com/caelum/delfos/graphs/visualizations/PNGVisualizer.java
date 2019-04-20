package br.com.caelum.delfos.graphs.visualizations;

import br.com.caelum.delfos.graphs.Graph;
import br.com.caelum.delfos.graphs.exceptions.GraphExportException;
import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import org.jgrapht.ext.JGraphXAdapter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PNGVisualizer<V, E> {


    public boolean export(Graph<V, E> graph, String path) {

        JGraphXAdapter<V, E> adapter = new JGraphXAdapter<>(graph.getGraphT());

        mxIGraphLayout layout = new mxCircleLayout(adapter);
        layout.execute(adapter.getDefaultParent());

        BufferedImage image =
                mxCellRenderer.createBufferedImage(adapter, null, 2, Color.WHITE, true, null);

        File imgFile = new File(path);

        try {
            ImageIO.write(image, "PNG", imgFile);
        } catch (IOException e) {
            throw new GraphExportException("Could not export graph to " + path, e);
        }

        return imgFile.exists();
    }
}
