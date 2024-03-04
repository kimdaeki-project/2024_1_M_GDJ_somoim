//console.log('연결');

//회원목록



//가입
//정원초과시 가입 불가
const joinBtn = document.getElementById('joinBtn');

//console.log(moimct);
//console.log(memct);

joinBtn.addEventListener("click",()=>{

    let result = confirm("가입하시겠습니까?");
        if(result){

            let moimct = joinBtn.getAttribute('data-moim-count');
            let memct = joinBtn.getAttribute('data-mem-count');
            let moimNum = joinBtn.getAttribute('data-moim-num');
        
            //console.log('연결'); moimct
            if(moimct == memct){
                alert ('정원이 초과되었습니다.')
                //e.defaultPrevented();
                return false;
            }
        
            joinBtn.setAttribute("href","./home/join?moimNum="+moimNum)
        }else {
            // alert("취소되었습니다.");
        }


    

})

//퇴출
const listBody = document.getElementById("listBody");

listBody.addEventListener("click",function(e){
	//console.log('연결1');
    if(e.target.classList.contains("kick")){
        //console.log('연결');

        let result = confirm("퇴출하시겠습니까?");
        if(result){
            let moimNum = e.target.getAttribute("data-moim-num");
            let userName = e.target.getAttribute("data-user-name");

            fetch("./home/kick",{
                method: "post",
                headers:{
                    "Content-type":"application/x-www-form-urlencoded"
                },
                body: "moimNum="+moimNum+"&userName="+userName
            })
            .then(res=>res.text())
            .then(r=>{
                alert("퇴출 완료!");
                
                location.reload();
            })

        } else {
            // alert("취소되었습니다.");
        }




    }
});






