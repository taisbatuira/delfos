package br.com.caelum.delfos.graphs.mappers;

import java.util.HashMap;
import java.util.Map;

public class OldCoursesToNewCousesMapper {

    private static final Map<Integer, Integer> courses = new HashMap<Integer, Integer>() {{
        put(49, 605);
        put(126, 612);
        put(127, 850);
        put(30, 853);
        put(32, 853);
        put(44, 891);
        put(45, 891 );
        put(39, 174);
        put(71, 440);
        put(165, 289);

    }};

    private OldCoursesToNewCousesMapper() { }

    public static Integer getRelativeCourse(Integer courseId) {
        return courses.getOrDefault(courseId, courseId);
    }
}
