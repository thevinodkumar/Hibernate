package com.nt.domain;

public class Phno {
	private int no;
	private long ph1;
	private String type;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public long getPh1() {
		return ph1;
	}

	public void setPh1(long ph1) {
		this.ph1 = ph1;
	}

	public String getType() {
		return type;
	}

	public void setType(String ph2) {
		this.type = ph2;
	}

	@Override
	public String toString() {
		return "Person [no=" + no + ", ph1=" + ph1 + ", ph2=" + type + "]";
	}

}
