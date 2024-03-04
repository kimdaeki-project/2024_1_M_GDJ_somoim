console.log("잘들어옴?");
$("#appDel").click(function(){
    $("#letModal").click();
})

$("#realDel").click(function(e){
    e.preventDefault();
    $("#frm")[0].submit();
})