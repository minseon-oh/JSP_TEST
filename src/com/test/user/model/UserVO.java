package com.test.user.model;

public class UserVO {
	private String id;
	private String pw;
	private String name;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email1;
	private String email2;
	private String addr_basic;
	private String addr_detail;
	
	//생성자
	public UserVO() {
		
	}

	public UserVO(String id, String pw, String name, String phone1, String phone2, String phone3, String email1,
			String email2, String addr_basic, String addr_detail) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email1 = email1;
		this.email2 = email2;
		this.addr_basic = addr_basic;
		this.addr_detail = addr_detail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getAddr_basic() {
		return addr_basic;
	}

	public void setAddr_basic(String addr_basic) {
		this.addr_basic = addr_basic;
	}

	public String getAddr_detail() {
		return addr_detail;
	}

	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}

}
