package com.impetus.blkch.sql.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.*;

import com.impetus.blkch.sql.generated.SqlBaseLexer;
import com.impetus.blkch.sql.generated.SqlBaseListener;
import com.impetus.blkch.sql.generated.SqlBaseParser;


public class SqlBaseListenerGethImplTest {

	@BeforeClass
	public static void runOnceBeforeClass() {
	}

	@AfterClass
	public static void runOnceAfterClass() {
	}

	@Before
	public void runBeforeTestMethod() {
	}

	@After
	public void runAfterTestMethod() {
	}

	@Test
	public void test_nona_tracer() {
		CharStream input = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("sql/input.sql").getFile());
		try {
			input = new ANTLRInputStream(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlBaseLexer lexer = new SqlBaseLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokens);
        ParseTree tree = parser.singleStatement(); 

        ParseTreeWalker walker = new ParseTreeWalker(); 
        SqlBaseListener extractor = new SqlBaseListenerGethImpl(parser);
        walker.walk(extractor, tree); 
	}

}
