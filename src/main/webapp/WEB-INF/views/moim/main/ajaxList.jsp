<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${list}" var="ar" varStatus="j">
    <!-- Start Single Grid -->
    <div class="col-lg-4 col-md-6 col-12">
        <div class="single-grid wow fadeInUp" data-wow-delay=".2s" style="visibility: visible; animation-delay: 0.2s; animation-name: fadeInUp;">
            <div class="image">
            
                <c:if test="${empty ar.meetFileDTO.fileName}">
                    <img src="/resources/img/moim/basic.png" style="height: 400px;" alt="..." >
                </c:if> 
                <c:if test="${not empty ar.meetFileDTO.fileName}">
                    <img src="/resources/upload/meet/${ar.meetFileDTO.fileName}" style="height: 400px;" alt="#">
                </c:if>
                
                <%-- <a href="item-details.html" class="thumbnail"><img src="/resources/upload/meet/${ar.meetFileDTO.fileName}" alt="#"></a> --%>
                
                <p class="item-position"><i class="lni lni-bolt"></i> 모집 중</p>
            </div>
            <div class="content">
                <div class="top-content">
                    <div style="text-align: right;">
                        <%-- <a href="javascript:void(0)" class="tag" data-meet-num="${ar.meetNum}" data-moim-num="${ar.moimNum}"><i class="lni lni-pencil update"></i></a> --%>
                        <a href="javascript:void(0)" class="tag" data-meet-num="${ar.meetNum}" data-moim-num="${ar.moimNum}"><i class="lni lni-trash del" ></i></a>
                    </div>
                    
                    <h3 class="title">
                        <a href="#">${ar.meetName}</a>
                    </h3>
                    <p class="update-time">모집 인원 : ${ar.meetCount}</p>
                    <p class="update-time">참가비 : ${ar.meetCost}</p>
                    <ul class="info-list">
                
                        <li><a href="javascript:void(0)"><i class="lni lni-timer"></i>${ar.meetDate}</a></li>
                        
                    </ul>
                    <ul class="rating">
                        <li><a href="javascript:void(0)"><i class="lni lni-map-marker" style="color: rgb(88,48,224);"></i> ${ar.meetPlace}</a></li>
                        
                        
                    

                        <!-- 클릭 시 지도 보이게 -->
                        <!-- Button trigger modal -->
                        <a class="btn btn-light meetXY" data-bs-toggle="modal" data-bs-target="#exampleModal" data-meet-x="${ar.meetX}" data-meet-y="${ar.meetY}">
                            <%-- <input type="hidden" name="meetX" class="meetX" value="${ar.meetX}">
                            <input type="hidden" name="meetY" class="meetY" value="${ar.meetY}"> --%>
                            위치 확인
                        </a>
                        
                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                            <div class="modal-content" style="width:800px;">
                                <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">위치 확인</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div id="map" style="width:765px;height:400px;"></div>
                                </div>
                            </div>
                            </div>
                        </div>


                        
                    </ul>
                </div>
                <div class="bottom-content">
                    <p class="price">참여 인원 : <span>${memNum[j.index]} / ${ar.meetCount}</span></p>
                    <a href="javascript:void(0)" class="like" data-mem-count="${memNum[j.index]}" data-meet-count="${ar.meetCount}"
                    data-meet-num="${ar.meetNum}" data-moim-num="${dto.moimNum}">참여</a>
                </div>
            </div>
        </div>
    </div>
    <!-- End Single Grid -->
</c:forEach>