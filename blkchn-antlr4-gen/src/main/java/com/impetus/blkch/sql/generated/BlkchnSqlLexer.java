// Generated from BlkchnSql.g4 by ANTLR 4.5
package com.impetus.blkch.sql.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BlkchnSqlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, SELECT=8, FROM=9, 
		ADD=10, AS=11, ALL=12, DISTINCT=13, WHERE=14, GROUP=15, BY=16, GROUPING=17, 
		SETS=18, CUBE=19, ROLLUP=20, ORDER=21, HAVING=22, LIMIT=23, AT=24, OR=25, 
		AND=26, IN=27, NOT=28, NO=29, EXISTS=30, BETWEEN=31, LIKE=32, RLIKE=33, 
		IS=34, NULL=35, TRUE=36, FALSE=37, NULLS=38, ASC=39, DESC=40, FOR=41, 
		INTERVAL=42, CASE=43, WHEN=44, THEN=45, ELSE=46, END=47, JOIN=48, CROSS=49, 
		OUTER=50, INNER=51, LEFT=52, SEMI=53, RIGHT=54, FULL=55, NATURAL=56, ON=57, 
		FIRST=58, AFTER=59, LAST=60, VALUES=61, CREATE=62, TABLE=63, VIEW=64, 
		REPLACE=65, INSERT=66, DELETE=67, INTO=68, DESCRIBE=69, EXPLAIN=70, CAST=71, 
		SHOW=72, TABLES=73, COLUMNS=74, COLUMN=75, USE=76, FUNCTIONS=77, DROP=78, 
		UNION=79, EXCEPT=80, SETMINUS=81, INTERSECT=82, TO=83, ALTER=84, RENAME=85, 
		ARRAY=86, MAP=87, STRUCT=88, COMMENT=89, SET=90, RESET=91, COMMIT=92, 
		ROLLBACK=93, IGNORE=94, IF=95, EQ=96, NSEQ=97, NEQ=98, NEQJ=99, LT=100, 
		LTE=101, GT=102, GTE=103, PLUS=104, MINUS=105, ASTERISK=106, SLASH=107, 
		PERCENT=108, DIV=109, TILDE=110, AMPERSAND=111, PIPE=112, HAT=113, PERCENTLIT=114, 
		OUT=115, OF=116, FUNCTION=117, DATABASE=118, DATABASES=119, TRUNCATE=120, 
		ANALYZE=121, COMPUTE=122, LIST=123, REVOKE=124, GRANT=125, EXPORT=126, 
		IMPORT=127, LOAD=128, ROLE=129, ROLES=130, INDEX=131, INDEXES=132, CURRENT_DATE=133, 
		CURRENT_TIMESTAMP=134, STRING=135, BIGINT_LITERAL=136, SMALLINT_LITERAL=137, 
		TINYINT_LITERAL=138, BYTELENGTH_LITERAL=139, INTEGER_VALUE=140, DECIMAL_VALUE=141, 
		DOUBLE_LITERAL=142, BIGDECIMAL_LITERAL=143, IDENTIFIER=144, BACKQUOTED_IDENTIFIER=145, 
		SIMPLE_COMMENT=146, BRACKETED_EMPTY_COMMENT=147, BRACKETED_COMMENT=148, 
		WS=149, UNRECOGNIZED=150;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "SELECT", "FROM", 
		"ADD", "AS", "ALL", "DISTINCT", "WHERE", "GROUP", "BY", "GROUPING", "SETS", 
		"CUBE", "ROLLUP", "ORDER", "HAVING", "LIMIT", "AT", "OR", "AND", "IN", 
		"NOT", "NO", "EXISTS", "BETWEEN", "LIKE", "RLIKE", "IS", "NULL", "TRUE", 
		"FALSE", "NULLS", "ASC", "DESC", "FOR", "INTERVAL", "CASE", "WHEN", "THEN", 
		"ELSE", "END", "JOIN", "CROSS", "OUTER", "INNER", "LEFT", "SEMI", "RIGHT", 
		"FULL", "NATURAL", "ON", "FIRST", "AFTER", "LAST", "VALUES", "CREATE", 
		"TABLE", "VIEW", "REPLACE", "INSERT", "DELETE", "INTO", "DESCRIBE", "EXPLAIN", 
		"CAST", "SHOW", "TABLES", "COLUMNS", "COLUMN", "USE", "FUNCTIONS", "DROP", 
		"UNION", "EXCEPT", "SETMINUS", "INTERSECT", "TO", "ALTER", "RENAME", "ARRAY", 
		"MAP", "STRUCT", "COMMENT", "SET", "RESET", "COMMIT", "ROLLBACK", "IGNORE", 
		"IF", "EQ", "NSEQ", "NEQ", "NEQJ", "LT", "LTE", "GT", "GTE", "PLUS", "MINUS", 
		"ASTERISK", "SLASH", "PERCENT", "DIV", "TILDE", "AMPERSAND", "PIPE", "HAT", 
		"PERCENTLIT", "OUT", "OF", "FUNCTION", "DATABASE", "DATABASES", "TRUNCATE", 
		"ANALYZE", "COMPUTE", "LIST", "REVOKE", "GRANT", "EXPORT", "IMPORT", "LOAD", 
		"ROLE", "ROLES", "INDEX", "INDEXES", "CURRENT_DATE", "CURRENT_TIMESTAMP", 
		"STRING", "BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", "BYTELENGTH_LITERAL", 
		"INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", 
		"IDENTIFIER", "BACKQUOTED_IDENTIFIER", "DECIMAL_DIGITS", "EXPONENT", "DIGIT", 
		"LETTER", "SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", "BRACKETED_COMMENT", 
		"WS", "UNRECOGNIZED"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'('", "')'", "'.'", "'['", "']'", "':'", "'SELECT'", "'FROM'", 
		"'ADD'", "'AS'", "'ALL'", "'DISTINCT'", "'WHERE'", "'GROUP'", "'BY'", 
		"'GROUPING'", "'SETS'", "'CUBE'", "'ROLLUP'", "'ORDER'", "'HAVING'", "'LIMIT'", 
		"'AT'", "'OR'", "'AND'", "'IN'", null, "'NO'", "'EXISTS'", "'BETWEEN'", 
		"'LIKE'", null, "'IS'", "'NULL'", "'TRUE'", "'FALSE'", "'NULLS'", "'ASC'", 
		"'DESC'", "'FOR'", "'INTERVAL'", "'CASE'", "'WHEN'", "'THEN'", "'ELSE'", 
		"'END'", "'JOIN'", "'CROSS'", "'OUTER'", "'INNER'", "'LEFT'", "'SEMI'", 
		"'RIGHT'", "'FULL'", "'NATURAL'", "'ON'", "'FIRST'", "'AFTER'", "'LAST'", 
		"'VALUES'", "'CREATE'", "'TABLE'", "'VIEW'", "'REPLACE'", "'INSERT'", 
		"'DELETE'", "'INTO'", "'DESCRIBE'", "'EXPLAIN'", "'CAST'", "'SHOW'", "'TABLES'", 
		"'COLUMNS'", "'COLUMN'", "'USE'", "'FUNCTIONS'", "'DROP'", "'UNION'", 
		"'EXCEPT'", "'MINUS'", "'INTERSECT'", "'TO'", "'ALTER'", "'RENAME'", "'ARRAY'", 
		"'MAP'", "'STRUCT'", "'COMMENT'", "'SET'", "'RESET'", "'COMMIT'", "'ROLLBACK'", 
		"'IGNORE'", "'IF'", null, "'<=>'", "'<>'", "'!='", "'<'", null, "'>'", 
		null, "'+'", "'-'", "'*'", "'/'", "'%'", "'DIV'", "'~'", "'&'", "'|'", 
		"'^'", "'PERCENT'", "'OUT'", "'OF'", "'FUNCTION'", null, null, "'TRUNCATE'", 
		"'ANALYZE'", "'COMPUTE'", "'LIST'", "'REVOKE'", "'GRANT'", "'EXPORT'", 
		"'IMPORT'", "'LOAD'", "'ROLE'", "'ROLES'", "'INDEX'", "'INDEXES'", "'CURRENT_DATE'", 
		"'CURRENT_TIMESTAMP'", null, null, null, null, null, null, null, null, 
		null, null, null, null, "'/**/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "SELECT", "FROM", "ADD", 
		"AS", "ALL", "DISTINCT", "WHERE", "GROUP", "BY", "GROUPING", "SETS", "CUBE", 
		"ROLLUP", "ORDER", "HAVING", "LIMIT", "AT", "OR", "AND", "IN", "NOT", 
		"NO", "EXISTS", "BETWEEN", "LIKE", "RLIKE", "IS", "NULL", "TRUE", "FALSE", 
		"NULLS", "ASC", "DESC", "FOR", "INTERVAL", "CASE", "WHEN", "THEN", "ELSE", 
		"END", "JOIN", "CROSS", "OUTER", "INNER", "LEFT", "SEMI", "RIGHT", "FULL", 
		"NATURAL", "ON", "FIRST", "AFTER", "LAST", "VALUES", "CREATE", "TABLE", 
		"VIEW", "REPLACE", "INSERT", "DELETE", "INTO", "DESCRIBE", "EXPLAIN", 
		"CAST", "SHOW", "TABLES", "COLUMNS", "COLUMN", "USE", "FUNCTIONS", "DROP", 
		"UNION", "EXCEPT", "SETMINUS", "INTERSECT", "TO", "ALTER", "RENAME", "ARRAY", 
		"MAP", "STRUCT", "COMMENT", "SET", "RESET", "COMMIT", "ROLLBACK", "IGNORE", 
		"IF", "EQ", "NSEQ", "NEQ", "NEQJ", "LT", "LTE", "GT", "GTE", "PLUS", "MINUS", 
		"ASTERISK", "SLASH", "PERCENT", "DIV", "TILDE", "AMPERSAND", "PIPE", "HAT", 
		"PERCENTLIT", "OUT", "OF", "FUNCTION", "DATABASE", "DATABASES", "TRUNCATE", 
		"ANALYZE", "COMPUTE", "LIST", "REVOKE", "GRANT", "EXPORT", "IMPORT", "LOAD", 
		"ROLE", "ROLES", "INDEX", "INDEXES", "CURRENT_DATE", "CURRENT_TIMESTAMP", 
		"STRING", "BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", "BYTELENGTH_LITERAL", 
		"INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", 
		"IDENTIFIER", "BACKQUOTED_IDENTIFIER", "SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", 
		"BRACKETED_COMMENT", "WS", "UNRECOGNIZED"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	  /**
	   * Verify whether current token is a valid decimal token (which contains dot).
	   * Returns true if the character that follows the token is not a digit or letter or underscore.
	   *
	   * For example:
	   * For char stream "2.3", "2." is not a valid decimal token, because it is followed by digit '3'.
	   * For char stream "2.3_", "2.3" is not a valid decimal token, because it is followed by '_'.
	   * For char stream "2.3W", "2.3" is not a valid decimal token, because it is followed by 'W'.
	   * For char stream "12.0D 34.E2+0.12 "  12.0D is a valid decimal token because it is folllowed
	   * by a space. 34.E2 is a valid decimal token because it is followed by symbol '+'
	   * which is not a digit or letter or underscore.
	   */
	  public boolean isValidDecimal() {
	    int nextChar = _input.LA(1);
	    if (nextChar >= 'A' && nextChar <= 'Z' || nextChar >= '0' && nextChar <= '9' ||
	      nextChar == '_') {
	      return false;
	    } else {
	      return true;
	    }
	  }


	public BlkchnSqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BlkchnSql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 140:
			return DECIMAL_VALUE_sempred((RuleContext)_localctx, predIndex);
		case 141:
			return DOUBLE_LITERAL_sempred((RuleContext)_localctx, predIndex);
		case 142:
			return BIGDECIMAL_LITERAL_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean DECIMAL_VALUE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return isValidDecimal();
		}
		return true;
	}
	private boolean DOUBLE_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return isValidDecimal();
		}
		return true;
	}
	private boolean BIGDECIMAL_LITERAL_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return isValidDecimal();
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\u0098\u0500\b\1\4"+
		"\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n"+
		"\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4"+
		"I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\t"+
		"T\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_"+
		"\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k"+
		"\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv"+
		"\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t"+
		"\u0080\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084"+
		"\4\u0085\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089"+
		"\t\u0089\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d"+
		"\4\u008e\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092"+
		"\t\u0092\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096"+
		"\4\u0097\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b"+
		"\t\u009b\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u01b3\n\35\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01d7\n\"\3#\3#\3#\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3"+
		",\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3"+
		"\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\3"+
		"8\38\39\39\39\39\39\39\39\39\3:\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3"+
		"<\3<\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3@\3@\3"+
		"@\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3"+
		"C\3D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3F\3G\3"+
		"G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J\3"+
		"J\3K\3K\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3L\3L\3M\3M\3M\3M\3N\3N\3N\3"+
		"N\3N\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3"+
		"Q\3Q\3R\3R\3R\3R\3R\3R\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3T\3T\3T\3U\3U\3"+
		"U\3U\3U\3U\3V\3V\3V\3V\3V\3V\3V\3W\3W\3W\3W\3W\3W\3X\3X\3X\3X\3Y\3Y\3"+
		"Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3\\\3\\\3\\\3\\\3\\"+
		"\3\\\3]\3]\3]\3]\3]\3]\3]\3^\3^\3^\3^\3^\3^\3^\3^\3^\3_\3_\3_\3_\3_\3"+
		"_\3_\3`\3`\3`\3a\3a\3a\5a\u034d\na\3b\3b\3b\3b\3c\3c\3c\3d\3d\3d\3e\3"+
		"e\3f\3f\3f\3f\5f\u035f\nf\3g\3g\3h\3h\3h\3h\5h\u0367\nh\3i\3i\3j\3j\3"+
		"k\3k\3l\3l\3m\3m\3n\3n\3n\3n\3o\3o\3p\3p\3q\3q\3r\3r\3s\3s\3s\3s\3s\3"+
		"s\3s\3s\3t\3t\3t\3t\3u\3u\3u\3v\3v\3v\3v\3v\3v\3v\3v\3v\3w\3w\3w\3w\3"+
		"w\3w\3w\3w\3w\3w\3w\3w\3w\3w\5w\u03a5\nw\3x\3x\3x\3x\3x\3x\3x\3x\3x\3"+
		"x\3x\3x\3x\3x\3x\3x\5x\u03b7\nx\3y\3y\3y\3y\3y\3y\3y\3y\3y\3z\3z\3z\3"+
		"z\3z\3z\3z\3z\3{\3{\3{\3{\3{\3{\3{\3{\3|\3|\3|\3|\3|\3}\3}\3}\3}\3}\3"+
		"}\3}\3~\3~\3~\3~\3~\3~\3\177\3\177\3\177\3\177\3\177\3\177\3\177\3\u0080"+
		"\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081\3\u0081"+
		"\3\u0081\3\u0081\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0083\3\u0083"+
		"\3\u0083\3\u0083\3\u0083\3\u0083\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084"+
		"\3\u0084\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085"+
		"\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086"+
		"\3\u0086\3\u0086\3\u0086\3\u0086\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0088\7\u0088"+
		"\u0433\n\u0088\f\u0088\16\u0088\u0436\13\u0088\3\u0088\3\u0088\3\u0088"+
		"\3\u0088\3\u0088\7\u0088\u043d\n\u0088\f\u0088\16\u0088\u0440\13\u0088"+
		"\3\u0088\5\u0088\u0443\n\u0088\3\u0089\6\u0089\u0446\n\u0089\r\u0089\16"+
		"\u0089\u0447\3\u0089\3\u0089\3\u008a\6\u008a\u044d\n\u008a\r\u008a\16"+
		"\u008a\u044e\3\u008a\3\u008a\3\u008b\6\u008b\u0454\n\u008b\r\u008b\16"+
		"\u008b\u0455\3\u008b\3\u008b\3\u008c\6\u008c\u045b\n\u008c\r\u008c\16"+
		"\u008c\u045c\3\u008c\3\u008c\3\u008d\6\u008d\u0462\n\u008d\r\u008d\16"+
		"\u008d\u0463\3\u008e\6\u008e\u0467\n\u008e\r\u008e\16\u008e\u0468\3\u008e"+
		"\3\u008e\3\u008e\3\u008e\5\u008e\u046f\n\u008e\3\u008e\3\u008e\5\u008e"+
		"\u0473\n\u008e\3\u008f\6\u008f\u0476\n\u008f\r\u008f\16\u008f\u0477\3"+
		"\u008f\5\u008f\u047b\n\u008f\3\u008f\3\u008f\3\u008f\3\u008f\5\u008f\u0481"+
		"\n\u008f\3\u008f\3\u008f\3\u008f\5\u008f\u0486\n\u008f\3\u0090\6\u0090"+
		"\u0489\n\u0090\r\u0090\16\u0090\u048a\3\u0090\5\u0090\u048e\n\u0090\3"+
		"\u0090\3\u0090\3\u0090\3\u0090\3\u0090\5\u0090\u0495\n\u0090\3\u0090\3"+
		"\u0090\3\u0090\3\u0090\3\u0090\5\u0090\u049c\n\u0090\3\u0091\3\u0091\3"+
		"\u0091\6\u0091\u04a1\n\u0091\r\u0091\16\u0091\u04a2\3\u0092\3\u0092\3"+
		"\u0092\3\u0092\7\u0092\u04a9\n\u0092\f\u0092\16\u0092\u04ac\13\u0092\3"+
		"\u0092\3\u0092\3\u0093\6\u0093\u04b1\n\u0093\r\u0093\16\u0093\u04b2\3"+
		"\u0093\3\u0093\7\u0093\u04b7\n\u0093\f\u0093\16\u0093\u04ba\13\u0093\3"+
		"\u0093\3\u0093\6\u0093\u04be\n\u0093\r\u0093\16\u0093\u04bf\5\u0093\u04c2"+
		"\n\u0093\3\u0094\3\u0094\5\u0094\u04c6\n\u0094\3\u0094\6\u0094\u04c9\n"+
		"\u0094\r\u0094\16\u0094\u04ca\3\u0095\3\u0095\3\u0096\3\u0096\3\u0097"+
		"\3\u0097\3\u0097\3\u0097\7\u0097\u04d5\n\u0097\f\u0097\16\u0097\u04d8"+
		"\13\u0097\3\u0097\5\u0097\u04db\n\u0097\3\u0097\5\u0097\u04de\n\u0097"+
		"\3\u0097\3\u0097\3\u0098\3\u0098\3\u0098\3\u0098\3\u0098\3\u0098\3\u0098"+
		"\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\7\u0099\u04ee\n\u0099\f\u0099"+
		"\16\u0099\u04f1\13\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u009a"+
		"\6\u009a\u04f9\n\u009a\r\u009a\16\u009a\u04fa\3\u009a\3\u009a\3\u009b"+
		"\3\u009b\3\u04ef\2\u009c\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62"+
		"c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087"+
		"E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009b"+
		"O\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00adX\u00af"+
		"Y\u00b1Z\u00b3[\u00b5\\\u00b7]\u00b9^\u00bb_\u00bd`\u00bfa\u00c1b\u00c3"+
		"c\u00c5d\u00c7e\u00c9f\u00cbg\u00cdh\u00cfi\u00d1j\u00d3k\u00d5l\u00d7"+
		"m\u00d9n\u00dbo\u00ddp\u00dfq\u00e1r\u00e3s\u00e5t\u00e7u\u00e9v\u00eb"+
		"w\u00edx\u00efy\u00f1z\u00f3{\u00f5|\u00f7}\u00f9~\u00fb\177\u00fd\u0080"+
		"\u00ff\u0081\u0101\u0082\u0103\u0083\u0105\u0084\u0107\u0085\u0109\u0086"+
		"\u010b\u0087\u010d\u0088\u010f\u0089\u0111\u008a\u0113\u008b\u0115\u008c"+
		"\u0117\u008d\u0119\u008e\u011b\u008f\u011d\u0090\u011f\u0091\u0121\u0092"+
		"\u0123\u0093\u0125\2\u0127\2\u0129\2\u012b\2\u012d\u0094\u012f\u0095\u0131"+
		"\u0096\u0133\u0097\u0135\u0098\3\2\f\4\2))^^\4\2$$^^\6\2DDIIMMOO\3\2b"+
		"b\4\2--//\3\2\62;\3\2C\\\4\2\f\f\17\17\3\2--\5\2\13\f\17\17\"\"\u0527"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097"+
		"\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2"+
		"\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2"+
		"\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb"+
		"\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2"+
		"\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd"+
		"\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2"+
		"\2\2\u00d7\3\2\2\2\2\u00d9\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df"+
		"\3\2\2\2\2\u00e1\3\2\2\2\2\u00e3\3\2\2\2\2\u00e5\3\2\2\2\2\u00e7\3\2\2"+
		"\2\2\u00e9\3\2\2\2\2\u00eb\3\2\2\2\2\u00ed\3\2\2\2\2\u00ef\3\2\2\2\2\u00f1"+
		"\3\2\2\2\2\u00f3\3\2\2\2\2\u00f5\3\2\2\2\2\u00f7\3\2\2\2\2\u00f9\3\2\2"+
		"\2\2\u00fb\3\2\2\2\2\u00fd\3\2\2\2\2\u00ff\3\2\2\2\2\u0101\3\2\2\2\2\u0103"+
		"\3\2\2\2\2\u0105\3\2\2\2\2\u0107\3\2\2\2\2\u0109\3\2\2\2\2\u010b\3\2\2"+
		"\2\2\u010d\3\2\2\2\2\u010f\3\2\2\2\2\u0111\3\2\2\2\2\u0113\3\2\2\2\2\u0115"+
		"\3\2\2\2\2\u0117\3\2\2\2\2\u0119\3\2\2\2\2\u011b\3\2\2\2\2\u011d\3\2\2"+
		"\2\2\u011f\3\2\2\2\2\u0121\3\2\2\2\2\u0123\3\2\2\2\2\u012d\3\2\2\2\2\u012f"+
		"\3\2\2\2\2\u0131\3\2\2\2\2\u0133\3\2\2\2\2\u0135\3\2\2\2\3\u0137\3\2\2"+
		"\2\5\u0139\3\2\2\2\7\u013b\3\2\2\2\t\u013d\3\2\2\2\13\u013f\3\2\2\2\r"+
		"\u0141\3\2\2\2\17\u0143\3\2\2\2\21\u0145\3\2\2\2\23\u014c\3\2\2\2\25\u0151"+
		"\3\2\2\2\27\u0155\3\2\2\2\31\u0158\3\2\2\2\33\u015c\3\2\2\2\35\u0165\3"+
		"\2\2\2\37\u016b\3\2\2\2!\u0171\3\2\2\2#\u0174\3\2\2\2%\u017d\3\2\2\2\'"+
		"\u0182\3\2\2\2)\u0187\3\2\2\2+\u018e\3\2\2\2-\u0194\3\2\2\2/\u019b\3\2"+
		"\2\2\61\u01a1\3\2\2\2\63\u01a4\3\2\2\2\65\u01a7\3\2\2\2\67\u01ab\3\2\2"+
		"\29\u01b2\3\2\2\2;\u01b4\3\2\2\2=\u01b7\3\2\2\2?\u01be\3\2\2\2A\u01c6"+
		"\3\2\2\2C\u01d6\3\2\2\2E\u01d8\3\2\2\2G\u01db\3\2\2\2I\u01e0\3\2\2\2K"+
		"\u01e5\3\2\2\2M\u01eb\3\2\2\2O\u01f1\3\2\2\2Q\u01f5\3\2\2\2S\u01fa\3\2"+
		"\2\2U\u01fe\3\2\2\2W\u0207\3\2\2\2Y\u020c\3\2\2\2[\u0211\3\2\2\2]\u0216"+
		"\3\2\2\2_\u021b\3\2\2\2a\u021f\3\2\2\2c\u0224\3\2\2\2e\u022a\3\2\2\2g"+
		"\u0230\3\2\2\2i\u0236\3\2\2\2k\u023b\3\2\2\2m\u0240\3\2\2\2o\u0246\3\2"+
		"\2\2q\u024b\3\2\2\2s\u0253\3\2\2\2u\u0256\3\2\2\2w\u025c\3\2\2\2y\u0262"+
		"\3\2\2\2{\u0267\3\2\2\2}\u026e\3\2\2\2\177\u0275\3\2\2\2\u0081\u027b\3"+
		"\2\2\2\u0083\u0280\3\2\2\2\u0085\u0288\3\2\2\2\u0087\u028f\3\2\2\2\u0089"+
		"\u0296\3\2\2\2\u008b\u029b\3\2\2\2\u008d\u02a4\3\2\2\2\u008f\u02ac\3\2"+
		"\2\2\u0091\u02b1\3\2\2\2\u0093\u02b6\3\2\2\2\u0095\u02bd\3\2\2\2\u0097"+
		"\u02c5\3\2\2\2\u0099\u02cc\3\2\2\2\u009b\u02d0\3\2\2\2\u009d\u02da\3\2"+
		"\2\2\u009f\u02df\3\2\2\2\u00a1\u02e5\3\2\2\2\u00a3\u02ec\3\2\2\2\u00a5"+
		"\u02f2\3\2\2\2\u00a7\u02fc\3\2\2\2\u00a9\u02ff\3\2\2\2\u00ab\u0305\3\2"+
		"\2\2\u00ad\u030c\3\2\2\2\u00af\u0312\3\2\2\2\u00b1\u0316\3\2\2\2\u00b3"+
		"\u031d\3\2\2\2\u00b5\u0325\3\2\2\2\u00b7\u0329\3\2\2\2\u00b9\u032f\3\2"+
		"\2\2\u00bb\u0336\3\2\2\2\u00bd\u033f\3\2\2\2\u00bf\u0346\3\2\2\2\u00c1"+
		"\u034c\3\2\2\2\u00c3\u034e\3\2\2\2\u00c5\u0352\3\2\2\2\u00c7\u0355\3\2"+
		"\2\2\u00c9\u0358\3\2\2\2\u00cb\u035e\3\2\2\2\u00cd\u0360\3\2\2\2\u00cf"+
		"\u0366\3\2\2\2\u00d1\u0368\3\2\2\2\u00d3\u036a\3\2\2\2\u00d5\u036c\3\2"+
		"\2\2\u00d7\u036e\3\2\2\2\u00d9\u0370\3\2\2\2\u00db\u0372\3\2\2\2\u00dd"+
		"\u0376\3\2\2\2\u00df\u0378\3\2\2\2\u00e1\u037a\3\2\2\2\u00e3\u037c\3\2"+
		"\2\2\u00e5\u037e\3\2\2\2\u00e7\u0386\3\2\2\2\u00e9\u038a\3\2\2\2\u00eb"+
		"\u038d\3\2\2\2\u00ed\u03a4\3\2\2\2\u00ef\u03b6\3\2\2\2\u00f1\u03b8\3\2"+
		"\2\2\u00f3\u03c1\3\2\2\2\u00f5\u03c9\3\2\2\2\u00f7\u03d1\3\2\2\2\u00f9"+
		"\u03d6\3\2\2\2\u00fb\u03dd\3\2\2\2\u00fd\u03e3\3\2\2\2\u00ff\u03ea\3\2"+
		"\2\2\u0101\u03f1\3\2\2\2\u0103\u03f6\3\2\2\2\u0105\u03fb\3\2\2\2\u0107"+
		"\u0401\3\2\2\2\u0109\u0407\3\2\2\2\u010b\u040f\3\2\2\2\u010d\u041c\3\2"+
		"\2\2\u010f\u0442\3\2\2\2\u0111\u0445\3\2\2\2\u0113\u044c\3\2\2\2\u0115"+
		"\u0453\3\2\2\2\u0117\u045a\3\2\2\2\u0119\u0461\3\2\2\2\u011b\u0472\3\2"+
		"\2\2\u011d\u0485\3\2\2\2\u011f\u049b\3\2\2\2\u0121\u04a0\3\2\2\2\u0123"+
		"\u04a4\3\2\2\2\u0125\u04c1\3\2\2\2\u0127\u04c3\3\2\2\2\u0129\u04cc\3\2"+
		"\2\2\u012b\u04ce\3\2\2\2\u012d\u04d0\3\2\2\2\u012f\u04e1\3\2\2\2\u0131"+
		"\u04e8\3\2\2\2\u0133\u04f8\3\2\2\2\u0135\u04fe\3\2\2\2\u0137\u0138\7."+
		"\2\2\u0138\4\3\2\2\2\u0139\u013a\7*\2\2\u013a\6\3\2\2\2\u013b\u013c\7"+
		"+\2\2\u013c\b\3\2\2\2\u013d\u013e\7\60\2\2\u013e\n\3\2\2\2\u013f\u0140"+
		"\7]\2\2\u0140\f\3\2\2\2\u0141\u0142\7_\2\2\u0142\16\3\2\2\2\u0143\u0144"+
		"\7<\2\2\u0144\20\3\2\2\2\u0145\u0146\7U\2\2\u0146\u0147\7G\2\2\u0147\u0148"+
		"\7N\2\2\u0148\u0149\7G\2\2\u0149\u014a\7E\2\2\u014a\u014b\7V\2\2\u014b"+
		"\22\3\2\2\2\u014c\u014d\7H\2\2\u014d\u014e\7T\2\2\u014e\u014f\7Q\2\2\u014f"+
		"\u0150\7O\2\2\u0150\24\3\2\2\2\u0151\u0152\7C\2\2\u0152\u0153\7F\2\2\u0153"+
		"\u0154\7F\2\2\u0154\26\3\2\2\2\u0155\u0156\7C\2\2\u0156\u0157\7U\2\2\u0157"+
		"\30\3\2\2\2\u0158\u0159\7C\2\2\u0159\u015a\7N\2\2\u015a\u015b\7N\2\2\u015b"+
		"\32\3\2\2\2\u015c\u015d\7F\2\2\u015d\u015e\7K\2\2\u015e\u015f\7U\2\2\u015f"+
		"\u0160\7V\2\2\u0160\u0161\7K\2\2\u0161\u0162\7P\2\2\u0162\u0163\7E\2\2"+
		"\u0163\u0164\7V\2\2\u0164\34\3\2\2\2\u0165\u0166\7Y\2\2\u0166\u0167\7"+
		"J\2\2\u0167\u0168\7G\2\2\u0168\u0169\7T\2\2\u0169\u016a\7G\2\2\u016a\36"+
		"\3\2\2\2\u016b\u016c\7I\2\2\u016c\u016d\7T\2\2\u016d\u016e\7Q\2\2\u016e"+
		"\u016f\7W\2\2\u016f\u0170\7R\2\2\u0170 \3\2\2\2\u0171\u0172\7D\2\2\u0172"+
		"\u0173\7[\2\2\u0173\"\3\2\2\2\u0174\u0175\7I\2\2\u0175\u0176\7T\2\2\u0176"+
		"\u0177\7Q\2\2\u0177\u0178\7W\2\2\u0178\u0179\7R\2\2\u0179\u017a\7K\2\2"+
		"\u017a\u017b\7P\2\2\u017b\u017c\7I\2\2\u017c$\3\2\2\2\u017d\u017e\7U\2"+
		"\2\u017e\u017f\7G\2\2\u017f\u0180\7V\2\2\u0180\u0181\7U\2\2\u0181&\3\2"+
		"\2\2\u0182\u0183\7E\2\2\u0183\u0184\7W\2\2\u0184\u0185\7D\2\2\u0185\u0186"+
		"\7G\2\2\u0186(\3\2\2\2\u0187\u0188\7T\2\2\u0188\u0189\7Q\2\2\u0189\u018a"+
		"\7N\2\2\u018a\u018b\7N\2\2\u018b\u018c\7W\2\2\u018c\u018d\7R\2\2\u018d"+
		"*\3\2\2\2\u018e\u018f\7Q\2\2\u018f\u0190\7T\2\2\u0190\u0191\7F\2\2\u0191"+
		"\u0192\7G\2\2\u0192\u0193\7T\2\2\u0193,\3\2\2\2\u0194\u0195\7J\2\2\u0195"+
		"\u0196\7C\2\2\u0196\u0197\7X\2\2\u0197\u0198\7K\2\2\u0198\u0199\7P\2\2"+
		"\u0199\u019a\7I\2\2\u019a.\3\2\2\2\u019b\u019c\7N\2\2\u019c\u019d\7K\2"+
		"\2\u019d\u019e\7O\2\2\u019e\u019f\7K\2\2\u019f\u01a0\7V\2\2\u01a0\60\3"+
		"\2\2\2\u01a1\u01a2\7C\2\2\u01a2\u01a3\7V\2\2\u01a3\62\3\2\2\2\u01a4\u01a5"+
		"\7Q\2\2\u01a5\u01a6\7T\2\2\u01a6\64\3\2\2\2\u01a7\u01a8\7C\2\2\u01a8\u01a9"+
		"\7P\2\2\u01a9\u01aa\7F\2\2\u01aa\66\3\2\2\2\u01ab\u01ac\7K\2\2\u01ac\u01ad"+
		"\7P\2\2\u01ad8\3\2\2\2\u01ae\u01af\7P\2\2\u01af\u01b0\7Q\2\2\u01b0\u01b3"+
		"\7V\2\2\u01b1\u01b3\7#\2\2\u01b2\u01ae\3\2\2\2\u01b2\u01b1\3\2\2\2\u01b3"+
		":\3\2\2\2\u01b4\u01b5\7P\2\2\u01b5\u01b6\7Q\2\2\u01b6<\3\2\2\2\u01b7\u01b8"+
		"\7G\2\2\u01b8\u01b9\7Z\2\2\u01b9\u01ba\7K\2\2\u01ba\u01bb\7U\2\2\u01bb"+
		"\u01bc\7V\2\2\u01bc\u01bd\7U\2\2\u01bd>\3\2\2\2\u01be\u01bf\7D\2\2\u01bf"+
		"\u01c0\7G\2\2\u01c0\u01c1\7V\2\2\u01c1\u01c2\7Y\2\2\u01c2\u01c3\7G\2\2"+
		"\u01c3\u01c4\7G\2\2\u01c4\u01c5\7P\2\2\u01c5@\3\2\2\2\u01c6\u01c7\7N\2"+
		"\2\u01c7\u01c8\7K\2\2\u01c8\u01c9\7M\2\2\u01c9\u01ca\7G\2\2\u01caB\3\2"+
		"\2\2\u01cb\u01cc\7T\2\2\u01cc\u01cd\7N\2\2\u01cd\u01ce\7K\2\2\u01ce\u01cf"+
		"\7M\2\2\u01cf\u01d7\7G\2\2\u01d0\u01d1\7T\2\2\u01d1\u01d2\7G\2\2\u01d2"+
		"\u01d3\7I\2\2\u01d3\u01d4\7G\2\2\u01d4\u01d5\7Z\2\2\u01d5\u01d7\7R\2\2"+
		"\u01d6\u01cb\3\2\2\2\u01d6\u01d0\3\2\2\2\u01d7D\3\2\2\2\u01d8\u01d9\7"+
		"K\2\2\u01d9\u01da\7U\2\2\u01daF\3\2\2\2\u01db\u01dc\7P\2\2\u01dc\u01dd"+
		"\7W\2\2\u01dd\u01de\7N\2\2\u01de\u01df\7N\2\2\u01dfH\3\2\2\2\u01e0\u01e1"+
		"\7V\2\2\u01e1\u01e2\7T\2\2\u01e2\u01e3\7W\2\2\u01e3\u01e4\7G\2\2\u01e4"+
		"J\3\2\2\2\u01e5\u01e6\7H\2\2\u01e6\u01e7\7C\2\2\u01e7\u01e8\7N\2\2\u01e8"+
		"\u01e9\7U\2\2\u01e9\u01ea\7G\2\2\u01eaL\3\2\2\2\u01eb\u01ec\7P\2\2\u01ec"+
		"\u01ed\7W\2\2\u01ed\u01ee\7N\2\2\u01ee\u01ef\7N\2\2\u01ef\u01f0\7U\2\2"+
		"\u01f0N\3\2\2\2\u01f1\u01f2\7C\2\2\u01f2\u01f3\7U\2\2\u01f3\u01f4\7E\2"+
		"\2\u01f4P\3\2\2\2\u01f5\u01f6\7F\2\2\u01f6\u01f7\7G\2\2\u01f7\u01f8\7"+
		"U\2\2\u01f8\u01f9\7E\2\2\u01f9R\3\2\2\2\u01fa\u01fb\7H\2\2\u01fb\u01fc"+
		"\7Q\2\2\u01fc\u01fd\7T\2\2\u01fdT\3\2\2\2\u01fe\u01ff\7K\2\2\u01ff\u0200"+
		"\7P\2\2\u0200\u0201\7V\2\2\u0201\u0202\7G\2\2\u0202\u0203\7T\2\2\u0203"+
		"\u0204\7X\2\2\u0204\u0205\7C\2\2\u0205\u0206\7N\2\2\u0206V\3\2\2\2\u0207"+
		"\u0208\7E\2\2\u0208\u0209\7C\2\2\u0209\u020a\7U\2\2\u020a\u020b\7G\2\2"+
		"\u020bX\3\2\2\2\u020c\u020d\7Y\2\2\u020d\u020e\7J\2\2\u020e\u020f\7G\2"+
		"\2\u020f\u0210\7P\2\2\u0210Z\3\2\2\2\u0211\u0212\7V\2\2\u0212\u0213\7"+
		"J\2\2\u0213\u0214\7G\2\2\u0214\u0215\7P\2\2\u0215\\\3\2\2\2\u0216\u0217"+
		"\7G\2\2\u0217\u0218\7N\2\2\u0218\u0219\7U\2\2\u0219\u021a\7G\2\2\u021a"+
		"^\3\2\2\2\u021b\u021c\7G\2\2\u021c\u021d\7P\2\2\u021d\u021e\7F\2\2\u021e"+
		"`\3\2\2\2\u021f\u0220\7L\2\2\u0220\u0221\7Q\2\2\u0221\u0222\7K\2\2\u0222"+
		"\u0223\7P\2\2\u0223b\3\2\2\2\u0224\u0225\7E\2\2\u0225\u0226\7T\2\2\u0226"+
		"\u0227\7Q\2\2\u0227\u0228\7U\2\2\u0228\u0229\7U\2\2\u0229d\3\2\2\2\u022a"+
		"\u022b\7Q\2\2\u022b\u022c\7W\2\2\u022c\u022d\7V\2\2\u022d\u022e\7G\2\2"+
		"\u022e\u022f\7T\2\2\u022ff\3\2\2\2\u0230\u0231\7K\2\2\u0231\u0232\7P\2"+
		"\2\u0232\u0233\7P\2\2\u0233\u0234\7G\2\2\u0234\u0235\7T\2\2\u0235h\3\2"+
		"\2\2\u0236\u0237\7N\2\2\u0237\u0238\7G\2\2\u0238\u0239\7H\2\2\u0239\u023a"+
		"\7V\2\2\u023aj\3\2\2\2\u023b\u023c\7U\2\2\u023c\u023d\7G\2\2\u023d\u023e"+
		"\7O\2\2\u023e\u023f\7K\2\2\u023fl\3\2\2\2\u0240\u0241\7T\2\2\u0241\u0242"+
		"\7K\2\2\u0242\u0243\7I\2\2\u0243\u0244\7J\2\2\u0244\u0245\7V\2\2\u0245"+
		"n\3\2\2\2\u0246\u0247\7H\2\2\u0247\u0248\7W\2\2\u0248\u0249\7N\2\2\u0249"+
		"\u024a\7N\2\2\u024ap\3\2\2\2\u024b\u024c\7P\2\2\u024c\u024d\7C\2\2\u024d"+
		"\u024e\7V\2\2\u024e\u024f\7W\2\2\u024f\u0250\7T\2\2\u0250\u0251\7C\2\2"+
		"\u0251\u0252\7N\2\2\u0252r\3\2\2\2\u0253\u0254\7Q\2\2\u0254\u0255\7P\2"+
		"\2\u0255t\3\2\2\2\u0256\u0257\7H\2\2\u0257\u0258\7K\2\2\u0258\u0259\7"+
		"T\2\2\u0259\u025a\7U\2\2\u025a\u025b\7V\2\2\u025bv\3\2\2\2\u025c\u025d"+
		"\7C\2\2\u025d\u025e\7H\2\2\u025e\u025f\7V\2\2\u025f\u0260\7G\2\2\u0260"+
		"\u0261\7T\2\2\u0261x\3\2\2\2\u0262\u0263\7N\2\2\u0263\u0264\7C\2\2\u0264"+
		"\u0265\7U\2\2\u0265\u0266\7V\2\2\u0266z\3\2\2\2\u0267\u0268\7X\2\2\u0268"+
		"\u0269\7C\2\2\u0269\u026a\7N\2\2\u026a\u026b\7W\2\2\u026b\u026c\7G\2\2"+
		"\u026c\u026d\7U\2\2\u026d|\3\2\2\2\u026e\u026f\7E\2\2\u026f\u0270\7T\2"+
		"\2\u0270\u0271\7G\2\2\u0271\u0272\7C\2\2\u0272\u0273\7V\2\2\u0273\u0274"+
		"\7G\2\2\u0274~\3\2\2\2\u0275\u0276\7V\2\2\u0276\u0277\7C\2\2\u0277\u0278"+
		"\7D\2\2\u0278\u0279\7N\2\2\u0279\u027a\7G\2\2\u027a\u0080\3\2\2\2\u027b"+
		"\u027c\7X\2\2\u027c\u027d\7K\2\2\u027d\u027e\7G\2\2\u027e\u027f\7Y\2\2"+
		"\u027f\u0082\3\2\2\2\u0280\u0281\7T\2\2\u0281\u0282\7G\2\2\u0282\u0283"+
		"\7R\2\2\u0283\u0284\7N\2\2\u0284\u0285\7C\2\2\u0285\u0286\7E\2\2\u0286"+
		"\u0287\7G\2\2\u0287\u0084\3\2\2\2\u0288\u0289\7K\2\2\u0289\u028a\7P\2"+
		"\2\u028a\u028b\7U\2\2\u028b\u028c\7G\2\2\u028c\u028d\7T\2\2\u028d\u028e"+
		"\7V\2\2\u028e\u0086\3\2\2\2\u028f\u0290\7F\2\2\u0290\u0291\7G\2\2\u0291"+
		"\u0292\7N\2\2\u0292\u0293\7G\2\2\u0293\u0294\7V\2\2\u0294\u0295\7G\2\2"+
		"\u0295\u0088\3\2\2\2\u0296\u0297\7K\2\2\u0297\u0298\7P\2\2\u0298\u0299"+
		"\7V\2\2\u0299\u029a\7Q\2\2\u029a\u008a\3\2\2\2\u029b\u029c\7F\2\2\u029c"+
		"\u029d\7G\2\2\u029d\u029e\7U\2\2\u029e\u029f\7E\2\2\u029f\u02a0\7T\2\2"+
		"\u02a0\u02a1\7K\2\2\u02a1\u02a2\7D\2\2\u02a2\u02a3\7G\2\2\u02a3\u008c"+
		"\3\2\2\2\u02a4\u02a5\7G\2\2\u02a5\u02a6\7Z\2\2\u02a6\u02a7\7R\2\2\u02a7"+
		"\u02a8\7N\2\2\u02a8\u02a9\7C\2\2\u02a9\u02aa\7K\2\2\u02aa\u02ab\7P\2\2"+
		"\u02ab\u008e\3\2\2\2\u02ac\u02ad\7E\2\2\u02ad\u02ae\7C\2\2\u02ae\u02af"+
		"\7U\2\2\u02af\u02b0\7V\2\2\u02b0\u0090\3\2\2\2\u02b1\u02b2\7U\2\2\u02b2"+
		"\u02b3\7J\2\2\u02b3\u02b4\7Q\2\2\u02b4\u02b5\7Y\2\2\u02b5\u0092\3\2\2"+
		"\2\u02b6\u02b7\7V\2\2\u02b7\u02b8\7C\2\2\u02b8\u02b9\7D\2\2\u02b9\u02ba"+
		"\7N\2\2\u02ba\u02bb\7G\2\2\u02bb\u02bc\7U\2\2\u02bc\u0094\3\2\2\2\u02bd"+
		"\u02be\7E\2\2\u02be\u02bf\7Q\2\2\u02bf\u02c0\7N\2\2\u02c0\u02c1\7W\2\2"+
		"\u02c1\u02c2\7O\2\2\u02c2\u02c3\7P\2\2\u02c3\u02c4\7U\2\2\u02c4\u0096"+
		"\3\2\2\2\u02c5\u02c6\7E\2\2\u02c6\u02c7\7Q\2\2\u02c7\u02c8\7N\2\2\u02c8"+
		"\u02c9\7W\2\2\u02c9\u02ca\7O\2\2\u02ca\u02cb\7P\2\2\u02cb\u0098\3\2\2"+
		"\2\u02cc\u02cd\7W\2\2\u02cd\u02ce\7U\2\2\u02ce\u02cf\7G\2\2\u02cf\u009a"+
		"\3\2\2\2\u02d0\u02d1\7H\2\2\u02d1\u02d2\7W\2\2\u02d2\u02d3\7P\2\2\u02d3"+
		"\u02d4\7E\2\2\u02d4\u02d5\7V\2\2\u02d5\u02d6\7K\2\2\u02d6\u02d7\7Q\2\2"+
		"\u02d7\u02d8\7P\2\2\u02d8\u02d9\7U\2\2\u02d9\u009c\3\2\2\2\u02da\u02db"+
		"\7F\2\2\u02db\u02dc\7T\2\2\u02dc\u02dd\7Q\2\2\u02dd\u02de\7R\2\2\u02de"+
		"\u009e\3\2\2\2\u02df\u02e0\7W\2\2\u02e0\u02e1\7P\2\2\u02e1\u02e2\7K\2"+
		"\2\u02e2\u02e3\7Q\2\2\u02e3\u02e4\7P\2\2\u02e4\u00a0\3\2\2\2\u02e5\u02e6"+
		"\7G\2\2\u02e6\u02e7\7Z\2\2\u02e7\u02e8\7E\2\2\u02e8\u02e9\7G\2\2\u02e9"+
		"\u02ea\7R\2\2\u02ea\u02eb\7V\2\2\u02eb\u00a2\3\2\2\2\u02ec\u02ed\7O\2"+
		"\2\u02ed\u02ee\7K\2\2\u02ee\u02ef\7P\2\2\u02ef\u02f0\7W\2\2\u02f0\u02f1"+
		"\7U\2\2\u02f1\u00a4\3\2\2\2\u02f2\u02f3\7K\2\2\u02f3\u02f4\7P\2\2\u02f4"+
		"\u02f5\7V\2\2\u02f5\u02f6\7G\2\2\u02f6\u02f7\7T\2\2\u02f7\u02f8\7U\2\2"+
		"\u02f8\u02f9\7G\2\2\u02f9\u02fa\7E\2\2\u02fa\u02fb\7V\2\2\u02fb\u00a6"+
		"\3\2\2\2\u02fc\u02fd\7V\2\2\u02fd\u02fe\7Q\2\2\u02fe\u00a8\3\2\2\2\u02ff"+
		"\u0300\7C\2\2\u0300\u0301\7N\2\2\u0301\u0302\7V\2\2\u0302\u0303\7G\2\2"+
		"\u0303\u0304\7T\2\2\u0304\u00aa\3\2\2\2\u0305\u0306\7T\2\2\u0306\u0307"+
		"\7G\2\2\u0307\u0308\7P\2\2\u0308\u0309\7C\2\2\u0309\u030a\7O\2\2\u030a"+
		"\u030b\7G\2\2\u030b\u00ac\3\2\2\2\u030c\u030d\7C\2\2\u030d\u030e\7T\2"+
		"\2\u030e\u030f\7T\2\2\u030f\u0310\7C\2\2\u0310\u0311\7[\2\2\u0311\u00ae"+
		"\3\2\2\2\u0312\u0313\7O\2\2\u0313\u0314\7C\2\2\u0314\u0315\7R\2\2\u0315"+
		"\u00b0\3\2\2\2\u0316\u0317\7U\2\2\u0317\u0318\7V\2\2\u0318\u0319\7T\2"+
		"\2\u0319\u031a\7W\2\2\u031a\u031b\7E\2\2\u031b\u031c\7V\2\2\u031c\u00b2"+
		"\3\2\2\2\u031d\u031e\7E\2\2\u031e\u031f\7Q\2\2\u031f\u0320\7O\2\2\u0320"+
		"\u0321\7O\2\2\u0321\u0322\7G\2\2\u0322\u0323\7P\2\2\u0323\u0324\7V\2\2"+
		"\u0324\u00b4\3\2\2\2\u0325\u0326\7U\2\2\u0326\u0327\7G\2\2\u0327\u0328"+
		"\7V\2\2\u0328\u00b6\3\2\2\2\u0329\u032a\7T\2\2\u032a\u032b\7G\2\2\u032b"+
		"\u032c\7U\2\2\u032c\u032d\7G\2\2\u032d\u032e\7V\2\2\u032e\u00b8\3\2\2"+
		"\2\u032f\u0330\7E\2\2\u0330\u0331\7Q\2\2\u0331\u0332\7O\2\2\u0332\u0333"+
		"\7O\2\2\u0333\u0334\7K\2\2\u0334\u0335\7V\2\2\u0335\u00ba\3\2\2\2\u0336"+
		"\u0337\7T\2\2\u0337\u0338\7Q\2\2\u0338\u0339\7N\2\2\u0339\u033a\7N\2\2"+
		"\u033a\u033b\7D\2\2\u033b\u033c\7C\2\2\u033c\u033d\7E\2\2\u033d\u033e"+
		"\7M\2\2\u033e\u00bc\3\2\2\2\u033f\u0340\7K\2\2\u0340\u0341\7I\2\2\u0341"+
		"\u0342\7P\2\2\u0342\u0343\7Q\2\2\u0343\u0344\7T\2\2\u0344\u0345\7G\2\2"+
		"\u0345\u00be\3\2\2\2\u0346\u0347\7K\2\2\u0347\u0348\7H\2\2\u0348\u00c0"+
		"\3\2\2\2\u0349\u034d\7?\2\2\u034a\u034b\7?\2\2\u034b\u034d\7?\2\2\u034c"+
		"\u0349\3\2\2\2\u034c\u034a\3\2\2\2\u034d\u00c2\3\2\2\2\u034e\u034f\7>"+
		"\2\2\u034f\u0350\7?\2\2\u0350\u0351\7@\2\2\u0351\u00c4\3\2\2\2\u0352\u0353"+
		"\7>\2\2\u0353\u0354\7@\2\2\u0354\u00c6\3\2\2\2\u0355\u0356\7#\2\2\u0356"+
		"\u0357\7?\2\2\u0357\u00c8\3\2\2\2\u0358\u0359\7>\2\2\u0359\u00ca\3\2\2"+
		"\2\u035a\u035b\7>\2\2\u035b\u035f\7?\2\2\u035c\u035d\7#\2\2\u035d\u035f"+
		"\7@\2\2\u035e\u035a\3\2\2\2\u035e\u035c\3\2\2\2\u035f\u00cc\3\2\2\2\u0360"+
		"\u0361\7@\2\2\u0361\u00ce\3\2\2\2\u0362\u0363\7@\2\2\u0363\u0367\7?\2"+
		"\2\u0364\u0365\7#\2\2\u0365\u0367\7>\2\2\u0366\u0362\3\2\2\2\u0366\u0364"+
		"\3\2\2\2\u0367\u00d0\3\2\2\2\u0368\u0369\7-\2\2\u0369\u00d2\3\2\2\2\u036a"+
		"\u036b\7/\2\2\u036b\u00d4\3\2\2\2\u036c\u036d\7,\2\2\u036d\u00d6\3\2\2"+
		"\2\u036e\u036f\7\61\2\2\u036f\u00d8\3\2\2\2\u0370\u0371\7\'\2\2\u0371"+
		"\u00da\3\2\2\2\u0372\u0373\7F\2\2\u0373\u0374\7K\2\2\u0374\u0375\7X\2"+
		"\2\u0375\u00dc\3\2\2\2\u0376\u0377\7\u0080\2\2\u0377\u00de\3\2\2\2\u0378"+
		"\u0379\7(\2\2\u0379\u00e0\3\2\2\2\u037a\u037b\7~\2\2\u037b\u00e2\3\2\2"+
		"\2\u037c\u037d\7`\2\2\u037d\u00e4\3\2\2\2\u037e\u037f\7R\2\2\u037f\u0380"+
		"\7G\2\2\u0380\u0381\7T\2\2\u0381\u0382\7E\2\2\u0382\u0383\7G\2\2\u0383"+
		"\u0384\7P\2\2\u0384\u0385\7V\2\2\u0385\u00e6\3\2\2\2\u0386\u0387\7Q\2"+
		"\2\u0387\u0388\7W\2\2\u0388\u0389\7V\2\2\u0389\u00e8\3\2\2\2\u038a\u038b"+
		"\7Q\2\2\u038b\u038c\7H\2\2\u038c\u00ea\3\2\2\2\u038d\u038e\7H\2\2\u038e"+
		"\u038f\7W\2\2\u038f\u0390\7P\2\2\u0390\u0391\7E\2\2\u0391\u0392\7V\2\2"+
		"\u0392\u0393\7K\2\2\u0393\u0394\7Q\2\2\u0394\u0395\7P\2\2\u0395\u00ec"+
		"\3\2\2\2\u0396\u0397\7F\2\2\u0397\u0398\7C\2\2\u0398\u0399\7V\2\2\u0399"+
		"\u039a\7C\2\2\u039a\u039b\7D\2\2\u039b\u039c\7C\2\2\u039c\u039d\7U\2\2"+
		"\u039d\u03a5\7G\2\2\u039e\u039f\7U\2\2\u039f\u03a0\7E\2\2\u03a0\u03a1"+
		"\7J\2\2\u03a1\u03a2\7G\2\2\u03a2\u03a3\7O\2\2\u03a3\u03a5\7C\2\2\u03a4"+
		"\u0396\3\2\2\2\u03a4\u039e\3\2\2\2\u03a5\u00ee\3\2\2\2\u03a6\u03a7\7F"+
		"\2\2\u03a7\u03a8\7C\2\2\u03a8\u03a9\7V\2\2\u03a9\u03aa\7C\2\2\u03aa\u03ab"+
		"\7D\2\2\u03ab\u03ac\7C\2\2\u03ac\u03ad\7U\2\2\u03ad\u03ae\7G\2\2\u03ae"+
		"\u03b7\7U\2\2\u03af\u03b0\7U\2\2\u03b0\u03b1\7E\2\2\u03b1\u03b2\7J\2\2"+
		"\u03b2\u03b3\7G\2\2\u03b3\u03b4\7O\2\2\u03b4\u03b5\7C\2\2\u03b5\u03b7"+
		"\7U\2\2\u03b6\u03a6\3\2\2\2\u03b6\u03af\3\2\2\2\u03b7\u00f0\3\2\2\2\u03b8"+
		"\u03b9\7V\2\2\u03b9\u03ba\7T\2\2\u03ba\u03bb\7W\2\2\u03bb\u03bc\7P\2\2"+
		"\u03bc\u03bd\7E\2\2\u03bd\u03be\7C\2\2\u03be\u03bf\7V\2\2\u03bf\u03c0"+
		"\7G\2\2\u03c0\u00f2\3\2\2\2\u03c1\u03c2\7C\2\2\u03c2\u03c3\7P\2\2\u03c3"+
		"\u03c4\7C\2\2\u03c4\u03c5\7N\2\2\u03c5\u03c6\7[\2\2\u03c6\u03c7\7\\\2"+
		"\2\u03c7\u03c8\7G\2\2\u03c8\u00f4\3\2\2\2\u03c9\u03ca\7E\2\2\u03ca\u03cb"+
		"\7Q\2\2\u03cb\u03cc\7O\2\2\u03cc\u03cd\7R\2\2\u03cd\u03ce\7W\2\2\u03ce"+
		"\u03cf\7V\2\2\u03cf\u03d0\7G\2\2\u03d0\u00f6\3\2\2\2\u03d1\u03d2\7N\2"+
		"\2\u03d2\u03d3\7K\2\2\u03d3\u03d4\7U\2\2\u03d4\u03d5\7V\2\2\u03d5\u00f8"+
		"\3\2\2\2\u03d6\u03d7\7T\2\2\u03d7\u03d8\7G\2\2\u03d8\u03d9\7X\2\2\u03d9"+
		"\u03da\7Q\2\2\u03da\u03db\7M\2\2\u03db\u03dc\7G\2\2\u03dc\u00fa\3\2\2"+
		"\2\u03dd\u03de\7I\2\2\u03de\u03df\7T\2\2\u03df\u03e0\7C\2\2\u03e0\u03e1"+
		"\7P\2\2\u03e1\u03e2\7V\2\2\u03e2\u00fc\3\2\2\2\u03e3\u03e4\7G\2\2\u03e4"+
		"\u03e5\7Z\2\2\u03e5\u03e6\7R\2\2\u03e6\u03e7\7Q\2\2\u03e7\u03e8\7T\2\2"+
		"\u03e8\u03e9\7V\2\2\u03e9\u00fe\3\2\2\2\u03ea\u03eb\7K\2\2\u03eb\u03ec"+
		"\7O\2\2\u03ec\u03ed\7R\2\2\u03ed\u03ee\7Q\2\2\u03ee\u03ef\7T\2\2\u03ef"+
		"\u03f0\7V\2\2\u03f0\u0100\3\2\2\2\u03f1\u03f2\7N\2\2\u03f2\u03f3\7Q\2"+
		"\2\u03f3\u03f4\7C\2\2\u03f4\u03f5\7F\2\2\u03f5\u0102\3\2\2\2\u03f6\u03f7"+
		"\7T\2\2\u03f7\u03f8\7Q\2\2\u03f8\u03f9\7N\2\2\u03f9\u03fa\7G\2\2\u03fa"+
		"\u0104\3\2\2\2\u03fb\u03fc\7T\2\2\u03fc\u03fd\7Q\2\2\u03fd\u03fe\7N\2"+
		"\2\u03fe\u03ff\7G\2\2\u03ff\u0400\7U\2\2\u0400\u0106\3\2\2\2\u0401\u0402"+
		"\7K\2\2\u0402\u0403\7P\2\2\u0403\u0404\7F\2\2\u0404\u0405\7G\2\2\u0405"+
		"\u0406\7Z\2\2\u0406\u0108\3\2\2\2\u0407\u0408\7K\2\2\u0408\u0409\7P\2"+
		"\2\u0409\u040a\7F\2\2\u040a\u040b\7G\2\2\u040b\u040c\7Z\2\2\u040c\u040d"+
		"\7G\2\2\u040d\u040e\7U\2\2\u040e\u010a\3\2\2\2\u040f\u0410\7E\2\2\u0410"+
		"\u0411\7W\2\2\u0411\u0412\7T\2\2\u0412\u0413\7T\2\2\u0413\u0414\7G\2\2"+
		"\u0414\u0415\7P\2\2\u0415\u0416\7V\2\2\u0416\u0417\7a\2\2\u0417\u0418"+
		"\7F\2\2\u0418\u0419\7C\2\2\u0419\u041a\7V\2\2\u041a\u041b\7G\2\2\u041b"+
		"\u010c\3\2\2\2\u041c\u041d\7E\2\2\u041d\u041e\7W\2\2\u041e\u041f\7T\2"+
		"\2\u041f\u0420\7T\2\2\u0420\u0421\7G\2\2\u0421\u0422\7P\2\2\u0422\u0423"+
		"\7V\2\2\u0423\u0424\7a\2\2\u0424\u0425\7V\2\2\u0425\u0426\7K\2\2\u0426"+
		"\u0427\7O\2\2\u0427\u0428\7G\2\2\u0428\u0429\7U\2\2\u0429\u042a\7V\2\2"+
		"\u042a\u042b\7C\2\2\u042b\u042c\7O\2\2\u042c\u042d\7R\2\2\u042d\u010e"+
		"\3\2\2\2\u042e\u0434\7)\2\2\u042f\u0433\n\2\2\2\u0430\u0431\7^\2\2\u0431"+
		"\u0433\13\2\2\2\u0432\u042f\3\2\2\2\u0432\u0430\3\2\2\2\u0433\u0436\3"+
		"\2\2\2\u0434\u0432\3\2\2\2\u0434\u0435\3\2\2\2\u0435\u0437\3\2\2\2\u0436"+
		"\u0434\3\2\2\2\u0437\u0443\7)\2\2\u0438\u043e\7$\2\2\u0439\u043d\n\3\2"+
		"\2\u043a\u043b\7^\2\2\u043b\u043d\13\2\2\2\u043c\u0439\3\2\2\2\u043c\u043a"+
		"\3\2\2\2\u043d\u0440\3\2\2\2\u043e\u043c\3\2\2\2\u043e\u043f\3\2\2\2\u043f"+
		"\u0441\3\2\2\2\u0440\u043e\3\2\2\2\u0441\u0443\7$\2\2\u0442\u042e\3\2"+
		"\2\2\u0442\u0438\3\2\2\2\u0443\u0110\3\2\2\2\u0444\u0446\5\u0129\u0095"+
		"\2\u0445\u0444\3\2\2\2\u0446\u0447\3\2\2\2\u0447\u0445\3\2\2\2\u0447\u0448"+
		"\3\2\2\2\u0448\u0449\3\2\2\2\u0449\u044a\7N\2\2\u044a\u0112\3\2\2\2\u044b"+
		"\u044d\5\u0129\u0095\2\u044c\u044b\3\2\2\2\u044d\u044e\3\2\2\2\u044e\u044c"+
		"\3\2\2\2\u044e\u044f\3\2\2\2\u044f\u0450\3\2\2\2\u0450\u0451\7U\2\2\u0451"+
		"\u0114\3\2\2\2\u0452\u0454\5\u0129\u0095\2\u0453\u0452\3\2\2\2\u0454\u0455"+
		"\3\2\2\2\u0455\u0453\3\2\2\2\u0455\u0456\3\2\2\2\u0456\u0457\3\2\2\2\u0457"+
		"\u0458\7[\2\2\u0458\u0116\3\2\2\2\u0459\u045b\5\u0129\u0095\2\u045a\u0459"+
		"\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u045a\3\2\2\2\u045c\u045d\3\2\2\2\u045d"+
		"\u045e\3\2\2\2\u045e\u045f\t\4\2\2\u045f\u0118\3\2\2\2\u0460\u0462\5\u0129"+
		"\u0095\2\u0461\u0460\3\2\2\2\u0462\u0463\3\2\2\2\u0463\u0461\3\2\2\2\u0463"+
		"\u0464\3\2\2\2\u0464\u011a\3\2\2\2\u0465\u0467\5\u0129\u0095\2\u0466\u0465"+
		"\3\2\2\2\u0467\u0468\3\2\2\2\u0468\u0466\3\2\2\2\u0468\u0469\3\2\2\2\u0469"+
		"\u046a\3\2\2\2\u046a\u046b\5\u0127\u0094\2\u046b\u0473\3\2\2\2\u046c\u046e"+
		"\5\u0125\u0093\2\u046d\u046f\5\u0127\u0094\2\u046e\u046d\3\2\2\2\u046e"+
		"\u046f\3\2\2\2\u046f\u0470\3\2\2\2\u0470\u0471\6\u008e\2\2\u0471\u0473"+
		"\3\2\2\2\u0472\u0466\3\2\2\2\u0472\u046c\3\2\2\2\u0473\u011c\3\2\2\2\u0474"+
		"\u0476\5\u0129\u0095\2\u0475\u0474\3\2\2\2\u0476\u0477\3\2\2\2\u0477\u0475"+
		"\3\2\2\2\u0477\u0478\3\2\2\2\u0478\u047a\3\2\2\2\u0479\u047b\5\u0127\u0094"+
		"\2\u047a\u0479\3\2\2\2\u047a\u047b\3\2\2\2\u047b\u047c\3\2\2\2\u047c\u047d"+
		"\7F\2\2\u047d\u0486\3\2\2\2\u047e\u0480\5\u0125\u0093\2\u047f\u0481\5"+
		"\u0127\u0094\2\u0480\u047f\3\2\2\2\u0480\u0481\3\2\2\2\u0481\u0482\3\2"+
		"\2\2\u0482\u0483\7F\2\2\u0483\u0484\6\u008f\3\2\u0484\u0486\3\2\2\2\u0485"+
		"\u0475\3\2\2\2\u0485\u047e\3\2\2\2\u0486\u011e\3\2\2\2\u0487\u0489\5\u0129"+
		"\u0095\2\u0488\u0487\3\2\2\2\u0489\u048a\3\2\2\2\u048a\u0488\3\2\2\2\u048a"+
		"\u048b\3\2\2\2\u048b\u048d\3\2\2\2\u048c\u048e\5\u0127\u0094\2\u048d\u048c"+
		"\3\2\2\2\u048d\u048e\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u0490\7D\2\2\u0490"+
		"\u0491\7F\2\2\u0491\u049c\3\2\2\2\u0492\u0494\5\u0125\u0093\2\u0493\u0495"+
		"\5\u0127\u0094\2\u0494\u0493\3\2\2\2\u0494\u0495\3\2\2\2\u0495\u0496\3"+
		"\2\2\2\u0496\u0497\7D\2\2\u0497\u0498\7F\2\2\u0498\u0499\3\2\2\2\u0499"+
		"\u049a\6\u0090\4\2\u049a\u049c\3\2\2\2\u049b\u0488\3\2\2\2\u049b\u0492"+
		"\3\2\2\2\u049c\u0120\3\2\2\2\u049d\u04a1\5\u012b\u0096\2\u049e\u04a1\5"+
		"\u0129\u0095\2\u049f\u04a1\7a\2\2\u04a0\u049d\3\2\2\2\u04a0\u049e\3\2"+
		"\2\2\u04a0\u049f\3\2\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04a0\3\2\2\2\u04a2"+
		"\u04a3\3\2\2\2\u04a3\u0122\3\2\2\2\u04a4\u04aa\7b\2\2\u04a5\u04a9\n\5"+
		"\2\2\u04a6\u04a7\7b\2\2\u04a7\u04a9\7b\2\2\u04a8\u04a5\3\2\2\2\u04a8\u04a6"+
		"\3\2\2\2\u04a9\u04ac\3\2\2\2\u04aa\u04a8\3\2\2\2\u04aa\u04ab\3\2\2\2\u04ab"+
		"\u04ad\3\2\2\2\u04ac\u04aa\3\2\2\2\u04ad\u04ae\7b\2\2\u04ae\u0124\3\2"+
		"\2\2\u04af\u04b1\5\u0129\u0095\2\u04b0\u04af\3\2\2\2\u04b1\u04b2\3\2\2"+
		"\2\u04b2\u04b0\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3\u04b4\3\2\2\2\u04b4\u04b8"+
		"\7\60\2\2\u04b5\u04b7\5\u0129\u0095\2\u04b6\u04b5\3\2\2\2\u04b7\u04ba"+
		"\3\2\2\2\u04b8\u04b6\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04c2\3\2\2\2\u04ba"+
		"\u04b8\3\2\2\2\u04bb\u04bd\7\60\2\2\u04bc\u04be\5\u0129\u0095\2\u04bd"+
		"\u04bc\3\2\2\2\u04be\u04bf\3\2\2\2\u04bf\u04bd\3\2\2\2\u04bf\u04c0\3\2"+
		"\2\2\u04c0\u04c2\3\2\2\2\u04c1\u04b0\3\2\2\2\u04c1\u04bb\3\2\2\2\u04c2"+
		"\u0126\3\2\2\2\u04c3\u04c5\7G\2\2\u04c4\u04c6\t\6\2\2\u04c5\u04c4\3\2"+
		"\2\2\u04c5\u04c6\3\2\2\2\u04c6\u04c8\3\2\2\2\u04c7\u04c9\5\u0129\u0095"+
		"\2\u04c8\u04c7\3\2\2\2\u04c9\u04ca\3\2\2\2\u04ca\u04c8\3\2\2\2\u04ca\u04cb"+
		"\3\2\2\2\u04cb\u0128\3\2\2\2\u04cc\u04cd\t\7\2\2\u04cd\u012a\3\2\2\2\u04ce"+
		"\u04cf\t\b\2\2\u04cf\u012c\3\2\2\2\u04d0\u04d1\7/\2\2\u04d1\u04d2\7/\2"+
		"\2\u04d2\u04d6\3\2\2\2\u04d3\u04d5\n\t\2\2\u04d4\u04d3\3\2\2\2\u04d5\u04d8"+
		"\3\2\2\2\u04d6\u04d4\3\2\2\2\u04d6\u04d7\3\2\2\2\u04d7\u04da\3\2\2\2\u04d8"+
		"\u04d6\3\2\2\2\u04d9\u04db\7\17\2\2\u04da\u04d9\3\2\2\2\u04da\u04db\3"+
		"\2\2\2\u04db\u04dd\3\2\2\2\u04dc\u04de\7\f\2\2\u04dd\u04dc\3\2\2\2\u04dd"+
		"\u04de\3\2\2\2\u04de\u04df\3\2\2\2\u04df\u04e0\b\u0097\2\2\u04e0\u012e"+
		"\3\2\2\2\u04e1\u04e2\7\61\2\2\u04e2\u04e3\7,\2\2\u04e3\u04e4\7,\2\2\u04e4"+
		"\u04e5\7\61\2\2\u04e5\u04e6\3\2\2\2\u04e6\u04e7\b\u0098\2\2\u04e7\u0130"+
		"\3\2\2\2\u04e8\u04e9\7\61\2\2\u04e9\u04ea\7,\2\2\u04ea\u04eb\3\2\2\2\u04eb"+
		"\u04ef\n\n\2\2\u04ec\u04ee\13\2\2\2\u04ed\u04ec\3\2\2\2\u04ee\u04f1\3"+
		"\2\2\2\u04ef\u04f0\3\2\2\2\u04ef\u04ed\3\2\2\2\u04f0\u04f2\3\2\2\2\u04f1"+
		"\u04ef\3\2\2\2\u04f2\u04f3\7,\2\2\u04f3\u04f4\7\61\2\2\u04f4\u04f5\3\2"+
		"\2\2\u04f5\u04f6\b\u0099\2\2\u04f6\u0132\3\2\2\2\u04f7\u04f9\t\13\2\2"+
		"\u04f8\u04f7\3\2\2\2\u04f9\u04fa\3\2\2\2\u04fa\u04f8\3\2\2\2\u04fa\u04fb"+
		"\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc\u04fd\b\u009a\2\2\u04fd\u0134\3\2\2"+
		"\2\u04fe\u04ff\13\2\2\2\u04ff\u0136\3\2\2\2.\2\u01b2\u01d6\u034c\u035e"+
		"\u0366\u03a4\u03b6\u0432\u0434\u043c\u043e\u0442\u0447\u044e\u0455\u045c"+
		"\u0463\u0468\u046e\u0472\u0477\u047a\u0480\u0485\u048a\u048d\u0494\u049b"+
		"\u04a0\u04a2\u04a8\u04aa\u04b2\u04b8\u04bf\u04c1\u04c5\u04ca\u04d6\u04da"+
		"\u04dd\u04ef\u04fa\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}