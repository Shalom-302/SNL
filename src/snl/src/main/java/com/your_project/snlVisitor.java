// Generated from snl.g4 by ANTLR 4.13.2

    package com.your_project;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link snlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface snlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link snlParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(snlParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#project}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProject(snlParser.ProjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#language}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLanguage(snlParser.LanguageContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(snlParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(snlParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#importStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStmt(snlParser.ImportStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(snlParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#entityDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityDecl(snlParser.EntityDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#entityBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityBody(snlParser.EntityBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#entityMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityMember(snlParser.EntityMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(snlParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMember(snlParser.ClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(snlParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#methodDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDecl(snlParser.MethodDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#visibility}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibility(snlParser.VisibilityContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(snlParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#argNames}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgNames(snlParser.ArgNamesContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(snlParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(snlParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(snlParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#apiDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApiDecl(snlParser.ApiDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#httpMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHttpMethod(snlParser.HttpMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#controlStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStmt(snlParser.ControlStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(snlParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(snlParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(snlParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(snlParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(snlParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(snlParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(snlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(snlParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#logic_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_or(snlParser.Logic_orContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#logic_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_and(snlParser.Logic_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(snlParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#relational}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(snlParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#additive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive(snlParser.AdditiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#multiplicative}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative(snlParser.MultiplicativeContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(snlParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix(snlParser.PostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberAccess}
	 * labeled alternative in {@link snlParser#postfixTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccess(snlParser.MemberAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodCallOn}
	 * labeled alternative in {@link snlParser#postfixTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallOn(snlParser.MethodCallOnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code indexAccess}
	 * labeled alternative in {@link snlParser#postfixTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexAccess(snlParser.IndexAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(snlParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(snlParser.VarRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCallExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(snlParser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newObjectExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewObjectExpr(snlParser.NewObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getCommandExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetCommandExpr(snlParser.GetCommandExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link snlParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(snlParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(snlParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(snlParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#newExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(snlParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#getCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetCommand(snlParser.GetCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(snlParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(snlParser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#mapLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapLiteral(snlParser.MapLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(snlParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(snlParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link snlParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(snlParser.ParamContext ctx);
}