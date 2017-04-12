package com.fronya.rest;

import com.fronya.exception.NotChangeTeacherException;
import com.fronya.model.Teacher;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("teachers")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_JSON)
public interface RestTeacherService {

    @GET
    List<Teacher> getAllTeachers();

    @GET
    @Path("/{id}")
    Teacher getTeacher(@PathParam("id") int id);

    @POST
    void addTeacher(Teacher newTeacher);

    @PUT
    @Path("/{id}")
    void updateTeacher(@PathParam("id") int id, Teacher updateTeacher) throws NotChangeTeacherException;

    @DELETE
    @Path("/{id}")
    void deleteTeacher(@PathParam("id") int id);

    @GET
    @Path("/busiest")
    Teacher getBusiestTeacher();
}
