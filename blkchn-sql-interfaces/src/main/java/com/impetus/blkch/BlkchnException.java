package com.impetus.blkch;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class BlkchnException extends RuntimeException {

    private static final long serialVersionUID = -5744699391802604922L;
    
    private String userMsg;
    
    public BlkchnException(Throwable e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        userMsg = sw.toString();
        try {
            sw.close();
        } catch (IOException e1) {
            //IGNORE
        }
    }
    
    public BlkchnException(String message) {
        this.userMsg = message;
    }
    
    @Override
    public String getMessage() {
        return userMsg;
    }

}
