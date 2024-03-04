// Add
let addform = document.getElementById("addform");
let addBtn = document.getElementById("fileAdd");

addBtn.addEventListener("click", function (event) {
    console.log("click");
    let title = document.getElementById("title");
    if (title.value == "") {
        alert("제목이 입력되지 않았습니다.");
        event.preventDefault();
        return;
    }
    let address = document.getElementById("address");
    if (address.value == "") {
        alert("내용이 입력되지 않았습니다.");
        event.preventDefault();
        return;
    }
    let link = document.getElementById("Link");
    if (link.value == "") {
        alert("URL이 입력되지 않았습니다.");
        event.preventDefault();
        return;
    }
    addform.submit();
});

let result = addBtn.getAttribute("data-result");
if (result == 1) {
    alert("등록되었습니다.");
    self.close();
}
