// Generated from snl.g4 by ANTLR 4.13.2

    package com.your_project;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link snlParser}.
 */
public interface snlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link snlParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(snlParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(snlParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#project}.
	 * @param ctx the parse tree
	 */
	void enterProject(snlParser.ProjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#project}.
	 * @param ctx the parse tree
	 */
	void exitProject(snlParser.ProjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#language}.
	 * @param ctx the parse tree
	 */
	void enterLanguage(snlParser.LanguageContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#language}.
	 * @param ctx the parse tree
	 */
	void exitLanguage(snlParser.LanguageContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(snlParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(snlParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(snlParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(snlParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#importStmt}.
	 * @param ctx the parse tree
	 */
	void enterImportStmt(snlParser.ImportStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#importStmt}.
	 * @param ctx the parse tree
	 */
	void exitImportStmt(snlParser.ImportStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(snlParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(snlParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#entityDecl}.
	 * @param ctx the parse tree
	 */
	void enterEntityDecl(snlParser.EntityDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#entityDecl}.
	 * @param ctx the parse tree
	 */
	void exitEntityDecl(snlParser.EntityDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#entityBody}.
	 * @param ctx the parse tree
	 */
	void enterEntityBody(snlParser.EntityBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#entityBody}.
	 * @param ctx the parse tree
	 */
	void exitEntityBody(snlParser.EntityBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#entityMember}.
	 * @param ctx the parse tree
	 */
	void enterEntityMember(snlParser.EntityMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#entityMember}.
	 * @param ctx the parse tree
	 */
	void exitEntityMember(snlParser.EntityMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(snlParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(snlParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(snlParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(snlParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(snlParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(snlParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void enterMethodDecl(snlParser.MethodDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#methodDecl}.
	 * @param ctx the parse tree
	 */
	void exitMethodDecl(snlParser.MethodDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#visibility}.
	 * @param ctx the parse tree
	 */
	void enterVisibility(snlParser.VisibilityContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#visibility}.
	 * @param ctx the parse tree
	 */
	void exitVisibility(snlParser.VisibilityContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(snlParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(snlParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#argNames}.
	 * @param ctx the parse tree
	 */
	void enterArgNames(snlParser.ArgNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#argNames}.
	 * @param ctx the parse tree
	 */
	void exitArgNames(snlParser.ArgNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(snlParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(snlParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(snlParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(snlParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(snlParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(snlParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#apiDecl}.
	 * @param ctx the parse tree
	 */
	void enterApiDecl(snlParser.ApiDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#apiDecl}.
	 * @param ctx the parse tree
	 */
	void exitApiDecl(snlParser.ApiDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#httpMethod}.
	 * @param ctx the parse tree
	 */
	void enterHttpMethod(snlParser.HttpMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#httpMethod}.
	 * @param ctx the parse tree
	 */
	void exitHttpMethod(snlParser.HttpMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void enterControlStmt(snlParser.ControlStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#controlStmt}.
	 * @param ctx the parse tree
	 */
	void exitControlStmt(snlParser.ControlStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(snlParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(snlParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(snlParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(snlParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(snlParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(snlParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(snlParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(snlParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(snlParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(snlParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(snlParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(snlParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(snlParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(snlParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(snlParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(snlParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#logic_or}.
	 * @param ctx the parse tree
	 */
	void enterLogic_or(snlParser.Logic_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#logic_or}.
	 * @param ctx the parse tree
	 */
	void exitLogic_or(snlParser.Logic_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#logic_and}.
	 * @param ctx the parse tree
	 */
	void enterLogic_and(snlParser.Logic_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#logic_and}.
	 * @param ctx the parse tree
	 */
	void exitLogic_and(snlParser.Logic_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(snlParser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(snlParser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterRelational(snlParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitRelational(snlParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#additive}.
	 * @param ctx the parse tree
	 */
	void enterAdditive(snlParser.AdditiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#additive}.
	 * @param ctx the parse tree
	 */
	void exitAdditive(snlParser.AdditiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative(snlParser.MultiplicativeContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#multiplicative}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative(snlParser.MultiplicativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(snlParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(snlParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfix(snlParser.PostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfix(snlParser.PostfixContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberAccess}
	 * labeled alternative in {@link snlParser#postfixTail}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccess(snlParser.MemberAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberAccess}
	 * labeled alternative in {@link snlParser#postfixTail}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccess(snlParser.MemberAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCallOn}
	 * labeled alternative in {@link snlParser#postfixTail}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallOn(snlParser.MethodCallOnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCallOn}
	 * labeled alternative in {@link snlParser#postfixTail}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallOn(snlParser.MethodCallOnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code indexAccess}
	 * labeled alternative in {@link snlParser#postfixTail}.
	 * @param ctx the parse tree
	 */
	void enterIndexAccess(snlParser.IndexAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code indexAccess}
	 * labeled alternative in {@link snlParser#postfixTail}.
	 * @param ctx the parse tree
	 */
	void exitIndexAccess(snlParser.IndexAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(snlParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(snlParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(snlParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(snlParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(snlParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(snlParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newObjectExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterNewObjectExpr(snlParser.NewObjectExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newObjectExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitNewObjectExpr(snlParser.NewObjectExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getCommandExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterGetCommandExpr(snlParser.GetCommandExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getCommandExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitGetCommandExpr(snlParser.GetCommandExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(snlParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(snlParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(snlParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(snlParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(snlParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(snlParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(snlParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#newExpr}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(snlParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#getCommand}.
	 * @param ctx the parse tree
	 */
	void enterGetCommand(snlParser.GetCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#getCommand}.
	 * @param ctx the parse tree
	 */
	void exitGetCommand(snlParser.GetCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(snlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(snlParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void enterListLiteral(snlParser.ListLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#listLiteral}.
	 * @param ctx the parse tree
	 */
	void exitListLiteral(snlParser.ListLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#mapLiteral}.
	 * @param ctx the parse tree
	 */
	void enterMapLiteral(snlParser.MapLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#mapLiteral}.
	 * @param ctx the parse tree
	 */
	void exitMapLiteral(snlParser.MapLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(snlParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(snlParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(snlParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(snlParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link snlParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(snlParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link snlParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(snlParser.ParamContext ctx);
}