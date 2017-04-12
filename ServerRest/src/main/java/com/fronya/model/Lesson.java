package com.fronya.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Lesson")
public class Lesson {
    @XmlAttribute(name = "id")
    private int id;
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "duration")
    private int duration;

    public Lesson() {
    }

    public Lesson(int id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
