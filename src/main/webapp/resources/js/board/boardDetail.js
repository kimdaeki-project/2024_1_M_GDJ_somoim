const update = document.getElementById("update");
const del = document.getElementById("delete");
const frm = document.querySelector("#frm");


update.addEventListener("click", (e)=>{
    e.preventDefault();
    frm.submit();
})

del.addEventListener("click", (e)=>{
    e.preventDefault();
    frm.setAttribute("action", "./delete");
    frm.setAttribute("method", "post");
    frm.submit();
});