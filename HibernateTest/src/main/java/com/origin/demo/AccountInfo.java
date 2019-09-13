package com.origin.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AccountInfo")
public class AccountInfo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmpId")
	private int id;
	
	@Column(name= "EmpName")
	private String name;
	
	@Column(name="AccountNo")
	private int accountNo;
	
	@Column(name="IFSCCode")
	private String ifsc;
	
	@Column(name="BankName")
	private String bankName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "EmployeeAccountInfo [id=" + id + ", name=" + name + ", accountNo=" + accountNo + ", ifsc="
				+ ifsc + ", BankName=" + bankName + "]";
	}
	
		
}
