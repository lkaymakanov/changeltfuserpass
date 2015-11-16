package user;

import java.util.Date;

import wiz.Sha512;





public class User extends AbstractModel{
	
	private String username;
	private String password;
	private String fullName;
	private Date beginDate;
	private Date endDate;
	private Date createdDate;
	private String other;
	private int faultCounter;
	private Date faultDate;
	private boolean accessDenied;
	private boolean deleted;
	private User createdBy;

	
	private boolean mustChangePass;
	
	
	
	public User(){
		//nothing
	}
	
	public String getEncryptedPass(){
		if(getPassword() == null)  return null;
		return new Sha512().digest(getPassword());
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public Integer getFaultCounter() {
		return faultCounter;
	}
	public void setFaultCounter(Integer faultCounter) {
		this.faultCounter = faultCounter;
	}
	public Date getFaultDate() {
		return faultDate;
	}
	public void setFaultDate(Date faultDate) {
		this.faultDate = faultDate;
	}
	public boolean isAccessDenied() {
		return accessDenied;
	}
	public void setAccessDenied(boolean accessDenied) {
		this.accessDenied = accessDenied;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public boolean isBlockedByError(){
		return (faultCounter >= 5);
	}
	public void setBlockedByError(boolean blocked){
		if (!blocked) faultCounter = 0;
	}

	public boolean isMustChangePass() {
		return mustChangePass;
	}

	public void setMustChangePass(boolean mustChangePass) {
		this.mustChangePass = mustChangePass;
	}

	

}
