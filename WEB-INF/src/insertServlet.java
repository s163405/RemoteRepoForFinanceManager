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


@WebServlet(name = "insertServlet", urlPatterns = { "/insertServlet" })

public class insertServlet extends HttpServlet {
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

		String type = (String) session.getAttribute("type");
		if (type == null) {
			req.getRequestDispatcher("/listServlet").forward(req, res);
		}

		if (type.equals("EXP")) {
			Expenses exp = (Expenses) session.getAttribute("exp");
			ExpensesManager em = new ExpensesManager();
			em.insert(exp);

		} else if(type.equals("INC")){
			Income inc = (Income) session.getAttribute("inc");
			IncomeManager im = new IncomeManager();
			im.insert(inc);

		}


		req.getRequestDispatcher("./listServlet").forward(req, res);

	}
}
