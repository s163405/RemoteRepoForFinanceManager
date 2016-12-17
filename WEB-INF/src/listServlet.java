import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

//		ItemManager im = new ItemManager();
//
//		LinkedList itemList = im.getList();
//		session.setAttribute("ItemList", itemList);
//
//		req.getRequestDispatcher("/list.jsp").forward(req, res);

		ExpensesManager em = new ExpensesManager();

		LinkedList EXPList = em.getEXPList();
		session.setAttribute("EXPList", EXPList);

		IncomeManager im = new IncomeManager();

		LinkedList INCList = im.getINCList();
		session.setAttribute("INCList", INCList);

		req.getRequestDispatcher("/list.jsp").forward(req, res);

	}
}
