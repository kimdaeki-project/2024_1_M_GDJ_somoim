// 쿼리 파라미터 값이 결제 요청할 때 보낸 데이터와 동일한지 반드시 확인하세요.
// 클라이언트에서 결제 금액을 조작하는 행위를 방지할 수 있습니다.

const urlParams = new URLSearchParams(window.location.search);
const paymentKey = urlParams.get("paymentKey");
const orderId = urlParams.get("orderId");
const amount = urlParams.get("amount");

const orderIdElement = document.getElementsByClassName("orderId");
const amountElement = document.getElementsByClassName("amount");
const titleElement = document.getElementById("title-message");

for(let i=0;i<orderIdElement.length;i++){
  orderIdElement[i].textContent = orderId;
  amountElement[i].textContent = `${amount}원`;
}

const confirmLoadingSection = document.querySelector('.confirm-loading');
const confirmSuccessSection = document.querySelector('.confirm-success');
const confirmFailSection = document.querySelector('.confirm-Fail');

async function confirmPayment() {

  window.resizeBy(500,600);

  window.onresize = function(){
    window.resizeTo(500,600);
  };

  // TODO: API를 호출해서 서버에게 paymentKey, orderId, amount를 넘겨주세요.
  // 서버에선 해당 데이터를 가지고 승인 API를 호출하면 결제가 완료됩니다.
  // https://docs.tosspayments.com/reference#%EA%B2%B0%EC%A0%9C-%EC%8A%B9%EC%9D%B8
  const response = await fetch('./confirm', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
        paymentKey,
        orderId,
        amount,
        keyName: "toss"
      }),
  }).then((r)=>(r.json()).then((r)=>{
    return r;
  }));
  console.log(response);
  titleElement.textContent=response.message;
  if(response.result==true) {
    if(response.accountNum!=null){
      document.getElementById("account").style.display="flex";
      document.getElementById("accountName").textContent=response.accountName;
      document.getElementById("accountNum").textContent=response.accountNum;
      document.getElementById("deposit").textContent="입금할 금액";
    }
    confirmLoadingSection.style.display = 'none';
    confirmSuccessSection.style.display = 'flex';
    
    console.log(response.message);
  }else{
    confirmLoadingSection.style.display = 'none';
    confirmFailSection.style.display = 'flex';
    const message = document.getElementById("message");
    message.textContent=response.message;
  }
}

// const confirmPaymentButton = document.getElementById('confirmPaymentButton');
// confirmPaymentButton.addEventListener('click', confirmPayment);

confirmPayment();

const confirmDoneBtn = document.getElementById("confirmDoneBtn");
confirmDoneBtn.addEventListener("click",()=>{
  window.close();
});

const confirmFailBtn = document.getElementById("confirmFailBtn");
confirmDoneBtn.addEventListener("click",()=>{
	console.log("fail");
  window.close();
});

function closeWindow(){
  window.close();
}
