// 카테고리 처리
function placeList() {
    fetch("admin/placeList", {
        method: "GET",
    })
        .then((r) => r.text())
        .then((r) => {
            document.getElementById("placeList").innerHTML = r;
        });
}
placeList();
