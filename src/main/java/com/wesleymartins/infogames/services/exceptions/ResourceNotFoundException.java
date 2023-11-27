package com.wesleymartins.infogames.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException (String msg){
        super(msg);
    }
}
