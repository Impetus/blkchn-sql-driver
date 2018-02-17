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
		ROLLBACK=93, IGNORE=94, CALL=95, WITH=96, VERSION=97, ENDORSERS=98, ARGS=99, 
		ASSET=100, CHAINCODE=101, SMARTCONTRACT=102, STORAGE=103, TYPE=104, JSON=105, 
		CSV=106, FIELDS=107, RECORDS=108, DELIMITED=109, IF=110, EQ=111, NSEQ=112, 
		NEQ=113, NEQJ=114, LT=115, LTE=116, GT=117, GTE=118, PLUS=119, MINUS=120, 
		ASTERISK=121, SLASH=122, PERCENT=123, DIV=124, TILDE=125, AMPERSAND=126, 
		PIPE=127, HAT=128, PERCENTLIT=129, OUT=130, OF=131, FUNCTION=132, DATABASE=133, 
		DATABASES=134, TRUNCATE=135, ANALYZE=136, COMPUTE=137, LIST=138, REVOKE=139, 
		GRANT=140, EXPORT=141, IMPORT=142, LOAD=143, ROLE=144, ROLES=145, INDEX=146, 
		INDEXES=147, CURRENT_DATE=148, CURRENT_TIMESTAMP=149, STRING=150, BIGINT_LITERAL=151, 
		SMALLINT_LITERAL=152, TINYINT_LITERAL=153, BYTELENGTH_LITERAL=154, INTEGER_VALUE=155, 
		DECIMAL_VALUE=156, DOUBLE_LITERAL=157, BIGDECIMAL_LITERAL=158, IDENTIFIER=159, 
		ENDORSER=160, BACKQUOTED_IDENTIFIER=161, SIMPLE_COMMENT=162, BRACKETED_EMPTY_COMMENT=163, 
		BRACKETED_COMMENT=164, WS=165, UNRECOGNIZED=166;
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
		"CALL", "WITH", "VERSION", "ENDORSERS", "ARGS", "ASSET", "CHAINCODE", 
		"SMARTCONTRACT", "STORAGE", "TYPE", "JSON", "CSV", "FIELDS", "RECORDS", 
		"DELIMITED", "IF", "EQ", "NSEQ", "NEQ", "NEQJ", "LT", "LTE", "GT", "GTE", 
		"PLUS", "MINUS", "ASTERISK", "SLASH", "PERCENT", "DIV", "TILDE", "AMPERSAND", 
		"PIPE", "HAT", "PERCENTLIT", "OUT", "OF", "FUNCTION", "DATABASE", "DATABASES", 
		"TRUNCATE", "ANALYZE", "COMPUTE", "LIST", "REVOKE", "GRANT", "EXPORT", 
		"IMPORT", "LOAD", "ROLE", "ROLES", "INDEX", "INDEXES", "CURRENT_DATE", 
		"CURRENT_TIMESTAMP", "STRING", "BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", 
		"BYTELENGTH_LITERAL", "INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_LITERAL", 
		"BIGDECIMAL_LITERAL", "IDENTIFIER", "ENDORSER", "BACKQUOTED_IDENTIFIER", 
		"DECIMAL_DIGITS", "EXPONENT", "DIGIT", "LETTER", "SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", 
		"BRACKETED_COMMENT", "WS", "UNRECOGNIZED"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "','", "'.'", "'['", "']'", "':'", "'SELECT'", "'FROM'", 
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
		"'IGNORE'", "'CALL'", "'WITH'", "'VERSION'", "'ENDORSERS'", "'ARGS'", 
		"'ASSET'", "'CHAINCODE'", "'SMARTCONTRACT'", "'STORAGE'", "'TYPE'", "'JSON'", 
		"'CSV'", "'FIELDS'", "'RECORDS'", "'DELIMITED'", "'IF'", null, "'<=>'", 
		"'<>'", "'!='", "'<'", null, "'>'", null, "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'DIV'", "'~'", "'&'", "'|'", "'^'", "'PERCENT'", "'OUT'", "'OF'", 
		"'FUNCTION'", null, null, "'TRUNCATE'", "'ANALYZE'", "'COMPUTE'", "'LIST'", 
		"'REVOKE'", "'GRANT'", "'EXPORT'", "'IMPORT'", "'LOAD'", "'ROLE'", "'ROLES'", 
		"'INDEX'", "'INDEXES'", "'CURRENT_DATE'", "'CURRENT_TIMESTAMP'", null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"'/**/'"
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
		"CALL", "WITH", "VERSION", "ENDORSERS", "ARGS", "ASSET", "CHAINCODE", 
		"SMARTCONTRACT", "STORAGE", "TYPE", "JSON", "CSV", "FIELDS", "RECORDS", 
		"DELIMITED", "IF", "EQ", "NSEQ", "NEQ", "NEQJ", "LT", "LTE", "GT", "GTE", 
		"PLUS", "MINUS", "ASTERISK", "SLASH", "PERCENT", "DIV", "TILDE", "AMPERSAND", 
		"PIPE", "HAT", "PERCENTLIT", "OUT", "OF", "FUNCTION", "DATABASE", "DATABASES", 
		"TRUNCATE", "ANALYZE", "COMPUTE", "LIST", "REVOKE", "GRANT", "EXPORT", 
		"IMPORT", "LOAD", "ROLE", "ROLES", "INDEX", "INDEXES", "CURRENT_DATE", 
		"CURRENT_TIMESTAMP", "STRING", "BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", 
		"BYTELENGTH_LITERAL", "INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_LITERAL", 
		"BIGDECIMAL_LITERAL", "IDENTIFIER", "ENDORSER", "BACKQUOTED_IDENTIFIER", 
		"SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", "BRACKETED_COMMENT", "WS", 
		"UNRECOGNIZED"
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
		case 155:
			return DECIMAL_VALUE_sempred((RuleContext)_localctx, predIndex);
		case 156:
			return DOUBLE_LITERAL_sempred((RuleContext)_localctx, predIndex);
		case 157:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\u00a8\u0595\b\1\4"+
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
		"\t\u009b\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f"+
		"\4\u00a0\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4"+
		"\t\u00a4\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8"+
		"\4\u00a9\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\5\35\u01d3\n\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 "+
		"\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\5\"\u01f7\n\"\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&"+
		"\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*"+
		"\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3."+
		"\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\39\39\39\39\39\39"+
		"\3:\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3>\3>\3>"+
		"\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B"+
		"\3B\3B\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3D\3D\3E\3E"+
		"\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H"+
		"\3H\3H\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\3K\3K\3L"+
		"\3L\3L\3L\3L\3L\3L\3M\3M\3M\3M\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3O\3O\3O"+
		"\3O\3O\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3R\3S\3S"+
		"\3S\3S\3S\3S\3S\3S\3S\3S\3T\3T\3T\3U\3U\3U\3U\3U\3U\3V\3V\3V\3V\3V\3V"+
		"\3V\3W\3W\3W\3W\3W\3W\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z"+
		"\3Z\3Z\3Z\3[\3[\3[\3[\3\\\3\\\3\\\3\\\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\3^"+
		"\3^\3^\3^\3^\3^\3^\3^\3^\3_\3_\3_\3_\3_\3_\3_\3`\3`\3`\3`\3`\3a\3a\3a"+
		"\3a\3a\3b\3b\3b\3b\3b\3b\3b\3b\3c\3c\3c\3c\3c\3c\3c\3c\3c\3c\3d\3d\3d"+
		"\3d\3d\3e\3e\3e\3e\3e\3e\3f\3f\3f\3f\3f\3f\3f\3f\3f\3f\3g\3g\3g\3g\3g"+
		"\3g\3g\3g\3g\3g\3g\3g\3g\3g\3h\3h\3h\3h\3h\3h\3h\3h\3i\3i\3i\3i\3i\3j"+
		"\3j\3j\3j\3j\3k\3k\3k\3k\3l\3l\3l\3l\3l\3l\3l\3m\3m\3m\3m\3m\3m\3m\3m"+
		"\3n\3n\3n\3n\3n\3n\3n\3n\3n\3n\3o\3o\3o\3p\3p\3p\5p\u03db\np\3q\3q\3q"+
		"\3q\3r\3r\3r\3s\3s\3s\3t\3t\3u\3u\3u\3u\5u\u03ed\nu\3v\3v\3w\3w\3w\3w"+
		"\5w\u03f5\nw\3x\3x\3y\3y\3z\3z\3{\3{\3|\3|\3}\3}\3}\3}\3~\3~\3\177\3\177"+
		"\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082"+
		"\3\u0082\3\u0082\3\u0082\3\u0083\3\u0083\3\u0083\3\u0083\3\u0084\3\u0084"+
		"\3\u0084\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085"+
		"\3\u0085\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086"+
		"\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\5\u0086\u0433\n\u0086"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087"+
		"\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\5\u0087\u0445"+
		"\n\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088\3\u0088"+
		"\3\u0088\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008b"+
		"\3\u008b\3\u008b\3\u008b\3\u008b\3\u008c\3\u008c\3\u008c\3\u008c\3\u008c"+
		"\3\u008c\3\u008c\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d\3\u008e"+
		"\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008f\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\3\u008f\3\u008f\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090"+
		"\3\u0091\3\u0091\3\u0091\3\u0091\3\u0091\3\u0092\3\u0092\3\u0092\3\u0092"+
		"\3\u0092\3\u0092\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0094"+
		"\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0094\3\u0095\3\u0095"+
		"\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095"+
		"\3\u0095\3\u0095\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096"+
		"\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096"+
		"\3\u0096\3\u0096\3\u0097\3\u0097\3\u0097\3\u0097\7\u0097\u04c1\n\u0097"+
		"\f\u0097\16\u0097\u04c4\13\u0097\3\u0097\3\u0097\3\u0097\3\u0097\3\u0097"+
		"\7\u0097\u04cb\n\u0097\f\u0097\16\u0097\u04ce\13\u0097\3\u0097\5\u0097"+
		"\u04d1\n\u0097\3\u0098\6\u0098\u04d4\n\u0098\r\u0098\16\u0098\u04d5\3"+
		"\u0098\3\u0098\3\u0099\6\u0099\u04db\n\u0099\r\u0099\16\u0099\u04dc\3"+
		"\u0099\3\u0099\3\u009a\6\u009a\u04e2\n\u009a\r\u009a\16\u009a\u04e3\3"+
		"\u009a\3\u009a\3\u009b\6\u009b\u04e9\n\u009b\r\u009b\16\u009b\u04ea\3"+
		"\u009b\3\u009b\3\u009c\6\u009c\u04f0\n\u009c\r\u009c\16\u009c\u04f1\3"+
		"\u009d\6\u009d\u04f5\n\u009d\r\u009d\16\u009d\u04f6\3\u009d\3\u009d\3"+
		"\u009d\3\u009d\5\u009d\u04fd\n\u009d\3\u009d\3\u009d\5\u009d\u0501\n\u009d"+
		"\3\u009e\6\u009e\u0504\n\u009e\r\u009e\16\u009e\u0505\3\u009e\5\u009e"+
		"\u0509\n\u009e\3\u009e\3\u009e\3\u009e\3\u009e\5\u009e\u050f\n\u009e\3"+
		"\u009e\3\u009e\3\u009e\5\u009e\u0514\n\u009e\3\u009f\6\u009f\u0517\n\u009f"+
		"\r\u009f\16\u009f\u0518\3\u009f\5\u009f\u051c\n\u009f\3\u009f\3\u009f"+
		"\3\u009f\3\u009f\3\u009f\5\u009f\u0523\n\u009f\3\u009f\3\u009f\3\u009f"+
		"\3\u009f\3\u009f\5\u009f\u052a\n\u009f\3\u00a0\3\u00a0\3\u00a0\6\u00a0"+
		"\u052f\n\u00a0\r\u00a0\16\u00a0\u0530\3\u00a1\3\u00a1\3\u00a1\6\u00a1"+
		"\u0536\n\u00a1\r\u00a1\16\u00a1\u0537\3\u00a2\3\u00a2\3\u00a2\3\u00a2"+
		"\7\u00a2\u053e\n\u00a2\f\u00a2\16\u00a2\u0541\13\u00a2\3\u00a2\3\u00a2"+
		"\3\u00a3\6\u00a3\u0546\n\u00a3\r\u00a3\16\u00a3\u0547\3\u00a3\3\u00a3"+
		"\7\u00a3\u054c\n\u00a3\f\u00a3\16\u00a3\u054f\13\u00a3\3\u00a3\3\u00a3"+
		"\6\u00a3\u0553\n\u00a3\r\u00a3\16\u00a3\u0554\5\u00a3\u0557\n\u00a3\3"+
		"\u00a4\3\u00a4\5\u00a4\u055b\n\u00a4\3\u00a4\6\u00a4\u055e\n\u00a4\r\u00a4"+
		"\16\u00a4\u055f\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a7\3\u00a7\3\u00a7"+
		"\3\u00a7\7\u00a7\u056a\n\u00a7\f\u00a7\16\u00a7\u056d\13\u00a7\3\u00a7"+
		"\5\u00a7\u0570\n\u00a7\3\u00a7\5\u00a7\u0573\n\u00a7\3\u00a7\3\u00a7\3"+
		"\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9"+
		"\3\u00a9\3\u00a9\3\u00a9\7\u00a9\u0583\n\u00a9\f\u00a9\16\u00a9\u0586"+
		"\13\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00a9\3\u00aa\6\u00aa\u058e"+
		"\n\u00aa\r\u00aa\16\u00aa\u058f\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u0584"+
		"\2\u00ac\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66"+
		"k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG"+
		"\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009dP\u009f"+
		"Q\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00adX\u00afY\u00b1Z\u00b3"+
		"[\u00b5\\\u00b7]\u00b9^\u00bb_\u00bd`\u00bfa\u00c1b\u00c3c\u00c5d\u00c7"+
		"e\u00c9f\u00cbg\u00cdh\u00cfi\u00d1j\u00d3k\u00d5l\u00d7m\u00d9n\u00db"+
		"o\u00ddp\u00dfq\u00e1r\u00e3s\u00e5t\u00e7u\u00e9v\u00ebw\u00edx\u00ef"+
		"y\u00f1z\u00f3{\u00f5|\u00f7}\u00f9~\u00fb\177\u00fd\u0080\u00ff\u0081"+
		"\u0101\u0082\u0103\u0083\u0105\u0084\u0107\u0085\u0109\u0086\u010b\u0087"+
		"\u010d\u0088\u010f\u0089\u0111\u008a\u0113\u008b\u0115\u008c\u0117\u008d"+
		"\u0119\u008e\u011b\u008f\u011d\u0090\u011f\u0091\u0121\u0092\u0123\u0093"+
		"\u0125\u0094\u0127\u0095\u0129\u0096\u012b\u0097\u012d\u0098\u012f\u0099"+
		"\u0131\u009a\u0133\u009b\u0135\u009c\u0137\u009d\u0139\u009e\u013b\u009f"+
		"\u013d\u00a0\u013f\u00a1\u0141\u00a2\u0143\u00a3\u0145\2\u0147\2\u0149"+
		"\2\u014b\2\u014d\u00a4\u014f\u00a5\u0151\u00a6\u0153\u00a7\u0155\u00a8"+
		"\3\2\f\4\2))^^\4\2$$^^\6\2DDIIMMOO\3\2bb\4\2--//\3\2\62;\3\2C\\\4\2\f"+
		"\f\17\17\3\2--\5\2\13\f\17\17\"\"\u05bf\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3"+
		"\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3"+
		"\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2"+
		"\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3"+
		"\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2"+
		"\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5"+
		"\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2"+
		"\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7"+
		"\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2"+
		"\2\2\u00d1\3\2\2\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2\2\2\u00d9"+
		"\3\2\2\2\2\u00db\3\2\2\2\2\u00dd\3\2\2\2\2\u00df\3\2\2\2\2\u00e1\3\2\2"+
		"\2\2\u00e3\3\2\2\2\2\u00e5\3\2\2\2\2\u00e7\3\2\2\2\2\u00e9\3\2\2\2\2\u00eb"+
		"\3\2\2\2\2\u00ed\3\2\2\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2\2\2\u00f3\3\2\2"+
		"\2\2\u00f5\3\2\2\2\2\u00f7\3\2\2\2\2\u00f9\3\2\2\2\2\u00fb\3\2\2\2\2\u00fd"+
		"\3\2\2\2\2\u00ff\3\2\2\2\2\u0101\3\2\2\2\2\u0103\3\2\2\2\2\u0105\3\2\2"+
		"\2\2\u0107\3\2\2\2\2\u0109\3\2\2\2\2\u010b\3\2\2\2\2\u010d\3\2\2\2\2\u010f"+
		"\3\2\2\2\2\u0111\3\2\2\2\2\u0113\3\2\2\2\2\u0115\3\2\2\2\2\u0117\3\2\2"+
		"\2\2\u0119\3\2\2\2\2\u011b\3\2\2\2\2\u011d\3\2\2\2\2\u011f\3\2\2\2\2\u0121"+
		"\3\2\2\2\2\u0123\3\2\2\2\2\u0125\3\2\2\2\2\u0127\3\2\2\2\2\u0129\3\2\2"+
		"\2\2\u012b\3\2\2\2\2\u012d\3\2\2\2\2\u012f\3\2\2\2\2\u0131\3\2\2\2\2\u0133"+
		"\3\2\2\2\2\u0135\3\2\2\2\2\u0137\3\2\2\2\2\u0139\3\2\2\2\2\u013b\3\2\2"+
		"\2\2\u013d\3\2\2\2\2\u013f\3\2\2\2\2\u0141\3\2\2\2\2\u0143\3\2\2\2\2\u014d"+
		"\3\2\2\2\2\u014f\3\2\2\2\2\u0151\3\2\2\2\2\u0153\3\2\2\2\2\u0155\3\2\2"+
		"\2\3\u0157\3\2\2\2\5\u0159\3\2\2\2\7\u015b\3\2\2\2\t\u015d\3\2\2\2\13"+
		"\u015f\3\2\2\2\r\u0161\3\2\2\2\17\u0163\3\2\2\2\21\u0165\3\2\2\2\23\u016c"+
		"\3\2\2\2\25\u0171\3\2\2\2\27\u0175\3\2\2\2\31\u0178\3\2\2\2\33\u017c\3"+
		"\2\2\2\35\u0185\3\2\2\2\37\u018b\3\2\2\2!\u0191\3\2\2\2#\u0194\3\2\2\2"+
		"%\u019d\3\2\2\2\'\u01a2\3\2\2\2)\u01a7\3\2\2\2+\u01ae\3\2\2\2-\u01b4\3"+
		"\2\2\2/\u01bb\3\2\2\2\61\u01c1\3\2\2\2\63\u01c4\3\2\2\2\65\u01c7\3\2\2"+
		"\2\67\u01cb\3\2\2\29\u01d2\3\2\2\2;\u01d4\3\2\2\2=\u01d7\3\2\2\2?\u01de"+
		"\3\2\2\2A\u01e6\3\2\2\2C\u01f6\3\2\2\2E\u01f8\3\2\2\2G\u01fb\3\2\2\2I"+
		"\u0200\3\2\2\2K\u0205\3\2\2\2M\u020b\3\2\2\2O\u0211\3\2\2\2Q\u0215\3\2"+
		"\2\2S\u021a\3\2\2\2U\u021e\3\2\2\2W\u0227\3\2\2\2Y\u022c\3\2\2\2[\u0231"+
		"\3\2\2\2]\u0236\3\2\2\2_\u023b\3\2\2\2a\u023f\3\2\2\2c\u0244\3\2\2\2e"+
		"\u024a\3\2\2\2g\u0250\3\2\2\2i\u0256\3\2\2\2k\u025b\3\2\2\2m\u0260\3\2"+
		"\2\2o\u0266\3\2\2\2q\u026b\3\2\2\2s\u0273\3\2\2\2u\u0276\3\2\2\2w\u027c"+
		"\3\2\2\2y\u0282\3\2\2\2{\u0287\3\2\2\2}\u028e\3\2\2\2\177\u0295\3\2\2"+
		"\2\u0081\u029b\3\2\2\2\u0083\u02a0\3\2\2\2\u0085\u02a8\3\2\2\2\u0087\u02af"+
		"\3\2\2\2\u0089\u02b6\3\2\2\2\u008b\u02bb\3\2\2\2\u008d\u02c4\3\2\2\2\u008f"+
		"\u02cc\3\2\2\2\u0091\u02d1\3\2\2\2\u0093\u02d6\3\2\2\2\u0095\u02dd\3\2"+
		"\2\2\u0097\u02e5\3\2\2\2\u0099\u02ec\3\2\2\2\u009b\u02f0\3\2\2\2\u009d"+
		"\u02fa\3\2\2\2\u009f\u02ff\3\2\2\2\u00a1\u0305\3\2\2\2\u00a3\u030c\3\2"+
		"\2\2\u00a5\u0312\3\2\2\2\u00a7\u031c\3\2\2\2\u00a9\u031f\3\2\2\2\u00ab"+
		"\u0325\3\2\2\2\u00ad\u032c\3\2\2\2\u00af\u0332\3\2\2\2\u00b1\u0336\3\2"+
		"\2\2\u00b3\u033d\3\2\2\2\u00b5\u0345\3\2\2\2\u00b7\u0349\3\2\2\2\u00b9"+
		"\u034f\3\2\2\2\u00bb\u0356\3\2\2\2\u00bd\u035f\3\2\2\2\u00bf\u0366\3\2"+
		"\2\2\u00c1\u036b\3\2\2\2\u00c3\u0370\3\2\2\2\u00c5\u0378\3\2\2\2\u00c7"+
		"\u0382\3\2\2\2\u00c9\u0387\3\2\2\2\u00cb\u038d\3\2\2\2\u00cd\u0397\3\2"+
		"\2\2\u00cf\u03a5\3\2\2\2\u00d1\u03ad\3\2\2\2\u00d3\u03b2\3\2\2\2\u00d5"+
		"\u03b7\3\2\2\2\u00d7\u03bb\3\2\2\2\u00d9\u03c2\3\2\2\2\u00db\u03ca\3\2"+
		"\2\2\u00dd\u03d4\3\2\2\2\u00df\u03da\3\2\2\2\u00e1\u03dc\3\2\2\2\u00e3"+
		"\u03e0\3\2\2\2\u00e5\u03e3\3\2\2\2\u00e7\u03e6\3\2\2\2\u00e9\u03ec\3\2"+
		"\2\2\u00eb\u03ee\3\2\2\2\u00ed\u03f4\3\2\2\2\u00ef\u03f6\3\2\2\2\u00f1"+
		"\u03f8\3\2\2\2\u00f3\u03fa\3\2\2\2\u00f5\u03fc\3\2\2\2\u00f7\u03fe\3\2"+
		"\2\2\u00f9\u0400\3\2\2\2\u00fb\u0404\3\2\2\2\u00fd\u0406\3\2\2\2\u00ff"+
		"\u0408\3\2\2\2\u0101\u040a\3\2\2\2\u0103\u040c\3\2\2\2\u0105\u0414\3\2"+
		"\2\2\u0107\u0418\3\2\2\2\u0109\u041b\3\2\2\2\u010b\u0432\3\2\2\2\u010d"+
		"\u0444\3\2\2\2\u010f\u0446\3\2\2\2\u0111\u044f\3\2\2\2\u0113\u0457\3\2"+
		"\2\2\u0115\u045f\3\2\2\2\u0117\u0464\3\2\2\2\u0119\u046b\3\2\2\2\u011b"+
		"\u0471\3\2\2\2\u011d\u0478\3\2\2\2\u011f\u047f\3\2\2\2\u0121\u0484\3\2"+
		"\2\2\u0123\u0489\3\2\2\2\u0125\u048f\3\2\2\2\u0127\u0495\3\2\2\2\u0129"+
		"\u049d\3\2\2\2\u012b\u04aa\3\2\2\2\u012d\u04d0\3\2\2\2\u012f\u04d3\3\2"+
		"\2\2\u0131\u04da\3\2\2\2\u0133\u04e1\3\2\2\2\u0135\u04e8\3\2\2\2\u0137"+
		"\u04ef\3\2\2\2\u0139\u0500\3\2\2\2\u013b\u0513\3\2\2\2\u013d\u0529\3\2"+
		"\2\2\u013f\u052e\3\2\2\2\u0141\u0535\3\2\2\2\u0143\u0539\3\2\2\2\u0145"+
		"\u0556\3\2\2\2\u0147\u0558\3\2\2\2\u0149\u0561\3\2\2\2\u014b\u0563\3\2"+
		"\2\2\u014d\u0565\3\2\2\2\u014f\u0576\3\2\2\2\u0151\u057d\3\2\2\2\u0153"+
		"\u058d\3\2\2\2\u0155\u0593\3\2\2\2\u0157\u0158\7*\2\2\u0158\4\3\2\2\2"+
		"\u0159\u015a\7+\2\2\u015a\6\3\2\2\2\u015b\u015c\7.\2\2\u015c\b\3\2\2\2"+
		"\u015d\u015e\7\60\2\2\u015e\n\3\2\2\2\u015f\u0160\7]\2\2\u0160\f\3\2\2"+
		"\2\u0161\u0162\7_\2\2\u0162\16\3\2\2\2\u0163\u0164\7<\2\2\u0164\20\3\2"+
		"\2\2\u0165\u0166\7U\2\2\u0166\u0167\7G\2\2\u0167\u0168\7N\2\2\u0168\u0169"+
		"\7G\2\2\u0169\u016a\7E\2\2\u016a\u016b\7V\2\2\u016b\22\3\2\2\2\u016c\u016d"+
		"\7H\2\2\u016d\u016e\7T\2\2\u016e\u016f\7Q\2\2\u016f\u0170\7O\2\2\u0170"+
		"\24\3\2\2\2\u0171\u0172\7C\2\2\u0172\u0173\7F\2\2\u0173\u0174\7F\2\2\u0174"+
		"\26\3\2\2\2\u0175\u0176\7C\2\2\u0176\u0177\7U\2\2\u0177\30\3\2\2\2\u0178"+
		"\u0179\7C\2\2\u0179\u017a\7N\2\2\u017a\u017b\7N\2\2\u017b\32\3\2\2\2\u017c"+
		"\u017d\7F\2\2\u017d\u017e\7K\2\2\u017e\u017f\7U\2\2\u017f\u0180\7V\2\2"+
		"\u0180\u0181\7K\2\2\u0181\u0182\7P\2\2\u0182\u0183\7E\2\2\u0183\u0184"+
		"\7V\2\2\u0184\34\3\2\2\2\u0185\u0186\7Y\2\2\u0186\u0187\7J\2\2\u0187\u0188"+
		"\7G\2\2\u0188\u0189\7T\2\2\u0189\u018a\7G\2\2\u018a\36\3\2\2\2\u018b\u018c"+
		"\7I\2\2\u018c\u018d\7T\2\2\u018d\u018e\7Q\2\2\u018e\u018f\7W\2\2\u018f"+
		"\u0190\7R\2\2\u0190 \3\2\2\2\u0191\u0192\7D\2\2\u0192\u0193\7[\2\2\u0193"+
		"\"\3\2\2\2\u0194\u0195\7I\2\2\u0195\u0196\7T\2\2\u0196\u0197\7Q\2\2\u0197"+
		"\u0198\7W\2\2\u0198\u0199\7R\2\2\u0199\u019a\7K\2\2\u019a\u019b\7P\2\2"+
		"\u019b\u019c\7I\2\2\u019c$\3\2\2\2\u019d\u019e\7U\2\2\u019e\u019f\7G\2"+
		"\2\u019f\u01a0\7V\2\2\u01a0\u01a1\7U\2\2\u01a1&\3\2\2\2\u01a2\u01a3\7"+
		"E\2\2\u01a3\u01a4\7W\2\2\u01a4\u01a5\7D\2\2\u01a5\u01a6\7G\2\2\u01a6("+
		"\3\2\2\2\u01a7\u01a8\7T\2\2\u01a8\u01a9\7Q\2\2\u01a9\u01aa\7N\2\2\u01aa"+
		"\u01ab\7N\2\2\u01ab\u01ac\7W\2\2\u01ac\u01ad\7R\2\2\u01ad*\3\2\2\2\u01ae"+
		"\u01af\7Q\2\2\u01af\u01b0\7T\2\2\u01b0\u01b1\7F\2\2\u01b1\u01b2\7G\2\2"+
		"\u01b2\u01b3\7T\2\2\u01b3,\3\2\2\2\u01b4\u01b5\7J\2\2\u01b5\u01b6\7C\2"+
		"\2\u01b6\u01b7\7X\2\2\u01b7\u01b8\7K\2\2\u01b8\u01b9\7P\2\2\u01b9\u01ba"+
		"\7I\2\2\u01ba.\3\2\2\2\u01bb\u01bc\7N\2\2\u01bc\u01bd\7K\2\2\u01bd\u01be"+
		"\7O\2\2\u01be\u01bf\7K\2\2\u01bf\u01c0\7V\2\2\u01c0\60\3\2\2\2\u01c1\u01c2"+
		"\7C\2\2\u01c2\u01c3\7V\2\2\u01c3\62\3\2\2\2\u01c4\u01c5\7Q\2\2\u01c5\u01c6"+
		"\7T\2\2\u01c6\64\3\2\2\2\u01c7\u01c8\7C\2\2\u01c8\u01c9\7P\2\2\u01c9\u01ca"+
		"\7F\2\2\u01ca\66\3\2\2\2\u01cb\u01cc\7K\2\2\u01cc\u01cd\7P\2\2\u01cd8"+
		"\3\2\2\2\u01ce\u01cf\7P\2\2\u01cf\u01d0\7Q\2\2\u01d0\u01d3\7V\2\2\u01d1"+
		"\u01d3\7#\2\2\u01d2\u01ce\3\2\2\2\u01d2\u01d1\3\2\2\2\u01d3:\3\2\2\2\u01d4"+
		"\u01d5\7P\2\2\u01d5\u01d6\7Q\2\2\u01d6<\3\2\2\2\u01d7\u01d8\7G\2\2\u01d8"+
		"\u01d9\7Z\2\2\u01d9\u01da\7K\2\2\u01da\u01db\7U\2\2\u01db\u01dc\7V\2\2"+
		"\u01dc\u01dd\7U\2\2\u01dd>\3\2\2\2\u01de\u01df\7D\2\2\u01df\u01e0\7G\2"+
		"\2\u01e0\u01e1\7V\2\2\u01e1\u01e2\7Y\2\2\u01e2\u01e3\7G\2\2\u01e3\u01e4"+
		"\7G\2\2\u01e4\u01e5\7P\2\2\u01e5@\3\2\2\2\u01e6\u01e7\7N\2\2\u01e7\u01e8"+
		"\7K\2\2\u01e8\u01e9\7M\2\2\u01e9\u01ea\7G\2\2\u01eaB\3\2\2\2\u01eb\u01ec"+
		"\7T\2\2\u01ec\u01ed\7N\2\2\u01ed\u01ee\7K\2\2\u01ee\u01ef\7M\2\2\u01ef"+
		"\u01f7\7G\2\2\u01f0\u01f1\7T\2\2\u01f1\u01f2\7G\2\2\u01f2\u01f3\7I\2\2"+
		"\u01f3\u01f4\7G\2\2\u01f4\u01f5\7Z\2\2\u01f5\u01f7\7R\2\2\u01f6\u01eb"+
		"\3\2\2\2\u01f6\u01f0\3\2\2\2\u01f7D\3\2\2\2\u01f8\u01f9\7K\2\2\u01f9\u01fa"+
		"\7U\2\2\u01faF\3\2\2\2\u01fb\u01fc\7P\2\2\u01fc\u01fd\7W\2\2\u01fd\u01fe"+
		"\7N\2\2\u01fe\u01ff\7N\2\2\u01ffH\3\2\2\2\u0200\u0201\7V\2\2\u0201\u0202"+
		"\7T\2\2\u0202\u0203\7W\2\2\u0203\u0204\7G\2\2\u0204J\3\2\2\2\u0205\u0206"+
		"\7H\2\2\u0206\u0207\7C\2\2\u0207\u0208\7N\2\2\u0208\u0209\7U\2\2\u0209"+
		"\u020a\7G\2\2\u020aL\3\2\2\2\u020b\u020c\7P\2\2\u020c\u020d\7W\2\2\u020d"+
		"\u020e\7N\2\2\u020e\u020f\7N\2\2\u020f\u0210\7U\2\2\u0210N\3\2\2\2\u0211"+
		"\u0212\7C\2\2\u0212\u0213\7U\2\2\u0213\u0214\7E\2\2\u0214P\3\2\2\2\u0215"+
		"\u0216\7F\2\2\u0216\u0217\7G\2\2\u0217\u0218\7U\2\2\u0218\u0219\7E\2\2"+
		"\u0219R\3\2\2\2\u021a\u021b\7H\2\2\u021b\u021c\7Q\2\2\u021c\u021d\7T\2"+
		"\2\u021dT\3\2\2\2\u021e\u021f\7K\2\2\u021f\u0220\7P\2\2\u0220\u0221\7"+
		"V\2\2\u0221\u0222\7G\2\2\u0222\u0223\7T\2\2\u0223\u0224\7X\2\2\u0224\u0225"+
		"\7C\2\2\u0225\u0226\7N\2\2\u0226V\3\2\2\2\u0227\u0228\7E\2\2\u0228\u0229"+
		"\7C\2\2\u0229\u022a\7U\2\2\u022a\u022b\7G\2\2\u022bX\3\2\2\2\u022c\u022d"+
		"\7Y\2\2\u022d\u022e\7J\2\2\u022e\u022f\7G\2\2\u022f\u0230\7P\2\2\u0230"+
		"Z\3\2\2\2\u0231\u0232\7V\2\2\u0232\u0233\7J\2\2\u0233\u0234\7G\2\2\u0234"+
		"\u0235\7P\2\2\u0235\\\3\2\2\2\u0236\u0237\7G\2\2\u0237\u0238\7N\2\2\u0238"+
		"\u0239\7U\2\2\u0239\u023a\7G\2\2\u023a^\3\2\2\2\u023b\u023c\7G\2\2\u023c"+
		"\u023d\7P\2\2\u023d\u023e\7F\2\2\u023e`\3\2\2\2\u023f\u0240\7L\2\2\u0240"+
		"\u0241\7Q\2\2\u0241\u0242\7K\2\2\u0242\u0243\7P\2\2\u0243b\3\2\2\2\u0244"+
		"\u0245\7E\2\2\u0245\u0246\7T\2\2\u0246\u0247\7Q\2\2\u0247\u0248\7U\2\2"+
		"\u0248\u0249\7U\2\2\u0249d\3\2\2\2\u024a\u024b\7Q\2\2\u024b\u024c\7W\2"+
		"\2\u024c\u024d\7V\2\2\u024d\u024e\7G\2\2\u024e\u024f\7T\2\2\u024ff\3\2"+
		"\2\2\u0250\u0251\7K\2\2\u0251\u0252\7P\2\2\u0252\u0253\7P\2\2\u0253\u0254"+
		"\7G\2\2\u0254\u0255\7T\2\2\u0255h\3\2\2\2\u0256\u0257\7N\2\2\u0257\u0258"+
		"\7G\2\2\u0258\u0259\7H\2\2\u0259\u025a\7V\2\2\u025aj\3\2\2\2\u025b\u025c"+
		"\7U\2\2\u025c\u025d\7G\2\2\u025d\u025e\7O\2\2\u025e\u025f\7K\2\2\u025f"+
		"l\3\2\2\2\u0260\u0261\7T\2\2\u0261\u0262\7K\2\2\u0262\u0263\7I\2\2\u0263"+
		"\u0264\7J\2\2\u0264\u0265\7V\2\2\u0265n\3\2\2\2\u0266\u0267\7H\2\2\u0267"+
		"\u0268\7W\2\2\u0268\u0269\7N\2\2\u0269\u026a\7N\2\2\u026ap\3\2\2\2\u026b"+
		"\u026c\7P\2\2\u026c\u026d\7C\2\2\u026d\u026e\7V\2\2\u026e\u026f\7W\2\2"+
		"\u026f\u0270\7T\2\2\u0270\u0271\7C\2\2\u0271\u0272\7N\2\2\u0272r\3\2\2"+
		"\2\u0273\u0274\7Q\2\2\u0274\u0275\7P\2\2\u0275t\3\2\2\2\u0276\u0277\7"+
		"H\2\2\u0277\u0278\7K\2\2\u0278\u0279\7T\2\2\u0279\u027a\7U\2\2\u027a\u027b"+
		"\7V\2\2\u027bv\3\2\2\2\u027c\u027d\7C\2\2\u027d\u027e\7H\2\2\u027e\u027f"+
		"\7V\2\2\u027f\u0280\7G\2\2\u0280\u0281\7T\2\2\u0281x\3\2\2\2\u0282\u0283"+
		"\7N\2\2\u0283\u0284\7C\2\2\u0284\u0285\7U\2\2\u0285\u0286\7V\2\2\u0286"+
		"z\3\2\2\2\u0287\u0288\7X\2\2\u0288\u0289\7C\2\2\u0289\u028a\7N\2\2\u028a"+
		"\u028b\7W\2\2\u028b\u028c\7G\2\2\u028c\u028d\7U\2\2\u028d|\3\2\2\2\u028e"+
		"\u028f\7E\2\2\u028f\u0290\7T\2\2\u0290\u0291\7G\2\2\u0291\u0292\7C\2\2"+
		"\u0292\u0293\7V\2\2\u0293\u0294\7G\2\2\u0294~\3\2\2\2\u0295\u0296\7V\2"+
		"\2\u0296\u0297\7C\2\2\u0297\u0298\7D\2\2\u0298\u0299\7N\2\2\u0299\u029a"+
		"\7G\2\2\u029a\u0080\3\2\2\2\u029b\u029c\7X\2\2\u029c\u029d\7K\2\2\u029d"+
		"\u029e\7G\2\2\u029e\u029f\7Y\2\2\u029f\u0082\3\2\2\2\u02a0\u02a1\7T\2"+
		"\2\u02a1\u02a2\7G\2\2\u02a2\u02a3\7R\2\2\u02a3\u02a4\7N\2\2\u02a4\u02a5"+
		"\7C\2\2\u02a5\u02a6\7E\2\2\u02a6\u02a7\7G\2\2\u02a7\u0084\3\2\2\2\u02a8"+
		"\u02a9\7K\2\2\u02a9\u02aa\7P\2\2\u02aa\u02ab\7U\2\2\u02ab\u02ac\7G\2\2"+
		"\u02ac\u02ad\7T\2\2\u02ad\u02ae\7V\2\2\u02ae\u0086\3\2\2\2\u02af\u02b0"+
		"\7F\2\2\u02b0\u02b1\7G\2\2\u02b1\u02b2\7N\2\2\u02b2\u02b3\7G\2\2\u02b3"+
		"\u02b4\7V\2\2\u02b4\u02b5\7G\2\2\u02b5\u0088\3\2\2\2\u02b6\u02b7\7K\2"+
		"\2\u02b7\u02b8\7P\2\2\u02b8\u02b9\7V\2\2\u02b9\u02ba\7Q\2\2\u02ba\u008a"+
		"\3\2\2\2\u02bb\u02bc\7F\2\2\u02bc\u02bd\7G\2\2\u02bd\u02be\7U\2\2\u02be"+
		"\u02bf\7E\2\2\u02bf\u02c0\7T\2\2\u02c0\u02c1\7K\2\2\u02c1\u02c2\7D\2\2"+
		"\u02c2\u02c3\7G\2\2\u02c3\u008c\3\2\2\2\u02c4\u02c5\7G\2\2\u02c5\u02c6"+
		"\7Z\2\2\u02c6\u02c7\7R\2\2\u02c7\u02c8\7N\2\2\u02c8\u02c9\7C\2\2\u02c9"+
		"\u02ca\7K\2\2\u02ca\u02cb\7P\2\2\u02cb\u008e\3\2\2\2\u02cc\u02cd\7E\2"+
		"\2\u02cd\u02ce\7C\2\2\u02ce\u02cf\7U\2\2\u02cf\u02d0\7V\2\2\u02d0\u0090"+
		"\3\2\2\2\u02d1\u02d2\7U\2\2\u02d2\u02d3\7J\2\2\u02d3\u02d4\7Q\2\2\u02d4"+
		"\u02d5\7Y\2\2\u02d5\u0092\3\2\2\2\u02d6\u02d7\7V\2\2\u02d7\u02d8\7C\2"+
		"\2\u02d8\u02d9\7D\2\2\u02d9\u02da\7N\2\2\u02da\u02db\7G\2\2\u02db\u02dc"+
		"\7U\2\2\u02dc\u0094\3\2\2\2\u02dd\u02de\7E\2\2\u02de\u02df\7Q\2\2\u02df"+
		"\u02e0\7N\2\2\u02e0\u02e1\7W\2\2\u02e1\u02e2\7O\2\2\u02e2\u02e3\7P\2\2"+
		"\u02e3\u02e4\7U\2\2\u02e4\u0096\3\2\2\2\u02e5\u02e6\7E\2\2\u02e6\u02e7"+
		"\7Q\2\2\u02e7\u02e8\7N\2\2\u02e8\u02e9\7W\2\2\u02e9\u02ea\7O\2\2\u02ea"+
		"\u02eb\7P\2\2\u02eb\u0098\3\2\2\2\u02ec\u02ed\7W\2\2\u02ed\u02ee\7U\2"+
		"\2\u02ee\u02ef\7G\2\2\u02ef\u009a\3\2\2\2\u02f0\u02f1\7H\2\2\u02f1\u02f2"+
		"\7W\2\2\u02f2\u02f3\7P\2\2\u02f3\u02f4\7E\2\2\u02f4\u02f5\7V\2\2\u02f5"+
		"\u02f6\7K\2\2\u02f6\u02f7\7Q\2\2\u02f7\u02f8\7P\2\2\u02f8\u02f9\7U\2\2"+
		"\u02f9\u009c\3\2\2\2\u02fa\u02fb\7F\2\2\u02fb\u02fc\7T\2\2\u02fc\u02fd"+
		"\7Q\2\2\u02fd\u02fe\7R\2\2\u02fe\u009e\3\2\2\2\u02ff\u0300\7W\2\2\u0300"+
		"\u0301\7P\2\2\u0301\u0302\7K\2\2\u0302\u0303\7Q\2\2\u0303\u0304\7P\2\2"+
		"\u0304\u00a0\3\2\2\2\u0305\u0306\7G\2\2\u0306\u0307\7Z\2\2\u0307\u0308"+
		"\7E\2\2\u0308\u0309\7G\2\2\u0309\u030a\7R\2\2\u030a\u030b\7V\2\2\u030b"+
		"\u00a2\3\2\2\2\u030c\u030d\7O\2\2\u030d\u030e\7K\2\2\u030e\u030f\7P\2"+
		"\2\u030f\u0310\7W\2\2\u0310\u0311\7U\2\2\u0311\u00a4\3\2\2\2\u0312\u0313"+
		"\7K\2\2\u0313\u0314\7P\2\2\u0314\u0315\7V\2\2\u0315\u0316\7G\2\2\u0316"+
		"\u0317\7T\2\2\u0317\u0318\7U\2\2\u0318\u0319\7G\2\2\u0319\u031a\7E\2\2"+
		"\u031a\u031b\7V\2\2\u031b\u00a6\3\2\2\2\u031c\u031d\7V\2\2\u031d\u031e"+
		"\7Q\2\2\u031e\u00a8\3\2\2\2\u031f\u0320\7C\2\2\u0320\u0321\7N\2\2\u0321"+
		"\u0322\7V\2\2\u0322\u0323\7G\2\2\u0323\u0324\7T\2\2\u0324\u00aa\3\2\2"+
		"\2\u0325\u0326\7T\2\2\u0326\u0327\7G\2\2\u0327\u0328\7P\2\2\u0328\u0329"+
		"\7C\2\2\u0329\u032a\7O\2\2\u032a\u032b\7G\2\2\u032b\u00ac\3\2\2\2\u032c"+
		"\u032d\7C\2\2\u032d\u032e\7T\2\2\u032e\u032f\7T\2\2\u032f\u0330\7C\2\2"+
		"\u0330\u0331\7[\2\2\u0331\u00ae\3\2\2\2\u0332\u0333\7O\2\2\u0333\u0334"+
		"\7C\2\2\u0334\u0335\7R\2\2\u0335\u00b0\3\2\2\2\u0336\u0337\7U\2\2\u0337"+
		"\u0338\7V\2\2\u0338\u0339\7T\2\2\u0339\u033a\7W\2\2\u033a\u033b\7E\2\2"+
		"\u033b\u033c\7V\2\2\u033c\u00b2\3\2\2\2\u033d\u033e\7E\2\2\u033e\u033f"+
		"\7Q\2\2\u033f\u0340\7O\2\2\u0340\u0341\7O\2\2\u0341\u0342\7G\2\2\u0342"+
		"\u0343\7P\2\2\u0343\u0344\7V\2\2\u0344\u00b4\3\2\2\2\u0345\u0346\7U\2"+
		"\2\u0346\u0347\7G\2\2\u0347\u0348\7V\2\2\u0348\u00b6\3\2\2\2\u0349\u034a"+
		"\7T\2\2\u034a\u034b\7G\2\2\u034b\u034c\7U\2\2\u034c\u034d\7G\2\2\u034d"+
		"\u034e\7V\2\2\u034e\u00b8\3\2\2\2\u034f\u0350\7E\2\2\u0350\u0351\7Q\2"+
		"\2\u0351\u0352\7O\2\2\u0352\u0353\7O\2\2\u0353\u0354\7K\2\2\u0354\u0355"+
		"\7V\2\2\u0355\u00ba\3\2\2\2\u0356\u0357\7T\2\2\u0357\u0358\7Q\2\2\u0358"+
		"\u0359\7N\2\2\u0359\u035a\7N\2\2\u035a\u035b\7D\2\2\u035b\u035c\7C\2\2"+
		"\u035c\u035d\7E\2\2\u035d\u035e\7M\2\2\u035e\u00bc\3\2\2\2\u035f\u0360"+
		"\7K\2\2\u0360\u0361\7I\2\2\u0361\u0362\7P\2\2\u0362\u0363\7Q\2\2\u0363"+
		"\u0364\7T\2\2\u0364\u0365\7G\2\2\u0365\u00be\3\2\2\2\u0366\u0367\7E\2"+
		"\2\u0367\u0368\7C\2\2\u0368\u0369\7N\2\2\u0369\u036a\7N\2\2\u036a\u00c0"+
		"\3\2\2\2\u036b\u036c\7Y\2\2\u036c\u036d\7K\2\2\u036d\u036e\7V\2\2\u036e"+
		"\u036f\7J\2\2\u036f\u00c2\3\2\2\2\u0370\u0371\7X\2\2\u0371\u0372\7G\2"+
		"\2\u0372\u0373\7T\2\2\u0373\u0374\7U\2\2\u0374\u0375\7K\2\2\u0375\u0376"+
		"\7Q\2\2\u0376\u0377\7P\2\2\u0377\u00c4\3\2\2\2\u0378\u0379\7G\2\2\u0379"+
		"\u037a\7P\2\2\u037a\u037b\7F\2\2\u037b\u037c\7Q\2\2\u037c\u037d\7T\2\2"+
		"\u037d\u037e\7U\2\2\u037e\u037f\7G\2\2\u037f\u0380\7T\2\2\u0380\u0381"+
		"\7U\2\2\u0381\u00c6\3\2\2\2\u0382\u0383\7C\2\2\u0383\u0384\7T\2\2\u0384"+
		"\u0385\7I\2\2\u0385\u0386\7U\2\2\u0386\u00c8\3\2\2\2\u0387\u0388\7C\2"+
		"\2\u0388\u0389\7U\2\2\u0389\u038a\7U\2\2\u038a\u038b\7G\2\2\u038b\u038c"+
		"\7V\2\2\u038c\u00ca\3\2\2\2\u038d\u038e\7E\2\2\u038e\u038f\7J\2\2\u038f"+
		"\u0390\7C\2\2\u0390\u0391\7K\2\2\u0391\u0392\7P\2\2\u0392\u0393\7E\2\2"+
		"\u0393\u0394\7Q\2\2\u0394\u0395\7F\2\2\u0395\u0396\7G\2\2\u0396\u00cc"+
		"\3\2\2\2\u0397\u0398\7U\2\2\u0398\u0399\7O\2\2\u0399\u039a\7C\2\2\u039a"+
		"\u039b\7T\2\2\u039b\u039c\7V\2\2\u039c\u039d\7E\2\2\u039d\u039e\7Q\2\2"+
		"\u039e\u039f\7P\2\2\u039f\u03a0\7V\2\2\u03a0\u03a1\7T\2\2\u03a1\u03a2"+
		"\7C\2\2\u03a2\u03a3\7E\2\2\u03a3\u03a4\7V\2\2\u03a4\u00ce\3\2\2\2\u03a5"+
		"\u03a6\7U\2\2\u03a6\u03a7\7V\2\2\u03a7\u03a8\7Q\2\2\u03a8\u03a9\7T\2\2"+
		"\u03a9\u03aa\7C\2\2\u03aa\u03ab\7I\2\2\u03ab\u03ac\7G\2\2\u03ac\u00d0"+
		"\3\2\2\2\u03ad\u03ae\7V\2\2\u03ae\u03af\7[\2\2\u03af\u03b0\7R\2\2\u03b0"+
		"\u03b1\7G\2\2\u03b1\u00d2\3\2\2\2\u03b2\u03b3\7L\2\2\u03b3\u03b4\7U\2"+
		"\2\u03b4\u03b5\7Q\2\2\u03b5\u03b6\7P\2\2\u03b6\u00d4\3\2\2\2\u03b7\u03b8"+
		"\7E\2\2\u03b8\u03b9\7U\2\2\u03b9\u03ba\7X\2\2\u03ba\u00d6\3\2\2\2\u03bb"+
		"\u03bc\7H\2\2\u03bc\u03bd\7K\2\2\u03bd\u03be\7G\2\2\u03be\u03bf\7N\2\2"+
		"\u03bf\u03c0\7F\2\2\u03c0\u03c1\7U\2\2\u03c1\u00d8\3\2\2\2\u03c2\u03c3"+
		"\7T\2\2\u03c3\u03c4\7G\2\2\u03c4\u03c5\7E\2\2\u03c5\u03c6\7Q\2\2\u03c6"+
		"\u03c7\7T\2\2\u03c7\u03c8\7F\2\2\u03c8\u03c9\7U\2\2\u03c9\u00da\3\2\2"+
		"\2\u03ca\u03cb\7F\2\2\u03cb\u03cc\7G\2\2\u03cc\u03cd\7N\2\2\u03cd\u03ce"+
		"\7K\2\2\u03ce\u03cf\7O\2\2\u03cf\u03d0\7K\2\2\u03d0\u03d1\7V\2\2\u03d1"+
		"\u03d2\7G\2\2\u03d2\u03d3\7F\2\2\u03d3\u00dc\3\2\2\2\u03d4\u03d5\7K\2"+
		"\2\u03d5\u03d6\7H\2\2\u03d6\u00de\3\2\2\2\u03d7\u03db\7?\2\2\u03d8\u03d9"+
		"\7?\2\2\u03d9\u03db\7?\2\2\u03da\u03d7\3\2\2\2\u03da\u03d8\3\2\2\2\u03db"+
		"\u00e0\3\2\2\2\u03dc\u03dd\7>\2\2\u03dd\u03de\7?\2\2\u03de\u03df\7@\2"+
		"\2\u03df\u00e2\3\2\2\2\u03e0\u03e1\7>\2\2\u03e1\u03e2\7@\2\2\u03e2\u00e4"+
		"\3\2\2\2\u03e3\u03e4\7#\2\2\u03e4\u03e5\7?\2\2\u03e5\u00e6\3\2\2\2\u03e6"+
		"\u03e7\7>\2\2\u03e7\u00e8\3\2\2\2\u03e8\u03e9\7>\2\2\u03e9\u03ed\7?\2"+
		"\2\u03ea\u03eb\7#\2\2\u03eb\u03ed\7@\2\2\u03ec\u03e8\3\2\2\2\u03ec\u03ea"+
		"\3\2\2\2\u03ed\u00ea\3\2\2\2\u03ee\u03ef\7@\2\2\u03ef\u00ec\3\2\2\2\u03f0"+
		"\u03f1\7@\2\2\u03f1\u03f5\7?\2\2\u03f2\u03f3\7#\2\2\u03f3\u03f5\7>\2\2"+
		"\u03f4\u03f0\3\2\2\2\u03f4\u03f2\3\2\2\2\u03f5\u00ee\3\2\2\2\u03f6\u03f7"+
		"\7-\2\2\u03f7\u00f0\3\2\2\2\u03f8\u03f9\7/\2\2\u03f9\u00f2\3\2\2\2\u03fa"+
		"\u03fb\7,\2\2\u03fb\u00f4\3\2\2\2\u03fc\u03fd\7\61\2\2\u03fd\u00f6\3\2"+
		"\2\2\u03fe\u03ff\7\'\2\2\u03ff\u00f8\3\2\2\2\u0400\u0401\7F\2\2\u0401"+
		"\u0402\7K\2\2\u0402\u0403\7X\2\2\u0403\u00fa\3\2\2\2\u0404\u0405\7\u0080"+
		"\2\2\u0405\u00fc\3\2\2\2\u0406\u0407\7(\2\2\u0407\u00fe\3\2\2\2\u0408"+
		"\u0409\7~\2\2\u0409\u0100\3\2\2\2\u040a\u040b\7`\2\2\u040b\u0102\3\2\2"+
		"\2\u040c\u040d\7R\2\2\u040d\u040e\7G\2\2\u040e\u040f\7T\2\2\u040f\u0410"+
		"\7E\2\2\u0410\u0411\7G\2\2\u0411\u0412\7P\2\2\u0412\u0413\7V\2\2\u0413"+
		"\u0104\3\2\2\2\u0414\u0415\7Q\2\2\u0415\u0416\7W\2\2\u0416\u0417\7V\2"+
		"\2\u0417\u0106\3\2\2\2\u0418\u0419\7Q\2\2\u0419\u041a\7H\2\2\u041a\u0108"+
		"\3\2\2\2\u041b\u041c\7H\2\2\u041c\u041d\7W\2\2\u041d\u041e\7P\2\2\u041e"+
		"\u041f\7E\2\2\u041f\u0420\7V\2\2\u0420\u0421\7K\2\2\u0421\u0422\7Q\2\2"+
		"\u0422\u0423\7P\2\2\u0423\u010a\3\2\2\2\u0424\u0425\7F\2\2\u0425\u0426"+
		"\7C\2\2\u0426\u0427\7V\2\2\u0427\u0428\7C\2\2\u0428\u0429\7D\2\2\u0429"+
		"\u042a\7C\2\2\u042a\u042b\7U\2\2\u042b\u0433\7G\2\2\u042c\u042d\7U\2\2"+
		"\u042d\u042e\7E\2\2\u042e\u042f\7J\2\2\u042f\u0430\7G\2\2\u0430\u0431"+
		"\7O\2\2\u0431\u0433\7C\2\2\u0432\u0424\3\2\2\2\u0432\u042c\3\2\2\2\u0433"+
		"\u010c\3\2\2\2\u0434\u0435\7F\2\2\u0435\u0436\7C\2\2\u0436\u0437\7V\2"+
		"\2\u0437\u0438\7C\2\2\u0438\u0439\7D\2\2\u0439\u043a\7C\2\2\u043a\u043b"+
		"\7U\2\2\u043b\u043c\7G\2\2\u043c\u0445\7U\2\2\u043d\u043e\7U\2\2\u043e"+
		"\u043f\7E\2\2\u043f\u0440\7J\2\2\u0440\u0441\7G\2\2\u0441\u0442\7O\2\2"+
		"\u0442\u0443\7C\2\2\u0443\u0445\7U\2\2\u0444\u0434\3\2\2\2\u0444\u043d"+
		"\3\2\2\2\u0445\u010e\3\2\2\2\u0446\u0447\7V\2\2\u0447\u0448\7T\2\2\u0448"+
		"\u0449\7W\2\2\u0449\u044a\7P\2\2\u044a\u044b\7E\2\2\u044b\u044c\7C\2\2"+
		"\u044c\u044d\7V\2\2\u044d\u044e\7G\2\2\u044e\u0110\3\2\2\2\u044f\u0450"+
		"\7C\2\2\u0450\u0451\7P\2\2\u0451\u0452\7C\2\2\u0452\u0453\7N\2\2\u0453"+
		"\u0454\7[\2\2\u0454\u0455\7\\\2\2\u0455\u0456\7G\2\2\u0456\u0112\3\2\2"+
		"\2\u0457\u0458\7E\2\2\u0458\u0459\7Q\2\2\u0459\u045a\7O\2\2\u045a\u045b"+
		"\7R\2\2\u045b\u045c\7W\2\2\u045c\u045d\7V\2\2\u045d\u045e\7G\2\2\u045e"+
		"\u0114\3\2\2\2\u045f\u0460\7N\2\2\u0460\u0461\7K\2\2\u0461\u0462\7U\2"+
		"\2\u0462\u0463\7V\2\2\u0463\u0116\3\2\2\2\u0464\u0465\7T\2\2\u0465\u0466"+
		"\7G\2\2\u0466\u0467\7X\2\2\u0467\u0468\7Q\2\2\u0468\u0469\7M\2\2\u0469"+
		"\u046a\7G\2\2\u046a\u0118\3\2\2\2\u046b\u046c\7I\2\2\u046c\u046d\7T\2"+
		"\2\u046d\u046e\7C\2\2\u046e\u046f\7P\2\2\u046f\u0470\7V\2\2\u0470\u011a"+
		"\3\2\2\2\u0471\u0472\7G\2\2\u0472\u0473\7Z\2\2\u0473\u0474\7R\2\2\u0474"+
		"\u0475\7Q\2\2\u0475\u0476\7T\2\2\u0476\u0477\7V\2\2\u0477\u011c\3\2\2"+
		"\2\u0478\u0479\7K\2\2\u0479\u047a\7O\2\2\u047a\u047b\7R\2\2\u047b\u047c"+
		"\7Q\2\2\u047c\u047d\7T\2\2\u047d\u047e\7V\2\2\u047e\u011e\3\2\2\2\u047f"+
		"\u0480\7N\2\2\u0480\u0481\7Q\2\2\u0481\u0482\7C\2\2\u0482\u0483\7F\2\2"+
		"\u0483\u0120\3\2\2\2\u0484\u0485\7T\2\2\u0485\u0486\7Q\2\2\u0486\u0487"+
		"\7N\2\2\u0487\u0488\7G\2\2\u0488\u0122\3\2\2\2\u0489\u048a\7T\2\2\u048a"+
		"\u048b\7Q\2\2\u048b\u048c\7N\2\2\u048c\u048d\7G\2\2\u048d\u048e\7U\2\2"+
		"\u048e\u0124\3\2\2\2\u048f\u0490\7K\2\2\u0490\u0491\7P\2\2\u0491\u0492"+
		"\7F\2\2\u0492\u0493\7G\2\2\u0493\u0494\7Z\2\2\u0494\u0126\3\2\2\2\u0495"+
		"\u0496\7K\2\2\u0496\u0497\7P\2\2\u0497\u0498\7F\2\2\u0498\u0499\7G\2\2"+
		"\u0499\u049a\7Z\2\2\u049a\u049b\7G\2\2\u049b\u049c\7U\2\2\u049c\u0128"+
		"\3\2\2\2\u049d\u049e\7E\2\2\u049e\u049f\7W\2\2\u049f\u04a0\7T\2\2\u04a0"+
		"\u04a1\7T\2\2\u04a1\u04a2\7G\2\2\u04a2\u04a3\7P\2\2\u04a3\u04a4\7V\2\2"+
		"\u04a4\u04a5\7a\2\2\u04a5\u04a6\7F\2\2\u04a6\u04a7\7C\2\2\u04a7\u04a8"+
		"\7V\2\2\u04a8\u04a9\7G\2\2\u04a9\u012a\3\2\2\2\u04aa\u04ab\7E\2\2\u04ab"+
		"\u04ac\7W\2\2\u04ac\u04ad\7T\2\2\u04ad\u04ae\7T\2\2\u04ae\u04af\7G\2\2"+
		"\u04af\u04b0\7P\2\2\u04b0\u04b1\7V\2\2\u04b1\u04b2\7a\2\2\u04b2\u04b3"+
		"\7V\2\2\u04b3\u04b4\7K\2\2\u04b4\u04b5\7O\2\2\u04b5\u04b6\7G\2\2\u04b6"+
		"\u04b7\7U\2\2\u04b7\u04b8\7V\2\2\u04b8\u04b9\7C\2\2\u04b9\u04ba\7O\2\2"+
		"\u04ba\u04bb\7R\2\2\u04bb\u012c\3\2\2\2\u04bc\u04c2\7)\2\2\u04bd\u04c1"+
		"\n\2\2\2\u04be\u04bf\7^\2\2\u04bf\u04c1\13\2\2\2\u04c0\u04bd\3\2\2\2\u04c0"+
		"\u04be\3\2\2\2\u04c1\u04c4\3\2\2\2\u04c2\u04c0\3\2\2\2\u04c2\u04c3\3\2"+
		"\2\2\u04c3\u04c5\3\2\2\2\u04c4\u04c2\3\2\2\2\u04c5\u04d1\7)\2\2\u04c6"+
		"\u04cc\7$\2\2\u04c7\u04cb\n\3\2\2\u04c8\u04c9\7^\2\2\u04c9\u04cb\13\2"+
		"\2\2\u04ca\u04c7\3\2\2\2\u04ca\u04c8\3\2\2\2\u04cb\u04ce\3\2\2\2\u04cc"+
		"\u04ca\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u04cf\3\2\2\2\u04ce\u04cc\3\2"+
		"\2\2\u04cf\u04d1\7$\2\2\u04d0\u04bc\3\2\2\2\u04d0\u04c6\3\2\2\2\u04d1"+
		"\u012e\3\2\2\2\u04d2\u04d4\5\u0149\u00a5\2\u04d3\u04d2\3\2\2\2\u04d4\u04d5"+
		"\3\2\2\2\u04d5\u04d3\3\2\2\2\u04d5\u04d6\3\2\2\2\u04d6\u04d7\3\2\2\2\u04d7"+
		"\u04d8\7N\2\2\u04d8\u0130\3\2\2\2\u04d9\u04db\5\u0149\u00a5\2\u04da\u04d9"+
		"\3\2\2\2\u04db\u04dc\3\2\2\2\u04dc\u04da\3\2\2\2\u04dc\u04dd\3\2\2\2\u04dd"+
		"\u04de\3\2\2\2\u04de\u04df\7U\2\2\u04df\u0132\3\2\2\2\u04e0\u04e2\5\u0149"+
		"\u00a5\2\u04e1\u04e0\3\2\2\2\u04e2\u04e3\3\2\2\2\u04e3\u04e1\3\2\2\2\u04e3"+
		"\u04e4\3\2\2\2\u04e4\u04e5\3\2\2\2\u04e5\u04e6\7[\2\2\u04e6\u0134\3\2"+
		"\2\2\u04e7\u04e9\5\u0149\u00a5\2\u04e8\u04e7\3\2\2\2\u04e9\u04ea\3\2\2"+
		"\2\u04ea\u04e8\3\2\2\2\u04ea\u04eb\3\2\2\2\u04eb\u04ec\3\2\2\2\u04ec\u04ed"+
		"\t\4\2\2\u04ed\u0136\3\2\2\2\u04ee\u04f0\5\u0149\u00a5\2\u04ef\u04ee\3"+
		"\2\2\2\u04f0\u04f1\3\2\2\2\u04f1\u04ef\3\2\2\2\u04f1\u04f2\3\2\2\2\u04f2"+
		"\u0138\3\2\2\2\u04f3\u04f5\5\u0149\u00a5\2\u04f4\u04f3\3\2\2\2\u04f5\u04f6"+
		"\3\2\2\2\u04f6\u04f4\3\2\2\2\u04f6\u04f7\3\2\2\2\u04f7\u04f8\3\2\2\2\u04f8"+
		"\u04f9\5\u0147\u00a4\2\u04f9\u0501\3\2\2\2\u04fa\u04fc\5\u0145\u00a3\2"+
		"\u04fb\u04fd\5\u0147\u00a4\2\u04fc\u04fb\3\2\2\2\u04fc\u04fd\3\2\2\2\u04fd"+
		"\u04fe\3\2\2\2\u04fe\u04ff\6\u009d\2\2\u04ff\u0501\3\2\2\2\u0500\u04f4"+
		"\3\2\2\2\u0500\u04fa\3\2\2\2\u0501\u013a\3\2\2\2\u0502\u0504\5\u0149\u00a5"+
		"\2\u0503\u0502\3\2\2\2\u0504\u0505\3\2\2\2\u0505\u0503\3\2\2\2\u0505\u0506"+
		"\3\2\2\2\u0506\u0508\3\2\2\2\u0507\u0509\5\u0147\u00a4\2\u0508\u0507\3"+
		"\2\2\2\u0508\u0509\3\2\2\2\u0509\u050a\3\2\2\2\u050a\u050b\7F\2\2\u050b"+
		"\u0514\3\2\2\2\u050c\u050e\5\u0145\u00a3\2\u050d\u050f\5\u0147\u00a4\2"+
		"\u050e\u050d\3\2\2\2\u050e\u050f\3\2\2\2\u050f\u0510\3\2\2\2\u0510\u0511"+
		"\7F\2\2\u0511\u0512\6\u009e\3\2\u0512\u0514\3\2\2\2\u0513\u0503\3\2\2"+
		"\2\u0513\u050c\3\2\2\2\u0514\u013c\3\2\2\2\u0515\u0517\5\u0149\u00a5\2"+
		"\u0516\u0515\3\2\2\2\u0517\u0518\3\2\2\2\u0518\u0516\3\2\2\2\u0518\u0519"+
		"\3\2\2\2\u0519\u051b\3\2\2\2\u051a\u051c\5\u0147\u00a4\2\u051b\u051a\3"+
		"\2\2\2\u051b\u051c\3\2\2\2\u051c\u051d\3\2\2\2\u051d\u051e\7D\2\2\u051e"+
		"\u051f\7F\2\2\u051f\u052a\3\2\2\2\u0520\u0522\5\u0145\u00a3\2\u0521\u0523"+
		"\5\u0147\u00a4\2\u0522\u0521\3\2\2\2\u0522\u0523\3\2\2\2\u0523\u0524\3"+
		"\2\2\2\u0524\u0525\7D\2\2\u0525\u0526\7F\2\2\u0526\u0527\3\2\2\2\u0527"+
		"\u0528\6\u009f\4\2\u0528\u052a\3\2\2\2\u0529\u0516\3\2\2\2\u0529\u0520"+
		"\3\2\2\2\u052a\u013e\3\2\2\2\u052b\u052f\5\u014b\u00a6\2\u052c\u052f\5"+
		"\u0149\u00a5\2\u052d\u052f\7a\2\2\u052e\u052b\3\2\2\2\u052e\u052c\3\2"+
		"\2\2\u052e\u052d\3\2\2\2\u052f\u0530\3\2\2\2\u0530\u052e\3\2\2\2\u0530"+
		"\u0531\3\2\2\2\u0531\u0140\3\2\2\2\u0532\u0536\5\u014b\u00a6\2\u0533\u0536"+
		"\5\u0149\u00a5\2\u0534\u0536\7\60\2\2\u0535\u0532\3\2\2\2\u0535\u0533"+
		"\3\2\2\2\u0535\u0534\3\2\2\2\u0536\u0537\3\2\2\2\u0537\u0535\3\2\2\2\u0537"+
		"\u0538\3\2\2\2\u0538\u0142\3\2\2\2\u0539\u053f\7b\2\2\u053a\u053e\n\5"+
		"\2\2\u053b\u053c\7b\2\2\u053c\u053e\7b\2\2\u053d\u053a\3\2\2\2\u053d\u053b"+
		"\3\2\2\2\u053e\u0541\3\2\2\2\u053f\u053d\3\2\2\2\u053f\u0540\3\2\2\2\u0540"+
		"\u0542\3\2\2\2\u0541\u053f\3\2\2\2\u0542\u0543\7b\2\2\u0543\u0144\3\2"+
		"\2\2\u0544\u0546\5\u0149\u00a5\2\u0545\u0544\3\2\2\2\u0546\u0547\3\2\2"+
		"\2\u0547\u0545\3\2\2\2\u0547\u0548\3\2\2\2\u0548\u0549\3\2\2\2\u0549\u054d"+
		"\7\60\2\2\u054a\u054c\5\u0149\u00a5\2\u054b\u054a\3\2\2\2\u054c\u054f"+
		"\3\2\2\2\u054d\u054b\3\2\2\2\u054d\u054e\3\2\2\2\u054e\u0557\3\2\2\2\u054f"+
		"\u054d\3\2\2\2\u0550\u0552\7\60\2\2\u0551\u0553\5\u0149\u00a5\2\u0552"+
		"\u0551\3\2\2\2\u0553\u0554\3\2\2\2\u0554\u0552\3\2\2\2\u0554\u0555\3\2"+
		"\2\2\u0555\u0557\3\2\2\2\u0556\u0545\3\2\2\2\u0556\u0550\3\2\2\2\u0557"+
		"\u0146\3\2\2\2\u0558\u055a\7G\2\2\u0559\u055b\t\6\2\2\u055a\u0559\3\2"+
		"\2\2\u055a\u055b\3\2\2\2\u055b\u055d\3\2\2\2\u055c\u055e\5\u0149\u00a5"+
		"\2\u055d\u055c\3\2\2\2\u055e\u055f\3\2\2\2\u055f\u055d\3\2\2\2\u055f\u0560"+
		"\3\2\2\2\u0560\u0148\3\2\2\2\u0561\u0562\t\7\2\2\u0562\u014a\3\2\2\2\u0563"+
		"\u0564\t\b\2\2\u0564\u014c\3\2\2\2\u0565\u0566\7/\2\2\u0566\u0567\7/\2"+
		"\2\u0567\u056b\3\2\2\2\u0568\u056a\n\t\2\2\u0569\u0568\3\2\2\2\u056a\u056d"+
		"\3\2\2\2\u056b\u0569\3\2\2\2\u056b\u056c\3\2\2\2\u056c\u056f\3\2\2\2\u056d"+
		"\u056b\3\2\2\2\u056e\u0570\7\17\2\2\u056f\u056e\3\2\2\2\u056f\u0570\3"+
		"\2\2\2\u0570\u0572\3\2\2\2\u0571\u0573\7\f\2\2\u0572\u0571\3\2\2\2\u0572"+
		"\u0573\3\2\2\2\u0573\u0574\3\2\2\2\u0574\u0575\b\u00a7\2\2\u0575\u014e"+
		"\3\2\2\2\u0576\u0577\7\61\2\2\u0577\u0578\7,\2\2\u0578\u0579\7,\2\2\u0579"+
		"\u057a\7\61\2\2\u057a\u057b\3\2\2\2\u057b\u057c\b\u00a8\2\2\u057c\u0150"+
		"\3\2\2\2\u057d\u057e\7\61\2\2\u057e\u057f\7,\2\2\u057f\u0580\3\2\2\2\u0580"+
		"\u0584\n\n\2\2\u0581\u0583\13\2\2\2\u0582\u0581\3\2\2\2\u0583\u0586\3"+
		"\2\2\2\u0584\u0585\3\2\2\2\u0584\u0582\3\2\2\2\u0585\u0587\3\2\2\2\u0586"+
		"\u0584\3\2\2\2\u0587\u0588\7,\2\2\u0588\u0589\7\61\2\2\u0589\u058a\3\2"+
		"\2\2\u058a\u058b\b\u00a9\2\2\u058b\u0152\3\2\2\2\u058c\u058e\t\13\2\2"+
		"\u058d\u058c\3\2\2\2\u058e\u058f\3\2\2\2\u058f\u058d\3\2\2\2\u058f\u0590"+
		"\3\2\2\2\u0590\u0591\3\2\2\2\u0591\u0592\b\u00aa\2\2\u0592\u0154\3\2\2"+
		"\2\u0593\u0594\13\2\2\2\u0594\u0156\3\2\2\2\60\2\u01d2\u01f6\u03da\u03ec"+
		"\u03f4\u0432\u0444\u04c0\u04c2\u04ca\u04cc\u04d0\u04d5\u04dc\u04e3\u04ea"+
		"\u04f1\u04f6\u04fc\u0500\u0505\u0508\u050e\u0513\u0518\u051b\u0522\u0529"+
		"\u052e\u0530\u0535\u0537\u053d\u053f\u0547\u054d\u0554\u0556\u055a\u055f"+
		"\u056b\u056f\u0572\u0584\u058f\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}