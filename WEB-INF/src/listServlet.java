import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBSample.Expenses;
import DBSample.Income;
import DBSample.UserData;
import DataBase.ExpensesManager;
import DataBase.IncomeManager;

@WebServlet(name = "listServlet", urlPatterns = { "/listServlet" })

public class listServlet extends HttpServlet {
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

		String yearMonth = "";
		yearMonth = (String) req.getParameter("month");
		if (yearMonth == null) {
			Calendar calendar = Calendar.getInstance();// îNåéêÿÇËë÷Ç¶
			yearMonth = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1);
		}

		String[] ym = yearMonth.split("-", 0);// 2016-12Ç2016Ç∆12Ç…ï™ÇØÇÈ
		int year = Integer.parseInt(ym[0]);
		int month = Integer.parseInt(ym[1]);

		ExpensesManager em = new ExpensesManager();

		LinkedList EXPList = em.getEXPList(year, month);

		session.setAttribute("EXPList", EXPList);
		session.setAttribute("year", year);
		session.setAttribute("month", month);

		IncomeManager im = new IncomeManager();

		LinkedList INCList = im.getINCList(year, month);

		session.setAttribute("INCList", INCList);

		req.getRequestDispatcher("/list.jsp").forward(req, res);

	}
}
