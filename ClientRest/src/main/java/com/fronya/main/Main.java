package com.fronya.main;


import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.fronya.model.Lesson;
import com.fronya.model.Teacher;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.util.*;

public class Main {
    private static String endpointUrl = "http://localhost:8080/rservice";

    public static void main(String[] args) {
        System.out.println("All teachers:");
        getAll();
        System.out.println("Get teacher (id = 2)");
        Teacher oldTeacher = get(1);

        Teacher newTeacher = new Teacher(1, "Pol", getCalendar(2, 2, 1994), new ArrayList<Lesson>(){{
            add(new Lesson(3, "english", 30));
            add(new Lesson(4, "french", 45));
        }});

        create(newTeacher);
        System.out.println("All teachers after create:");
        getAll();

        oldTeacher.setName("UpdateName");
        update(oldTeacher, oldTeacher.getId());
        System.out.println("All teachers after update name:");
        getAll();

        System.out.println("Update lessons:");
        oldTeacher.setLessons(new ArrayList<Lesson>(){{
            add(new Lesson(1, "math", -50));
        }});
        update(oldTeacher, oldTeacher.getId());

        System.out.println("Busiest teacher:");
        getBusiestTeacher();

        delete(1);
        System.out.println("All teachers after delete teacher (id  = 1):");
        getAll();
    }

    private static void getAll(){
        Collection<? extends Teacher> teachers = WebClient.create(endpointUrl).path("teachers").getCollection(Teacher.class);

        for (Teacher t: teachers) {
            System.out.println(t);
        }
    }

    private static Teacher get(int id){
        Teacher teacher = WebClient.create(endpointUrl).path("/teachers/" + id)
                .accept("application/xml").get(Teacher.class);

        System.out.println(teacher);
        return teacher;
    }

    private static boolean create(Teacher teacher){
        WebClient client = WebClient
                .create(endpointUrl, Collections.singletonList(new JacksonJsonProvider()))
                .path("teachers").type("application/json");
        Response response = client.post(teacher);
        return response.getStatus() == 204;
    }

    private static boolean update(Teacher teacher, int id){
        WebClient client = WebClient
                .create(endpointUrl, Collections.singletonList(new JacksonJsonProvider()))
                .path("teachers/" + id).type("application/json");
        Response response = client.put(teacher);
        if(response.getStatus() == 204){
            return true;
        }else{
            System.out.println("Error! Status: " + response.getStatus() + "\n");
            return false;
        }
    }

    private static void getBusiestTeacher(){
        Teacher busiestTeacher = WebClient.create(endpointUrl).path("/teachers/busiest")
                .accept("application/xml").get(Teacher.class);

        System.out.println(busiestTeacher);
    }

    private static void delete(int id){
        WebClient client = WebClient.create(endpointUrl).path("/teachers/" + id)
                .accept("application/xml");
        client.delete();
    }

    private static Calendar getCalendar(int day, int month, int year){
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_MONTH, day);
        date.set(Calendar.MONTH, month);
        date.set(Calendar.YEAR, year);
        return date;
    }
}
