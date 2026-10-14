package kr.co.retrominihome.minihome.web;

// TODO 0: 필요한 import (HelloServlet 과 같음)

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO 1: /main 주소와 연결하는 어노테이션
public class MainServlet extends HttpServlet {

    private static final String LAYOUT = "/WEB-INF/views/layout/layout.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO 2: LAYOUT 으로 forward
    }
}
