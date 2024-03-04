console.log("메인테스트");

let del = document.querySelectorAll('.del');
let show = document.getElementsByClassName("show");
let profile = document.querySelectorAll(".profile");
let show_profile = document.getElementById("show_profile");
let getLocation = document.getElementById("getLocation");
let btn_area = document.getElementById("btn_area");

let btn1 = document.getElementById("btn1");
let btn2 = document.getElementById("btn2");
let btn3 = document.getElementById("btn3");
let frm = document.querySelector("#frm");
let frm2 = document.querySelector("#frm2");

btn_area.addEventListener("click",()=>{
    const btn_close = document.getElementById("btn_close");
    const adrs_in = document.getElementById("adrs_in");

    const area = document.getElementById("area"); // area 요소 가져오기
    const area_detail = document.getElementById("area_detail"); // area_detail 요소 가져오기
    
    console.log(area_detail.value);

    if(area.value !=="" && area_detail.value !=="" && area_detail.value !=='0'){
        adrs_in.value = '';
        adrs_in.value +=area.options[area.selectedIndex].innerHTML+" ";
        adrs_in.value +=area_detail.options[area_detail.selectedIndex].innerHTML;
        btn_close.click();
    }else{
        alert("지역 또는 세부지역을 확인해주세요");
    }  
})

btn1.addEventListener("click",()=>{
    console.log("클릭")

    if(show_profile.style.display === "none"){
        console.log("왜안돼")
        show_profile.style.display = "table-row";
    }
    getLocation.style.display = "block";
    
    
    profile.forEach(profiles=>{
        profiles.setAttribute("type","file");
    })

    del.forEach(e => {
        e.remove();
    });
    for(let j = 0 ;j<del.length;j++){
    show[j].setAttribute("type","text");
    }

    btn1.setAttribute("disabled",true);
    btn2.removeAttribute("hidden");

})

btn2.addEventListener("click",(e)=>{
    e.preventDefault();
    frm.submit();
    alert("수정 완료");

})



btn3.addEventListener("click",(e)=>{
    let pwd = document.getElementById("password").value;
    let pwdCheck = document.getElementById("passwordCheck").value;
    let p_pwd=document.getElementById("p_pwd").value;
    let p_pwdCheck=document.getElementById("p_pwdCheck").innerHTML;

    function strongPassword (str) {
        return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(str);
      }

        if(p_pwd !== p_pwdCheck){
            console.log(p_pwdCheck);
            console.log(p_pwd);
            alert("현재비밀번호 확인")
        }else if(pwd==pwdCheck){
            if(strongPassword(pwd)){
                e.preventDefault();
                frm2.submit();
                alert("변경되었습니다");
                }else{
                    alert("비밀번호는 8글자 이상,영문,숫자,특수문자가 들어가야합니다")
                }
            }else{
        alert("변경할 비밀번호를 확인해주세요");
    }


    
})

let accessToken;													
   //토근 가져오기
    var errCnt=0;						
    getAccessToken();												
    function getAccessToken(){												
    jQuery.ajax({																												
        type:'GET', 																											
        url: 'https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json',													
        data:{																													
        consumer_key : 'ef9b5bab0a4e4ed492be',																					
        consumer_secret : '9f793743e64e4f0b90aa',																				
        },																														
        success:function(data){																									
            errCnt = 0;																									
            accessToken = data.result.accessToken														
        },																													
        error:function(data) {																									
        }																														
    });																		
    }


//시,도,광역시,특별시
getLocation.addEventListener("click", function() {
    
    
    // AJAX 요청
    jQuery.ajax({
        type: "GET",
        url: "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json",
        data: {
            accessToken: accessToken,
            pg_yn: 0
        },
        success: function(data) {
            errCnt = 0;
            area.innerHTML='';
            for (let i = 0; i < data.result.length; i++) {

                let addr_name = data.result[i].addr_name;
                let cd = data.result[i].cd;
                    console.log(cd);
                    let sel = document.createElement("option");
                    sel.setAttribute("value", cd);
                    sel.innerHTML = addr_name;
                    area.append(sel);
                    if(cd==11){    
                        let selected = area.options[area.selectedIndex];
                        let area_detail = document.getElementById("area_detail");
                       
                        // 여기서 result_item을 resultItem으로 수정
                    
                        jQuery.ajax({
                            type:"GET",
                            url: "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json",
                            data:{
                                accessToken:accessToken,
                                cd:selected.value,
                                pg_yn:0
                            },
                            success: function(data){
                    
                                area_detail.innerHTML = "";
                                for(let i = 0;i<data.result.length;i++){
                                    let addr_name = data.result[i].addr_name;
                                    let cd = data.result[i].cd;
                                    
                                    let sel = document.createElement("option");
                                    sel.setAttribute("value",cd);
                                    sel.innerHTML = addr_name;
                                    area_detail.append(sel);
                                }
                            },
                            error: function(data){
                                //에러 처리   
                            }
                    
                        });
                    }
               
                }
            },
        error: function(data) {
            // 에러 처리
        }
    });
});

//군,구 처리
function changeList(){

    let selected = area.options[area.selectedIndex];

    let area_detail = document.getElementById("area_detail");
   
    // 여기서 result_item을 resultItem으로 수정

    jQuery.ajax({
        type:"GET",
        url: "https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json",
        data:{
            accessToken:accessToken,
            cd:selected.value,
            pg_yn:0
        },
        success: function(data){

            area_detail.innerHTML = "";
            for(let i = 0;i<data.result.length;i++){
                let addr_name = data.result[i].addr_name;
                let cd = data.result[i].cd;
                
                let sel = document.createElement("option");
                sel.setAttribute("value",cd);
                sel.innerHTML = addr_name;
                area_detail.append(sel);
            }
        },
        error: function(data){
            //에러 처리   
        }

    });
}
