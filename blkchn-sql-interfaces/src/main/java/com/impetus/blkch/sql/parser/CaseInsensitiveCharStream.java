package com.impetus.blkch.sql.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.IntStream;

public class CaseInsensitiveCharStream extends ANTLRInputStream{
	
	public CaseInsensitiveCharStream(String input) {
		super(input);
	}
	
	public int LA(int i){
		int res = super.LA(i);
		if(res == 0 || res == IntStream.EOF){
			return res;
		}else{
			return Character.toUpperCase(res);
		}
	}
}
