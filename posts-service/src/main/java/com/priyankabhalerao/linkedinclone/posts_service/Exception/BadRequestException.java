package com.priyankabhalerao.linkedinclone.posts_service.Exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String msg)
    {
        super(msg);
    }
}
