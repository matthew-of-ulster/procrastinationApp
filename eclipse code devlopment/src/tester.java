import java.time.LocalDateTime;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) {
		reminderCard a = new reminderCard(null, null, null, 0, false, 0);
		
		System.out.println(a.getInitTimePutOff());
		LocalDateTime temp = LocalDateTime.of(2000, 7, 10, 15, 5, 20); 
		a.setInitTimePutOff(temp);
		System.out.println(a.getInitTimePutOff());
		System.out.println(a.timeDiff(6));
	}

}
