package com.fronya.rest;


import com.fronya.exception.NotChangeTeacherException;
import com.fronya.model.Lesson;
import com.fronya.model.Teacher;
import com.fronya.service.TeacherService;

import java.util.List;

public class RestTeacherServiceImpl implements RestTeacherService{
    public List<Teacher> getAllTeachers() {
        return TeacherService.getInstance().getAll();
    }

    public Teacher getTeacher(int id) {
        return TeacherService.getInstance().get(id);
    }

    public void addTeacher(Teacher newTeacher) {
        TeacherService.getInstance().create(newTeacher);
    }

    public void updateTeacher(int id, Teacher updateTeacher) throws NotChangeTeacherException {
        for(Lesson l: updateTeacher.getLessons()){
            if(l.getDuration() <= 0){
                throw new NotChangeTeacherException();
            }
        }
        TeacherService.getInstance().update(id, updateTeacher);
    }

    public void deleteTeacher(int id) {
        TeacherService.getInstance().delete(id);
    }

    public Teacher getBusiestTeacher() {
        return TeacherService.getInstance().getBusiestTeacher();
    }
}
