import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBSample.Item;
import DataBase.ItemManager;

@WebServlet(name = "confirmUpdateServlet", urlPatterns = { "/confirmUpdateServlet" })

public class confirmUpdateServlet extends HttpServlet {
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
		ItemManager im = new ItemManager();

		Item item = (Item)session.getAttribute("item");

		item.setName(req.getParameter("name"));
		item.setPrice(Integer.parseInt(req.getParameter("price")));
		item.setDetails(req.getParameter("details"));
		item.setStock(Integer.parseInt(req.getParameter("stock")));


		session.setAttribute("item", item);

		req.getRequestDispatcher("/confirmUpdate.jsp").forward(req, res);
	}
}
