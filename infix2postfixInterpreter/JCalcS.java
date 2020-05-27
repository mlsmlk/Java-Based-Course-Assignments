package infix2postfixInterpreter;

import java.util.Scanner;
import java.util.StringTokenizer;

public class JCalcS {

	public static boolean isOperator(String str) {
		if (str.compareToIgnoreCase("-") == 0 || str.compareToIgnoreCase("+") == 0 || str.compareToIgnoreCase("*") == 0
				|| str.compareToIgnoreCase("/") == 0 || str.compareToIgnoreCase("^") == 0
				|| str.compareToIgnoreCase("(") == 0 || str.compareToIgnoreCase(")") == 0) {
			return true;
		} else
			return false;
	}

	public static int getPrecedence(String str) {

		if (str.compareToIgnoreCase("(") == 0 || str.compareToIgnoreCase(")") == 0)
			return 4;
		if (str.compareToIgnoreCase("^") == 0)
			return 3;
		if (str.compareToIgnoreCase("*") == 0 || str.compareToIgnoreCase("/") == 0)
			return 2;
		if (str.compareToIgnoreCase("-") == 0 || str.compareToIgnoreCase("+") == 0)
			return 1;
		return 0;
	}

	public static boolean isLeftAssociative(String str) {
		if (str.compareToIgnoreCase("-") == 0 || str.compareToIgnoreCase("+") == 0 || str.compareToIgnoreCase("*") == 0
				|| str.compareToIgnoreCase("/") == 0 || str.compareToIgnoreCase("^") == 0
				|| str.compareToIgnoreCase("(") == 0 || str.compareToIgnoreCase(")") == 0) {
			return true;
		} else
			return false;
	}

	public static void evaluate_postfix(Queue input) {
		Stack eval_stack = new Stack();
		int counter_eval = 0;

		while (!input.isEmpty()) {

			String str = input.Dequeue();

			if (!isOperator(str)) {
				eval_stack.push(str);
			} else {
				counter_eval++;

				String op2 = eval_stack.pop().value;
				String op1 = eval_stack.pop().value;

				String eval_counter_str = "Eval" + counter_eval;

				String result_eval = "<" + op1 + str + op2 + ">";
				eval_stack.push(eval_counter_str);
				System.out.println(eval_counter_str + ":" + result_eval);
			}
		}
	}

	public static void main(String args[]) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter expression (blank line to exit): ");
			String str = sc.nextLine();
			if ("".equals(str)) {
				break;
			} else {

				StringTokenizer st = new StringTokenizer(str, "+-*/^()", true);

				Queue output = new Queue();
				Stack stack = new Stack();

				while (st.hasMoreTokens()) {

					String eq = st.nextToken();
					if (isOperator(eq)) {
						int PrecValue = getPrecedence(eq);

						while (stack.top != null && (getPrecedence(stack.top.value) > PrecValue
								|| (getPrecedence(stack.top.value) == PrecValue
										&& isLeftAssociative(stack.top.value)))) {

							output.Enqueue(stack.pop().value);
						}

						if (stack.top != null) {

							int top_st_prec = getPrecedence(stack.top.value);
							boolean isLeftAssoc = isLeftAssociative(stack.top.value);
							if (top_st_prec > PrecValue || (top_st_prec == PrecValue && isLeftAssoc)) {

								output.Enqueue(stack.pop().value);
							}
						}

						stack.push(eq);
					}

					else {
						output.Enqueue(eq);
					}
				}

				while (stack.top != null) {
					output.Enqueue(stack.pop().value);
				}
				evaluate_postfix(output);

				while (!output.isEmpty()) {
					output.Dequeue();
				}
				System.out.println(" ");

			}
		}
	}
}
