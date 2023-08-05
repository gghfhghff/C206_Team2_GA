
public class Payment {
	
	private String name;
	private String cardNo;
	private int cvc;
	private String expDate;
	
	public Payment(String name, String cardNo, int cvc, String expDate) {
		this.name = name;
		this.cardNo = cardNo;
		this.cvc = cvc;
		this.expDate = expDate;
	}

	
	
	public String toString() {
		
		return String.format("%-10s %-25s %-15d %-15s", getName(), getCardNo(), getCvc(), getExpDate());

	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCardNo() {
		return cardNo;
	}


	public void setCardNo(String cardNo) {
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
