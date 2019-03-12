package net.ukr.andy777;

public class BlackList {
	private Class<?>[] bl;
	int count = 0;

	public BlackList() {
		super();
		count = 0;
	}

	public BlackList(Class<?> bl) {
		super();
		this.bl=new Class[1];
		this.bl[0] = bl;
		count = this.bl.length;
	}

	protected boolean check(Object obj) {
		for (Class<?> cl : bl)
			if (cl.equals(obj.getClass()))
				return true;
		return false;
	}

	/* додавання класу до чорного списку */
	public String addBlackListElement(Class<?> cl) {
		if (bl == null)
			bl = new Class[1];
		else {
			for (Class<?> c : bl)
				if (c.equals(cl)) {
					return "can't add Class =" + cl + "= It`s already in BlackList";
				}
				Class<?>[] temp = new Class[bl.length + 1];
				System.arraycopy(bl, 0, temp, 0, bl.length);
				bl = temp;
		}
		bl[count++] = cl;
		return "Class =" + cl + "= ADDed to BlackList";
	}

	/* видалення класу з чорного списку */
	public String deleteBlackListElement(Class<?> cl) {
		if (count == 0)
			return "BlackList is EMPTY";
		for (int i = 0; i < count;) {
			if (bl[i].equals(cl)) {
				Class<?>[] temp = new Class<?>[bl.length - 1];
				System.arraycopy(bl, 0, temp, 0, i);
				System.arraycopy(bl, i + 1, temp, i, bl.length - i - 1);
				count--;
				bl = temp;
			} else
				i++;
		}
		return "Class " + cl + " DELETEd from BlackList";
	}

	@Override
	public String toString() {
		if (count == 0)
			return "BlackList is EMPTY";
		String resStr = "";
		int i = 0;
		for (Class<?> cl : this.bl)
			resStr += ++i + ". " + cl + "\n";
		return resStr;
	}
}
