/*******************************************************************************
* * Copyright 2018 Impetus Infotech.
* *
* * Licensed under the Apache License, Version 2.0 (the "License");
* * you may not use this file except in compliance with the License.
* * You may obtain a copy of the License at
* *
* * http://www.apache.org/licenses/LICENSE-2.0
* *
* * Unless required by applicable law or agreed to in writing, software
* * distributed under the License is distributed on an "AS IS" BASIS,
* * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* * See the License for the specific language governing permissions and
* * limitations under the License.
******************************************************************************/
grammar BlkchnSql;

@members {
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
}

tokens {
    DELIMITER
}

singleStatement
    : statement EOF
    ;
    
statement
    : query                                                        #statementDefault
    | insertInto                                                   #singleInsert
    | createFunction                                               #createFunctionRule
    | callFunction                                                 #callFunctionRule
    | createAsset                                                  #createAssetRule
    | deleteFunction                                               #deleteFunctionRule
    | dropAsset                                                    #dropAssetRule
    | upgradeFunction                                              #upgradeFunctionRule
    | deploySmartContract 										   #deploySmartContractRule
    ;
       
insertInto
    : INSERT INTO tableIdentifier ('(' columnNames ')')? VALUES '(' columnValues ')'
    ;
    
columnNames
    : identifierSeq
    ;
    
columnValues
    : constantSeq
    ;
    
constantSeq
    : constant (',' constant)*
    ;
    
createFunction
    : CREATE (FUNCTION | CHAINCODE | SMARTCONTRACT) qualifiedName AS className version? endorsersFile? args?
    ;
    
upgradeFunction
    : UPGRADE (FUNCTION | CHAINCODE | SMARTCONTRACT) qualifiedName AS className version? endorsersFile? args?
    ;
    
createAsset
    : CREATE (ASSET | TABLE) asset ('(' colTypeList ')')? WITH STORAGE TYPE storageType
      fieldDelimiter? recordDelimiter?
    ;

   
deploySmartContract
	: DEPLOY SMARTCONTRACT className '(' parameterValues? ')' (AND WITHASYNC asyncOption)?
	;
	
asset
    : identifier
    ;
    
storageType
    : JSON
    | CSV
    ;
    
fieldDelimiter
    : FIELDS DELIMITED BY STRING
    ;
    
recordDelimiter
    : RECORDS DELIMITED BY STRING
    ;
    
deleteFunction
    : DELETE qualifiedName '(' parameterValues? ')'
    ;
    
dropAsset
    : DROP (ASSET | TABLE) asset
    ;

className
    : STRING
    ;
    
version
    : WITH VERSION STRING
    ;
    
endorsersFile
    : WITH ENDORSEMENT POLICY FILE policyFile
    ;
    
policyFile
    : STRING
    ;
    
args
    : WITH ARGS argParamSeq
    ;
    
argParamSeq
    : argParam (',' argParam)*
    ;
    
argParam
    : constant
    | collection     
    ;

collection
    : list
    | bytes
    ;

bytes
    : 'HEX('STRING')'
    ;

list
    :  listTypeDec? '[' parameterValues? ']'
    ;

listTypeDec
    :  '<'listType'>' 
    ;

listType
    : STRING
    ;

callFunction
    : CALL qualifiedName '(' parameterValues? ')' (smartFunction | assetFunction)
    ;

smartFunction
    : USE classOption WITH addressOption (AND WITHASYNC asyncOption)?
    ;

assetFunction
    : (AS (ASSET | TABLE) asset)?
    ;

classOption
    : SMARTCONTRACT className
    ;

addressOption
    : ADDRESS addressVlaue
    ;

addressVlaue
    : STRING
    ;

asyncOption
    :  booleanValue
    ;

parameterValues
    : argParamSeq
    ;
    
query
    : queryTerm queryOrganization                                   #simpleQuery
    ;
    
queryOrganization
    : orderByClause? limitClause?
    ;
    
orderByClause
    : ORDER BY order+=sortItem (',' order+=sortItem)*
    ;
    
limitClause
    : (LIMIT limit=expression)
    ;
    
queryTerm
    : queryPrimary                                                                                    #queryTermDefault
    | left=queryTerm operator=(INTERSECT | UNION | EXCEPT | SETMINUS) setQuantifier? right=queryTerm  #setOperation
    ;
    
queryPrimary
    : querySpecification                                                    #queryPrimaryDefault
    | '(' query  ')'                                                        #subquery
    ;
    
sortItem
    : expression ordering=(ASC | DESC)? (NULLS nullOrder=(LAST | FIRST))?
    ;
    
querySpecification
    : selectClause fromClause whereClause? groupByClause? havingClause?
    ;
    
selectClause
    : SELECT setQuantifier? namedExpressionSeq
    ;
    
whereClause
    : WHERE booleanExpression;
    
havingClause
    : HAVING booleanExpression
    ;
    
fromClause
    : FROM relation (',' relation)*
    ;
    
groupByClause
    : GROUP BY groupingExpressions+=expression (',' groupingExpressions+=expression)*
    ;
    
setQuantifier
    : DISTINCT
    | ALL
    ;
    
relation
    : relationPrimary joinRelation*
    ;
    
joinRelation
    : (joinType) JOIN right=relationPrimary joinCriteria?
    ;
    
joinType
    : INNER?
    | CROSS
    | LEFT OUTER?
    | RIGHT OUTER?
    | FULL OUTER?
    ;
    
joinCriteria
    : ON booleanExpression
    ;
    
identifierList
    : '(' identifierSeq ')'
    ;
    
identifierSeq
    : identifier (',' identifier)*
    ;
    
relationPrimary
    : tableIdentifier (AS? strictIdentifier)?                       #tableName
    | '(' query ')' (AS? strictIdentifier)?                         #aliasedQuery
    | inlineTable                                                   #inlineTableDefault2
    | '(' relation ')' (AS? strictIdentifier)?                      #aliasedRelation
    ;
    
inlineTable
    : VALUES expression (',' expression)*  (AS? identifier identifierList?)?
    ;
    
tableIdentifier
    : (db=identifier '.')? table=identifier
    ;
    
namedExpression
    : expression (AS? (identifier | identifierList))?
    ;
    
namedExpressionSeq
    : namedExpression (',' namedExpression)*
    ;
    
expression
    : booleanExpression
    ;
    
booleanExpression
    : NOT booleanExpression                                        #logicalNot
    | predicated                                                   #booleanDefault
    | left=booleanExpression operator=AND right=booleanExpression  #logicalBinary
    | left=booleanExpression operator=OR right=booleanExpression   #logicalBinary
    ;
    
// workaround for:
//  https://github.com/antlr/antlr4/issues/780
//  https://github.com/antlr/antlr4/issues/781
predicated
    : valueExpression predicate?
    ;
    
predicate
    : NOT? kind=BETWEEN lower=valueExpression AND upper=valueExpression
    | NOT? kind=IN '(' expression (',' expression)* ')'
    | NOT? kind=IN '(' query ')'
    | NOT? kind=(RLIKE | LIKE) pattern=valueExpression
    | IS NOT? kind=NULL
    ;
    
valueExpression
    : primaryExpression                                                                      #valueExpressionDefault
    | operator=(PLUS | TILDE) valueExpression                                        #arithmeticUnary
    | left=valueExpression operator=(ASTERISK | SLASH | PERCENT | DIV) right=valueExpression #arithmeticBinary
    | left=valueExpression operator=(PLUS | MINUS) right=valueExpression                     #arithmeticBinary
    | left=valueExpression operator=AMPERSAND right=valueExpression                          #arithmeticBinary
    | left=valueExpression operator=HAT right=valueExpression                                #arithmeticBinary
    | left=valueExpression operator=PIPE right=valueExpression                               #arithmeticBinary
    | left=valueExpression comparisonOperator right=valueExpression                          #comparison
    ;
    
primaryExpression
    : name=(CURRENT_DATE | CURRENT_TIMESTAMP)                                                  #timeFunctionCall
    | CASE whenClause+ (ELSE elseExpression=expression)? END                                   #searchedCase
    | CASE value=expression whenClause+ (ELSE elseExpression=expression)? END                  #simpleCase
    | CAST '(' expression AS dataType ')'                                                      #cast
    | FIRST '(' expression (IGNORE NULLS)? ')'                                                 #first
    | LAST '(' expression (IGNORE NULLS)? ')'                                                  #last
    | constant                                                                                 #constantDefault
    | ASTERISK                                                                                 #star
    | qualifiedName '.' ASTERISK                                                               #star
    | '(' namedExpression (',' namedExpression)+ ')'                                           #rowConstructor
    | '(' query ')'                                                                            #subqueryExpression
    | qualifiedName '(' (setQuantifier? namedExpression (',' namedExpression)*)? ')'           #functionCall
    | value=primaryExpression '[' index=valueExpression ']'                                    #subscript
    | identifier                                                                               #columnReference
    | base=primaryExpression '.' fieldName=identifier                                          #dereference
    | '(' expression ')'                                                                       #parenthesizedExpression
    ;
    
constant
    : NULL                                                                                     #nullLiteral
    | interval                                                                                 #intervalLiteral
    | identifier STRING                                                                        #typeConstructor
    | number                                                                                   #numericLiteral
    | booleanValue                                                                             #booleanLiteral
    | STRING+                                                                                  #stringLiteral
    ;
    
comparisonOperator
    : EQ | NEQ | NEQJ | LT | LTE | GT | GTE | NSEQ
    ;
    
arithmeticOperator
    : PLUS | MINUS | ASTERISK | SLASH | PERCENT | DIV | TILDE | AMPERSAND | PIPE | HAT
    ;

predicateOperator
    : OR | AND | IN | NOT
    ;
    
booleanValue
    : TRUE | FALSE
    ;
    
interval
    : INTERVAL intervalField*
    ;

intervalField
    : value=intervalValue unit=identifier (TO to=identifier)?
    ;

intervalValue
    : (PLUS | MINUS)? (INTEGER_VALUE | DECIMAL_VALUE)
    | STRING
    ;
    
dataType
    : complex=ARRAY '<' dataType '>'                            #complexDataType
    | complex=MAP '<' dataType ',' dataType '>'                 #complexDataType
    | complex=STRUCT ('<' complexColTypeList? '>' | NEQ)        #complexDataType
    | identifier ('(' INTEGER_VALUE (',' INTEGER_VALUE)* ')')?  #primitiveDataType
    ;
    
colTypeList
    : colType (',' colType)*
    ;

colType
    : identifier dataType (COMMENT STRING)?
    ;
    
complexColTypeList
    : complexColType (',' complexColType)*
    ;
    
complexColType
    : identifier ':' dataType (COMMENT STRING)?
    ;
    
whenClause
    : WHEN condition=expression THEN result=expression
    ;
    
qualifiedName
    : identifier ('.' identifier)*
    ;

identifier
    : strictIdentifier
    | FULL | INNER | LEFT | SEMI | RIGHT | NATURAL | JOIN | CROSS | ON
    | UNION | INTERSECT | EXCEPT | SETMINUS
    ;
    
strictIdentifier
    : IDENTIFIER             #unquotedIdentifier
    | quotedIdentifier       #quotedIdentifierAlternative
    | nonReserved            #unquotedIdentifier
    ;
    
quotedIdentifier
    : BACKQUOTED_IDENTIFIER
    ;
    
number
    : MINUS? DECIMAL_VALUE            #decimalLiteral
    | MINUS? INTEGER_VALUE            #integerLiteral
    | MINUS? BIGINT_LITERAL           #bigIntLiteral
    | MINUS? SMALLINT_LITERAL         #smallIntLiteral
    | MINUS? TINYINT_LITERAL          #tinyIntLiteral
    | MINUS? DOUBLE_LITERAL           #doubleLiteral
    | MINUS? BIGDECIMAL_LITERAL       #bigDecimalLiteral
    ;
    
    
nonReserved
    : SHOW | TABLES | COLUMNS | COLUMN | FUNCTIONS | DATABASES | ADD | LAST | FIRST | AFTER | MAP 
    | ARRAY | STRUCT | GROUPING | CUBE | ROLLUP | EXPLAIN | USE | TO | PERCENTLIT | OUT | OF
    | SET | RESET | VIEW | REPLACE | IF | NO | COMMIT | ROLLBACK | IGNORE
    | TRUNCATE | COMPUTE | LIST | ANALYZE | REVOKE | GRANT
    | EXPORT | IMPORT | LOAD | VALUES | COMMENT | ROLE | ROLES | INDEX | INDEXES
    | ASC | DESC | LIMIT | RENAME | SETS
    | AT | NULLS | ALL | ALTER | AS | BETWEEN | BY | CREATE | DELETE
    | DESCRIBE | DROP | EXISTS | FALSE | FOR | GROUP | IN | INSERT | INTO | IS |LIKE
    | NULL | ORDER | OUTER | TABLE | TRUE | RLIKE
    | AND | CASE | CAST | DISTINCT | DIV | ELSE | END | FUNCTION | INTERVAL | OR | THEN
    | WHEN | DATABASE | SELECT | FROM | WHERE | HAVING | TO | TABLE | NOT | CURRENT_DATE | CURRENT_TIMESTAMP
    ;
    
SELECT: 'SELECT';
FROM: 'FROM';
ADD: 'ADD';
AS: 'AS';
ALL: 'ALL';
DISTINCT: 'DISTINCT';
WHERE: 'WHERE';
GROUP: 'GROUP';
BY: 'BY';
GROUPING: 'GROUPING';
SETS: 'SETS';
CUBE: 'CUBE';
ROLLUP: 'ROLLUP';
ORDER: 'ORDER';
HAVING: 'HAVING';
LIMIT: 'LIMIT';
AT: 'AT';
OR: 'OR';
AND: 'AND';
IN: 'IN';
NOT: 'NOT' | '!';
NO: 'NO';
EXISTS: 'EXISTS';
BETWEEN: 'BETWEEN';
LIKE: 'LIKE';
RLIKE: 'RLIKE' | 'REGEXP';
IS: 'IS';
NULL: 'NULL';
TRUE: 'TRUE';
FALSE: 'FALSE';
NULLS: 'NULLS';
ASC: 'ASC';
DESC: 'DESC';
HEX: 'HEX';
FOR: 'FOR';
INTERVAL: 'INTERVAL';
CASE: 'CASE';
WHEN: 'WHEN';
THEN: 'THEN';
ELSE: 'ELSE';
END: 'END';
JOIN: 'JOIN';
CROSS: 'CROSS';
OUTER: 'OUTER';
INNER: 'INNER';
LEFT: 'LEFT';
SEMI: 'SEMI';
RIGHT: 'RIGHT';
FULL: 'FULL';
NATURAL: 'NATURAL';
ON: 'ON';
FIRST: 'FIRST';
AFTER: 'AFTER';
LAST: 'LAST';
VALUES: 'VALUES';
CREATE: 'CREATE';
TABLE: 'TABLE';
VIEW: 'VIEW';
REPLACE: 'REPLACE';
INSERT: 'INSERT';
DELETE: 'DELETE';
INTO: 'INTO';
DESCRIBE: 'DESCRIBE';
EXPLAIN: 'EXPLAIN';
CAST: 'CAST';
SHOW: 'SHOW';
TABLES: 'TABLES';
COLUMNS: 'COLUMNS';
COLUMN: 'COLUMN';
USE: 'USE';
FUNCTIONS: 'FUNCTIONS';
DROP: 'DROP';
UNION: 'UNION';
EXCEPT: 'EXCEPT';
SETMINUS: 'MINUS';
INTERSECT: 'INTERSECT';
TO: 'TO';
ALTER: 'ALTER';
RENAME: 'RENAME';
ARRAY: 'ARRAY';
MAP: 'MAP';
STRUCT: 'STRUCT';
COMMENT: 'COMMENT';
SET: 'SET';
RESET: 'RESET';
COMMIT: 'COMMIT';
ROLLBACK: 'ROLLBACK';
IGNORE: 'IGNORE';
CALL: 'CALL';
WITH: 'WITH';
VERSION: 'VERSION';
ENDORSEMENT: 'ENDORSEMENT';
POLICY: 'POLICY';
FILE: 'FILE';
ARGS: 'ARGS';
ASSET: 'ASSET';
CHAINCODE: 'CHAINCODE';
SMARTCONTRACT: 'SMARTCONTRACT';
STORAGE: 'STORAGE';
TYPE: 'TYPE';
JSON: 'JSON';
CSV: 'CSV';
FIELDS: 'FIELDS';
RECORDS: 'RECORDS';
DELIMITED: 'DELIMITED';
UPGRADE: 'UPGRADE';
ADDRESS : 'ADDRESS';
WITHASYNC:'WITHASYNC';
DEPLOY:'DEPLOY';
IF: 'IF';

EQ  : '=' | '==';
NSEQ: '<=>';
NEQ : '<>';
NEQJ: '!=';
LT  : '<';
LTE : '<=' | '!>';
GT  : '>';
GTE : '>=' | '!<';

PLUS: '+';
MINUS: '-';
ASTERISK: '*';
SLASH: '/';
PERCENT: '%';
DIV: 'DIV';
TILDE: '~';
AMPERSAND: '&';
PIPE: '|';
HAT: '^';

PERCENTLIT: 'PERCENT';
OUT: 'OUT';
OF: 'OF';

FUNCTION: 'FUNCTION';
DATABASE: 'DATABASE' | 'SCHEMA';
DATABASES: 'DATABASES' | 'SCHEMAS';
TRUNCATE: 'TRUNCATE';
ANALYZE: 'ANALYZE';
COMPUTE: 'COMPUTE';
LIST: 'LIST';
REVOKE: 'REVOKE';
GRANT: 'GRANT';
EXPORT: 'EXPORT';
IMPORT: 'IMPORT';
LOAD: 'LOAD';
ROLE: 'ROLE';
ROLES: 'ROLES';
INDEX: 'INDEX';
INDEXES: 'INDEXES';
CURRENT_DATE: 'CURRENT_DATE';
CURRENT_TIMESTAMP: 'CURRENT_TIMESTAMP';

STRING
    : '\'' ( ~('\''|'\\') | ('\\' .) )* '\''
    | '"' ( ~('"'|'\\') | ('\\' .) )* '"'
    ;

BIGINT_LITERAL
    : DIGIT+ 'L'
    ;

SMALLINT_LITERAL
    : DIGIT+ 'S'
    ;

TINYINT_LITERAL
    : DIGIT+ 'Y'
    ;

BYTELENGTH_LITERAL
    : DIGIT+ ('B' | 'K' | 'M' | 'G')
    ;

INTEGER_VALUE
    : DIGIT+
    ;
    
DECIMAL_VALUE
    : DIGIT+ EXPONENT
    | DECIMAL_DIGITS EXPONENT? {isValidDecimal()}?
    ;

DOUBLE_LITERAL
    : DIGIT+ EXPONENT? 'D'
    | DECIMAL_DIGITS EXPONENT? 'D' {isValidDecimal()}?
    ;

BIGDECIMAL_LITERAL
    : DIGIT+ EXPONENT? 'BD'
    | DECIMAL_DIGITS EXPONENT? 'BD' {isValidDecimal()}?
    ;

IDENTIFIER
    : (LETTER | DIGIT | '_')+
    ;


BACKQUOTED_IDENTIFIER
    : '`' ( ~'`' | '``' )* '`'
    ;
    
fragment DECIMAL_DIGITS
    : DIGIT+ '.' DIGIT*
    | '.' DIGIT+
    ;

fragment EXPONENT
    : 'E' [+-]? DIGIT+
    ;

fragment DIGIT
    : [0-9]
    ;

fragment LETTER
    : [A-Z]
    ;
    
SIMPLE_COMMENT
    : '--' ~[\r\n]* '\r'? '\n'? -> channel(HIDDEN)
    ;

BRACKETED_EMPTY_COMMENT
    : '/**/' -> channel(HIDDEN)
    ;

BRACKETED_COMMENT
    : '/*' ~[+] .*? '*/' -> channel(HIDDEN)
    ;

WS
    : [ \r\n\t]+ -> channel(HIDDEN)
    ;
    
// Catch-all for anything we can't recognize.
// We use this to be able to ignore and recover all the text
// when splitting statements with DelimiterLexer
UNRECOGNIZED
    : .
    ;
