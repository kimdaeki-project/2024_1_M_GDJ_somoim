let moimList = document.getElementById("moimList");
moimList.addEventListener("click", function (e) {
    e.preventDefault();
    let width = 1100;
    let height = 600;
    let left = (window.innerWidth - width) / 2;
    let top = (window.innerHeight - height) / 2;
    let features = `width=${width},height=${height},left=${left},top=${top}`;

    let popupWindow = window.open("/admin/adminList", "PopupWin", features);
    popupWindow.addEventListener("load", () => {
        let content = popupWindow.document.querySelector("body");
        content.style.overflowX = "auto";
    });
    popupWindow.onresize = (_) => {
        popupWindow.resizeTo(width, height);
    };
});
