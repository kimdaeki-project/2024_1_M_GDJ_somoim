
let echeck = false;

$("#checkId").click(function(){
    fetch("./findCheck?userName="+$("#userName").val()+"&email="+$("#email").val(),{
        method:"GET",
    })
    .then(response=>response.text())
    .then(response=>{response.trim()
        console.log(response)
        if(response == 1){
                var email = $('#email').val();                   	 
                    alert("인증번호가 전송되었습니다");
                $.ajax({
                    type : "POST",
                    url : "emailAuth",
                    data : {email : email},
                    success : function(edata){
                        console.log("data"+edata);
                        email_auth_cd=edata;
                    },
                    error: function(edata){
                        alert("메일 발송 실패");
                    }
                });            
            
            
            
        }else{
            alert("아이디,이메일을 확인하세요");            
        }
    })
});

$("#key_check").click(function(){
    if($("#email_auth_key").val()==email_auth_cd){
        $("#auth_check").show();
        $("#findpwd").show();
        $("#chg_pwd").show();
        echeck = true;
    }else{
        alert("인증번호를 확인해주세요");
        console.log(email_auth_cd);
        console.log(typeof email_auth_cd);
        $("#auth_check").hide();
        $("#findpwd").hide();
        $("#chg_pwd").hide();
        echeck = false;
    }
});

$("#chg_pwd").click(function(e){
    
    
 

    function strongPassword (str) {
        return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(str);
      }

    if($("#password").val()===$("#passwordCheck").val()){
        if(strongPassword($("#password").val())){
            e.preventDefault();
            const formdata = new FormData();
            formdata.append("userName",$("#userName").val());
            formdata.append("email",$("#email").val());
            formdata.append("password",$("#password").val());
        
            fetch("/member/findPw",{
                method:"POST",
                body:formdata,
                }).then(r=>{
                    if(r.status==200){
                        alert("비밀번호가 변경되었습니다");
                        location.href="login";
                    }else{
                        alert("서버오류 잠시후 다시 시도해주세요");
                        location.href="findPw";
                    }
                  
                })
        }else{
            alert("비밀번호는 8글자 이상,영문,숫자,특수문자가 들어가야합니다");
        }
    }else{
        alert("변경할 비밀번호를 확인해주세요");
    }
})