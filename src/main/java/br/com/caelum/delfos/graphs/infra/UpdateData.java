package br.com.caelum.delfos.graphs.infra;

import br.com.caelum.delfos.graphs.mappers.OldCoursesToNewCousesMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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
                ArrayList<String> courses = new ArrayList<>();

                String[] destinations = extractDestinations(line);

                for (int i = 0; i < destinations.length; i++) {
                    Integer courseId = Integer.parseInt(destinations[i]);
                    Integer updatedCourseId = oldToNewMapper.getRelativeCourse(courseId);
                    courses.add(destinations[i].replace(destinations[i], updatedCourseId.toString()));
                }
                out.write(String.join(" ", courses) + "\n");
                out.flush();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return this.file;
    }
}
