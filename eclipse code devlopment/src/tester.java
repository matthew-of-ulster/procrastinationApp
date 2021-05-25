import java.util.Scanner;

public class tester {

	public static void main(String[] args) {
		reminderCard a = new reminderCard(null, null, null, 0, false, 0);
		
		System.out.println(a.getInitTimePutOff());
		a.setTimeNow();
		Scanner sc = new Scanner(System.in);
		String pause = sc.next();
		System.out.println(a.timeDiff());
	}

}
