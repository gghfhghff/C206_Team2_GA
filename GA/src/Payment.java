
public class Payment {
	
	private String name;
	private int cardNo;
	private int cvc;
	private String expDate;
	
	public Payment(String name, int cardNo, int cvc, String expDate) {
		super();
		this.name = name;
		this.cardNo = cardNo;
		this.cvc = cvc;
		this.expDate = expDate;
	}

	
	
	public String toString() {
		
		return String.format("%-10s %-10d %-10d %-10s", getName(), getCardNo(), getCvc(), getExpDate());

	}


	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCardNo() {
		return cardNo;
	}


	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}


	public int getCvc() {
		return cvc;
	}


	public void setCvc(int cvc) {
		this.cvc = cvc;
	}


	public String getExpDate() {
		return expDate;
	}


	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	

	
	

}
