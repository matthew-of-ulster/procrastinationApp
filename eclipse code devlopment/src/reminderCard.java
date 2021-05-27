import java.time.LocalDateTime;

public class reminderCard {
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
	public String slotTime3() {
		//if()
		return null;
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
