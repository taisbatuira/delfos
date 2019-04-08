package br.com.caelum.delfos.graphs;

import java.util.LinkedList;

public class Vertex {

    private Integer courseId;

    public Vertex(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseId() {
        return courseId;
    }
}
