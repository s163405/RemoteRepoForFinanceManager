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
import DataBase.EXPCatManager;
import DataBase.ExpensesManager;
import DataBase.INCCatManager;
import DataBase.IncomeManager;

@WebServlet(name = "insertPreperationServlet", urlPatterns = { "/insertPreperationServlet" })

public class insertPreperationServlet extends HttpServlet {
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

		String type = (String)session.getAttribute("type");

		EXPCatManager em = new EXPCatManager();

		LinkedList EXPCatList = em.getEXPList();
		session.setAttribute("EXPCatList", EXPCatList);

		INCCatManager im = new INCCatManager();

		LinkedList INCCatList = im.getINCList();

		session.setAttribute("INCCatList", INCCatList);
		if (type.equals("EXP")) {
			req.getRequestDispatcher("/insertExpensesInput.jsp").forward(req, res);

		} else if (type.equals("INC")) {
			req.getRequestDispatcher("/insertIncomeInput.jsp").forward(req, res);
		} else {
			out.println("ÉyÅ[ÉWëJà⁄Ç…é∏îsÇµÇ‹ÇµÇΩÅB");

		}

	}
}
