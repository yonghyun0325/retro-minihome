<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="box">
  <h2 class="box-title">최근 소식</h2>
  <ul class="news-list">
    <c:forEach var="post" items="${recentPosts}">
      <li>
        <span class="tag"><c:out value="${post.category}" /></span>
        <span class="news-title"><c:out value="${post.title}" /></span>
        <span class="date"><c:out value="${post.date}" /></span>
      </li>
    </c:forEach>
    <c:if test="${empty recentPosts}">
      <li class="empty">아직 새 소식이 없어요.</li>
    </c:if>
  </ul>
</section>

<section class="box">
  <h2 class="box-title">일촌평</h2>
  <ul class="comment-list">
    <c:forEach var="cmt" items="${ilchonComments}">
      <li>
        <span class="text"><c:out value="${cmt.text}" /></span>
        <span class="writer">- <c:out value="${cmt.writer}" /> (<c:out value="${cmt.relation}" />)</span>
        <span class="date"><c:out value="${cmt.date}" /></span>
      </li>
    </c:forEach>
    <c:if test="${empty ilchonComments}">
      <li class="empty">아직 일촌평이 없어요.</li>
    </c:if>
  </ul>
</section>
