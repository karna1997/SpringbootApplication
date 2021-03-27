package com.example.First;

public class Country {
 int cid;
 String cname;

public Country() {
	super();
	
}
public Country(int cid, String cname) {
	super(); 
	this.cid = cid;
	this.cname = cname;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
}
