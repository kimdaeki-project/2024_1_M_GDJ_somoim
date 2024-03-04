// File uload 검사
let ctncheck = $("#formFileMultiple");
ctncheck.on("change", () => {
    let files = ctncheck[0].files; // 선택된 파일들
    console.log("click");
    console.log("value임 = " + ctncheck.val());
    console.log("Attribute임 = " + ctncheck.attr("value"));
    console.log("선택된 파일 개수 = " + files.length);
    if (files.length > 5) {
        alert("5개 이하의 파일만 업로드 가능합니다.");
        ctncheck.val(""); // 파일 선택 취소
        return false;
    }
    for (let i = 0; i < files.length; i++) {
        let ext = files[i].name.split(".").pop().toLowerCase(); // 확장자 분리
        console.log("ext임" + ext);
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

//Title
let title = document.getElementById("title");

//Text
let boardText = document.getElementById("boardText");

// Add
let fileAddBtn = document.getElementById("fileAdd");
fileAddBtn.addEventListener("click", function (event) {
    let title = document.getElementById("title");
    if (title.value.trim() === "") {
        alert("제목이 입력되지 않았습니다.");
        event.preventDefault();
    }
    if (boardText.value.trim() === "") {
        alert("내용이 입력되지 않았습니다.");
        event.preventDefault();
    }
});
