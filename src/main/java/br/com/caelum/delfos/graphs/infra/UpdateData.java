package br.com.caelum.delfos.graphs.infra;

import br.com.caelum.delfos.graphs.mappers.OldCoursesToNewCousesMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class UpdateData extends FileReader {

    private final Scanner scanner;
    private OldCoursesToNewCousesMapper oldToNewMapper = new OldCoursesToNewCousesMapper();
    private File file;

    public UpdateData(String file) {
        super(file);
        scanner = super.getScanner();
    }

        public File createFile()  {
        file = new File(StringsFile.DATA_FILE_ALTERED);
        try {
            FileWriter fileWriter = new FileWriter(this.file);
            BufferedWriter out = new BufferedWriter(fileWriter);
            while (scanner.hasNext()) {
                String line = scanner.next();

                String[] destinations = extractDestinations(line);

                for (int i = 0; i < destinations.length; i++) {
                    Integer bla = Integer.parseInt(destinations[i]);
                    Integer blabs = oldToNewMapper.getRelativeCourse(bla);
                    String dest = destinations[i].replace(destinations[i], blabs.toString());
                    out.write(dest + " ");
                    out.flush();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.file;
    }

}
