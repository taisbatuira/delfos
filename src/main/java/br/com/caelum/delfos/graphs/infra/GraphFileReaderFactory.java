package br.com.caelum.delfos.graphs.infra;

import java.io.File;

public class GraphFileReaderFactory {

    public static GraphFileReader from(String file) {
        File newFile = new UpdateData(file).createFile();
        return new GraphFileReader(newFile.getPath());
    }
}
