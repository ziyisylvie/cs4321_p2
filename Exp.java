package cs4321_p2;

import net.sf.jsqlparser.expression.AllComparisonExpression;
import net.sf.jsqlparser.expression.AnyComparisonExpression;
import net.sf.jsqlparser.expression.CaseExpression;
import net.sf.jsqlparser.expression.DateValue;
import net.sf.jsqlparser.expression.DoubleValue;
import net.sf.jsqlparser.expression.ExpressionVisitor;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.InverseExpression;
import net.sf.jsqlparser.expression.JdbcParameter;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.TimeValue;
import net.sf.jsqlparser.expression.TimestampValue;
import net.sf.jsqlparser.expression.WhenClause;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseAnd;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseOr;
import net.sf.jsqlparser.expression.operators.arithmetic.BitwiseXor;
import net.sf.jsqlparser.expression.operators.arithmetic.Concat;
import net.sf.jsqlparser.expression.operators.arithmetic.Division;
import net.sf.jsqlparser.expression.operators.arithmetic.Multiplication;
import net.sf.jsqlparser.expression.operators.arithmetic.Subtraction;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExistsExpression;
import net.sf.jsqlparser.expression.operators.relational.GreaterThan;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.expression.operators.relational.Matches;
import net.sf.jsqlparser.expression.operators.relational.MinorThan;
import net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import net.sf.jsqlparser.expression.operators.relational.NotEqualsTo;
import net.sf.jsqlparser.statement.select.SubSelect;

/**
 * 
 * @author Ziyi Wang (zw376)
 *
 */

public abstract class Exp implements ExpressionVisitor{

	//the current numeric value in the visitor
	protected long currnumber = 0;
	//judge whether the condition is true
	protected boolean condition = false;
	
	public boolean getResult(){
		return this.condition;
	}
	
	@Override
	public void visit(NullValue arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(Function arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
		
	}

	@Override
	public void visit(InverseExpression arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(JdbcParameter arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(DoubleValue arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}


	@Override
	public void visit(DateValue arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(TimeValue arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(TimestampValue arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(Parenthesis arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(StringValue arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(Addition arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(Division arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(Multiplication arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(Subtraction arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	/**
	 * first visit the left child and judge whether it is true or false
	 * then judge the right condition
	 * the final judgment should be (left == true && right == true)
	 */
	@Override
	public void visit(AndExpression arg0) {
		// TODO Auto-generated method stub
		arg0.getLeftExpression().accept(this);
		boolean leftcondition = condition;
		arg0.getRightExpression().accept(this);
		boolean rightcondition = condition;
		condition = leftcondition && rightcondition;
	}

	@Override
	public void visit(OrExpression arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(Between arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	
	@Override
	public void visit(InExpression arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(IsNullExpression arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(LikeExpression arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}


	@Override
	public void visit(SubSelect arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(CaseExpression arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(WhenClause arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(ExistsExpression arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(AllComparisonExpression arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(AnyComparisonExpression arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(Concat arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(Matches arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(BitwiseAnd arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(BitwiseOr arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	@Override
	public void visit(BitwiseXor arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This is not allowed");
	}

	/**
	 * set the value of the expression to current value
	 */
	@Override
	public void visit(LongValue arg0) {
		// TODO Auto-generated method stub
		this.currnumber = arg0.getValue();
	}

	/**
	 * first get the value of the left child
	 * then get the value of the right child
	 * finally judge whether the two numbers are the same
	 */
	@Override
	public void visit(EqualsTo arg0) {
		// TODO Auto-generated method stub
		arg0.getLeftExpression().accept(this);
		long leftnumber = this.currnumber;
		arg0.getRightExpression().accept(this);
		long rightnumber = this.currnumber;
		this.condition = (leftnumber == rightnumber);
	}

	/**
	 * first get the value of the left child
	 * then get the value of the right child
	 * finally judge whether left is larger than the right
	 */
	@Override
	public void visit(GreaterThan arg0) {
		// TODO Auto-generated method stub
		arg0.getLeftExpression().accept(this);
		long leftnumber = this.currnumber;
		arg0.getRightExpression().accept(this);
		long rightnumber = this.currnumber;
		this.condition = (leftnumber > rightnumber);
	}

	/**
	 * first get the value of the left child
	 * then get the value of the right child
	 * finally judge whether left is larger or equal to the right
	 */
	@Override
	public void visit(GreaterThanEquals arg0) {
		// TODO Auto-generated method stub
		arg0.getLeftExpression().accept(this);
		long leftnumber = this.currnumber;
		arg0.getRightExpression().accept(this);
		long rightnumber = this.currnumber;
		this.condition = (leftnumber >= rightnumber);
	}

	/**
	 * first get the value of the left child
	 * then get the value of the right child
	 * finally judge whether left is smaller than the right
	 */
	@Override
	public void visit(MinorThan arg0) {
		// TODO Auto-generated method stub
		arg0.getLeftExpression().accept(this);
		long leftnumber = this.currnumber;
		arg0.getRightExpression().accept(this);
		long rightnumber = this.currnumber;
		this.condition = (leftnumber < rightnumber);
	}

	/**
	 * first get the value of the left child
	 * then get the value of the right child
	 * finally judge whether left is smaller or equal to the right
	 */
	@Override
	public void visit(MinorThanEquals arg0) {
		// TODO Auto-generated method stub
		arg0.getLeftExpression().accept(this);
		long leftnumber = this.currnumber;
		arg0.getRightExpression().accept(this);
		long rightnumber = this.currnumber;
		this.condition = (leftnumber <= rightnumber);
	}

	/**
	 * first get the value of the left child
	 * then get the value of the right child
	 * finally judge whether left is not equal to the right
	 */
	@Override
	public void visit(NotEqualsTo arg0) {
		// TODO Auto-generated method stub
		arg0.getLeftExpression().accept(this);
		long leftnumber = this.currnumber;
		arg0.getRightExpression().accept(this);
		long rightnumber = this.currnumber;
		this.condition = (leftnumber != rightnumber);
	}

}
