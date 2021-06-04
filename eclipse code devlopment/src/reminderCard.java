import java.time.LocalDateTime;

public class reminderCard {
	private char startChar;
	private char[] threeSmall;
	private int index;
	//title of card to be displayed when scrolling through reminders, "calculus"
	private String title;
	//What the user is putting off, "finish calculus assignment 3".
	private String content;
	//When the user initially put it off
	private LocalDateTime initTimePutOff;
	//How many times the user has chosen to put it off
	private int numPutOff;
	//Whether or not the user has completed it
	private boolean complete;
	//When the user will next be reminded
	private int reminder;
	
	public reminderCard(String title, String content, LocalDateTime initTimePutOff, int numPutOff, boolean complete, int reminder) {
		this.setTitle(title);
		this.setContent(content);
		this.setInitTimePutOff(initTimePutOff);
		this.setNumPutOff(numPutOff);
		this.setComplete(complete);
		this.setReminder(reminder);
	}
	
	public void setTimeNow() {
		initTimePutOff = LocalDateTime.now();
	}
	private boolean checkSec() {
		return LocalDateTime.now().getSecond() - initTimePutOff.getSecond() < 0;
	}
	private boolean checkMin() {
		return LocalDateTime.now().getMinute() - initTimePutOff.getMinute() < 0;
	}
	private boolean checkHour() {
		return LocalDateTime.now().getHour() - initTimePutOff.getHour() < 0;
	}
	private boolean checkDay() {
		return (LocalDateTime.now().getDayOfMonth() - initTimePutOff.getDayOfMonth()) - ((LocalDateTime.now().getDayOfMonth() - initTimePutOff.getDayOfMonth())/7)*7 < 0;
	}
	private boolean checkWeek() {
		return (LocalDateTime.now().getDayOfMonth() - initTimePutOff.getDayOfMonth())/7<0;
		}
	private boolean checkMonth() {
		return LocalDateTime.now().getMonthValue() - initTimePutOff.getMonthValue() < 0;
	}
	
	
	public int timeDiff(int measure) {
		switch (measure) {
			case 1:
				int returnSec = LocalDateTime.now().getSecond() - initTimePutOff.getSecond();
				if (checkSec()) {
					returnSec+=60;
				}
				return returnSec;
			case 2:
				int returnMin = LocalDateTime.now().getMinute() - initTimePutOff.getMinute();
				if(checkSec()) {
					returnMin++;
				}
				if(checkMin()) {
					returnMin += 60;
				}
				return returnMin;
			case 3:
				int returnHour = LocalDateTime.now().getHour() - initTimePutOff.getHour();
				if(checkMin()) {
					returnHour++;
				}
				if(checkHour()) {
					returnHour+=24;
				}
				return returnHour;
				
			case 4:
				int returnDay = (LocalDateTime.now().getDayOfMonth() - initTimePutOff.getDayOfMonth()) - ((LocalDateTime.now().getDayOfMonth() - initTimePutOff.getDayOfMonth())/7)*7;
				if(checkHour()) {
					returnDay++;
				}
				if(checkDay()) {
					returnDay+=7;
				}
				
				return returnDay;
						
			case 5:
				int returnWeek = (LocalDateTime.now().getDayOfMonth() - initTimePutOff.getDayOfMonth())/7;
				if(checkDay()) {
					returnWeek++;
				}
				if(checkWeek()) {
					returnWeek+=4;
				}
				return returnWeek;
				
			case 6:
				int returnMonth = LocalDateTime.now().getMonthValue() - initTimePutOff.getMonthValue();
				if(checkWeek()) {
					returnMonth++;
				}
				if(checkMonth()) {
					returnMonth+=12;
				}
				return returnMonth;
			case 7:
				int returnYear = LocalDateTime.now().getYear() - initTimePutOff.getYear();
				if(checkMonth()) {
					returnYear++;
				}
				return returnYear;
		}
		return LocalDateTime.now().getSecond() - initTimePutOff.getSecond();
	}

	//Returns a String displaying the time difference using the three smallest measurements
	public String getTime() {
		String returnString = "";
		returnString += "(7) - Years: " + timeDiff(7);
		returnString += "\n(6) - Months: " + timeDiff(6);
		returnString += "\n(5) - Weeks: " + timeDiff(5);
		returnString += "\n(4) - Days: " + timeDiff(4);
		returnString += "\n(3) - Hours: " + timeDiff(3);
		returnString += "\n(2) - Minutes: " + timeDiff(2);
		returnString += "\n(1) - Seconds: " + timeDiff(1);
		return returnString;
	}
	public int[] slotTime3() {
		int[] digits = new int[3];
		if(timeDiff(7)>0) {
			digits[0]=timeDiff(7);
			digits[1]=timeDiff(6);
			digits[2]=timeDiff(5);
			startChar = 'y';
		}else if (timeDiff(6)>0) {
			digits[0] = timeDiff(6);
			digits[1]=timeDiff(5);
			digits[2]=timeDiff(4);
			startChar = 'm';
		}else if (timeDiff(5)>0) {
			digits[0] = timeDiff(5);
			digits[1]=timeDiff(4);
			digits[2]=timeDiff(3);
			startChar = 'w';
		}else if (timeDiff(4)>0) {
			digits[0] = timeDiff(4);
			digits[1]=timeDiff(3);
			digits[2]=timeDiff(2);
			startChar = 'd';
		}else{
			digits[0] = timeDiff(3);
			digits[1]=timeDiff(2);
			digits[2]=timeDiff(1);
			startChar = 'h';
		}
		setThreeSmall(startChar);
		return digits;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void setThreeSmall(char index) {
		char[] temp = new char[3];
		threeSmall = temp;
		switch(index) {
			case 'y':
				threeSmall[0] = 'y';
				threeSmall[1] = 'm';
				threeSmall[2] = 'w';
			break;
			case 'm':
				threeSmall[0] = 'm';
				threeSmall[1] = 'w';
				threeSmall[2] = 'd';
			break;
			case 'w':
				threeSmall[0] = 'w';
				threeSmall[1] = 'd';
				threeSmall[2] = 'h';
			break;
			case 'd':
				threeSmall[0] = 'd';
				threeSmall[1] = 'h';
				threeSmall[2] = 'm';
			break;
			case 'h':
				threeSmall[0] = 'h';
				threeSmall[1] = 'm';
				threeSmall[2] = 's';
			break;
		}
			
			
	}
	public char[] getThreeSmall() {
		return threeSmall;
	}
	
	public char getStartChar() {
		return startChar;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getInitTimePutOff() {
		return initTimePutOff;
	}
	
	public void setInitTimePutOff(LocalDateTime initTimePutOff) {
		this.initTimePutOff = initTimePutOff;
	}

	public int getNumPutOff() {
		return numPutOff;
	}

	public void setNumPutOff(int numPutOff) {
		this.numPutOff = numPutOff;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public int getReminder() {
		return reminder;
	}

	public void setReminder(int reminder) {
		this.reminder = reminder;
	}

}
