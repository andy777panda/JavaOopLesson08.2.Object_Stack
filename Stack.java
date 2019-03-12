package net.ukr.andy777;

public class Stack {
	private Object[] stack;
	int count = 0;
	private BlackList bl;

	public Stack(BlackList bl) {
		super();
		this.bl = bl;
		count = 0;
	}

	public Stack(BlackList bl,Object obj) {
		super();
		this.bl = bl;
		this.stack=new Object[1];
		this.stack[0] = obj;
		count = this.stack.length;
	}

	/* додавання елементу до стеку об'єктів, в його вершину/кінець */
	public String addLastStackElement(Object obj) {
		if (bl.check(obj))
			return "ObjectClass =" + obj + "= is in BlackList. CAN`T add to Stack";
		if (stack == null)
			stack = new Object[1];
		else {
			Object[] temp = new Object[stack.length + 1];
			System.arraycopy(stack, 0, temp, 0, stack.length);
			stack = temp;
		}
		stack[count++] = obj;
		return "Object =" + obj + "= ADDed to Stack";
	}

	/* читання елементу з вершини стеку */
	public Object readLastStackElement() {
		if (count == 0)
			return "Stack is EMPTY";
		return stack[count - 1];
	}

	/* отримання та видалення елементу з вершини стеку */
	public Object getLastStackElement() {
		if (count == 0)
			return "Stack is EMPTY";
		Object res = stack[--count];
		Object[] temp = new Object[stack.length - 1];
		System.arraycopy(stack, 0, temp, 0, stack.length - 1);
		stack = temp;
		return res;
	}

	@Override
	public String toString() {
		if (count == 0)
			return "Stack is EMPTY";
		String resStr = "";
		int i = 0;
		for (Object obj : stack)
			resStr += ++i + ". " + obj.getClass() + " -> \t" + obj.toString() + "\n";
		return resStr;
	}
}