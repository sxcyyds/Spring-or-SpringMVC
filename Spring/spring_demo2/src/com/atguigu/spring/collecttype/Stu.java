package com.atguigu.spring.collecttype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
//   1、 数组类型的属性
    private String[] course;
//   2、list集合类型属性
    private List<String> list;
//   3、 map集合类型属性
    private Map<String,String> map;
//   4、set集合类型属性
    private Set<String> sets;

//    学生所学的多门课程
    private List<Course> courseslist;

    public void setCourseslist(List<Course> courseslist) {
        this.courseslist = courseslist;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }


}
