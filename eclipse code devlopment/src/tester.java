import java.time.LocalDateTime;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) {
		reminderCard a = new reminderCard(null, null, null, 0, false, 0);
		
		System.out.println(a.getInitTimePutOff());
		LocalDateTime temp = LocalDateTime.of(2020, 5, 3, 15, 5, 20); 
		a.setInitTimePutOff(temp);
		System.out.println(a.getInitTimePutOff());
		System.out.println(LocalDateTime.now());
		
		int[]test = a.slotTime3();
		char[] testChar = a.getThreeSmall();
		
		System.out.println(a.getStartChar());
		for(int i = 0;i<test.length;i++) {
			System.out.println(test[i] + " ");
		}
		for(int i = 0;i<testChar.length;i++) {
			System.out.println(testChar[i] + " ");
		}
	}

}
