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
		ROLLBACK=93, IGNORE=94, CALL=95, WITH=96, VERSION=97, ENDORSEMENT=98, 
		POLICY=99, FILE=100, ARGS=101, ASSET=102, CHAINCODE=103, SMARTCONTRACT=104, 
		STORAGE=105, TYPE=106, JSON=107, CSV=108, FIELDS=109, RECORDS=110, DELIMITED=111, 
		UPGRADE=112, IF=113, EQ=114, NSEQ=115, NEQ=116, NEQJ=117, LT=118, LTE=119, 
		GT=120, GTE=121, PLUS=122, MINUS=123, ASTERISK=124, SLASH=125, PERCENT=126, 
		DIV=127, TILDE=128, AMPERSAND=129, PIPE=130, HAT=131, QUESTIONMARK=132, 
		PERCENTLIT=133, OUT=134, OF=135, FUNCTION=136, DATABASE=137, DATABASES=138, 
		TRUNCATE=139, ANALYZE=140, COMPUTE=141, LIST=142, REVOKE=143, GRANT=144, 
		EXPORT=145, IMPORT=146, LOAD=147, ROLE=148, ROLES=149, INDEX=150, INDEXES=151, 
		CURRENT_DATE=152, CURRENT_TIMESTAMP=153, STRING=154, BIGINT_LITERAL=155, 
		SMALLINT_LITERAL=156, TINYINT_LITERAL=157, BYTELENGTH_LITERAL=158, INTEGER_VALUE=159, 
		DECIMAL_VALUE=160, DOUBLE_LITERAL=161, BIGDECIMAL_LITERAL=162, IDENTIFIER=163, 
		BACKQUOTED_IDENTIFIER=164, SIMPLE_COMMENT=165, BRACKETED_EMPTY_COMMENT=166, 
		BRACKETED_COMMENT=167, WS=168, UNRECOGNIZED=169;
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
		"CALL", "WITH", "VERSION", "ENDORSEMENT", "POLICY", "FILE", "ARGS", "ASSET", 
		"CHAINCODE", "SMARTCONTRACT", "STORAGE", "TYPE", "JSON", "CSV", "FIELDS", 
		"RECORDS", "DELIMITED", "UPGRADE", "IF", "EQ", "NSEQ", "NEQ", "NEQJ", 
		"LT", "LTE", "GT", "GTE", "PLUS", "MINUS", "ASTERISK", "SLASH", "PERCENT", 
		"DIV", "TILDE", "AMPERSAND", "PIPE", "HAT", "QUESTIONMARK", "PERCENTLIT", 
		"OUT", "OF", "FUNCTION", "DATABASE", "DATABASES", "TRUNCATE", "ANALYZE", 
		"COMPUTE", "LIST", "REVOKE", "GRANT", "EXPORT", "IMPORT", "LOAD", "ROLE", 
		"ROLES", "INDEX", "INDEXES", "CURRENT_DATE", "CURRENT_TIMESTAMP", "STRING", 
		"BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", "BYTELENGTH_LITERAL", 
		"INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_LITERAL", "BIGDECIMAL_LITERAL", 
		"IDENTIFIER", "BACKQUOTED_IDENTIFIER", "DECIMAL_DIGITS", "EXPONENT", "DIGIT", 
		"LETTER", "SIMPLE_COMMENT", "BRACKETED_EMPTY_COMMENT", "BRACKETED_COMMENT", 
		"WS", "UNRECOGNIZED"
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
		"'IGNORE'", "'CALL'", "'WITH'", "'VERSION'", "'ENDORSEMENT'", "'POLICY'", 
		"'FILE'", "'ARGS'", "'ASSET'", "'CHAINCODE'", "'SMARTCONTRACT'", "'STORAGE'", 
		"'TYPE'", "'JSON'", "'CSV'", "'FIELDS'", "'RECORDS'", "'DELIMITED'", "'UPGRADE'", 
		"'IF'", null, "'<=>'", "'<>'", "'!='", "'<'", null, "'>'", null, "'+'", 
		"'-'", "'*'", "'/'", "'%'", "'DIV'", "'~'", "'&'", "'|'", "'^'", "'?'", 
		"'PERCENT'", "'OUT'", "'OF'", "'FUNCTION'", null, null, "'TRUNCATE'", 
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
		"CALL", "WITH", "VERSION", "ENDORSEMENT", "POLICY", "FILE", "ARGS", "ASSET", 
		"CHAINCODE", "SMARTCONTRACT", "STORAGE", "TYPE", "JSON", "CSV", "FIELDS", 
		"RECORDS", "DELIMITED", "UPGRADE", "IF", "EQ", "NSEQ", "NEQ", "NEQJ", 
		"LT", "LTE", "GT", "GTE", "PLUS", "MINUS", "ASTERISK", "SLASH", "PERCENT", 
		"DIV", "TILDE", "AMPERSAND", "PIPE", "HAT", "QUESTIONMARK", "PERCENTLIT", 
		"OUT", "OF", "FUNCTION", "DATABASE", "DATABASES", "TRUNCATE", "ANALYZE", 
		"COMPUTE", "LIST", "REVOKE", "GRANT", "EXPORT", "IMPORT", "LOAD", "ROLE", 
		"ROLES", "INDEX", "INDEXES", "CURRENT_DATE", "CURRENT_TIMESTAMP", "STRING", 
		"BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", "BYTELENGTH_LITERAL", 
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
		case 159:
			return DECIMAL_VALUE_sempred((RuleContext)_localctx, predIndex);
		case 160:
			return DOUBLE_LITERAL_sempred((RuleContext)_localctx, predIndex);
		case 161:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\u00ab\u05ac\b\1\4"+
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
		"\4\u00a9\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad"+
		"\t\u00ad\4\u00ae\t\u00ae\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\5\35\u01d9\n\35\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01fd\n\"\3"+
		"#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3"+
		"+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3"+
		"\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3"+
		"\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3"+
		"\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3"+
		"\67\38\38\38\38\38\39\39\39\39\39\39\39\39\3:\3:\3:\3;\3;\3;\3;\3;\3;"+
		"\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?"+
		"\3?\3?\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3B\3C\3C"+
		"\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F"+
		"\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3J\3J"+
		"\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3L\3L\3M\3M\3M"+
		"\3M\3N\3N\3N\3N\3N\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3Q"+
		"\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3R\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3T"+
		"\3T\3T\3U\3U\3U\3U\3U\3U\3V\3V\3V\3V\3V\3V\3V\3W\3W\3W\3W\3W\3W\3X\3X"+
		"\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3\\\3"+
		"\\\3\\\3\\\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\3^\3^\3^\3^\3^\3^\3^\3^\3^\3_"+
		"\3_\3_\3_\3_\3_\3_\3`\3`\3`\3`\3`\3a\3a\3a\3a\3a\3b\3b\3b\3b\3b\3b\3b"+
		"\3b\3c\3c\3c\3c\3c\3c\3c\3c\3c\3c\3c\3c\3d\3d\3d\3d\3d\3d\3d\3e\3e\3e"+
		"\3e\3e\3f\3f\3f\3f\3f\3g\3g\3g\3g\3g\3g\3h\3h\3h\3h\3h\3h\3h\3h\3h\3h"+
		"\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3i\3j\3j\3j\3j\3j\3j\3j\3j\3k"+
		"\3k\3k\3k\3k\3l\3l\3l\3l\3l\3m\3m\3m\3m\3n\3n\3n\3n\3n\3n\3n\3o\3o\3o"+
		"\3o\3o\3o\3o\3o\3p\3p\3p\3p\3p\3p\3p\3p\3p\3p\3q\3q\3q\3q\3q\3q\3q\3q"+
		"\3r\3r\3r\3s\3s\3s\5s\u03f7\ns\3t\3t\3t\3t\3u\3u\3u\3v\3v\3v\3w\3w\3x"+
		"\3x\3x\3x\5x\u0409\nx\3y\3y\3z\3z\3z\3z\5z\u0411\nz\3{\3{\3|\3|\3}\3}"+
		"\3~\3~\3\177\3\177\3\u0080\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082"+
		"\3\u0082\3\u0083\3\u0083\3\u0084\3\u0084\3\u0085\3\u0085\3\u0086\3\u0086"+
		"\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0086\3\u0087\3\u0087\3\u0087"+
		"\3\u0087\3\u0088\3\u0088\3\u0088\3\u0089\3\u0089\3\u0089\3\u0089\3\u0089"+
		"\3\u0089\3\u0089\3\u0089\3\u0089\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a"+
		"\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a\3\u008a"+
		"\5\u008a\u0451\n\u008a\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\5\u008b\u0463\n\u008b\3\u008c\3\u008c\3\u008c\3\u008c\3\u008c"+
		"\3\u008c\3\u008c\3\u008c\3\u008c\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d"+
		"\3\u008d\3\u008d\3\u008d\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e\3\u008e"+
		"\3\u008e\3\u008e\3\u008f\3\u008f\3\u008f\3\u008f\3\u008f\3\u0090\3\u0090"+
		"\3\u0090\3\u0090\3\u0090\3\u0090\3\u0090\3\u0091\3\u0091\3\u0091\3\u0091"+
		"\3\u0091\3\u0091\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092\3\u0092"+
		"\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0093\3\u0094\3\u0094"+
		"\3\u0094\3\u0094\3\u0094\3\u0095\3\u0095\3\u0095\3\u0095\3\u0095\3\u0096"+
		"\3\u0096\3\u0096\3\u0096\3\u0096\3\u0096\3\u0097\3\u0097\3\u0097\3\u0097"+
		"\3\u0097\3\u0097\3\u0098\3\u0098\3\u0098\3\u0098\3\u0098\3\u0098\3\u0098"+
		"\3\u0098\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099"+
		"\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u009a\3\u009a\3\u009a\3\u009a"+
		"\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a"+
		"\3\u009a\3\u009a\3\u009a\3\u009a\3\u009a\3\u009b\3\u009b\3\u009b\3\u009b"+
		"\7\u009b\u04df\n\u009b\f\u009b\16\u009b\u04e2\13\u009b\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009b\7\u009b\u04e9\n\u009b\f\u009b\16\u009b\u04ec"+
		"\13\u009b\3\u009b\5\u009b\u04ef\n\u009b\3\u009c\6\u009c\u04f2\n\u009c"+
		"\r\u009c\16\u009c\u04f3\3\u009c\3\u009c\3\u009d\6\u009d\u04f9\n\u009d"+
		"\r\u009d\16\u009d\u04fa\3\u009d\3\u009d\3\u009e\6\u009e\u0500\n\u009e"+
		"\r\u009e\16\u009e\u0501\3\u009e\3\u009e\3\u009f\6\u009f\u0507\n\u009f"+
		"\r\u009f\16\u009f\u0508\3\u009f\3\u009f\3\u00a0\6\u00a0\u050e\n\u00a0"+
		"\r\u00a0\16\u00a0\u050f\3\u00a1\6\u00a1\u0513\n\u00a1\r\u00a1\16\u00a1"+
		"\u0514\3\u00a1\3\u00a1\3\u00a1\3\u00a1\5\u00a1\u051b\n\u00a1\3\u00a1\3"+
		"\u00a1\5\u00a1\u051f\n\u00a1\3\u00a2\6\u00a2\u0522\n\u00a2\r\u00a2\16"+
		"\u00a2\u0523\3\u00a2\5\u00a2\u0527\n\u00a2\3\u00a2\3\u00a2\3\u00a2\3\u00a2"+
		"\5\u00a2\u052d\n\u00a2\3\u00a2\3\u00a2\3\u00a2\5\u00a2\u0532\n\u00a2\3"+
		"\u00a3\6\u00a3\u0535\n\u00a3\r\u00a3\16\u00a3\u0536\3\u00a3\5\u00a3\u053a"+
		"\n\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3\5\u00a3\u0541\n\u00a3"+
		"\3\u00a3\3\u00a3\3\u00a3\3\u00a3\3\u00a3\5\u00a3\u0548\n\u00a3\3\u00a4"+
		"\3\u00a4\3\u00a4\6\u00a4\u054d\n\u00a4\r\u00a4\16\u00a4\u054e\3\u00a5"+
		"\3\u00a5\3\u00a5\3\u00a5\7\u00a5\u0555\n\u00a5\f\u00a5\16\u00a5\u0558"+
		"\13\u00a5\3\u00a5\3\u00a5\3\u00a6\6\u00a6\u055d\n\u00a6\r\u00a6\16\u00a6"+
		"\u055e\3\u00a6\3\u00a6\7\u00a6\u0563\n\u00a6\f\u00a6\16\u00a6\u0566\13"+
		"\u00a6\3\u00a6\3\u00a6\6\u00a6\u056a\n\u00a6\r\u00a6\16\u00a6\u056b\5"+
		"\u00a6\u056e\n\u00a6\3\u00a7\3\u00a7\5\u00a7\u0572\n\u00a7\3\u00a7\6\u00a7"+
		"\u0575\n\u00a7\r\u00a7\16\u00a7\u0576\3\u00a8\3\u00a8\3\u00a9\3\u00a9"+
		"\3\u00aa\3\u00aa\3\u00aa\3\u00aa\7\u00aa\u0581\n\u00aa\f\u00aa\16\u00aa"+
		"\u0584\13\u00aa\3\u00aa\5\u00aa\u0587\n\u00aa\3\u00aa\5\u00aa\u058a\n"+
		"\u00aa\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab"+
		"\3\u00ab\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\7\u00ac\u059a\n\u00ac"+
		"\f\u00ac\16\u00ac\u059d\13\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac"+
		"\3\u00ad\6\u00ad\u05a5\n\u00ad\r\u00ad\16\u00ad\u05a6\3\u00ad\3\u00ad"+
		"\3\u00ae\3\u00ae\3\u059b\2\u00af\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085"+
		"D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099"+
		"N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00ad"+
		"X\u00afY\u00b1Z\u00b3[\u00b5\\\u00b7]\u00b9^\u00bb_\u00bd`\u00bfa\u00c1"+
		"b\u00c3c\u00c5d\u00c7e\u00c9f\u00cbg\u00cdh\u00cfi\u00d1j\u00d3k\u00d5"+
		"l\u00d7m\u00d9n\u00dbo\u00ddp\u00dfq\u00e1r\u00e3s\u00e5t\u00e7u\u00e9"+
		"v\u00ebw\u00edx\u00efy\u00f1z\u00f3{\u00f5|\u00f7}\u00f9~\u00fb\177\u00fd"+
		"\u0080\u00ff\u0081\u0101\u0082\u0103\u0083\u0105\u0084\u0107\u0085\u0109"+
		"\u0086\u010b\u0087\u010d\u0088\u010f\u0089\u0111\u008a\u0113\u008b\u0115"+
		"\u008c\u0117\u008d\u0119\u008e\u011b\u008f\u011d\u0090\u011f\u0091\u0121"+
		"\u0092\u0123\u0093\u0125\u0094\u0127\u0095\u0129\u0096\u012b\u0097\u012d"+
		"\u0098\u012f\u0099\u0131\u009a\u0133\u009b\u0135\u009c\u0137\u009d\u0139"+
		"\u009e\u013b\u009f\u013d\u00a0\u013f\u00a1\u0141\u00a2\u0143\u00a3\u0145"+
		"\u00a4\u0147\u00a5\u0149\u00a6\u014b\2\u014d\2\u014f\2\u0151\2\u0153\u00a7"+
		"\u0155\u00a8\u0157\u00a9\u0159\u00aa\u015b\u00ab\3\2\f\4\2))^^\4\2$$^"+
		"^\6\2DDIIMMOO\3\2bb\4\2--//\3\2\62;\3\2C\\\4\2\f\f\17\17\3\2--\5\2\13"+
		"\f\17\17\"\"\u05d3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2"+
		"\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2"+
		"\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b"+
		"\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2"+
		"\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d"+
		"\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2"+
		"\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af"+
		"\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2"+
		"\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1"+
		"\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2"+
		"\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1\3\2\2\2\2\u00d3"+
		"\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2\2\2\u00d9\3\2\2\2\2\u00db\3\2\2"+
		"\2\2\u00dd\3\2\2\2\2\u00df\3\2\2\2\2\u00e1\3\2\2\2\2\u00e3\3\2\2\2\2\u00e5"+
		"\3\2\2\2\2\u00e7\3\2\2\2\2\u00e9\3\2\2\2\2\u00eb\3\2\2\2\2\u00ed\3\2\2"+
		"\2\2\u00ef\3\2\2\2\2\u00f1\3\2\2\2\2\u00f3\3\2\2\2\2\u00f5\3\2\2\2\2\u00f7"+
		"\3\2\2\2\2\u00f9\3\2\2\2\2\u00fb\3\2\2\2\2\u00fd\3\2\2\2\2\u00ff\3\2\2"+
		"\2\2\u0101\3\2\2\2\2\u0103\3\2\2\2\2\u0105\3\2\2\2\2\u0107\3\2\2\2\2\u0109"+
		"\3\2\2\2\2\u010b\3\2\2\2\2\u010d\3\2\2\2\2\u010f\3\2\2\2\2\u0111\3\2\2"+
		"\2\2\u0113\3\2\2\2\2\u0115\3\2\2\2\2\u0117\3\2\2\2\2\u0119\3\2\2\2\2\u011b"+
		"\3\2\2\2\2\u011d\3\2\2\2\2\u011f\3\2\2\2\2\u0121\3\2\2\2\2\u0123\3\2\2"+
		"\2\2\u0125\3\2\2\2\2\u0127\3\2\2\2\2\u0129\3\2\2\2\2\u012b\3\2\2\2\2\u012d"+
		"\3\2\2\2\2\u012f\3\2\2\2\2\u0131\3\2\2\2\2\u0133\3\2\2\2\2\u0135\3\2\2"+
		"\2\2\u0137\3\2\2\2\2\u0139\3\2\2\2\2\u013b\3\2\2\2\2\u013d\3\2\2\2\2\u013f"+
		"\3\2\2\2\2\u0141\3\2\2\2\2\u0143\3\2\2\2\2\u0145\3\2\2\2\2\u0147\3\2\2"+
		"\2\2\u0149\3\2\2\2\2\u0153\3\2\2\2\2\u0155\3\2\2\2\2\u0157\3\2\2\2\2\u0159"+
		"\3\2\2\2\2\u015b\3\2\2\2\3\u015d\3\2\2\2\5\u015f\3\2\2\2\7\u0161\3\2\2"+
		"\2\t\u0163\3\2\2\2\13\u0165\3\2\2\2\r\u0167\3\2\2\2\17\u0169\3\2\2\2\21"+
		"\u016b\3\2\2\2\23\u0172\3\2\2\2\25\u0177\3\2\2\2\27\u017b\3\2\2\2\31\u017e"+
		"\3\2\2\2\33\u0182\3\2\2\2\35\u018b\3\2\2\2\37\u0191\3\2\2\2!\u0197\3\2"+
		"\2\2#\u019a\3\2\2\2%\u01a3\3\2\2\2\'\u01a8\3\2\2\2)\u01ad\3\2\2\2+\u01b4"+
		"\3\2\2\2-\u01ba\3\2\2\2/\u01c1\3\2\2\2\61\u01c7\3\2\2\2\63\u01ca\3\2\2"+
		"\2\65\u01cd\3\2\2\2\67\u01d1\3\2\2\29\u01d8\3\2\2\2;\u01da\3\2\2\2=\u01dd"+
		"\3\2\2\2?\u01e4\3\2\2\2A\u01ec\3\2\2\2C\u01fc\3\2\2\2E\u01fe\3\2\2\2G"+
		"\u0201\3\2\2\2I\u0206\3\2\2\2K\u020b\3\2\2\2M\u0211\3\2\2\2O\u0217\3\2"+
		"\2\2Q\u021b\3\2\2\2S\u0220\3\2\2\2U\u0224\3\2\2\2W\u022d\3\2\2\2Y\u0232"+
		"\3\2\2\2[\u0237\3\2\2\2]\u023c\3\2\2\2_\u0241\3\2\2\2a\u0245\3\2\2\2c"+
		"\u024a\3\2\2\2e\u0250\3\2\2\2g\u0256\3\2\2\2i\u025c\3\2\2\2k\u0261\3\2"+
		"\2\2m\u0266\3\2\2\2o\u026c\3\2\2\2q\u0271\3\2\2\2s\u0279\3\2\2\2u\u027c"+
		"\3\2\2\2w\u0282\3\2\2\2y\u0288\3\2\2\2{\u028d\3\2\2\2}\u0294\3\2\2\2\177"+
		"\u029b\3\2\2\2\u0081\u02a1\3\2\2\2\u0083\u02a6\3\2\2\2\u0085\u02ae\3\2"+
		"\2\2\u0087\u02b5\3\2\2\2\u0089\u02bc\3\2\2\2\u008b\u02c1\3\2\2\2\u008d"+
		"\u02ca\3\2\2\2\u008f\u02d2\3\2\2\2\u0091\u02d7\3\2\2\2\u0093\u02dc\3\2"+
		"\2\2\u0095\u02e3\3\2\2\2\u0097\u02eb\3\2\2\2\u0099\u02f2\3\2\2\2\u009b"+
		"\u02f6\3\2\2\2\u009d\u0300\3\2\2\2\u009f\u0305\3\2\2\2\u00a1\u030b\3\2"+
		"\2\2\u00a3\u0312\3\2\2\2\u00a5\u0318\3\2\2\2\u00a7\u0322\3\2\2\2\u00a9"+
		"\u0325\3\2\2\2\u00ab\u032b\3\2\2\2\u00ad\u0332\3\2\2\2\u00af\u0338\3\2"+
		"\2\2\u00b1\u033c\3\2\2\2\u00b3\u0343\3\2\2\2\u00b5\u034b\3\2\2\2\u00b7"+
		"\u034f\3\2\2\2\u00b9\u0355\3\2\2\2\u00bb\u035c\3\2\2\2\u00bd\u0365\3\2"+
		"\2\2\u00bf\u036c\3\2\2\2\u00c1\u0371\3\2\2\2\u00c3\u0376\3\2\2\2\u00c5"+
		"\u037e\3\2\2\2\u00c7\u038a\3\2\2\2\u00c9\u0391\3\2\2\2\u00cb\u0396\3\2"+
		"\2\2\u00cd\u039b\3\2\2\2\u00cf\u03a1\3\2\2\2\u00d1\u03ab\3\2\2\2\u00d3"+
		"\u03b9\3\2\2\2\u00d5\u03c1\3\2\2\2\u00d7\u03c6\3\2\2\2\u00d9\u03cb\3\2"+
		"\2\2\u00db\u03cf\3\2\2\2\u00dd\u03d6\3\2\2\2\u00df\u03de\3\2\2\2\u00e1"+
		"\u03e8\3\2\2\2\u00e3\u03f0\3\2\2\2\u00e5\u03f6\3\2\2\2\u00e7\u03f8\3\2"+
		"\2\2\u00e9\u03fc\3\2\2\2\u00eb\u03ff\3\2\2\2\u00ed\u0402\3\2\2\2\u00ef"+
		"\u0408\3\2\2\2\u00f1\u040a\3\2\2\2\u00f3\u0410\3\2\2\2\u00f5\u0412\3\2"+
		"\2\2\u00f7\u0414\3\2\2\2\u00f9\u0416\3\2\2\2\u00fb\u0418\3\2\2\2\u00fd"+
		"\u041a\3\2\2\2\u00ff\u041c\3\2\2\2\u0101\u0420\3\2\2\2\u0103\u0422\3\2"+
		"\2\2\u0105\u0424\3\2\2\2\u0107\u0426\3\2\2\2\u0109\u0428\3\2\2\2\u010b"+
		"\u042a\3\2\2\2\u010d\u0432\3\2\2\2\u010f\u0436\3\2\2\2\u0111\u0439\3\2"+
		"\2\2\u0113\u0450\3\2\2\2\u0115\u0462\3\2\2\2\u0117\u0464\3\2\2\2\u0119"+
		"\u046d\3\2\2\2\u011b\u0475\3\2\2\2\u011d\u047d\3\2\2\2\u011f\u0482\3\2"+
		"\2\2\u0121\u0489\3\2\2\2\u0123\u048f\3\2\2\2\u0125\u0496\3\2\2\2\u0127"+
		"\u049d\3\2\2\2\u0129\u04a2\3\2\2\2\u012b\u04a7\3\2\2\2\u012d\u04ad\3\2"+
		"\2\2\u012f\u04b3\3\2\2\2\u0131\u04bb\3\2\2\2\u0133\u04c8\3\2\2\2\u0135"+
		"\u04ee\3\2\2\2\u0137\u04f1\3\2\2\2\u0139\u04f8\3\2\2\2\u013b\u04ff\3\2"+
		"\2\2\u013d\u0506\3\2\2\2\u013f\u050d\3\2\2\2\u0141\u051e\3\2\2\2\u0143"+
		"\u0531\3\2\2\2\u0145\u0547\3\2\2\2\u0147\u054c\3\2\2\2\u0149\u0550\3\2"+
		"\2\2\u014b\u056d\3\2\2\2\u014d\u056f\3\2\2\2\u014f\u0578\3\2\2\2\u0151"+
		"\u057a\3\2\2\2\u0153\u057c\3\2\2\2\u0155\u058d\3\2\2\2\u0157\u0594\3\2"+
		"\2\2\u0159\u05a4\3\2\2\2\u015b\u05aa\3\2\2\2\u015d\u015e\7*\2\2\u015e"+
		"\4\3\2\2\2\u015f\u0160\7+\2\2\u0160\6\3\2\2\2\u0161\u0162\7.\2\2\u0162"+
		"\b\3\2\2\2\u0163\u0164\7\60\2\2\u0164\n\3\2\2\2\u0165\u0166\7]\2\2\u0166"+
		"\f\3\2\2\2\u0167\u0168\7_\2\2\u0168\16\3\2\2\2\u0169\u016a\7<\2\2\u016a"+
		"\20\3\2\2\2\u016b\u016c\7U\2\2\u016c\u016d\7G\2\2\u016d\u016e\7N\2\2\u016e"+
		"\u016f\7G\2\2\u016f\u0170\7E\2\2\u0170\u0171\7V\2\2\u0171\22\3\2\2\2\u0172"+
		"\u0173\7H\2\2\u0173\u0174\7T\2\2\u0174\u0175\7Q\2\2\u0175\u0176\7O\2\2"+
		"\u0176\24\3\2\2\2\u0177\u0178\7C\2\2\u0178\u0179\7F\2\2\u0179\u017a\7"+
		"F\2\2\u017a\26\3\2\2\2\u017b\u017c\7C\2\2\u017c\u017d\7U\2\2\u017d\30"+
		"\3\2\2\2\u017e\u017f\7C\2\2\u017f\u0180\7N\2\2\u0180\u0181\7N\2\2\u0181"+
		"\32\3\2\2\2\u0182\u0183\7F\2\2\u0183\u0184\7K\2\2\u0184\u0185\7U\2\2\u0185"+
		"\u0186\7V\2\2\u0186\u0187\7K\2\2\u0187\u0188\7P\2\2\u0188\u0189\7E\2\2"+
		"\u0189\u018a\7V\2\2\u018a\34\3\2\2\2\u018b\u018c\7Y\2\2\u018c\u018d\7"+
		"J\2\2\u018d\u018e\7G\2\2\u018e\u018f\7T\2\2\u018f\u0190\7G\2\2\u0190\36"+
		"\3\2\2\2\u0191\u0192\7I\2\2\u0192\u0193\7T\2\2\u0193\u0194\7Q\2\2\u0194"+
		"\u0195\7W\2\2\u0195\u0196\7R\2\2\u0196 \3\2\2\2\u0197\u0198\7D\2\2\u0198"+
		"\u0199\7[\2\2\u0199\"\3\2\2\2\u019a\u019b\7I\2\2\u019b\u019c\7T\2\2\u019c"+
		"\u019d\7Q\2\2\u019d\u019e\7W\2\2\u019e\u019f\7R\2\2\u019f\u01a0\7K\2\2"+
		"\u01a0\u01a1\7P\2\2\u01a1\u01a2\7I\2\2\u01a2$\3\2\2\2\u01a3\u01a4\7U\2"+
		"\2\u01a4\u01a5\7G\2\2\u01a5\u01a6\7V\2\2\u01a6\u01a7\7U\2\2\u01a7&\3\2"+
		"\2\2\u01a8\u01a9\7E\2\2\u01a9\u01aa\7W\2\2\u01aa\u01ab\7D\2\2\u01ab\u01ac"+
		"\7G\2\2\u01ac(\3\2\2\2\u01ad\u01ae\7T\2\2\u01ae\u01af\7Q\2\2\u01af\u01b0"+
		"\7N\2\2\u01b0\u01b1\7N\2\2\u01b1\u01b2\7W\2\2\u01b2\u01b3\7R\2\2\u01b3"+
		"*\3\2\2\2\u01b4\u01b5\7Q\2\2\u01b5\u01b6\7T\2\2\u01b6\u01b7\7F\2\2\u01b7"+
		"\u01b8\7G\2\2\u01b8\u01b9\7T\2\2\u01b9,\3\2\2\2\u01ba\u01bb\7J\2\2\u01bb"+
		"\u01bc\7C\2\2\u01bc\u01bd\7X\2\2\u01bd\u01be\7K\2\2\u01be\u01bf\7P\2\2"+
		"\u01bf\u01c0\7I\2\2\u01c0.\3\2\2\2\u01c1\u01c2\7N\2\2\u01c2\u01c3\7K\2"+
		"\2\u01c3\u01c4\7O\2\2\u01c4\u01c5\7K\2\2\u01c5\u01c6\7V\2\2\u01c6\60\3"+
		"\2\2\2\u01c7\u01c8\7C\2\2\u01c8\u01c9\7V\2\2\u01c9\62\3\2\2\2\u01ca\u01cb"+
		"\7Q\2\2\u01cb\u01cc\7T\2\2\u01cc\64\3\2\2\2\u01cd\u01ce\7C\2\2\u01ce\u01cf"+
		"\7P\2\2\u01cf\u01d0\7F\2\2\u01d0\66\3\2\2\2\u01d1\u01d2\7K\2\2\u01d2\u01d3"+
		"\7P\2\2\u01d38\3\2\2\2\u01d4\u01d5\7P\2\2\u01d5\u01d6\7Q\2\2\u01d6\u01d9"+
		"\7V\2\2\u01d7\u01d9\7#\2\2\u01d8\u01d4\3\2\2\2\u01d8\u01d7\3\2\2\2\u01d9"+
		":\3\2\2\2\u01da\u01db\7P\2\2\u01db\u01dc\7Q\2\2\u01dc<\3\2\2\2\u01dd\u01de"+
		"\7G\2\2\u01de\u01df\7Z\2\2\u01df\u01e0\7K\2\2\u01e0\u01e1\7U\2\2\u01e1"+
		"\u01e2\7V\2\2\u01e2\u01e3\7U\2\2\u01e3>\3\2\2\2\u01e4\u01e5\7D\2\2\u01e5"+
		"\u01e6\7G\2\2\u01e6\u01e7\7V\2\2\u01e7\u01e8\7Y\2\2\u01e8\u01e9\7G\2\2"+
		"\u01e9\u01ea\7G\2\2\u01ea\u01eb\7P\2\2\u01eb@\3\2\2\2\u01ec\u01ed\7N\2"+
		"\2\u01ed\u01ee\7K\2\2\u01ee\u01ef\7M\2\2\u01ef\u01f0\7G\2\2\u01f0B\3\2"+
		"\2\2\u01f1\u01f2\7T\2\2\u01f2\u01f3\7N\2\2\u01f3\u01f4\7K\2\2\u01f4\u01f5"+
		"\7M\2\2\u01f5\u01fd\7G\2\2\u01f6\u01f7\7T\2\2\u01f7\u01f8\7G\2\2\u01f8"+
		"\u01f9\7I\2\2\u01f9\u01fa\7G\2\2\u01fa\u01fb\7Z\2\2\u01fb\u01fd\7R\2\2"+
		"\u01fc\u01f1\3\2\2\2\u01fc\u01f6\3\2\2\2\u01fdD\3\2\2\2\u01fe\u01ff\7"+
		"K\2\2\u01ff\u0200\7U\2\2\u0200F\3\2\2\2\u0201\u0202\7P\2\2\u0202\u0203"+
		"\7W\2\2\u0203\u0204\7N\2\2\u0204\u0205\7N\2\2\u0205H\3\2\2\2\u0206\u0207"+
		"\7V\2\2\u0207\u0208\7T\2\2\u0208\u0209\7W\2\2\u0209\u020a\7G\2\2\u020a"+
		"J\3\2\2\2\u020b\u020c\7H\2\2\u020c\u020d\7C\2\2\u020d\u020e\7N\2\2\u020e"+
		"\u020f\7U\2\2\u020f\u0210\7G\2\2\u0210L\3\2\2\2\u0211\u0212\7P\2\2\u0212"+
		"\u0213\7W\2\2\u0213\u0214\7N\2\2\u0214\u0215\7N\2\2\u0215\u0216\7U\2\2"+
		"\u0216N\3\2\2\2\u0217\u0218\7C\2\2\u0218\u0219\7U\2\2\u0219\u021a\7E\2"+
		"\2\u021aP\3\2\2\2\u021b\u021c\7F\2\2\u021c\u021d\7G\2\2\u021d\u021e\7"+
		"U\2\2\u021e\u021f\7E\2\2\u021fR\3\2\2\2\u0220\u0221\7H\2\2\u0221\u0222"+
		"\7Q\2\2\u0222\u0223\7T\2\2\u0223T\3\2\2\2\u0224\u0225\7K\2\2\u0225\u0226"+
		"\7P\2\2\u0226\u0227\7V\2\2\u0227\u0228\7G\2\2\u0228\u0229\7T\2\2\u0229"+
		"\u022a\7X\2\2\u022a\u022b\7C\2\2\u022b\u022c\7N\2\2\u022cV\3\2\2\2\u022d"+
		"\u022e\7E\2\2\u022e\u022f\7C\2\2\u022f\u0230\7U\2\2\u0230\u0231\7G\2\2"+
		"\u0231X\3\2\2\2\u0232\u0233\7Y\2\2\u0233\u0234\7J\2\2\u0234\u0235\7G\2"+
		"\2\u0235\u0236\7P\2\2\u0236Z\3\2\2\2\u0237\u0238\7V\2\2\u0238\u0239\7"+
		"J\2\2\u0239\u023a\7G\2\2\u023a\u023b\7P\2\2\u023b\\\3\2\2\2\u023c\u023d"+
		"\7G\2\2\u023d\u023e\7N\2\2\u023e\u023f\7U\2\2\u023f\u0240\7G\2\2\u0240"+
		"^\3\2\2\2\u0241\u0242\7G\2\2\u0242\u0243\7P\2\2\u0243\u0244\7F\2\2\u0244"+
		"`\3\2\2\2\u0245\u0246\7L\2\2\u0246\u0247\7Q\2\2\u0247\u0248\7K\2\2\u0248"+
		"\u0249\7P\2\2\u0249b\3\2\2\2\u024a\u024b\7E\2\2\u024b\u024c\7T\2\2\u024c"+
		"\u024d\7Q\2\2\u024d\u024e\7U\2\2\u024e\u024f\7U\2\2\u024fd\3\2\2\2\u0250"+
		"\u0251\7Q\2\2\u0251\u0252\7W\2\2\u0252\u0253\7V\2\2\u0253\u0254\7G\2\2"+
		"\u0254\u0255\7T\2\2\u0255f\3\2\2\2\u0256\u0257\7K\2\2\u0257\u0258\7P\2"+
		"\2\u0258\u0259\7P\2\2\u0259\u025a\7G\2\2\u025a\u025b\7T\2\2\u025bh\3\2"+
		"\2\2\u025c\u025d\7N\2\2\u025d\u025e\7G\2\2\u025e\u025f\7H\2\2\u025f\u0260"+
		"\7V\2\2\u0260j\3\2\2\2\u0261\u0262\7U\2\2\u0262\u0263\7G\2\2\u0263\u0264"+
		"\7O\2\2\u0264\u0265\7K\2\2\u0265l\3\2\2\2\u0266\u0267\7T\2\2\u0267\u0268"+
		"\7K\2\2\u0268\u0269\7I\2\2\u0269\u026a\7J\2\2\u026a\u026b\7V\2\2\u026b"+
		"n\3\2\2\2\u026c\u026d\7H\2\2\u026d\u026e\7W\2\2\u026e\u026f\7N\2\2\u026f"+
		"\u0270\7N\2\2\u0270p\3\2\2\2\u0271\u0272\7P\2\2\u0272\u0273\7C\2\2\u0273"+
		"\u0274\7V\2\2\u0274\u0275\7W\2\2\u0275\u0276\7T\2\2\u0276\u0277\7C\2\2"+
		"\u0277\u0278\7N\2\2\u0278r\3\2\2\2\u0279\u027a\7Q\2\2\u027a\u027b\7P\2"+
		"\2\u027bt\3\2\2\2\u027c\u027d\7H\2\2\u027d\u027e\7K\2\2\u027e\u027f\7"+
		"T\2\2\u027f\u0280\7U\2\2\u0280\u0281\7V\2\2\u0281v\3\2\2\2\u0282\u0283"+
		"\7C\2\2\u0283\u0284\7H\2\2\u0284\u0285\7V\2\2\u0285\u0286\7G\2\2\u0286"+
		"\u0287\7T\2\2\u0287x\3\2\2\2\u0288\u0289\7N\2\2\u0289\u028a\7C\2\2\u028a"+
		"\u028b\7U\2\2\u028b\u028c\7V\2\2\u028cz\3\2\2\2\u028d\u028e\7X\2\2\u028e"+
		"\u028f\7C\2\2\u028f\u0290\7N\2\2\u0290\u0291\7W\2\2\u0291\u0292\7G\2\2"+
		"\u0292\u0293\7U\2\2\u0293|\3\2\2\2\u0294\u0295\7E\2\2\u0295\u0296\7T\2"+
		"\2\u0296\u0297\7G\2\2\u0297\u0298\7C\2\2\u0298\u0299\7V\2\2\u0299\u029a"+
		"\7G\2\2\u029a~\3\2\2\2\u029b\u029c\7V\2\2\u029c\u029d\7C\2\2\u029d\u029e"+
		"\7D\2\2\u029e\u029f\7N\2\2\u029f\u02a0\7G\2\2\u02a0\u0080\3\2\2\2\u02a1"+
		"\u02a2\7X\2\2\u02a2\u02a3\7K\2\2\u02a3\u02a4\7G\2\2\u02a4\u02a5\7Y\2\2"+
		"\u02a5\u0082\3\2\2\2\u02a6\u02a7\7T\2\2\u02a7\u02a8\7G\2\2\u02a8\u02a9"+
		"\7R\2\2\u02a9\u02aa\7N\2\2\u02aa\u02ab\7C\2\2\u02ab\u02ac\7E\2\2\u02ac"+
		"\u02ad\7G\2\2\u02ad\u0084\3\2\2\2\u02ae\u02af\7K\2\2\u02af\u02b0\7P\2"+
		"\2\u02b0\u02b1\7U\2\2\u02b1\u02b2\7G\2\2\u02b2\u02b3\7T\2\2\u02b3\u02b4"+
		"\7V\2\2\u02b4\u0086\3\2\2\2\u02b5\u02b6\7F\2\2\u02b6\u02b7\7G\2\2\u02b7"+
		"\u02b8\7N\2\2\u02b8\u02b9\7G\2\2\u02b9\u02ba\7V\2\2\u02ba\u02bb\7G\2\2"+
		"\u02bb\u0088\3\2\2\2\u02bc\u02bd\7K\2\2\u02bd\u02be\7P\2\2\u02be\u02bf"+
		"\7V\2\2\u02bf\u02c0\7Q\2\2\u02c0\u008a\3\2\2\2\u02c1\u02c2\7F\2\2\u02c2"+
		"\u02c3\7G\2\2\u02c3\u02c4\7U\2\2\u02c4\u02c5\7E\2\2\u02c5\u02c6\7T\2\2"+
		"\u02c6\u02c7\7K\2\2\u02c7\u02c8\7D\2\2\u02c8\u02c9\7G\2\2\u02c9\u008c"+
		"\3\2\2\2\u02ca\u02cb\7G\2\2\u02cb\u02cc\7Z\2\2\u02cc\u02cd\7R\2\2\u02cd"+
		"\u02ce\7N\2\2\u02ce\u02cf\7C\2\2\u02cf\u02d0\7K\2\2\u02d0\u02d1\7P\2\2"+
		"\u02d1\u008e\3\2\2\2\u02d2\u02d3\7E\2\2\u02d3\u02d4\7C\2\2\u02d4\u02d5"+
		"\7U\2\2\u02d5\u02d6\7V\2\2\u02d6\u0090\3\2\2\2\u02d7\u02d8\7U\2\2\u02d8"+
		"\u02d9\7J\2\2\u02d9\u02da\7Q\2\2\u02da\u02db\7Y\2\2\u02db\u0092\3\2\2"+
		"\2\u02dc\u02dd\7V\2\2\u02dd\u02de\7C\2\2\u02de\u02df\7D\2\2\u02df\u02e0"+
		"\7N\2\2\u02e0\u02e1\7G\2\2\u02e1\u02e2\7U\2\2\u02e2\u0094\3\2\2\2\u02e3"+
		"\u02e4\7E\2\2\u02e4\u02e5\7Q\2\2\u02e5\u02e6\7N\2\2\u02e6\u02e7\7W\2\2"+
		"\u02e7\u02e8\7O\2\2\u02e8\u02e9\7P\2\2\u02e9\u02ea\7U\2\2\u02ea\u0096"+
		"\3\2\2\2\u02eb\u02ec\7E\2\2\u02ec\u02ed\7Q\2\2\u02ed\u02ee\7N\2\2\u02ee"+
		"\u02ef\7W\2\2\u02ef\u02f0\7O\2\2\u02f0\u02f1\7P\2\2\u02f1\u0098\3\2\2"+
		"\2\u02f2\u02f3\7W\2\2\u02f3\u02f4\7U\2\2\u02f4\u02f5\7G\2\2\u02f5\u009a"+
		"\3\2\2\2\u02f6\u02f7\7H\2\2\u02f7\u02f8\7W\2\2\u02f8\u02f9\7P\2\2\u02f9"+
		"\u02fa\7E\2\2\u02fa\u02fb\7V\2\2\u02fb\u02fc\7K\2\2\u02fc\u02fd\7Q\2\2"+
		"\u02fd\u02fe\7P\2\2\u02fe\u02ff\7U\2\2\u02ff\u009c\3\2\2\2\u0300\u0301"+
		"\7F\2\2\u0301\u0302\7T\2\2\u0302\u0303\7Q\2\2\u0303\u0304\7R\2\2\u0304"+
		"\u009e\3\2\2\2\u0305\u0306\7W\2\2\u0306\u0307\7P\2\2\u0307\u0308\7K\2"+
		"\2\u0308\u0309\7Q\2\2\u0309\u030a\7P\2\2\u030a\u00a0\3\2\2\2\u030b\u030c"+
		"\7G\2\2\u030c\u030d\7Z\2\2\u030d\u030e\7E\2\2\u030e\u030f\7G\2\2\u030f"+
		"\u0310\7R\2\2\u0310\u0311\7V\2\2\u0311\u00a2\3\2\2\2\u0312\u0313\7O\2"+
		"\2\u0313\u0314\7K\2\2\u0314\u0315\7P\2\2\u0315\u0316\7W\2\2\u0316\u0317"+
		"\7U\2\2\u0317\u00a4\3\2\2\2\u0318\u0319\7K\2\2\u0319\u031a\7P\2\2\u031a"+
		"\u031b\7V\2\2\u031b\u031c\7G\2\2\u031c\u031d\7T\2\2\u031d\u031e\7U\2\2"+
		"\u031e\u031f\7G\2\2\u031f\u0320\7E\2\2\u0320\u0321\7V\2\2\u0321\u00a6"+
		"\3\2\2\2\u0322\u0323\7V\2\2\u0323\u0324\7Q\2\2\u0324\u00a8\3\2\2\2\u0325"+
		"\u0326\7C\2\2\u0326\u0327\7N\2\2\u0327\u0328\7V\2\2\u0328\u0329\7G\2\2"+
		"\u0329\u032a\7T\2\2\u032a\u00aa\3\2\2\2\u032b\u032c\7T\2\2\u032c\u032d"+
		"\7G\2\2\u032d\u032e\7P\2\2\u032e\u032f\7C\2\2\u032f\u0330\7O\2\2\u0330"+
		"\u0331\7G\2\2\u0331\u00ac\3\2\2\2\u0332\u0333\7C\2\2\u0333\u0334\7T\2"+
		"\2\u0334\u0335\7T\2\2\u0335\u0336\7C\2\2\u0336\u0337\7[\2\2\u0337\u00ae"+
		"\3\2\2\2\u0338\u0339\7O\2\2\u0339\u033a\7C\2\2\u033a\u033b\7R\2\2\u033b"+
		"\u00b0\3\2\2\2\u033c\u033d\7U\2\2\u033d\u033e\7V\2\2\u033e\u033f\7T\2"+
		"\2\u033f\u0340\7W\2\2\u0340\u0341\7E\2\2\u0341\u0342\7V\2\2\u0342\u00b2"+
		"\3\2\2\2\u0343\u0344\7E\2\2\u0344\u0345\7Q\2\2\u0345\u0346\7O\2\2\u0346"+
		"\u0347\7O\2\2\u0347\u0348\7G\2\2\u0348\u0349\7P\2\2\u0349\u034a\7V\2\2"+
		"\u034a\u00b4\3\2\2\2\u034b\u034c\7U\2\2\u034c\u034d\7G\2\2\u034d\u034e"+
		"\7V\2\2\u034e\u00b6\3\2\2\2\u034f\u0350\7T\2\2\u0350\u0351\7G\2\2\u0351"+
		"\u0352\7U\2\2\u0352\u0353\7G\2\2\u0353\u0354\7V\2\2\u0354\u00b8\3\2\2"+
		"\2\u0355\u0356\7E\2\2\u0356\u0357\7Q\2\2\u0357\u0358\7O\2\2\u0358\u0359"+
		"\7O\2\2\u0359\u035a\7K\2\2\u035a\u035b\7V\2\2\u035b\u00ba\3\2\2\2\u035c"+
		"\u035d\7T\2\2\u035d\u035e\7Q\2\2\u035e\u035f\7N\2\2\u035f\u0360\7N\2\2"+
		"\u0360\u0361\7D\2\2\u0361\u0362\7C\2\2\u0362\u0363\7E\2\2\u0363\u0364"+
		"\7M\2\2\u0364\u00bc\3\2\2\2\u0365\u0366\7K\2\2\u0366\u0367\7I\2\2\u0367"+
		"\u0368\7P\2\2\u0368\u0369\7Q\2\2\u0369\u036a\7T\2\2\u036a\u036b\7G\2\2"+
		"\u036b\u00be\3\2\2\2\u036c\u036d\7E\2\2\u036d\u036e\7C\2\2\u036e\u036f"+
		"\7N\2\2\u036f\u0370\7N\2\2\u0370\u00c0\3\2\2\2\u0371\u0372\7Y\2\2\u0372"+
		"\u0373\7K\2\2\u0373\u0374\7V\2\2\u0374\u0375\7J\2\2\u0375\u00c2\3\2\2"+
		"\2\u0376\u0377\7X\2\2\u0377\u0378\7G\2\2\u0378\u0379\7T\2\2\u0379\u037a"+
		"\7U\2\2\u037a\u037b\7K\2\2\u037b\u037c\7Q\2\2\u037c\u037d\7P\2\2\u037d"+
		"\u00c4\3\2\2\2\u037e\u037f\7G\2\2\u037f\u0380\7P\2\2\u0380\u0381\7F\2"+
		"\2\u0381\u0382\7Q\2\2\u0382\u0383\7T\2\2\u0383\u0384\7U\2\2\u0384\u0385"+
		"\7G\2\2\u0385\u0386\7O\2\2\u0386\u0387\7G\2\2\u0387\u0388\7P\2\2\u0388"+
		"\u0389\7V\2\2\u0389\u00c6\3\2\2\2\u038a\u038b\7R\2\2\u038b\u038c\7Q\2"+
		"\2\u038c\u038d\7N\2\2\u038d\u038e\7K\2\2\u038e\u038f\7E\2\2\u038f\u0390"+
		"\7[\2\2\u0390\u00c8\3\2\2\2\u0391\u0392\7H\2\2\u0392\u0393\7K\2\2\u0393"+
		"\u0394\7N\2\2\u0394\u0395\7G\2\2\u0395\u00ca\3\2\2\2\u0396\u0397\7C\2"+
		"\2\u0397\u0398\7T\2\2\u0398\u0399\7I\2\2\u0399\u039a\7U\2\2\u039a\u00cc"+
		"\3\2\2\2\u039b\u039c\7C\2\2\u039c\u039d\7U\2\2\u039d\u039e\7U\2\2\u039e"+
		"\u039f\7G\2\2\u039f\u03a0\7V\2\2\u03a0\u00ce\3\2\2\2\u03a1\u03a2\7E\2"+
		"\2\u03a2\u03a3\7J\2\2\u03a3\u03a4\7C\2\2\u03a4\u03a5\7K\2\2\u03a5\u03a6"+
		"\7P\2\2\u03a6\u03a7\7E\2\2\u03a7\u03a8\7Q\2\2\u03a8\u03a9\7F\2\2\u03a9"+
		"\u03aa\7G\2\2\u03aa\u00d0\3\2\2\2\u03ab\u03ac\7U\2\2\u03ac\u03ad\7O\2"+
		"\2\u03ad\u03ae\7C\2\2\u03ae\u03af\7T\2\2\u03af\u03b0\7V\2\2\u03b0\u03b1"+
		"\7E\2\2\u03b1\u03b2\7Q\2\2\u03b2\u03b3\7P\2\2\u03b3\u03b4\7V\2\2\u03b4"+
		"\u03b5\7T\2\2\u03b5\u03b6\7C\2\2\u03b6\u03b7\7E\2\2\u03b7\u03b8\7V\2\2"+
		"\u03b8\u00d2\3\2\2\2\u03b9\u03ba\7U\2\2\u03ba\u03bb\7V\2\2\u03bb\u03bc"+
		"\7Q\2\2\u03bc\u03bd\7T\2\2\u03bd\u03be\7C\2\2\u03be\u03bf\7I\2\2\u03bf"+
		"\u03c0\7G\2\2\u03c0\u00d4\3\2\2\2\u03c1\u03c2\7V\2\2\u03c2\u03c3\7[\2"+
		"\2\u03c3\u03c4\7R\2\2\u03c4\u03c5\7G\2\2\u03c5\u00d6\3\2\2\2\u03c6\u03c7"+
		"\7L\2\2\u03c7\u03c8\7U\2\2\u03c8\u03c9\7Q\2\2\u03c9\u03ca\7P\2\2\u03ca"+
		"\u00d8\3\2\2\2\u03cb\u03cc\7E\2\2\u03cc\u03cd\7U\2\2\u03cd\u03ce\7X\2"+
		"\2\u03ce\u00da\3\2\2\2\u03cf\u03d0\7H\2\2\u03d0\u03d1\7K\2\2\u03d1\u03d2"+
		"\7G\2\2\u03d2\u03d3\7N\2\2\u03d3\u03d4\7F\2\2\u03d4\u03d5\7U\2\2\u03d5"+
		"\u00dc\3\2\2\2\u03d6\u03d7\7T\2\2\u03d7\u03d8\7G\2\2\u03d8\u03d9\7E\2"+
		"\2\u03d9\u03da\7Q\2\2\u03da\u03db\7T\2\2\u03db\u03dc\7F\2\2\u03dc\u03dd"+
		"\7U\2\2\u03dd\u00de\3\2\2\2\u03de\u03df\7F\2\2\u03df\u03e0\7G\2\2\u03e0"+
		"\u03e1\7N\2\2\u03e1\u03e2\7K\2\2\u03e2\u03e3\7O\2\2\u03e3\u03e4\7K\2\2"+
		"\u03e4\u03e5\7V\2\2\u03e5\u03e6\7G\2\2\u03e6\u03e7\7F\2\2\u03e7\u00e0"+
		"\3\2\2\2\u03e8\u03e9\7W\2\2\u03e9\u03ea\7R\2\2\u03ea\u03eb\7I\2\2\u03eb"+
		"\u03ec\7T\2\2\u03ec\u03ed\7C\2\2\u03ed\u03ee\7F\2\2\u03ee\u03ef\7G\2\2"+
		"\u03ef\u00e2\3\2\2\2\u03f0\u03f1\7K\2\2\u03f1\u03f2\7H\2\2\u03f2\u00e4"+
		"\3\2\2\2\u03f3\u03f7\7?\2\2\u03f4\u03f5\7?\2\2\u03f5\u03f7\7?\2\2\u03f6"+
		"\u03f3\3\2\2\2\u03f6\u03f4\3\2\2\2\u03f7\u00e6\3\2\2\2\u03f8\u03f9\7>"+
		"\2\2\u03f9\u03fa\7?\2\2\u03fa\u03fb\7@\2\2\u03fb\u00e8\3\2\2\2\u03fc\u03fd"+
		"\7>\2\2\u03fd\u03fe\7@\2\2\u03fe\u00ea\3\2\2\2\u03ff\u0400\7#\2\2\u0400"+
		"\u0401\7?\2\2\u0401\u00ec\3\2\2\2\u0402\u0403\7>\2\2\u0403\u00ee\3\2\2"+
		"\2\u0404\u0405\7>\2\2\u0405\u0409\7?\2\2\u0406\u0407\7#\2\2\u0407\u0409"+
		"\7@\2\2\u0408\u0404\3\2\2\2\u0408\u0406\3\2\2\2\u0409\u00f0\3\2\2\2\u040a"+
		"\u040b\7@\2\2\u040b\u00f2\3\2\2\2\u040c\u040d\7@\2\2\u040d\u0411\7?\2"+
		"\2\u040e\u040f\7#\2\2\u040f\u0411\7>\2\2\u0410\u040c\3\2\2\2\u0410\u040e"+
		"\3\2\2\2\u0411\u00f4\3\2\2\2\u0412\u0413\7-\2\2\u0413\u00f6\3\2\2\2\u0414"+
		"\u0415\7/\2\2\u0415\u00f8\3\2\2\2\u0416\u0417\7,\2\2\u0417\u00fa\3\2\2"+
		"\2\u0418\u0419\7\61\2\2\u0419\u00fc\3\2\2\2\u041a\u041b\7\'\2\2\u041b"+
		"\u00fe\3\2\2\2\u041c\u041d\7F\2\2\u041d\u041e\7K\2\2\u041e\u041f\7X\2"+
		"\2\u041f\u0100\3\2\2\2\u0420\u0421\7\u0080\2\2\u0421\u0102\3\2\2\2\u0422"+
		"\u0423\7(\2\2\u0423\u0104\3\2\2\2\u0424\u0425\7~\2\2\u0425\u0106\3\2\2"+
		"\2\u0426\u0427\7`\2\2\u0427\u0108\3\2\2\2\u0428\u0429\7A\2\2\u0429\u010a"+
		"\3\2\2\2\u042a\u042b\7R\2\2\u042b\u042c\7G\2\2\u042c\u042d\7T\2\2\u042d"+
		"\u042e\7E\2\2\u042e\u042f\7G\2\2\u042f\u0430\7P\2\2\u0430\u0431\7V\2\2"+
		"\u0431\u010c\3\2\2\2\u0432\u0433\7Q\2\2\u0433\u0434\7W\2\2\u0434\u0435"+
		"\7V\2\2\u0435\u010e\3\2\2\2\u0436\u0437\7Q\2\2\u0437\u0438\7H\2\2\u0438"+
		"\u0110\3\2\2\2\u0439\u043a\7H\2\2\u043a\u043b\7W\2\2\u043b\u043c\7P\2"+
		"\2\u043c\u043d\7E\2\2\u043d\u043e\7V\2\2\u043e\u043f\7K\2\2\u043f\u0440"+
		"\7Q\2\2\u0440\u0441\7P\2\2\u0441\u0112\3\2\2\2\u0442\u0443\7F\2\2\u0443"+
		"\u0444\7C\2\2\u0444\u0445\7V\2\2\u0445\u0446\7C\2\2\u0446\u0447\7D\2\2"+
		"\u0447\u0448\7C\2\2\u0448\u0449\7U\2\2\u0449\u0451\7G\2\2\u044a\u044b"+
		"\7U\2\2\u044b\u044c\7E\2\2\u044c\u044d\7J\2\2\u044d\u044e\7G\2\2\u044e"+
		"\u044f\7O\2\2\u044f\u0451\7C\2\2\u0450\u0442\3\2\2\2\u0450\u044a\3\2\2"+
		"\2\u0451\u0114\3\2\2\2\u0452\u0453\7F\2\2\u0453\u0454\7C\2\2\u0454\u0455"+
		"\7V\2\2\u0455\u0456\7C\2\2\u0456\u0457\7D\2\2\u0457\u0458\7C\2\2\u0458"+
		"\u0459\7U\2\2\u0459\u045a\7G\2\2\u045a\u0463\7U\2\2\u045b\u045c\7U\2\2"+
		"\u045c\u045d\7E\2\2\u045d\u045e\7J\2\2\u045e\u045f\7G\2\2\u045f\u0460"+
		"\7O\2\2\u0460\u0461\7C\2\2\u0461\u0463\7U\2\2\u0462\u0452\3\2\2\2\u0462"+
		"\u045b\3\2\2\2\u0463\u0116\3\2\2\2\u0464\u0465\7V\2\2\u0465\u0466\7T\2"+
		"\2\u0466\u0467\7W\2\2\u0467\u0468\7P\2\2\u0468\u0469\7E\2\2\u0469\u046a"+
		"\7C\2\2\u046a\u046b\7V\2\2\u046b\u046c\7G\2\2\u046c\u0118\3\2\2\2\u046d"+
		"\u046e\7C\2\2\u046e\u046f\7P\2\2\u046f\u0470\7C\2\2\u0470\u0471\7N\2\2"+
		"\u0471\u0472\7[\2\2\u0472\u0473\7\\\2\2\u0473\u0474\7G\2\2\u0474\u011a"+
		"\3\2\2\2\u0475\u0476\7E\2\2\u0476\u0477\7Q\2\2\u0477\u0478\7O\2\2\u0478"+
		"\u0479\7R\2\2\u0479\u047a\7W\2\2\u047a\u047b\7V\2\2\u047b\u047c\7G\2\2"+
		"\u047c\u011c\3\2\2\2\u047d\u047e\7N\2\2\u047e\u047f\7K\2\2\u047f\u0480"+
		"\7U\2\2\u0480\u0481\7V\2\2\u0481\u011e\3\2\2\2\u0482\u0483\7T\2\2\u0483"+
		"\u0484\7G\2\2\u0484\u0485\7X\2\2\u0485\u0486\7Q\2\2\u0486\u0487\7M\2\2"+
		"\u0487\u0488\7G\2\2\u0488\u0120\3\2\2\2\u0489\u048a\7I\2\2\u048a\u048b"+
		"\7T\2\2\u048b\u048c\7C\2\2\u048c\u048d\7P\2\2\u048d\u048e\7V\2\2\u048e"+
		"\u0122\3\2\2\2\u048f\u0490\7G\2\2\u0490\u0491\7Z\2\2\u0491\u0492\7R\2"+
		"\2\u0492\u0493\7Q\2\2\u0493\u0494\7T\2\2\u0494\u0495\7V\2\2\u0495\u0124"+
		"\3\2\2\2\u0496\u0497\7K\2\2\u0497\u0498\7O\2\2\u0498\u0499\7R\2\2\u0499"+
		"\u049a\7Q\2\2\u049a\u049b\7T\2\2\u049b\u049c\7V\2\2\u049c\u0126\3\2\2"+
		"\2\u049d\u049e\7N\2\2\u049e\u049f\7Q\2\2\u049f\u04a0\7C\2\2\u04a0\u04a1"+
		"\7F\2\2\u04a1\u0128\3\2\2\2\u04a2\u04a3\7T\2\2\u04a3\u04a4\7Q\2\2\u04a4"+
		"\u04a5\7N\2\2\u04a5\u04a6\7G\2\2\u04a6\u012a\3\2\2\2\u04a7\u04a8\7T\2"+
		"\2\u04a8\u04a9\7Q\2\2\u04a9\u04aa\7N\2\2\u04aa\u04ab\7G\2\2\u04ab\u04ac"+
		"\7U\2\2\u04ac\u012c\3\2\2\2\u04ad\u04ae\7K\2\2\u04ae\u04af\7P\2\2\u04af"+
		"\u04b0\7F\2\2\u04b0\u04b1\7G\2\2\u04b1\u04b2\7Z\2\2\u04b2\u012e\3\2\2"+
		"\2\u04b3\u04b4\7K\2\2\u04b4\u04b5\7P\2\2\u04b5\u04b6\7F\2\2\u04b6\u04b7"+
		"\7G\2\2\u04b7\u04b8\7Z\2\2\u04b8\u04b9\7G\2\2\u04b9\u04ba\7U\2\2\u04ba"+
		"\u0130\3\2\2\2\u04bb\u04bc\7E\2\2\u04bc\u04bd\7W\2\2\u04bd\u04be\7T\2"+
		"\2\u04be\u04bf\7T\2\2\u04bf\u04c0\7G\2\2\u04c0\u04c1\7P\2\2\u04c1\u04c2"+
		"\7V\2\2\u04c2\u04c3\7a\2\2\u04c3\u04c4\7F\2\2\u04c4\u04c5\7C\2\2\u04c5"+
		"\u04c6\7V\2\2\u04c6\u04c7\7G\2\2\u04c7\u0132\3\2\2\2\u04c8\u04c9\7E\2"+
		"\2\u04c9\u04ca\7W\2\2\u04ca\u04cb\7T\2\2\u04cb\u04cc\7T\2\2\u04cc\u04cd"+
		"\7G\2\2\u04cd\u04ce\7P\2\2\u04ce\u04cf\7V\2\2\u04cf\u04d0\7a\2\2\u04d0"+
		"\u04d1\7V\2\2\u04d1\u04d2\7K\2\2\u04d2\u04d3\7O\2\2\u04d3\u04d4\7G\2\2"+
		"\u04d4\u04d5\7U\2\2\u04d5\u04d6\7V\2\2\u04d6\u04d7\7C\2\2\u04d7\u04d8"+
		"\7O\2\2\u04d8\u04d9\7R\2\2\u04d9\u0134\3\2\2\2\u04da\u04e0\7)\2\2\u04db"+
		"\u04df\n\2\2\2\u04dc\u04dd\7^\2\2\u04dd\u04df\13\2\2\2\u04de\u04db\3\2"+
		"\2\2\u04de\u04dc\3\2\2\2\u04df\u04e2\3\2\2\2\u04e0\u04de\3\2\2\2\u04e0"+
		"\u04e1\3\2\2\2\u04e1\u04e3\3\2\2\2\u04e2\u04e0\3\2\2\2\u04e3\u04ef\7)"+
		"\2\2\u04e4\u04ea\7$\2\2\u04e5\u04e9\n\3\2\2\u04e6\u04e7\7^\2\2\u04e7\u04e9"+
		"\13\2\2\2\u04e8\u04e5\3\2\2\2\u04e8\u04e6\3\2\2\2\u04e9\u04ec\3\2\2\2"+
		"\u04ea\u04e8\3\2\2\2\u04ea\u04eb\3\2\2\2\u04eb\u04ed\3\2\2\2\u04ec\u04ea"+
		"\3\2\2\2\u04ed\u04ef\7$\2\2\u04ee\u04da\3\2\2\2\u04ee\u04e4\3\2\2\2\u04ef"+
		"\u0136\3\2\2\2\u04f0\u04f2\5\u014f\u00a8\2\u04f1\u04f0\3\2\2\2\u04f2\u04f3"+
		"\3\2\2\2\u04f3\u04f1\3\2\2\2\u04f3\u04f4\3\2\2\2\u04f4\u04f5\3\2\2\2\u04f5"+
		"\u04f6\7N\2\2\u04f6\u0138\3\2\2\2\u04f7\u04f9\5\u014f\u00a8\2\u04f8\u04f7"+
		"\3\2\2\2\u04f9\u04fa\3\2\2\2\u04fa\u04f8\3\2\2\2\u04fa\u04fb\3\2\2\2\u04fb"+
		"\u04fc\3\2\2\2\u04fc\u04fd\7U\2\2\u04fd\u013a\3\2\2\2\u04fe\u0500\5\u014f"+
		"\u00a8\2\u04ff\u04fe\3\2\2\2\u0500\u0501\3\2\2\2\u0501\u04ff\3\2\2\2\u0501"+
		"\u0502\3\2\2\2\u0502\u0503\3\2\2\2\u0503\u0504\7[\2\2\u0504\u013c\3\2"+
		"\2\2\u0505\u0507\5\u014f\u00a8\2\u0506\u0505\3\2\2\2\u0507\u0508\3\2\2"+
		"\2\u0508\u0506\3\2\2\2\u0508\u0509\3\2\2\2\u0509\u050a\3\2\2\2\u050a\u050b"+
		"\t\4\2\2\u050b\u013e\3\2\2\2\u050c\u050e\5\u014f\u00a8\2\u050d\u050c\3"+
		"\2\2\2\u050e\u050f\3\2\2\2\u050f\u050d\3\2\2\2\u050f\u0510\3\2\2\2\u0510"+
		"\u0140\3\2\2\2\u0511\u0513\5\u014f\u00a8\2\u0512\u0511\3\2\2\2\u0513\u0514"+
		"\3\2\2\2\u0514\u0512\3\2\2\2\u0514\u0515\3\2\2\2\u0515\u0516\3\2\2\2\u0516"+
		"\u0517\5\u014d\u00a7\2\u0517\u051f\3\2\2\2\u0518\u051a\5\u014b\u00a6\2"+
		"\u0519\u051b\5\u014d\u00a7\2\u051a\u0519\3\2\2\2\u051a\u051b\3\2\2\2\u051b"+
		"\u051c\3\2\2\2\u051c\u051d\6\u00a1\2\2\u051d\u051f\3\2\2\2\u051e\u0512"+
		"\3\2\2\2\u051e\u0518\3\2\2\2\u051f\u0142\3\2\2\2\u0520\u0522\5\u014f\u00a8"+
		"\2\u0521\u0520\3\2\2\2\u0522\u0523\3\2\2\2\u0523\u0521\3\2\2\2\u0523\u0524"+
		"\3\2\2\2\u0524\u0526\3\2\2\2\u0525\u0527\5\u014d\u00a7\2\u0526\u0525\3"+
		"\2\2\2\u0526\u0527\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u0529\7F\2\2\u0529"+
		"\u0532\3\2\2\2\u052a\u052c\5\u014b\u00a6\2\u052b\u052d\5\u014d\u00a7\2"+
		"\u052c\u052b\3\2\2\2\u052c\u052d\3\2\2\2\u052d\u052e\3\2\2\2\u052e\u052f"+
		"\7F\2\2\u052f\u0530\6\u00a2\3\2\u0530\u0532\3\2\2\2\u0531\u0521\3\2\2"+
		"\2\u0531\u052a\3\2\2\2\u0532\u0144\3\2\2\2\u0533\u0535\5\u014f\u00a8\2"+
		"\u0534\u0533\3\2\2\2\u0535\u0536\3\2\2\2\u0536\u0534\3\2\2\2\u0536\u0537"+
		"\3\2\2\2\u0537\u0539\3\2\2\2\u0538\u053a\5\u014d\u00a7\2\u0539\u0538\3"+
		"\2\2\2\u0539\u053a\3\2\2\2\u053a\u053b\3\2\2\2\u053b\u053c\7D\2\2\u053c"+
		"\u053d\7F\2\2\u053d\u0548\3\2\2\2\u053e\u0540\5\u014b\u00a6\2\u053f\u0541"+
		"\5\u014d\u00a7\2\u0540\u053f\3\2\2\2\u0540\u0541\3\2\2\2\u0541\u0542\3"+
		"\2\2\2\u0542\u0543\7D\2\2\u0543\u0544\7F\2\2\u0544\u0545\3\2\2\2\u0545"+
		"\u0546\6\u00a3\4\2\u0546\u0548\3\2\2\2\u0547\u0534\3\2\2\2\u0547\u053e"+
		"\3\2\2\2\u0548\u0146\3\2\2\2\u0549\u054d\5\u0151\u00a9\2\u054a\u054d\5"+
		"\u014f\u00a8\2\u054b\u054d\7a\2\2\u054c\u0549\3\2\2\2\u054c\u054a\3\2"+
		"\2\2\u054c\u054b\3\2\2\2\u054d\u054e\3\2\2\2\u054e\u054c\3\2\2\2\u054e"+
		"\u054f\3\2\2\2\u054f\u0148\3\2\2\2\u0550\u0556\7b\2\2\u0551\u0555\n\5"+
		"\2\2\u0552\u0553\7b\2\2\u0553\u0555\7b\2\2\u0554\u0551\3\2\2\2\u0554\u0552"+
		"\3\2\2\2\u0555\u0558\3\2\2\2\u0556\u0554\3\2\2\2\u0556\u0557\3\2\2\2\u0557"+
		"\u0559\3\2\2\2\u0558\u0556\3\2\2\2\u0559\u055a\7b\2\2\u055a\u014a\3\2"+
		"\2\2\u055b\u055d\5\u014f\u00a8\2\u055c\u055b\3\2\2\2\u055d\u055e\3\2\2"+
		"\2\u055e\u055c\3\2\2\2\u055e\u055f\3\2\2\2\u055f\u0560\3\2\2\2\u0560\u0564"+
		"\7\60\2\2\u0561\u0563\5\u014f\u00a8\2\u0562\u0561\3\2\2\2\u0563\u0566"+
		"\3\2\2\2\u0564\u0562\3\2\2\2\u0564\u0565\3\2\2\2\u0565\u056e\3\2\2\2\u0566"+
		"\u0564\3\2\2\2\u0567\u0569\7\60\2\2\u0568\u056a\5\u014f\u00a8\2\u0569"+
		"\u0568\3\2\2\2\u056a\u056b\3\2\2\2\u056b\u0569\3\2\2\2\u056b\u056c\3\2"+
		"\2\2\u056c\u056e\3\2\2\2\u056d\u055c\3\2\2\2\u056d\u0567\3\2\2\2\u056e"+
		"\u014c\3\2\2\2\u056f\u0571\7G\2\2\u0570\u0572\t\6\2\2\u0571\u0570\3\2"+
		"\2\2\u0571\u0572\3\2\2\2\u0572\u0574\3\2\2\2\u0573\u0575\5\u014f\u00a8"+
		"\2\u0574\u0573\3\2\2\2\u0575\u0576\3\2\2\2\u0576\u0574\3\2\2\2\u0576\u0577"+
		"\3\2\2\2\u0577\u014e\3\2\2\2\u0578\u0579\t\7\2\2\u0579\u0150\3\2\2\2\u057a"+
		"\u057b\t\b\2\2\u057b\u0152\3\2\2\2\u057c\u057d\7/\2\2\u057d\u057e\7/\2"+
		"\2\u057e\u0582\3\2\2\2\u057f\u0581\n\t\2\2\u0580\u057f\3\2\2\2\u0581\u0584"+
		"\3\2\2\2\u0582\u0580\3\2\2\2\u0582\u0583\3\2\2\2\u0583\u0586\3\2\2\2\u0584"+
		"\u0582\3\2\2\2\u0585\u0587\7\17\2\2\u0586\u0585\3\2\2\2\u0586\u0587\3"+
		"\2\2\2\u0587\u0589\3\2\2\2\u0588\u058a\7\f\2\2\u0589\u0588\3\2\2\2\u0589"+
		"\u058a\3\2\2\2\u058a\u058b\3\2\2\2\u058b\u058c\b\u00aa\2\2\u058c\u0154"+
		"\3\2\2\2\u058d\u058e\7\61\2\2\u058e\u058f\7,\2\2\u058f\u0590\7,\2\2\u0590"+
		"\u0591\7\61\2\2\u0591\u0592\3\2\2\2\u0592\u0593\b\u00ab\2\2\u0593\u0156"+
		"\3\2\2\2\u0594\u0595\7\61\2\2\u0595\u0596\7,\2\2\u0596\u0597\3\2\2\2\u0597"+
		"\u059b\n\n\2\2\u0598\u059a\13\2\2\2\u0599\u0598\3\2\2\2\u059a\u059d\3"+
		"\2\2\2\u059b\u059c\3\2\2\2\u059b\u0599\3\2\2\2\u059c\u059e\3\2\2\2\u059d"+
		"\u059b\3\2\2\2\u059e\u059f\7,\2\2\u059f\u05a0\7\61\2\2\u05a0\u05a1\3\2"+
		"\2\2\u05a1\u05a2\b\u00ac\2\2\u05a2\u0158\3\2\2\2\u05a3\u05a5\t\13\2\2"+
		"\u05a4\u05a3\3\2\2\2\u05a5\u05a6\3\2\2\2\u05a6\u05a4\3\2\2\2\u05a6\u05a7"+
		"\3\2\2\2\u05a7\u05a8\3\2\2\2\u05a8\u05a9\b\u00ad\2\2\u05a9\u015a\3\2\2"+
		"\2\u05aa\u05ab\13\2\2\2\u05ab\u015c\3\2\2\2.\2\u01d8\u01fc\u03f6\u0408"+
		"\u0410\u0450\u0462\u04de\u04e0\u04e8\u04ea\u04ee\u04f3\u04fa\u0501\u0508"+
		"\u050f\u0514\u051a\u051e\u0523\u0526\u052c\u0531\u0536\u0539\u0540\u0547"+
		"\u054c\u054e\u0554\u0556\u055e\u0564\u056b\u056d\u0571\u0576\u0582\u0586"+
		"\u0589\u059b\u05a6\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}