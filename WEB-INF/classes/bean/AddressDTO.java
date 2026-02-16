package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class AddressDTO implements Serializable{
	private ArrayList<AddressBean> list;
	
	public AddressDTO(){
	  list = new ArrayList<AddressBean>();
	}
	
	public void add(AddressBean ab){
	  list.add(ab);
	}
	
	public AddressBean get(int i){
	  return list.get(i);
	}
	public int size(){
	  return list.size();
	}
}
