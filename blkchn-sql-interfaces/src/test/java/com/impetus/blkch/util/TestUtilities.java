package com.impetus.blkch.util;

import org.junit.Test;

public class TestUtilities {

    @Test
    public void testUnquoteFunction(){
        String expectedOutput = "test String";
        String result = Utilities.unquote("\"test String\"");
        assert(expectedOutput.equals(result));
    }
}
