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
      


//update
//update 사진 미리보기
function readImg(input) {
    if (input.files && input.files[0]) {
        ////파일읽기
      let reader = new FileReader();
      reader.onload = function(e) {
        document.getElementById('preview').src = e.target.result;
      };
        //////file 인풋에서 change이벤트가 실행됐을때의 이벤트 헨들러
      reader.readAsDataURL(input.files[0]);
    } else {
      document.getElementById('preview').src = "";
    }
  }
  
//update 공백시
const submitBtn = document.getElementById("submitBtn");
let moimText = document.getElementById("moimText");
let moimMemCount = document.getElementById("moimMemCount");

document.addEventListener("DOMContentLoaded", function(){
    submitBtn.addEventListener("click",(e)=>{
    console.log('연결')
    if(moimName.value === ''){
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

    


    })
});

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