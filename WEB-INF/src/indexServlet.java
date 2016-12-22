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

import DBSample.*;
import DataBase.*;

@WebServlet(name = "indexServlet", urlPatterns = { "/indexServlet" })

public class indexServlet extends HttpServlet {
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

		// DBManagerの呼び出し
		ExpensesManager em = new ExpensesManager();
		IncomeManager im = new IncomeManager();
		EXPCatManager ecm = new EXPCatManager();
		INCCatManager icm = new INCCatManager();


		/******************************************
		 * 年月の処理
		 ******************************************/
		String yearMonth = "";
		yearMonth = (String) req.getParameter("month");
		if (yearMonth == null) {
			Calendar calendar = Calendar.getInstance();// 年月切り替え
			yearMonth = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1);
		}

		String[] ym = yearMonth.split("-", 0);// 2016-12を2016と12に分ける
		int year = Integer.parseInt(ym[0]);
		int month = Integer.parseInt(ym[1]);

		session.setAttribute("year", year);
		session.setAttribute("month", month);

		/******************************************
		 * 総額計算（支出,収入）
		 ******************************************/
		LinkedList EXPList = em.getEXPList(year, month);
		LinkedList INCList = im.getINCList(year, month);

		int totalEXP = 0;
		int totalINC = 0;

		for (int i = 0; i < EXPList.size(); i++) {
			Expenses aExp = (Expenses) EXPList.get(i);
			totalEXP += aExp.getAmount();

		}
		for (int i = 0; i < INCList.size(); i++) {
			Income aInc = (Income) INCList.get(i);
			totalINC += aInc.getAmount();

		}

		session.setAttribute("totalEXP", totalEXP);
		session.setAttribute("totalINC", totalINC);

		/*******************************************
		 * 支出/収入カテゴリの取得
		 ******************************************/
		LinkedList EXPCatList = ecm.getEXPCatList();
		LinkedList INCCatList = icm.getINCCatList();

		session.setAttribute("EXPCatList", EXPCatList);
		session.setAttribute("INCCatList", INCCatList);

		/*******************************************
		 * 積み上げグラフ（日別支出）Stacked Column
		 ******************************************/
		// 月末の日を計算
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);

		// グラフに入力するための二次元配列の生成
		int expSCData[][] = new int[lastDayOfMonth][EXPCatList.size()];

//		for (int thisDay = 0; thisDay < lastDayOfMonth; thisDay++) {
//			for (int thisCategory = 0; thisCategory < EXPCatList.size(); thisCategory++) {
//				LinkedList expListCat = em.getEXPListCat(year, month, thisDay + 1, thisCategory + 1);
//				for (int i = 0; i < expListCat.size(); i++) {
//					Expenses expthisDayCat = (Expenses) expListCat.get(i);
//					expSCData[thisDay][thisCategory] += expthisDayCat.getAmount();
//
//				}
//			}
//		}

		for (int thisDay = 0; thisDay < lastDayOfMonth; thisDay++) {
			for (int thisCategory = 0; thisCategory < EXPCatList.size(); thisCategory++) {
				LinkedList expListCat = em.getEXPListCat(year, month, thisDay + 1, thisCategory + 1);
				for (int i = 0; i < expListCat.size(); i++) {
					Expenses expthisDayCat = (Expenses) expListCat.get(i);
					expSCData[thisDay][thisCategory] += expthisDayCat.getAmount();

				}
			}
		}

		session.setAttribute("expSCData", expSCData);

		/*******************************************
		 * 円グラフ（支出）pie chart(Expenses)
		 ******************************************/
		int expPieData[] = new int[EXPCatList.size()];
		for (int thisCategory = 0; thisCategory < EXPCatList.size(); thisCategory++) {
			LinkedList monthlyEXPListCat = em.getEXPListCat(year, month, thisCategory+1);
			for (int i = 0; i < monthlyEXPListCat.size(); i++) {
				Expenses monthlyEXPAmountCat = (Expenses) monthlyEXPListCat.get(i);
				expPieData[thisCategory] += monthlyEXPAmountCat.getAmount();

			}
		}
		session.setAttribute("expPieData", expPieData);

		/*******************************************
		 * 円グラフ（収入）pie chart(Income)
		 ******************************************/
		int incPieData[] = new int[INCCatList.size()];
		for (int thisCategory = 0; thisCategory < INCCatList.size(); thisCategory++) {
			LinkedList monthlyINCListCat = im.getINCListCat(year, month, thisCategory+1);
			for (int i = 0; i < monthlyINCListCat.size(); i++) {
				Income monthlyINCAmountCat = (Income) monthlyINCListCat.get(i);
				incPieData[thisCategory] += monthlyINCAmountCat.getAmount();

			}
		}
		session.setAttribute("incPieData", incPieData);

		req.getRequestDispatcher("/index.jsp").forward(req, res);

	}
}
