package com.fronya.exception;


public class NotChangeTeacherException extends Exception {
    public NotChangeTeacherException(){
        super("Can't update duration.");
    }
}
