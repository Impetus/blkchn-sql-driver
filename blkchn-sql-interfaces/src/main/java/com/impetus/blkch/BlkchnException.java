package com.impetus.blkch;


public class BlkchnException extends RuntimeException {

    private static final long serialVersionUID = -5744699391802604922L;
    
    public BlkchnException(){
        super();
    }
    
    public BlkchnException(Throwable e) {
        super(e);
    }
    
    public BlkchnException(String message) {
        super(message);
    }
    
    public BlkchnException(String msg, Throwable e){
        super(msg, e);
    }

}
