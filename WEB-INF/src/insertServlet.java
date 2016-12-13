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

		// ItemManager im = new ItemManager();
		// String sql = "insert into stockItem (Name,Price,Details,Stock)
		// Values('ÇΩÇæÇÃêÖ',100,'Ç∑Ç¡Ç´ÇËëuâı',10)";
		// im.updateRecord(sql);

		HttpSession session = req.getSession();

		Item aItem = (Item) session.getAttribute("item");
		ItemManager im = new ItemManager();

		im.insert(aItem);

		req.getRequestDispatcher("./listServlet").forward(req, res);

	}
}
