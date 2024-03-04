
//datepicker
$(function() {
    $("#meetDate").datepicker({
        dateFormat: 'yy-mm-dd' //달력 날짜 형태
        ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
        ,showMonthAfterYear:true // 월- 년 순서가아닌 년도 - 월 순서
        ,changeYear: true //option값 년 선택 가능
        ,changeMonth: true //option값  월 선택 가능                
        ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
        ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
        ,buttonImageOnly: true //버튼 이미지만 깔끔하게 보이게함
        ,buttonText: "선택" //버튼 호버 텍스트              
        ,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
        ,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
        ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
        ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
        ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
        ,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
        ,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
        ,showAnim: "slide"
        ,minDate: 0 //지난 날짜 선택x
    });                    
    
    //초기값 오늘 날짜로 설정
    $('#meetDate').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
});
        

//공백시
const submitBtn = document.getElementById("submitBtn");
let meetName = document.getElementById("meetName");
let meetDate = document.getElementById("meetDate");
let meetPlace = document.getElementById("meetPlace");
let meetCost = document.getElementById("meetCost");
let meetCount = document.getElementById("meetCount");

document.addEventListener("DOMContentLoaded", function(){
    submitBtn.addEventListener("click",(e)=>{
    console.log('연결')
    if(meetName.value === ''){
      alert('이름을 입력하세요.');
      e.preventDefault();
      return false;
    }else if(meetDate.value === ''){
      alert('날짜를 지정하세요.');
      e.preventDefault();
      return false;
    }else if(meetPlace.value === ''){
        alert('위치를 지정하세요.');
        e.preventDefault();
        return false;
    }else if(meetCost.value === ''){
    alert('비용을 입력하세요.');
    e.preventDefault();
    return false;
    }else if(meetCount.value === ''){
      alert('정원을 입력하세요.');
      e.preventDefault();
      return false;
    }

    return true;
  })
});



//지도 실행
showMap();

//검색한 주소의 정보를 insertAddress 함수로 넘겨준다.
function searchAddressToCoordinate(address) {
    //naver.maps.Service 객체: 서버 API를 호출하는 데 필요한 파라미터와 메서드를 제공
    naver.maps.Service.geocode({ //지오코드 요청파라미터
        query: address
    }, function(status, response) {
        //console.log(response);
        
                            //검색 결과 상태 코드
        if (status === naver.maps.Service.Status.ERROR) {
            return alert('Something Wrong!');
        }
        if (response.v2.meta.totalCount === 0) {
            return alert('올바른 주소를 입력해주세요.');
        }
        var htmlAddresses = [],
            item = response.v2.addresses[0],
            point = new naver.maps.Point(item.x, item.y);
        if (item.roadAddress) {
            htmlAddresses.push('[도로명 주소] ' + item.roadAddress);
        }
        if (item.jibunAddress) {
            htmlAddresses.push('[지번 주소] ' + item.jibunAddress);
        }
        if (item.englishAddress) {
            htmlAddresses.push('[영문명 주소] ' + item.englishAddress);
        }
        //console.log(item.x);
        //console.log(item.y);
        insertAddress(item.roadAddress,item.jibunAddress,item.englishAddress, item.x, item.y);
        
    });
}

// 주소 검색
$('#address').on('keydown', function(e) {
    //event.keyCode(js) = e.which(jquery) 각 키보드의 고유 번호
    var keyCode = e.which;
    if (keyCode === 13) { // Enter
        searchAddressToCoordinate($('#address').val());
    }
});
$('#submit').on('click', function(e) {
    e.preventDefault();
    searchAddressToCoordinate($('#address').val());
});
//naver.maps.Event.once(map, 'init_stylemap', initGeocoder);


    
//검색정보 작성, 지도 마커
function insertAddress(address1, address2, address3,longitude, latitude) {
	
    var mapList = "";
	mapList += "<div>"+ '[도로명 주소] ' + address1 + "</div>"
	mapList += "<div>"+ '[지번 주소] ' + address2 + "</div>"
	mapList += "<div>"+ '[영문명 주소] ' + address3 + "</div>"

    let meetX = document.getElementById("meetX");
    let meetY = document.getElementById("meetY");
    let meetPlace = document.getElementById("meetPlace");
    meetX.setAttribute("value",longitude);
    meetY.setAttribute("value",latitude);
    meetPlace.setAttribute("value",address1);
    $('#mapList').html(mapList);




	var map = new naver.maps.Map('map', {
	    center: new naver.maps.LatLng(latitude, longitude),
	    zoom: 14
	});
    var marker = new naver.maps.Marker({
        map: map,
        position: new naver.maps.LatLng(latitude, longitude),
    });
}

//지도 보여주는 함수
function showMap() {
	var map = new naver.maps.Map('map', {
	    center: new naver.maps.LatLng(37.3595704, 127.105399),
	    zoom: 15
	});
}


// 지도를 이동하게 해주는 함수
function moveMap(len, lat) {
	var mapOptions = {
		    center: new naver.maps.LatLng(len, lat),
		    zoom: 15,
		    mapTypeControl: true
		};
    var map = new naver.maps.Map('map', mapOptions);
    var marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(len, lat),
        map: map
    });
}



//정모 개설
// const submitBtn = document.getElementById("submitBtn");
// let addForm = document.getElementById("addForm");
// submitBtn.addEventListener("click",()=>{
//     let form = new FormData(addForm);

//     fetch("./add",{
//         method:"post",
//         headers:{
//             "Content-type":"application/x-www-form-urlencoded"
//         },
//         body: form
//     })
//     .then(res=>res.text)
//     .then(r=>{
//         console.log(r);
//     })
// })