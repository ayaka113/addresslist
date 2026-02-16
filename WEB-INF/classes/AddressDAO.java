import java.sql.*;
import bean.*;

public class AddressDAO{
	private final String URL = "jdbc:mysql://localhost/addressdb";
	private final String USER = "root";
	private final String PASS = "pass";
	private Connection con = null;

	public void connect(){
    	try{
          //①DBに接続
          con = DriverManager.getConnection(URL,USER,PASS);
          }catch(Exception e){
          e.printStackTrace();
          }
		}
	
	public AddressDTO select(){
	  Statement stmt = null;
	  ResultSet rs = null;
	  AddressDTO adto = new AddressDTO();
	  String sql = "SELECT * FROM address";
	  try{
	  	  connect();
          //②ステートメントを生成
          stmt = con.createStatement();
	  	  //③SQLを実行
		  rs = stmt.executeQuery(sql);
		  //④検索結果の処理
	  	  while(rs.next()){
	  	  	AddressBean ab = new AddressBean();
	  	  	ab.setNo(rs.getInt("no"));
	  	  	ab.setName(rs.getString("name"));
	  	  	ab.setAddress(rs.getString("address"));
	  	  	adto.add(ab);
	  	  }
	  	}catch(Exception e){
		e.printStackTrace();
		}finally{
		  try{
			if(rs != null)rs.close();
			if(stmt != null)stmt.close();
		  	}catch(Exception e){
		  	 e.printStackTrace();
		  	}
		}
	  	disconnect();
		return adto;
	  }

	public int insert(int no,String name,String address){
	  String sql = "INSERT INTO address VALUES ("
					+ no + ",'"+ name +"','"+ address +"')";
	  return executeSql(sql);
	}

	public int update(int no,String name,String address){
	  String sql = "UPDATE address SET no = "+ no + ",name = '" + name
					+ "', address = '" + address + "' WHERE no = " + no;
	  return executeSql(sql);
	}

	public int delete(int no){
	  String sql ="DELETE FROM address WHERE no = " + no;
	  return executeSql(sql);
	}

	public int executeSql(String sql){
	  Statement stmt = null;
	  ResultSet rs = null;
	  int result = 0;
	  try{
	  	connect();
	  	//②ステートメントを生成
	  	stmt = con.createStatement();
	  	//③SQLを実行
	  	result = stmt.executeUpdate(sql);
	  }catch(Exception e){
	  	e.printStackTrace();
	  }finally{
	  	try{
	  		if(rs != null)rs.close();
	  		if(stmt != null)stmt.close();
	  	}catch(Exception e){
	  	  e.printStackTrace();
	  	}
	  }
	disconnect();
	return result;
	}
	

	public void disconnect(){
		try{
		//⑤DBを切断
			if(con != null)con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
