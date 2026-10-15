<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>미니홈피</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/minihome.css">
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
