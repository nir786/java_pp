
public class Consule {

	public String ToPrint() {
		return this.name;

	}

	private void realloc_memb() {
		Prof[] temp = new Prof[members.length + 10];
		for (int i = 0; i < members.length; ++i) {
			temp[i] = members[i];
		}

	}

	private Prof head;
	private Prof[] members = new Prof[10];
	private int last_mem = 0;
	private String name;

	Consule(Prof _p, String _name) {
		this.name = _name;
		this.head = _p;
	}

	public String GetName() {
		return this.name;
	}

	public boolean assign_memb(Prof _p) {
		int c = is_in(_p.GetName());

		if (last_mem >= members.length)
			realloc_memb();
		this.members[last_mem] = _p;
		last_mem++;
		return true;

	}

	public int is_in(String name) {
		int index = 0;
		if (last_mem == 0)
			return -1;
		while (index < members.length && members[index] != null) {
			if (members[index].GetName().equals(name)) {
				return index;

			}
			index++;

		}
		return last_mem;
	}

	public boolean remove_memeber(String name) {
		int c = is_in(name);
		if (c == -1 || c == last_mem || last_mem == 0)
			return false;
		members[c] = members[last_mem - 1];
		members[last_mem] = null;
		return true;

	}

	public void ToString() {
		for (int i = 0; i < members.length; ++i) {
			if (members[i] != null && i + 1 < members.length && members[i + 1] != null) {
				String[] temp_1 = members[i].ToPrint();
				String[] temp_2 = members[i + 1].ToPrint();
				System.out.printf("%-17s %-2s\n", temp_1[0], temp_2[0]);
				System.out.printf("%-17s %-2s\n", temp_1[1], temp_2[1]);
				System.out.printf("%-17s %-2s\n", temp_1[2], temp_2[2]);
				System.out.printf("%-17s %-2s\n", temp_1[3], temp_2[3]);
				System.out.printf("%-17s %-2s\n", temp_1[4], temp_2[4]);
				System.out.println();
				System.out.println();
				i++;

			}

			else {
				if (members[i] != null) {
					String[] temp_1 = members[i].ToPrint();
					System.out.println(temp_1[0]);
					System.out.println(temp_1[1]);
					System.out.println(temp_1[2]);
					System.out.println(temp_1[3]);
					System.out.println(temp_1[4]);
					System.out.println();
					System.out.println();

				} else
					return;
			}
		}

	}

}
