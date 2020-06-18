package mybean;

public class Beans {
	// 通过订单表和报刊表的连接，查询报刊号，报刊名， 销售总数， 总售价
	private String sellNum;
	private String SumPrice;
	
	private String newsID;
	private String newsName;
	private String newsPrice;
	// 通过订单表和报刊表和报社表连接查询报社号，报社名，售出数量，总售
	private String publishID;
	private String publishName;
	private String address;
	
	private String buyNum;
	
	public String getNewsID() {
		return newsID;
	}
	public void setNewsID(String newsID) {
		this.newsID = newsID;
	}
	public String getNewsName() {
		return newsName;
	}
	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}
	public String getPublishID() {
		return publishID;
	}
	public void setPublishID(String publishID) {
		this.publishID = publishID;
	}
	public String getPublishName() {
		return publishName;
	}
	public void setPublishName(String publishName) {
		this.publishName = publishName;
	}
	private String userID;
	public String getSellNum() {
		return sellNum;
	}
	public void setSellNum(String sellNum) {
		this.sellNum = sellNum;
	}
	public String getSumPrice() {
		return SumPrice;
	}
	public void setSumPrice(String sumPrice) {
		SumPrice = sumPrice;
	}
	private String userName;
	private String sexy;
	private String phoneNum;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSexy() {
		return sexy;
	}
	public void setSexy(String sexy) {
		this.sexy = sexy;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(String buyNum) {
		this.buyNum = buyNum;
	}
	public String getNewsPrice() {
		return newsPrice;
	}
	public void setNewsPrice(String newsPrice) {
		this.newsPrice = newsPrice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String userPassword;
}
