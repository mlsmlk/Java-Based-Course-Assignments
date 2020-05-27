package expressionParsing;

import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class ln2pJ extends ConsoleProgram {

	public boolean isOperator(String equation) {
		if (equation.compareToIgnoreCase("-") == 0 || equation.compareToIgnoreCase("+") == 0
				|| equation.compareToIgnoreCase("*") == 0 || equation.compareToIgnoreCase("/") == 0
				|| equation.compareToIgnoreCase("^") == 0 || equation.compareToIgnoreCase("(") == 0
				|| equation.compareToIgnoreCase(")") == 0) {
			return true;
		} else
			return false;
	}

	public int getPrecedence(String equation) {

		if (equation.compareToIgnoreCase("(") == 0 || equation.compareToIgnoreCase(")") == 0)
			return 4;
		if (equation.compareToIgnoreCase("^") == 0)
			return 3;
		if (equation.compareToIgnoreCase("*") == 0 || equation.compareToIgnoreCase("/") == 0)
			return 2;
		if (equation.compareToIgnoreCase("-") == 0 || equation.compareToIgnoreCase("+") == 0)
			return 1;
		return 0;
	}

	public boolean isLeftAssociative(String equation) {
		if (equation.compareToIgnoreCase("-") == 0 || equation.compareToIgnoreCase("+") == 0
				|| equation.compareToIgnoreCase("*") == 0 || equation.compareToIgnoreCase("/") == 0
				|| equation.compareToIgnoreCase("^") == 0 || equation.compareToIgnoreCase("(") == 0
				|| equation.compareToIgnoreCase(")") == 0) {
			return true;
		} else
			return false;
	}

	public void run() {
		while (true) {
			String equation = readLine("Enter string: ");

			StringTokenizer st = new StringTokenizer(equation, "+-*/^()", true);

			Queue output = new Queue();
			Stack stack = new Stack();

			while (st.hasMoreTokens()) {

				String eq = st.nextToken();
				if (isOperator(eq)) {
					int PrecValue = getPrecedence(eq);

					while (stack.top != null && (getPrecedence(stack.top.value) > PrecValue
							|| (getPrecedence(stack.top.value) == PrecValue && isLeftAssociative(stack.top.value)))) {

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

			print("Postfix: ");

			while (stack.top != null) {
				output.Enqueue(stack.pop().value);
			}

			while (!output.isEmpty()) {
				String result = output.Dequeue();
				print(result + " ");
			}
			println(" ");

		}
	}
}
