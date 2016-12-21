import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBSample.*;
import DataBase.*;

@WebServlet(name = "confirmExpensesInsertServlet", urlPatterns = { "/confirmExpensesInsertServlet" })

public class confirmExpensesInsertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doMain(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doMain(req, res);
	}

	protected void doMain(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		HttpSession session = req.getSession();
		PrintWriter out = res.getWriter();

		Expenses exp = new Expenses();
		String yearMonthDay = (String) req.getParameter("date");

		String[] ymd = yearMonthDay.split("-", 0);// 2016-12-01‚ð2016‚Æ12‚Æ1‚É•ª‚¯‚é
		int year = Integer.parseInt(ymd[0]);
		int month = Integer.parseInt(ymd[1]);
		int day = Integer.parseInt(ymd[2]);

		EXPCatManager ecm = new EXPCatManager();
		EXPCat eCat = ecm.get((int) Integer.parseInt(req.getParameter("category")));

		exp.setUser((UserData) session.getAttribute("user"));
		exp.setYear(year);
		exp.setMonth(month);
		exp.setDay(day);
		exp.setCategory(eCat);
		exp.setAmount(Integer.parseInt(req.getParameter("amount")));
		exp.setPlace((String) req.getParameter("place"));
		exp.setMemo((String) req.getParameter("memo"));

		session.setAttribute("exp", exp);

		req.getRequestDispatcher("/confirmExpensesInsert.jsp").forward(req, res);
	}
}
