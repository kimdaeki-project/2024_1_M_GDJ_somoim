let moimadd = document.getElementById("moimadd");
moimadd.addEventListener("click", function (e) {
    e.preventDefault();
    let width = 520;
    let height = 600;
    let left = (window.innerWidth - width) / 2;
    let top = (window.innerHeight - height) / 2;
    let features = `width=${width},height=${height},left=${left},top=${top},resizable=no,location=no`;

    let popupWindow = window.open("/admin/add", "PopupWin", features);
    popupWindow.resizeTo(width, height);
    popupWindow.onresize = (_) => {
        popupWindow.resizeTo(width, height);
    };
});
