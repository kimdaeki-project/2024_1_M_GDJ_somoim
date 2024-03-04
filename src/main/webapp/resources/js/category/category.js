// 카테고리 처리
const navLinks = document.querySelectorAll(".moimCategory");
let category = "";
let page = "";
let region = "";
navLinks.forEach((link) => {
    link.addEventListener("click", function (event) {
        event.preventDefault();
        console.log("클릭했음");
        category = this.getAttribute("data-category"); // category 업데이트
        navLinks.forEach((navLink) => navLink.classList.remove("active"));
        this.classList.add("active");
        console.log("선택된 카테고리:", category);
        page = "";
        getcategoryList(page, category, region);
    });
});
getcategoryList("", "", ""); // 첫 페이지 호출

let re = document.querySelectorAll(".moimRegion");
re.forEach((reg) => {
    reg.addEventListener("click", function (event) {
        event.preventDefault();
        console.log("지역 모임 클릭");
        region = this.getAttribute("data-selete");
        re.forEach((re) => re.classList.remove("active"));
        this.classList.add("active");
        console.log("지역 모음 :", region);
        getcategoryList(page, category, region);
    });
});

function getcategoryList(page) {
    fetch(
        "categoryList?page=" +
            page +
            "&categorySelect=" +
            category +
            "&searchFind=" +
            region,
        {
            method: "GET",
        }
    )
        .then((r) => r.text())
        .then((r) => {
            document.getElementById("categoryList").innerHTML = r;
        });
}
//페이저 및 테이블 처리
let categoryList = document.getElementById("categoryList");
categoryList.addEventListener("click", function (e) {
    if (e.target.classList.contains("page-link")) {
        page = e.target.getAttribute("data-pageNum"); // 페이지 업데이트
        console.log(page);
        console.log("페이지, 테이블");
        getcategoryList(page, category, region); // 페이지 변수 전달
    }
});
