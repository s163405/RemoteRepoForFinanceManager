import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBSample.UserData;
import DataBase.UserDataManager;

@WebServlet(name = "loginServlet", urlPatterns = { "/loginServlet" })

public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doMain(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doMain(req, res);
	}

	protected void doMain(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();

		String reqUserID=(String)req.getParameter("uid");
		String reqUserPW=(String)req.getParameter("pswd");

		UserDataManager um=new UserDataManager();
		UserData user = um.get(reqUserID, reqUserPW);

		if(user==null){
			System.out.println("ユーザログイン：失敗");
			req.getRequestDispatcher("./login.jsp").forward(req, res);
		}else{
			session.setAttribute("user", user);
			System.out.println("ユーザログイン：成功");
			req.getRequestDispatcher("./indexServlet").forward(req, res);


		}



	}
}
