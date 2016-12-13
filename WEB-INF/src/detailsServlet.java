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
		ItemManager im = new ItemManager();

		String rid = req.getParameter("RID");

		int ridInt= Integer.parseInt(rid);

		Item item = (Item) im.get(ridInt); // sql•¶‚ð‘—‚Á‚ÄŒ‹‰Ê‚ðŽæ“¾
		// out.println(item.getName() + "<br />");
		// out.println(item.getPrice() + "<br />");
		// out.println(item.getDetails() + "<br />");
		// out.println(item.getStock() + "<br />");

		session.setAttribute("item", item);

		req.getRequestDispatcher("/details.jsp").forward(req, res);
	}
}
