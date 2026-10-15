<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 컨텍스트 경로를 ctx 로 저장. include 된 조각에서도 쓸 수 있게 request 범위 --%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request" />
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>미니홈피</title>
  <link rel="stylesheet" href="${ctx}/resources/css/minihome.css">
</head>
<body>
  <div class="frame">
    <div class="frame-inner">
      <header class="top">
        <jsp:include page="/WEB-INF/views/layout/top.jsp" />
      </header>
      <div class="body">
        <aside class="aside">
          <jsp:include page="/WEB-INF/views/layout/aside.jsp" />
        </aside>
        <main class="content">
          <jsp:include page="/WEB-INF/views/layout/content.jsp" />
        </main>
      </div>
      <footer class="bottom">
        <jsp:include page="/WEB-INF/views/layout/bottom.jsp" />
      </footer>
    </div>
  </div>
</body>
</html>
