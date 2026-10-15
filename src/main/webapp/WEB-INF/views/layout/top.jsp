<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="top-left">
  <span class="today">TODAY <strong><c:out value="${todayCount}" /></strong></span>
  <span class="bar">|</span>
  <span class="total">TOTAL <fmt:formatNumber value="${totalCount}" pattern="#,###" /></span>
</div>
<div class="top-right">
  <h1 class="home-title"><c:out value="${homeTitle}" /></h1>
  <div class="bgm">
    <span class="bgm-note">♪</span>
    <span class="bgm-title"><c:out value="${bgmTitle}" /></span>
    <button type="button" class="bgm-btn" title="재생">▶</button>
    <button type="button" class="bgm-btn" title="정지">■</button>
  </div>
</div>
