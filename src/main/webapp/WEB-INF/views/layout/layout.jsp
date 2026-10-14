<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>미니홈피</title>
  <%-- CSS 는 1-2 에서 연결 --%>
</head>
<body>
  <div class="frame">
    <div class="frame-inner">
      <header class="top">
        <jsp:include page="/WEB-INF/views/layout/top.jsp" />
      </header>
      <div class="body">
        <aside class="aside">
          <%-- TODO: aside.jsp include --%>
        </aside>
        <main class="content">
          <%-- TODO: content.jsp include --%>
        </main>
      </div>
      <footer class="bottom">
        <%-- TODO: bottom.jsp include --%>
      </footer>
    </div>
  </div>
</body>
</html>
