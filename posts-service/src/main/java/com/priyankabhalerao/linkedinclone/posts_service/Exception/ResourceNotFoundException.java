package com.priyankabhalerao.linkedinclone.posts_service.Exception;

import org.springframework.context.annotation.Configuration;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg)
    {
        super(msg);
    }
}
