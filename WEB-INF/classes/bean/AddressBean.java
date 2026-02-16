package bean;

import java.io.Serializable;

public class AddressBean implements Serializable{
	private int no;
	private String name;
	private String address;
	
	public void setNo(int no){
	  this.no = no;
	}
	public void setName(String name){
	  this.name = name;
	}
	public void setAddress(String address){
	  this.address = address;
	}
	public int getNo(){
	  return no;
	}
	public String getName(){
	  return name;
	}
	public String getAddress(){
	  return address;
	}
}
