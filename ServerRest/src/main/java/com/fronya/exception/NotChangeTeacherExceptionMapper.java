package com.fronya.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class NotChangeTeacherExceptionMapper implements ExceptionMapper<NotChangeTeacherException>{

    @Override
    public Response toResponse(NotChangeTeacherException e) {
        return Response.status(Response.Status.NOT_MODIFIED)
                .header("Content-Type", "application/json")
                .entity(e.getMessage()).build();
    }
}
