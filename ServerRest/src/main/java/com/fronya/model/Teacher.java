package com.fronya.model;


import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.*;
import java.util.Calendar;
import java.util.List;

@XmlRootElement(name="Teacher")
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher {
    @XmlAttribute(name = "id")
    private int id;
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "birthday")
    private Calendar birthday;

    @XmlElementWrapper(name = "lessons")
    @XmlElement(name = "lesson")
    private List<Lesson> lessons;

    public Teacher() {
    }

    public Teacher(int id, String name, Calendar birthday, List<Lesson> lessons) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.lessons = lessons;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @JsonIgnore
    public int getAllDuration(){
        int sum = 0;
        for(Lesson lesson: lessons){
            sum += lesson.getDuration();
        }
        return sum;
    }
}
