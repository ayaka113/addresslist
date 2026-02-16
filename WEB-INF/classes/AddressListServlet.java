import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import bean.AddressDTO;

@WebServlet("/addressList")
public class AddressListServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
		throws IOException,ServletException{
	  String msg = "住所録の情報を表示します";
	  //入力値(btn)を取得
	  req.setCharacterEncoding("utf-8");
	  String btn = req.getParameter("btn");
	  //studentDAOオブジェクトを生成
	  AddressDAO adao = new AddressDAO();
	  //押下ボタンによる分岐処理
	  if(btn.equals("追加")){
	     int no = Integer.parseInt(req.getParameter("no"));
	     String name = req.getParameter("name");
	  	 String address = req.getParameter("address");
	     adao.insert(no,name,address);
	  	 msg = "番号" + no + "の住所録を追加しました";
	    }else if(btn.equals("修正")){
	     int no = Integer.parseInt(req.getParameter("no"));
	     String name = req.getParameter("name");
	  	 String address = req.getParameter("address");
	     adao.update(no,name,address);
	     msg = "番号" + no + "の住所録を修正しました";
	    }else if(btn.equals("削除")){
	     int no = Integer.parseInt(req.getParameter("no"));
	     adao.delete(no);
	     msg = "番号" + no + "の住所録を削除しました";
	    }
		//全件検索
		AddressDTO adto = adao.select();
		//リクエストスコープにDTOとmsgを格納
		req.setAttribute("adto",adto);
		req.setAttribute("msg",msg);
		//JSPにフォワード
		RequestDispatcher rd = req.getRequestDispatcher("/addressList.jsp");
		rd.forward(req, res);
		}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException,ServletException{
	  doPost(req,res);
	}
}
