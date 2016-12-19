import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBSample.Expenses;
import DBSample.Income;
import DBSample.Item;
import DataBase.ExpensesManager;
import DataBase.IncomeManager;
import DataBase.ItemManager;

@WebServlet(name = "detailsServlet", urlPatterns = { "/detailsServlet" })

public class detailsServlet extends HttpServlet {
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

		String type = req.getParameter("type");
		System.out.println(type);
		int rid = Integer.parseInt(req.getParameter("RID"));

		if (type.equals("EXP")) {
			ExpensesManager em = new ExpensesManager();
			Expenses exp = (Expenses) em.get(rid);
			session.setAttribute("exp", exp);
			req.getRequestDispatcher("/expensesDetails.jsp").forward(req, res);

		} else if (type.equals("INC")) {
			IncomeManager im = new IncomeManager();
			Income inc = (Income) im.get(rid);
			session.setAttribute("inc", inc);
			req.getRequestDispatcher("/incomeDetails.jsp").forward(req, res);

		} else {
			System.out.println("detailsServlet.javaでエラーが発生しました。");
		}

	}
}
