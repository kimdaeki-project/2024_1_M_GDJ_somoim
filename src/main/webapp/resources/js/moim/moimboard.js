//REPLY
//
//댓 뜨게
let boardNum = document.getElementById("boardNum").value;
fetch("../reply/list?boardNum="+boardNum, {
	method:"GET"
}).then(r=> r.text())
  .then(r=>{
    //console.log(r);    
    document.getElementById("replyList").innerHTML=r
  })


//댓글 add
const replyAdd = document.getElementById("replyAdd");
const replyForm = document.getElementById("replyForm");

let replyList = document.getElementById("replyList");

replyAdd.addEventListener("click",()=>{
	//console.log('연결');
    let form = new FormData(replyForm);
    
    fetch("../reply/add",{
        method:"POST",
        body:form
    })

    .then(res=>res.text())
    .then(res=>{//console.log(res)
        
        replyList.innerHTML=res;
        
        //새댓추가하고 입력한 폼 값 초기화
        replyForm.reset();

    })


})

//댓 delete
replyList.addEventListener("click",function(e){
    if(e.target.classList.contains("del")){
        //console.log('연결');
        let replyNum = e.target.getAttribute("data-reply-num");
        //console.log(num);
        fetch("../reply/delete",{
            method: "post",
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body: "replyNum="+replyNum+"&boardNum="+boardNum
        })
        .then(res=>res.text())
        .then(r=>{
            //console.log(r);
            replyList.innerHTML=r;
        })
    }
});

//댓 update
replyList.addEventListener("click",(e)=>{
    if(e.target.classList.contains("up")){
        let replyNum = e.target.getAttribute("data-reply-num");
        let replyText = document.getElementById("replyText"+replyNum).value;

        if(replyText === ''){
            alert('내용을 입력하세요.');
            e.preventDefault();
            return false;
        }




        //console.log(replyText);
        //console.log(replyText.value);
        fetch("../reply/update",{
            method: "post",
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body: "replyNum="+replyNum+"&replyText="+replyText+"&boardNum="+boardNum
        })
        .then(res=>res.text())
        .then(r=>{
            //console.log(r);
            //폼내용 초기화
            //replyUpdateForm.reset();
            //modal창 닫기 버튼 강제 누름
            document.getElementById("replyCloseButton"+replyNum).click();
            

            replyList.innerHTML=r;

        })
    }
})

//답 댓 add
replyList.addEventListener("click",(e)=>{
    if(e.target.classList.contains("replyup")){
        console.log('연결');

        let replyNum = e.target.getAttribute("data-reply-num");
        let reText = document.getElementById("reText"+replyNum).value;
        
        //console.log(replyNum);
        //console.log(reText);
        if(reText === ''){
            alert('내용을 입력하세요.');
            e.preventDefault();
            return false;
        }


        fetch("../reply/reply",{
            method: "post",
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body: "replyNum="+replyNum+"&replyText="+reText+"&boardNum="+boardNum
        })
        .then(res=>res.text())
        .then(r=>{
            //console.log(r);
            //폼내용 초기화
            //replyUpdateForm.reset();
            //modal창 닫기 버튼 강제 누름
            document.getElementById("reCloseButton"+replyNum).click();

            replyList.innerHTML=r;

        })
    }
})


//댓 페이징

//getReplyList(1, update.getAttribute("data-product-num"));

replyList.addEventListener("click",(e)=>{
    //console.log(e.target.getAttribute("id"));
    if(e.target.getAttribute("id")=='more'){
        let page = more.getAttribute("data-replyList-page");//현재 페이지 번호
        let totalPage = more.getAttribute("data-replyList-totalPage");//전체 페이지 번호

        //console.log(page)
        //console.log(totalPage)

        if(page>=totalPage){
            alert('마지막 페이지 입니다');

            return false;
        }

        fetch("../reply/list?boardNum="+boardNum+"&page="+(page*1+1),{
                method: "get"
        })
        .then(res=>res.text())
        .then(r=>{
            //console.log(r);
            replyList.innerHTML=r;
            
            more.setAttribute("data-replyList-page", page*1+1);
            more.setAttribute("data-replyList-totalPage", totalPage);


        })

    }
});

    // const more = document.getElementById("more");
    // if(e.target.getAttribute("id")){
    // more.addEventListener("click", ()=>{
    //     console.log('연결');
        // let p = more.getAttribute("data-replyList-page");//현재 페이지 번호
        // let a = more.getAttribute("data-replyList-totalPage");//전체 페이지 번호

        // if(p>a){
        // 	alert('마지막 페이지 입니다');
        // }

        // fetch("../reply/list?boardNum="+boardNum+"&page="+p,{
        //     method: "get",
            
        // })
        // .then(res=>res.text())
        // .then(r=>{
        //     //console.log(r);
            
        //     //more.setAttribute("data-replyList-page", r.pager.page*1+1);
        //     //more.setAttribute("data-replyList-totalPage", r.pager.totalPage);

        //     replyList.innerHTML=r;

        // })
    //})}
//});

// getReplyList(p, update.getAttribute("data-product-num"))
// function getReplyList(page, num){
// 	fetch("../reply/list?page="+page+"&productNum="+num, {
// 		method:"GET"
// 	})
//     .then(r => r.json())
// 	.then(r => {
//         console.log('=================')
//         console.log(r)

//         
        
//         makeList(r);
//     })
//  };





//UPDATE DELETE
//
if(document.getElementById("update") != null){
    
    const update = document.getElementById("update");
    const delBtn = document.getElementById("delBtn");
    const frm = document.getElementById("frm");
    
    
    update.addEventListener("click",(e)=>{
        e.preventDefault();
        frm.submit();
    })
    
    delBtn.addEventListener("click", (e)=>{
        //console.log('연결');
        e.preventDefault();
        frm.setAttribute("action", "./delete");
        frm.setAttribute("method", "post");
        frm.submit();
    });
}
