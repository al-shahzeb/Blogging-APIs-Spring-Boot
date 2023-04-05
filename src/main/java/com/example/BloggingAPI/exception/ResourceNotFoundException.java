package com.example.BloggingAPI.exception;

public class ResourceNotFoundException extends RuntimeException{
    private String resourse;
    private String field;
    private long value;


    public ResourceNotFoundException(String resourse, String field, long value){
        super(String.format("%s not found with %s : %s",resourse,field,value));
        this.resourse=resourse;
        this.field=field;
        this.value=value;
    }

    public String getResourse() {
        return resourse;
    }

    public void setResourse(String resourse) {
        this.resourse = resourse;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
