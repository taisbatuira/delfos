package br.com.caelum.delfos.graphs.mappers;

import br.com.caelum.delfos.graphs.infra.RedirectFileReader;
import br.com.caelum.delfos.graphs.infra.StringsFile;

import java.util.Map;


public class OldCoursesToNewCousesMapper {

    private Map<Integer, Integer> courses;
    private RedirectFileReader reader;

    public OldCoursesToNewCousesMapper() {
        reader = new RedirectFileReader(StringsFile.REDIRECTED_COURSES_FILE);
    }

    public Integer getRelativeCourse(Integer courseId) {
        courses = reader.arquivoDePara();
        return courses.getOrDefault(courseId, courseId);
    }
}
