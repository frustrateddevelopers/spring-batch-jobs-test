package com.example.springbatch.myfirstspringbatchexample.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Report {

	private int id_report;
	private BigDecimal sales_report;
	private int qty_report;
	private String staffName_report;
	private Date date_report;

	
	public int getId_report() {
		return id_report;
	}


	public void setId_report(int id_report) {
		this.id_report = id_report;
	}


	public BigDecimal getSales_report() {
		return sales_report;
	}


	public void setSales_report(BigDecimal sales_report) {
		this.sales_report = sales_report;
	}


	public int getQty_report() {
		return qty_report;
	}


	public void setQty_report(int qty_report) {
		this.qty_report = qty_report;
	}


	public String getStaffName_report() {
		return staffName_report;
	}


	public void setStaffName_report(String staffName_report) {
		this.staffName_report = staffName_report;
	}


	public Date getDate_report() {
		return date_report;
	}


	public void setDate_report(Date date_report) {
		this.date_report = date_report;
	}


	@Override
	public String toString() {
		return "Report [id=" + id_report + ", sales=" + sales_report 
                    + ", qty=" + qty_report + ", staffName=" + staffName_report + "]";
	}

}

