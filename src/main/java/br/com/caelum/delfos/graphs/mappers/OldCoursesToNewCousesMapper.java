package br.com.caelum.delfos.graphs.mappers;

import br.com.caelum.delfos.graphs.infra.RedirectFileReader;

import java.util.Map;


public class OldCoursesToNewCousesMapper {

    private Map<Integer, Integer> courses;
    private RedirectFileReader reader;

    public OldCoursesToNewCousesMapper() {
        reader = new RedirectFileReader("data/redirected_courses.txt");
    }

    public Integer getRelativeCourse(Integer courseId) {
        courses = reader.arquivoDePara();
        return courses.getOrDefault(courseId, courseId);
    }
}
