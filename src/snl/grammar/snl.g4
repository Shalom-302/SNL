grammar snl;

@header {
    package com.your_project;
}

options {
    language = Java;
}

program
    : project EOF;
project
    : 'create' 'project' STRING 'with' 'language' language block;
language
    : 'snl';
block
    : '{' statement* '}';
statement
    : entityDecl | classDecl | functionDecl | apiDecl | varDecl | importStmt | printStmt | controlStmt | exprStmt;
importStmt
    : 'import' STRING ';';
printStmt
    : 'print' '(' expression ')' ';';
entityDecl
    : 'create' 'entity' ID '{' entityBody? '}';
entityBody
    : entityMember (';' entityMember)* ';'? ;
entityMember
    : ID ':' type ('=' expression)?;
classDecl
    : 'class' ID ( 'extends' ID )? '{' classMember* '}';
classMember
    : fieldDecl | methodDecl;
fieldDecl
    : visibility? type ID ('=' expression)? ';';
methodDecl
    : visibility? (type | 'void') ID '(' paramList? ')' block;
visibility
    : 'public' | 'private' | 'protected';
functionDecl
    : 'create' 'func' ID ('with' 'arguments' argNames)? block;
argNames
    : ID (',' ID)*;
varDecl
    : varDeclaration ';';
varDeclaration
    : 'var' ID ':' type ('=' expression)?;
exprStmt
    : expression ';';
apiDecl
    : 'create' 'route' STRING 'on' httpMethod 'execute' (ID | block) ';'?;
httpMethod
    : 'get' | 'post' | 'put' | 'delete' | 'patch';
controlStmt
    : ifStmt | whileStmt | forStmt | returnStmt;
ifStmt
    : 'if' '(' expression ')' 'then' block ('else' block)?;
whileStmt
    : 'while' '(' expression ')' block;
forStmt
    : 'for' '(' forInit? ';' expression? ';' forUpdate? ')' block;
forInit
    : varDeclaration | expression;
forUpdate
    : expression;
returnStmt
    : 'return' expression? ';';
expression
    : assignment;
assignment
    : logic_or ( '=' assignment )?;
logic_or
    : logic_and ( 'or' logic_and )*;
logic_and
    : equality ( 'and' equality )*;
equality
    : relational ( ( '==' | '!=' ) relational )*;
relational
    : additive ( ( '<' | '>' | '<=' | '>=' ) additive )*;
additive
    : multiplicative ( ( '+' | '-' ) multiplicative )*;
multiplicative
    : unary ( ( '*' | '/' | '%' ) unary )*;
unary
    : ( 'not' | '!' | '-' ) unary | postfix;
postfix
    : primary postfixTail*;
postfixTail
    : '.' ID                            # memberAccess
    | '.' ID '(' argList? ')'           # methodCallOn
    | '[' expression ']'                # indexAccess
    ;
primary
    : literal                           # literalExpr
    | ID                                # varRef
    | functionCall                      # funcCallExpr
    | newExpr                           # newObjectExpr
    | getCommand                        # getCommandExpr
    | '(' expression ')'                # parenExpr
    ;
functionCall
    : ID '(' argList? ')';
argList
    : expression (',' expression)*;
newExpr
    : 'new' ID '(' argList? ')';
getCommand
    : 'get' 'from' ID;
literal
    : STRING | FLOAT | NUMBER | BOOLEAN | listLiteral | mapLiteral;
listLiteral
    : '[' (expression (',' expression)*)? ']';
mapLiteral
    : '{' (STRING ':' expression (',' STRING ':' expression)*)? '}';
type
    : 'string' | 'integer' | 'float' | 'boolean' | 'date' | 'list' | 'dict' | ID;
paramList
    : param (',' param)*;
param
    : type ID;
ID
    : [a-zA-Z_] [a-zA-Z_0-9]*;
STRING
    : '"' ( '\\' . | ~["\\\r\n] )* '"';
FLOAT
    : [0-9]+ '.' [0-9]+;
NUMBER
    : [0-9]+;
BOOLEAN
    : 'true' | 'false';
LINE_COMMENT
    : '//' ~[\r\n]* -> skip;
BLOCK_COMMENT
    : '/*' .*? '*/' -> skip;
WS
    : [ \t\r\n]+ -> skip;
