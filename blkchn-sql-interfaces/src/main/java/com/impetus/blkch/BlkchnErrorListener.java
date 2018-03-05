package com.impetus.blkch;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class BlkchnErrorListener extends BaseErrorListener {
    
    public static final BlkchnErrorListener INSTANCE = new BlkchnErrorListener();
    
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
            String msg, RecognitionException e) {
        throw new BlkchnException("line " + line + ":" + charPositionInLine + " " + msg, e);
    }

}
