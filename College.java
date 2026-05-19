import java.util.Scanner;

public class College {
	/*
	 * ======================================Classs utils==========================
	 * 
	 */

	private void clear_screen() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public void print_consule_mem(String name) {
		cons[consule_is_in(name)].ToString();

	}

	public void print_consules() {
		for (int i = 0; i < cons.length; ++i) {
			if (cons[i] != null) {
				System.out.println(cons[i].ToPrint());
			} else {
				return;
			}
		}

	}

	public void print_prof() {
		for (int i = 0; i < prof.length; ++i) {
			if (prof[i] != null && i + 1 < prof.length && prof[i + 1] != null) {
				String[] temp_1 = prof[i].ToPrint();
				String[] temp_2 = prof[i + 1].ToPrint();
				System.out.printf("%-30s %-2s\n", temp_1[0], temp_2[0]);
				System.out.printf("%-30s %-2s\n", temp_1[1], temp_2[1]);
				System.out.printf("%-30s %-2s\n", temp_1[2], temp_2[2]);
				System.out.printf("%-30s %-2s\n", temp_1[3], temp_2[3]);
				System.out.printf("%-30s %-2s\n", temp_1[4], temp_2[4]);
				System.out.println();
				System.out.println();
				i++;

			}

			else {
				if (prof[i] != null) {
					String[] temp_1 = prof[i].ToPrint();
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

	private Prof valid_prof(String name) {
		for (int i = 0; i < prof.length; ++i) {
			if (prof[i] == null) {
				return null;
			} else {
				if (prof[i].GetName().equals(name) && prof[i].GetDegress() == Degrees.Doctor) {
					return prof[i];
				}
			}

		}
		return null;

	}

	public Prof get_prof(String name) {

		int i = 0;

		while (prof[i] != null) {
			if (prof[i].GetName().equals(name)) {
				return prof[i];

			}
			i++;

		}
		return null;

	}

	public void assign_to_counsil(String name, String counsil_name) {
		if (last_prof == 0 && prof[last_prof] == null) {
			System.out.println("faculty memeber list is empty try adding one first");
			return;
		}

		Prof p = get_prof(name);
		if (p == null) {
			System.out.println("failed");
			return;
		}

		int c = 0;
		int should_exit = 0;
		while ((c = consule_is_in(counsil_name)) == -1) {

			System.out.println("counsil name isn't on the list\n0)exit\n1)new council name");
			should_exit = s.nextInt();
			if (should_exit == 0) {
				return;
			} else {
				if (should_exit == 1) {
					System.out.println("Enter a new counsil name");
					clear_screen();
					System.out.print("input-->");
					counsil_name = s.next();
					System.out.println();
				}
			}

		}

		if (cons[c].assign_memb(p))
			System.out.println("assigned to " + counsil_name + " seccusfully");
		else
			System.out.println("already a memeber of the council");

	}

	public void remove_from_counsil(String name, String counsil_name) {
		int c = 0;
		int should_exit = 0;
		while ((c = consule_is_in(counsil_name)) == -1) {

			System.out.println("counsil name isn't on the list\n0)exit\n1)new council name");
			should_exit = s.nextInt();
			if (should_exit == 0) {
				return;
			} else {
				if (should_exit == 1) {
					System.out.println("Enter a new counsil name");
					clear_screen();
					System.out.print("input-->");
					counsil_name = s.next();
					System.out.println();
				}
			}

		}
		cons[c].remove_memeber(name);

	}

	private boolean consule_isempty() {
		if (last_cons == 0 && cons[last_cons] == null) {
			return true;

		}
		return false;

	}

	private String name = "afeka";
	private Scanner s = new Scanner(System.in);
	private Prof[] prof = new Prof[2];// base allocation
	private Department[] deps = new Department[2];// base allocation
	private Consule[] cons = new Consule[2];
	private int last_prof = 0;
	private int last_cons = 0;
	private int last_deps = 0;

	/*
	 * =============================================================================
	 */
	public int avg_prof() {
		int avg = 0;
		int i = 0;
		while (i < prof.length && prof[i] != null) {
			avg += prof[i].GetSalery();
			i++;
		}
		return (i == 0) ? 0 : avg / i;
	}

	public void avg_department(String name) {
		int i = 0;
		while (i < deps.length && deps[i] != null) {
			if (deps[i].GetName().equals(name))
				System.out.println(
						"the avg salery of department " + name + " is: "
								+ deps[i].avg_salery());
			i++;

		}

		System.out.println(name + " isn't on the department list");
		System.out.println("0)exit 1)new department name");
		int condi = s.nextInt();
		if (condi == 0)
			return;
		else {
			System.out.println("enter a valid department name");
			clear_screen();
			System.out.print("input-->");
			name = s.next();
			System.out.println();
			avg_department(name);
		}

	}

	public int consule_is_in(String name) {
		if (consule_isempty()) {
			return -1;
		}

		int i = 0;
		while (i < cons.length && cons[i] != null) {
			if (cons[i].GetName().equals(name)) {
				return i;
			}
			i++;
		}

		return last_cons;
	}

	public void assign_department(String name, int studs) {
		while (is_in_dep(name)) {
			System.out.println("department name is in use\nenter a new name");
			clear_screen();
			System.out.print("input-->");
			name = s.next();
			System.out.println();
		}
		if (last_deps >= deps.length)
			realloc_department();
		deps[last_deps] = new Department(name, studs);
		last_deps++;

	}

	public void assign_prof_dp(String name, String dp) {
		if (is_in_dep(dp)) {
			Prof p = valid_prof(name);
			while (p == null) {
				System.out.println("faculty member isn't on the list\n0)exit\n1)new name");
				int c = s.nextInt();
				if (c == 0)
					return;
				System.out.println("enter another faculty name");
				clear_screen();
				System.out.print("input-->");
				name = s.next();
				System.out.println();
				p = valid_prof(name);

			}
			int i = 0;
			while (i < deps.length && deps[i] != null && !deps[i].GetName().equals(dp)) {
				i++;
			}
			if (deps[i] != null)
				deps[i].add_prof(p);
			else {
				System.out.println("department list is empty");
			}

		} else {
			System.out.println(
					"department picked isn't on the department list\n0)exit\n1)another department");
			int c = s.nextInt();
			if (c == 0) {
				return;
			}
			System.out.println("enter a valid deparment name");
			clear_screen();
			System.out.print("input-->");
			dp = s.next();
			System.out.println();
			assign_prof_dp(name, dp);
		}

	}

	public void assign_consule(String head, String consule_name) {
		if (last_prof == 0 && prof[last_prof] == null) {
			System.out.println("faculty memeber list is empty try adding one first");
			return;
		}

		Prof p = valid_prof(head);
		int should_exit = 0;
		do {

			if (p != null) {
				should_exit = -1;
			} else {

				System.out.println(
						"faculty member doesn't meet the requirments/already taken/not on the list");
				System.out.println("0)exit\n1)pick new faculty memeber from the list");
				clear_screen();
				System.out.print("input-->");
				should_exit = s.nextInt();
				System.out.println();

			}
			switch (should_exit) {
				case 0:
					return;
				case 1:
					System.out.println("enter a proffesor's name from the list");
					clear_screen();
					head = s.next();
					System.out.print("input-->");
					p = valid_prof(head);
					System.out.println();
					break;
				default:
					break;

			}

		} while (should_exit != -1);

		/*
		 * ===============================proffesor
		 * validtation=======================================
		 */

		int c = 0;
		if ((c = consule_is_in(consule_name)) != -1) {
			do {
				System.out.println("0)exit\n1)new counsil name");
				clear_screen();
				System.out.print("input-->");
				should_exit = s.nextInt();
				System.out.println();

				if (should_exit == 1) {
					System.out.println("enter a new counsil name");
					clear_screen();
					System.out.print("input-->");
					consule_name = s.next();
					System.out.println();
					if ((c = consule_is_in(consule_name)) == -1) {
						System.out.println(consule_name + " is already taken");
					}

				} else {
					return;
				}

			} while (should_exit != 1);

		}
		if (last_cons >= cons.length)
			realloc_consule();
		cons[last_cons] = new Consule(p, consule_name);
		clear_screen();
		System.out.println("counsil was instantiated seccessfully");
		last_cons++;

	}

	public void assign_prof(String name, int salery, String id, Degrees deg, String course) {

		boolean is_in = false;
		int index = 0;

		while (!is_in && index < prof.length) {
			if (prof[index] == null) {
				index = prof.length;
			} else {
				if (prof[index].GetName().equals(name)) {
					is_in = true;
				}

			}
			index++;
		}
		if (!is_in) {
			if (prof.length >= last_prof)
				realloc_prof();
			prof[last_prof] = new Prof(name, salery, id, deg, course);
			last_prof++;
		} else {
			clear_screen();
			System.out.println("faculty member is already in \nenter a new one");
			name = s.next();
			System.out.println("enter Salery");
			salery = s.nextInt();
			System.out.println("enter id");
			id = s.next();
			int aducation = 3;

			System.out.println("aducation\n0)first Degree\n1)second degree\n2)phd ");
			do {
				aducation = s.nextInt();
				switch (aducation) {
					case 0:
						deg = Degrees.First;

						aducation = -1;

						break;
					case 1:

						deg = Degrees.Second;
						aducation = -1;
						break;
					case 2:
						deg = Degrees.Doctor;
						aducation = -1;
						break;

				}

			} while (aducation != -1);

			System.out.println("enter course name");
			course = s.next();
			assign_prof(name, salery, id, deg, course);

		}

	}

	private void realloc_prof() {
		Prof[] temp = new Prof[this.prof.length + 10];

		int internal_count = 0;
		for (int i = 0; i < prof.length; ++i) {
			if (prof[i] != null) {
				temp[internal_count] = prof[i]; // pointer swap before deletion to not messup the rest
								// of the stuff

				internal_count++;
			}

		}

		prof = temp;

	}

	private boolean is_in_dep(String name) {
		if (deps.length == 0) {
			return false;
		}
		int i = 0;
		while (i < deps.length && deps[i] != null) {
			if (deps[i].GetName().equals(name)) {
				return true;
			}
			i++;
		}
		return false;

	}

	private void realloc_department() {
		Department[] temp = new Department[deps.length + 10];
		int i = 0;

		while (i < deps.length && deps[i] != null) {
			temp[i] = deps[i];

		}
		deps = temp;

	}

	public void realloc_consule() {

		Consule[] temp = new Consule[this.cons.length + 10];

		int internal_count = 0;
		for (int i = 0; i < cons.length; ++i) {
			if (cons[i] != null) {
				temp[internal_count] = cons[i]; // pointer swap before deletion to not messup the rest
								// of the stuff

				internal_count++;
			}

		}

		cons = temp;

	}

	public String GetName() {
		return this.name;
	}

}
