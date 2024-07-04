package monitoring;

public class Messages {

	

	private String caseNumber;
	private String receivedDate;
	private String sfType;
	private String autoClassified;
	private String status;
	
	public Messages(String caseNumber, String receivedDate, String sfType, String autoClassified, String status) {
		super();
		this.caseNumber = caseNumber;
		this.receivedDate = receivedDate;
		this.sfType = sfType;
		this.autoClassified = autoClassified;
		this.status = status;
	}
	
	
	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	public String getSfType() {
		return sfType;
	}

	public void setSfType(String sfType) {
		this.sfType = sfType;
	}

	public String getAutoClassified() {
		return autoClassified;
	}

	public void setAutoClassified(String autoClassified) {
		this.autoClassified = autoClassified;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Messages [caseNumber=" + caseNumber + ", receivedDate=" + receivedDate + ", sfType=" + sfType
				+ ", autoClassified=" + autoClassified + ", status=" + status + "]";
	}
}
