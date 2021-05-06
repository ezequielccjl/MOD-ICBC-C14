package mapeo;

public class Data {
	
	private String destinationAliasCbuCvu;
	private String originDocumentNumber;
	
	
	public Data(String destinationAliasCbuCvu, String originDocumentNumber) {
		super();
		this.destinationAliasCbuCvu = destinationAliasCbuCvu;
		this.originDocumentNumber = originDocumentNumber;
	}


	public String getDestinationAliasCbuCvu() {
		return destinationAliasCbuCvu;
	}


	public void setDestinationAliasCbuCvu(String destinationAliasCbuCvu) {
		this.destinationAliasCbuCvu = destinationAliasCbuCvu;
	}


	public String getOriginDocumentNumber() {
		return originDocumentNumber;
	}


	public void setOriginDocumentNumber(String originDocumentNumber) {
		this.originDocumentNumber = originDocumentNumber;
	}
	
	
}
