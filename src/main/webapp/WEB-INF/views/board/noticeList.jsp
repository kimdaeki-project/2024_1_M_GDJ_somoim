<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!-- table -->

<c:forEach items="${data}" var="data">
    <tr class="something">
        <td class="col-md-2">${data.boardNum}</td>
        <c:if test="${board eq '문의게시판'}">
        <c:choose>
        <c:when test="${data.boardSecret eq 1}">
        
        <c:choose>
        <c:when test="${member.roleDTO.roleNum eq 1}">
        <td class="col-md-4"><a href="/qna/detail?boardNum=${data.boardNum}"><img src="/resources/img/board/file-lock.svg" > 비밀글입니다.</a></td>
         </c:when>
         <c:when test="${member.userName eq data.boardWriter}">
         <td class="col-md-4"><a href="/qna/detail?boardNum=${data.boardNum}"><img src="/resources/img/board/file-lock.svg" > 비밀글입니다.</a></td>
         </c:when>
         <c:otherwise>
         <td class="col-md-4"><img src="/resources/img/board/file-lock.svg" > 비밀글입니다.</td>
         </c:otherwise>
        </c:choose>
        
         </c:when>
         <c:otherwise>
        <td class="col-md-4"><a href="/qna/detail?boardNum=${data.boardNum}">${data.boardTitle}</a></td>
        </c:otherwise>
        </c:choose>
        </c:if>
        <c:if test="${board eq '공지게시판'}">
        <td class="col-md-4"><a href="/notice/detail?boardNum=${data.boardNum}">${data.boardTitle}</a></td>
        </c:if>
        <td class="col-md-4">${data.boardWriter}</td>
        <td class="col-md-4">${data.boardDate}</td>
    </tr>
</c:forEach>

<!-- pager -->
<tr>
    <td row="1" colspan="4" style="border-bottom: hidden">
        <div>
            <ul
                class="list-group list-group-horizontal d-flex justify-content-center"
            >
                <c:if test="${!pager.start}">
                    <li class="page-item">
                        <a class="page-link" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <c:forEach
                    begin="${pager.startNum}"
                    end="${pager.lastNum}"
                    var="i"
                >
                    <li class="page-item">
                        <a data-pageNum="${i}" class="page-link">${i}</a>
                    </li>
                </c:forEach>

                <c:if test="${!pager.last}">
                    <li class="page-item">
                        <a class="page-link" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
    </td>
</tr>
