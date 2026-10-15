<%@ page pageEncoding="UTF-8" %>
<nav class="tabs">
  <a href="${ctx}/main?menu=home"      class="${menu == 'home' ? 'on' : ''}">홈</a>
  <a href="${ctx}/main?menu=diary"     class="${menu == 'diary' ? 'on' : ''}">다이어리</a>
  <a href="${ctx}/main?menu=photo"     class="${menu == 'photo' ? 'on' : ''}">사진첩</a>
  <a href="${ctx}/main?menu=guestbook" class="${menu == 'guestbook' ? 'on' : ''}">방명록</a>
</nav>

<%-- 서블릿이 정해 준 화면만 이 자리에 들어온다 --%>
<div class="content-body">
  <jsp:include page="${contentPage}" />
</div>
