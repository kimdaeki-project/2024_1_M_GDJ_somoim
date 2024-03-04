//summernote
$('#moimText').summernote({
        placeholder: '모임에 대한 설명이나 목표를 적어주세요.',
        tabsize: 2,
        height: 250,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture', 'video']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ]
      });

//모임개설
const submitBtn = document.getElementById("submitBtn");
let addForm = document.getElementById("addForm");

//input 공백시

let moimName = document.getElementById("moimName");
let moimText = document.getElementById("moimText");
let moimMemCount = document.getElementById("moimMemCount");
let regionShow = document.getElementById("regionShow");

document.addEventListener("DOMContentLoaded", function(){
    submitBtn.addEventListener("click",(e)=>{
    //console.log('연결')
    //console.log(regionShow.innerText)
    if(regionShow.innerText === '지역 찾기' ||regionShow.innerText === '시/군/구 선택'){
    	alert('지역을 설정해주세요.');
        e.preventDefault();
        return false;
    }else if(moimName.value === ''){
        alert('이름을 입력하세요.');
        e.preventDefault();
        return false;
    }else if(moimText.value === ''){
        alert('내용을 입력하세요.');
        e.preventDefault();
        return false;
    }else if(moimMemCount.value === ''){
        alert('정원을 입력하세요.');
        e.preventDefault();
        return false;
    }

    return true;

    let form = new FormData(addForm);
    //console.log(form)
    fetch("./add",{
        method:"post",
        headers:{
            "Content-type":"application/x-www-form-urlencoded"
        },
        body: form
    })
    .then(res=>res.text)
    .then(r=>{
        //console.log(r);
    })


    })
});

//모임 개설

// submitBtn.addEventListener("click",()=>{
//     let form = new FormData(addForm);
//     //console.log(form)
//     fetch("./add",{
//         method:"post",
//         headers:{
//             "Content-type":"application/x-www-form-urlencoded"
//         },
//         body: form
//     })
//     .then(res=>res.text)
//     .then(r=>{
//         //console.log(r);
//     })
// })

//개설시 제한
	//이미지
// File uload 검사
let ctncheck = $("#formFileMultiple");
ctncheck.on("change", () => {
    let files = ctncheck[0].files; // 선택된 파일들
    //console.log("click");
    //console.log("value임 = " + ctncheck.val());
    //console.log("Attribute임 = " + ctncheck.attr("value"));
    //console.log("선택된 파일 개수 = " + files.length);
    if (files.length > 1) {
        alert("1개의 파일만 업로드 가능합니다.");
        ctncheck.val(""); // 파일 선택 취소
        return false;
    }
    for (let i = 0; i < files.length; i++) {
        let ext = files[i].name.split(".").pop().toLowerCase(); // 확장자 분리
        //console.log("ext임" + ext);
        // 아래 확장자가 있는지 체크 배열에 담아서 비교
        if ($.inArray(ext, ["jpg", "jpeg", "gif", "png"]) == -1) {
            alert(
                "jpg,gif,jpeg,png 파일만 업로드 할수 있습니다. 다시 업로드 해주십시오."
            );
            ctncheck.val(""); // 파일 선택 취소
            return false;
        }
    }
});






//카테고리
const $_SELECT_PICKER = $('.my-image-selectpicker');
$_SELECT_PICKER.find('option').each((idx, elem) => {
    const $OPTION = $(elem);
    const IMAGE_URL = $OPTION.attr('data-thumbnail');
    if (IMAGE_URL) {$OPTION.attr('data-content', "<img src='%i'/> %s".replace(/%i/,IMAGE_URL).replace(/%s/, $OPTION.text()))}
});
$('select.selectpicker').selectpicker({caretIcon: 'fa fa-angle-down'});
$_SELECT_PICKER.selectpicker();


//지역
let moimRegion = document.getElementById("moimRegion");
const save = document.getElementById("save");
const regionbutton = document.getElementById('regionbutton');
const cityList = document.getElementById('cityList');
let remainList = document.getElementById("remainList");
const close = document.getElementById("close");
let accessToken;													

fetch("https://sgisapi.kostat.go.kr/OpenAPI3/auth/authentication.json?consumer_key=78c3de9d1714451591a9&consumer_secret=59adf4be81304268ac42",{
    method: "get"
})
.then(res=>res.json())
.then(res=>{
    //console.log(res)
    //console.log(res.result.accessToken)
    accessToken = res.result.accessToken
});
    

regionbutton.addEventListener("click", function() {
    
    fetch("https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json?accessToken="+accessToken,{
        method: "get"
    })
    .then(res=>res.json())
    .then(res=>{
        //console.log(res)
        
        cityList.innerHTML='';
        remainList.innerHTML='';
        
        let city = document.createElement("option");
        city.setAttribute("selected", "selected");
        city.setAttribute("disabled", "");
        city.setAttribute("value", '0');

        city.innerHTML= '전체';
        cityList.append(city);

        let remain = document.createElement("option");
        remain.setAttribute("selected", "selected");
        remain.setAttribute("disabled", "");
        remain.setAttribute("value", '0');

        remain.innerHTML= '시/군/구 선택';
        remainList.append(remain);

        for (let i = 0; i < res.result.length; i++) {
            let addr_name = res.result[i].addr_name;
            let cd = res.result[i].cd; 

            let option = document.createElement("option");
            option.setAttribute("value", cd);
            option.innerHTML= addr_name;
            cityList.append(option);
        }
        

    })

});

function city(e){
    let selected = cityList.options[cityList.selectedIndex].value;
    //console.log(selected);

    fetch("https://sgisapi.kostat.go.kr/OpenAPI3/addr/stage.json?accessToken="+accessToken+"&cd="+selected,{
        method: "get"
    })
    .then(res=>res.json())
    .then(res=>{
        //console.log(res);
        remainList.innerHTML='';
        for (let i = 0; i < res.result.length; i++) {
            let addr_name = res.result[i].addr_name;
            let cd = res.result[i].cd; 

            let option = document.createElement("option");
            option.setAttribute("value", cd);
            option.innerHTML= addr_name;
            remainList.append(option);
        }

    })

}

save.addEventListener("click",()=>{
    if(cityList.value !=="" && cityList.value !=='0' && remainList.value !=="" && remainList.value !=='0'){
        let regionResult=cityList.options[cityList.selectedIndex].innerHTML + " " +remainList.options[remainList.selectedIndex].innerHTML;
        regionShow.innerText = regionResult;
        moimRegion.value = regionResult;
        //console.log(moimRegion.value);
        
        //remainList.value='0';
        close.click();
    }else{
        alert("지역을 선택해 주세요");
    }
});
