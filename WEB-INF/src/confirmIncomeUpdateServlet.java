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

@WebServlet(name = "confirmIncomeUpdateServlet", urlPatterns = { "/confirmIncomeUpdateServlet" })

public class confirmIncomeUpdateServlet extends HttpServlet {
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
		IncomeManager em = new IncomeManager();

		Income inc = (Income) session.getAttribute("inc");
		String yearMonthDay = (String) req.getParameter("date");
		System.out.println(yearMonthDay);

		String[] ymd = yearMonthDay.split("-", 0);// 2016-12-01‚ð2016‚Æ12‚Æ1‚É•ª‚¯‚é
		int year = Integer.parseInt(ymd[0]);
		int month = Integer.parseInt(ymd[1]);
		int day = Integer.parseInt(ymd[2]);

		INCCatManager icm = new INCCatManager();
		INCCat incCat = icm.get((int) Integer.parseInt(req.getParameter("category")));

		inc.setYear(year);
		inc.setMonth(month);
		inc.setDay(day);
		inc.setCategory(incCat);
		inc.setAmount(Integer.parseInt(req.getParameter("amount")));
		inc.setMemo((String) req.getParameter("memo"));

		session.setAttribute("inc", inc);

		req.getRequestDispatcher("/confirmIncomeUpdate.jsp").forward(req, res);
	}
}
