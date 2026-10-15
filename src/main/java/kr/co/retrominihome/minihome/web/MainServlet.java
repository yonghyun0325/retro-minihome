package kr.co.retrominihome.minihome.web;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    private static final String LAYOUT = "/WEB-INF/views/layout/layout.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setDummyData(req);
        req.getRequestDispatcher(LAYOUT).forward(req, resp);
    }

    /** DB 를 붙이기 전까지 쓰는 임시 데이터 */
    private void setDummyData(HttpServletRequest req) {

        req.setAttribute("homeTitle", "길동이의 작은 방 ♪");
        req.setAttribute("bgmTitle", "봄날의 산책 (무료 음원)");
        req.setAttribute("todayCount", 12);
        req.setAttribute("totalCount", 3456);

        req.setAttribute("ownerName", "홍길동");
        req.setAttribute("mood", "행복 (^_^)");
        req.setAttribute("intro", "미니홈피 오픈했어요~\n일촌 신청 언제나 환영!");
        req.setAttribute("ilchonList", Arrays.asList("김철수 (베프)", "이영희 (동네친구)", "박민수 (동아리)"));
    }
}
