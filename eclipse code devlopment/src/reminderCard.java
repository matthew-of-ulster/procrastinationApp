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
	
	public int timeDiff() {
		return LocalDateTime.now().getSecond() - initTimePutOff.getSecond();
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
