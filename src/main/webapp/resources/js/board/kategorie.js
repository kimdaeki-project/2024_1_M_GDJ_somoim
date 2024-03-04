const navLinks = document.querySelectorAll(".BOARDCATEGORY");
// 카테고리 처리

let category = "";
let page = "";

navLinks.forEach((link) => {
    link.addEventListener("click", function (event) {
        event.preventDefault();

        category = this.getAttribute("data-category"); // category 업데이트

        navLinks.forEach((navLink) => navLink.classList.remove("active"));
        this.classList.add("active");

        console.log("선택된 카테고리:", category);
        page = "";
        getNoticeList(listsear.value, page, searchFind.value, category); // 페이지 변수 전달
    });
});

getNoticeList("", "", "", ""); // 첫 페이지 호출

//페이저 및 테이블 처리
let tbody = document.getElementById("noticeList");
tbody.addEventListener("click", function (e) {
    if (e.target.classList.contains("page-link")) {
        page = e.target.getAttribute("data-pageNum"); // 페이지 업데이트
        console.log(page);
        console.log("페이지, 테이블");
        getNoticeList("", page, "", category); // 페이지 변수 전달
    }
});
// noticeList,page 호출
function getNoticeList(search, page, searchFind, category) {
    let url =
        "noticeList?page=" +
        page +
        "&search=" +
        search +
        "&searchFind=" +
        searchFind +
        "&categorySelect=" +
        category;
    fetch(url, {
        method: "GET",
    })
        .then((response) => response.text())
        .then((r) => {
            console.log(url);
            document.getElementById("noticeList").innerHTML = r;
        });
}

// input text , 검색 버튼

let searchbtn = document.getElementById("searchbtn");
let listsear = document.getElementById("search");
searchbtn.addEventListener("click", function (e) {
    e.preventDefault();
    console.log("gd" + listsear.value);
    let searchFind = document.getElementById("searchFind").value;
    console.log(searchFind);
    console.log("btn쪽임 : " + category);
    getNoticeList(listsear.value, "", searchFind, category);
});

//  select (제목, 작성자 , 내용)
let searchFind = document.getElementById("searchFind");
searchFind.addEventListener("change", (e) => {
    console.log(searchFind.value);
});

let secretclick = document.getElementById("secretclick");
