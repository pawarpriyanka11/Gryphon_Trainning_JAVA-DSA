package DAY9;

public class WindowFunctions {

	/**
	 * Window functions in SQL:
	 * 
	 * window functions performs calculations across a
	 * set of rows that are related to the current row, without collapsing the row into a single result
	 * (unlike group by).
	 * 
	 * @@@they give you the aggregate like results while keeping
	 * each row visible
	 * 
	 * Basic syntax: 
	 * window_function(expression )
	 * OVER(PARTITION BY column ORDER BY column)
	 * 
	 * Why we use window function?
	 * @ to calculate running totals
	 * @ to find rank, row number
	 * @ to compare current row with previous/next row.
	 * @ to calculate moving averages
	 * @ to avoid complex subqueries
	 * 
	 *     GROPU BY 						VS			WINDOW FUNCTION
	 * 1) reduces rows 									keeps all rows
	 * 2) one row per group								one row per recored
	 * 3) use for aggregation							use for analysis
	 * 
	 * :::::::::::::::REAL LIFE CASES::::::
	 * # Top 3 salaries in each department
	 * # month-wise running sales
	 * # compare today's sales with yestersday's
	 * # ranking students/employees
	 * 
	 * 
	 * @ Types of window functions
	 * 1. ROW_NUMBER()
	 * 2. RANK()
	 * 3. DENSE_RANK()
	 * 4. SUM() OVER
	 * 5. AVG() OVER
	 * 6. LAG()
	 * 7. LEAD()
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
