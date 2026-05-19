import java.util.Scanner;

public class Logic {
	/* =======================wrappers================================= */
	private void Assign_consule_wrap(String head, String name) {
	}

	private void Assign_prof_wrap() {
		System.out.println("enter new proffesors name");
		String name = s.next();
		System.out.println("enter new proffesors salary");
		int salery = s.nextInt();
		System.out.println("enter id");
		String id = s.next();
		int aducation = -1;
		Degrees deg = Degrees.First;
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
		System.out.println("enter the course");
		String course = s.next();
		afeka.assign_prof(name, salery, id, deg, course);

	}

	/* =======================wrappers================================= */
	private Scanner s = new Scanner(System.in);
	private College afeka = new College();

	public void run() {
		int exit_status = -1;

		do {
			System.out.println(
					"choose function\n0) Exit\n1)Assign Proffesor\n2)Assign consule\n3)assign counsil member\n4)update member\n5)remove memeber\n6)department creation\n7)assign proffesor to consule\n8)overall avg salery\n9)avg department salery\n10)faculty list");
			exit_status = s.nextInt();

			switch (exit_status) {
				case 0:
					break;
				case 1:
					Assign_prof_wrap();
					break;
				case 2:
					System.out.println("enter heads name");
					String head = s.next();
					System.out.println("enter consule name");
					String name = s.next();
					afeka.assign_consule(head, name);
					break;
				case 3:
					System.out.println("enter faculty name");
					String nm = s.next();
					System.out.println("enter a counsil name");
					String cn = s.next();
					afeka.assign_to_counsil(nm, cn);
					break;
				case 4:
					System.out.println("not implemented yet");
					break;
				case 5:
					System.out.println("enter a council name");
					String cc = s.next();
					System.out.println("enter a member's name to remove");
					String cm = s.next();
					afeka.remove_from_counsil(cm, cc);
					break;
				case 6:
					System.out.println("enter department name");
					String n = s.next();
					System.out.println("enter number of students");
					int studs = s.nextInt();
					afeka.assign_department(n, studs);

					break;
				case 7:
					System.out.println("enter a department name");
					String dpa = s.next();
					System.out.println("enter a prof name ");
					String na = s.next();
					afeka.assign_prof_dp(na, dpa);

					break;
				case 8:
					System.out.println("the avg saleriy in for lecturures in " + afeka.GetName()
							+ "is: " + afeka.avg_prof());
					break;
				case 9:
					System.out.println("enter departments name");
					String dp = s.next();
					afeka.avg_department(dp);
					break;
				case 10:
					afeka.print_prof();
					break;
				case 11:
					afeka.print_consules();
					System.out.println("enter counsil name");
					String cname = s.next();
					afeka.print_consule_mem(cname);
					break;

			}

		} while (exit_status != 0);

	}

}
