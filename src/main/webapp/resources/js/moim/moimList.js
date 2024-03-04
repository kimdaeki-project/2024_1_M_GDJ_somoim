
//delete
// const deleteBtn = document.getElementById("deleteBtn");
let moimName = document.getElementById("moimName");
//let moimNum = moimName.getAttribute("data-moim-num");
const listTbody = document.getElementById("listTbody");

// deleteBtn.addEventListener("click",()=>{
listTbody.addEventListener("click",function(e){
    
    if(e.target.classList.contains("del")){
    	//console.log('dus');
        //console.log(this);
        let num = e.target.parentNode.getAttribute("data-moim-num");
        //console.log(num);

        fetch("./delete",{
            method: "post",
            headers:{
                "Content-type":"application/x-www-form-urlencoded"
            },
            body: "moimNum="+num
        })
        .then(res=>res.text())
        .then(r=>{
            //console.log(r);
            listTbody.innerHTML=r;
        })
    }
})

//update

    ////수정 GET
    listTbody.addEventListener("click",function(e){
    
    
      if(e.target.classList.contains("update")){
          //console.log('연결');
          let num = e.target.parentNode.getAttribute("data-moim-num");
          let frm = document.getElementById(num);
          //console.log(num);
  
          frm.submit();
      }
  })