package com.fronya.service;


import com.fronya.model.Lesson;
import com.fronya.model.Teacher;

import java.util.*;

public class TeacherService {
    private static TeacherService instance;
    private Map<Integer, Teacher> teachers;
    private int nextId = 0;

    private TeacherService(){}

    public static TeacherService getInstance() {
        if(instance == null){
            instance = new TeacherService();
            instance.init();
        }
        return instance;
    }

    public List<Teacher> getAll(){
        List<Teacher> teacherList = new ArrayList<>(teachers.values());
        return teacherList;
    }

    public Teacher get(int id){
        return teachers.get(id);
    }

    public void create(Teacher newTeacher){
        newTeacher.setId(nextId);
        teachers.put(nextId, newTeacher);
        nextId++;
    }

    public void update(int id, Teacher newTeacher){
        teachers.put(id, newTeacher);
    }

    public void delete(int id){
        teachers.remove(id);
    }

    public Teacher getBusiestTeacher(){
        int maxDuration = 0;
        Teacher busiestTeacher = null;

        for (Teacher teacher: teachers.values()) {
            if(maxDuration <= teacher.getAllDuration()){
                maxDuration = teacher.getAllDuration();
                busiestTeacher = teacher;
            }
        }
        return busiestTeacher;
    }


    private void init(){
        Lesson math = new Lesson(1, "math", 45);
        Lesson history = new Lesson(2, "history", 30);
        Lesson english = new Lesson(3, "english", 40);
        Lesson biology = new Lesson(4, "biology", 45);
        Lesson chemistry = new Lesson(5, "chemistry", 40);

        teachers = new HashMap<>();
        Teacher teacherAnn = new Teacher(nextId, "Ann", getCalendar(5, 2, 1991), new ArrayList<Lesson>(){{
            add(math);
            add(chemistry);
        }});
        teachers.put(nextId, teacherAnn);
        nextId++;

        Teacher teacherAndy = new Teacher(nextId, "Andy", getCalendar(22, 9, 1992), new ArrayList<Lesson>(){{
            add(history);
            add(english);
        }});
        teachers.put(nextId, teacherAndy);
        nextId++;

        Teacher teacherMax = new Teacher(nextId, "Max", getCalendar(21, 3, 1990), new ArrayList<Lesson>(){{
            add(biology);
            add(chemistry);
        }});
        teachers.put(nextId, teacherMax);
        nextId++;
    }

    private Calendar getCalendar(int day, int month, int year){
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_MONTH, day);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.YEAR, year);
        return date;
    }
}
