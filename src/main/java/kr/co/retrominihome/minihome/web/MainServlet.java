package kr.co.retrominihome.minihome.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    private static final String VIEW_PATH = "/WEB-INF/views/";
    private static final String LAYOUT = VIEW_PATH + "layout/layout.jsp";

    private static final Map<String, String> CONTENT_PAGES;
    static {
        Map<String, String> pages = new HashMap<>();
        pages.put("home",      VIEW_PATH + "minihome/home.jsp");
        pages.put("diary",     VIEW_PATH + "common/ready.jsp");
        pages.put("photo",     VIEW_PATH + "common/ready.jsp");
        pages.put("guestbook", VIEW_PATH + "common/ready.jsp");
        CONTENT_PAGES = Collections.unmodifiableMap(pages);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String menu = req.getParameter("menu");
        if (menu == null || !CONTENT_PAGES.containsKey(menu)) {
            menu = "home";
        }

        setLayoutDummyData(req);
        if ("home".equals(menu)) {
            setHomeDummyData(req);
        }

        req.setAttribute("menu", menu);
        req.setAttribute("contentPage", CONTENT_PAGES.get(menu));
        req.getRequestDispatcher(LAYOUT).forward(req, resp);
    }

    /** 모든 탭에 공통으로 보이는 top, aside 의 임시 데이터 (DB 연결 전까지) */
    private void setLayoutDummyData(HttpServletRequest req) {
        // top.jsp
        req.setAttribute("homeTitle", "길동이의 작은 방 ♪");
        req.setAttribute("bgmTitle", "봄날의 산책 (무료 음원)");
        req.setAttribute("todayCount", 12);
        req.setAttribute("totalCount", 3456);

        // aside.jsp
        req.setAttribute("ownerName", "홍길동");
        req.setAttribute("mood", "행복 (^_^)");
        req.setAttribute("intro", "미니홈피 오픈했어요~\n일촌 신청 언제나 환영!");
        req.setAttribute("ilchonList", Arrays.asList("김철수 (베프)", "이영희 (동네친구)", "박민수 (동아리)"));
    }

    /** 홈 탭에서만 쓰는 임시 데이터 (DB 연결 전까지) */
    private void setHomeDummyData(HttpServletRequest req) {
        req.setAttribute("recentPosts", Arrays.asList(
                row("category", "다이어리", "title", "오늘 미니홈피 처음 만들었다", "date", "2026.10.13"),
                row("category", "사진첩", "title", "가을 하늘 사진 올림", "date", "2026.10.12"),
                row("category", "방명록", "title", "철수가 방명록 남김", "date", "2026.10.11")
        ));
        req.setAttribute("ilchonComments", Arrays.asList(
                row("writer", "김철수", "relation", "베프", "text", "홈피 이쁘다~ 자주 놀러올게", "date", "2026.10.13"),
                row("writer", "이영희", "relation", "동네친구", "text", "BGM 뭐야? 노래 좋다 ㅎㅎ", "date", "2026.10.12")
        ));
    }

    /** "키", 값, "키", 값 ... 순서로 받아서 Map 하나를 만든다 (Java 8 에는 Map.of 가 없어서) */
    private static Map<String, Object> row(Object... keyValues) {
        if (keyValues.length % 2 != 0) {
            throw new IllegalArgumentException("키와 값은 짝을 맞춰야 합니다");
        }
        Map<String, Object> map = new LinkedHashMap<>();
        for (int i = 0; i < keyValues.length; i += 2) {
            map.put((String) keyValues[i], keyValues[i + 1]);
        }
        return map;
    }
}
