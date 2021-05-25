import java.util.Scanner;

public class tester {

	public static void main(String[] args) {
		reminderCard a = new reminderCard(null, null, null, 0, false, 0);
		
		System.out.println(a.getInitTimePutOff());
		a.setTimeNow();
		System.out.println(a.getInitTimePutOff().getDayOfMonth());
	}

}
