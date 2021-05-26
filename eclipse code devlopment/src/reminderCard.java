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
	
	public int timeDiff(int measure) {
		switch (measure) {
			case 1:
				return checkSec();
			case 2:
				int returnTime = LocalDateTime.now().getMinute() - initTimePutOff.getMinute();
				if(returnTime<0) {
					returnTime += 60;
				}
				return returnTime;
			case 3:
				
				if((LocalDateTime.now().getMinute() - initTimePutOff.getMinute())<0) {
					return (LocalDateTime.now().getHour()-1) - initTimePutOff.getHour();
				}
				return LocalDateTime.now().getHour() - initTimePutOff.getHour();
			case 4:
				return (LocalDateTime.now().getDayOfMonth() - initTimePutOff.getDayOfMonth()) - ((LocalDateTime.now().getDayOfMonth() - initTimePutOff.getDayOfMonth())/7)*7;
			case 5:
				return (LocalDateTime.now().getDayOfMonth() - initTimePutOff.getDayOfMonth())/7;
			case 6:
				return LocalDateTime.now().getMonthValue() - initTimePutOff.getMonthValue();
			case 7:
				return LocalDateTime.now().getYear() - initTimePutOff.getYear();
		}
		return LocalDateTime.now().getSecond() - initTimePutOff.getSecond();
	}
	
	private boolean checkSec() {
		int testInt = LocalDateTime.now().getSecond() - initTimePutOff.getSecond();
		boolean returnBool = false;
		if (testInt<0) {
			returnBool=true;
		}
		return returnBool;
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
