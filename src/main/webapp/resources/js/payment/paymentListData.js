let paymenListData = [];

async function requestPayment(){
  await fetch("./paymentData",{
    method: "GET"
  }).then((r)=>(r.json()).then((r)=>{
    paymenListData = r;
    console.log(paymenListData);

    render(r);
  }))
}

requestPayment();

function render(data){
  let paymentList = document.getElementById("paymentList-body");

  let createTable = "";
  for(let i=0;i<data.length;i++){
    
    let formattedAmount = Number(data[i].AMOUNT).toLocaleString("ko-KR");
    let paymentDay = new Date(data[i].PAYMENTDAY);
    let formattedPaymentDay = `${paymentDay.getFullYear()}-${(paymentDay.getMonth() + 1).toString().padStart(2, "0")}-${paymentDay.getDate().toString().padStart(2, "0")} ${paymentDay.getHours().toString().padStart(2, "0")}:${paymentDay.getMinutes().toString().padStart(2, "0")}:${paymentDay.getSeconds().toString().padStart(2, "0")}`;

    createTable+=`<tr><td>${data[i].ROWNUM}</td><td>${formattedAmount}원</td><td>${data[i].PTYPENAME}</td><td>${data[i].PAYMETHOD}</td><td>${formattedPaymentDay}</td></tr>`;
  };

  console.log(createTable);

  paymentList.innerHTML = createTable;
}
