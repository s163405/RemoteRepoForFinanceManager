import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBSample.*;
import DataBase.*;

@WebServlet(name = "confirmExpensesUpdateServlet", urlPatterns = { "/confirmExpensesUpdateServlet" })

public class confirmExpensesUpdateServlet extends HttpServlet {
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
		ExpensesManager em = new ExpensesManager();

		Expenses exp = (Expenses) session.getAttribute("exp");
		String yearMonthDay = (String) req.getParameter("date");

		String[] ymd = yearMonthDay.split("-", 0);// 2016-12-01を2016と12と1に分ける
		int year = Integer.parseInt(ymd[0]);
		int month = Integer.parseInt(ymd[1]);
		int day = Integer.parseInt(ymd[2]);

		EXPCatManager ecm = new EXPCatManager();
		EXPCat expCat = ecm.get((int) Integer.parseInt(req.getParameter("category")));

		exp.setUser((UserData) session.getAttribute("user"));
		exp.setYear(year);
		exp.setMonth(month);
		exp.setDay(day);
		exp.setCategory(expCat);
		exp.setAmount(Integer.parseInt(req.getParameter("amount")));
		exp.setPlace((String) req.getParameter("place"));
		exp.setMemo((String) req.getParameter("memo"));

		session.setAttribute("exp", exp);

		req.getRequestDispatcher("/confirmExpensesUpdate.jsp").forward(req, res);
	}
}
