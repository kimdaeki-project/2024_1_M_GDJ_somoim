console.log("탈퇴")


$("#accountDel").on('click',function(){   
    
    const formdata = new FormData();
    formdata.append("userName",$("#userName").val());
    formdata.append("password",$("#password").val());

    fetch("checkId",{
        method:"POST",
        body:formdata,
    })
    .then(r=>r.text())
    .then(r=>{r.trim()
        console.log(r);
        if(r==1){            
            $("#letModal").click();
        }else{
            alert("비밀번호를 확인해주세요");
            
        }
    })
    .catch(error=>{
        console.error("Error",error);
    });
})

$("#realDel").click(function(e){
    e.preventDefault();
    $("#frm")[0].submit();
})