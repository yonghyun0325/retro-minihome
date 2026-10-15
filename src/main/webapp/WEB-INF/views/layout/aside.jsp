<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="profile-photo">
  <span>PHOTO</span>
</div>

<dl class="mood">
  <dt>TODAY IS..</dt>
  <dd><c:out value="${mood}" /></dd>
</dl>

<p class="intro"><c:out value="${intro}" /></p>

<div class="owner">
  <strong><c:out value="${ownerName}" /></strong>님의 미니홈피
</div>

<div class="ilchon">
  <select class="ilchon-select" aria-label="일촌 파도타기">
    <option value="">일촌 파도타기</option>
    <c:forEach var="name" items="${ilchonList}">
      <option><c:out value="${name}" /></option>
    </c:forEach>
  </select>
  <button type="button" class="btn-small">GO</button>
</div>
