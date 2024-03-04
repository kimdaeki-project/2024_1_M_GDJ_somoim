const payment = document.getElementById("payment");
const agreementCheck = document.getElementById("agreementCheck");
let price = document.getElementById("priceSpan").innerText;
const exitBtn = document.getElementById("exitBtn");
const orderName = document.getElementById("orderName").innerText;
const pTypeNum = document.getElementById("pTypeNum").getAttribute("data-ptype");

price = parseInt(price.replace(/,/g,""));

let ordersDTO = {"amount":price,"pTypeNum":pTypeNum}
let clientDTO = {"keyName":"toss"}

fetch("./payment",{
  method: "POST",
  headers: {"Content-Type": "application/json"},
  body: JSON.stringify(
    {
      "ordersDTO":{
        "amount": price,
        "pTypeNum": pTypeNum
      },
      "clientDTO":{
        "keyName": "toss"
      }
    })
  }).then(r=>r.json()).then(r=>{

  const customerKey = r.orders.customerKey;
  const widgetClientKey = r.client.keyID;
  const paymentWidget = PaymentWidget(widgetClientKey, customerKey); // 회원 결제

  const paymentMethodWidget = paymentWidget.renderPaymentMethods(
    "#payment-method",
    { value: price },
    { variantKey: "DEFAULT" }
  );

  let check = paymentWidget.renderAgreement(
    "#agreement", 
    { variantKey: "AGREEMENT" }
  );


  payment.addEventListener("click", function() {
    if(!agreementCheck.checked||!check.getAgreementStatus().agreedRequiredTerms){
      alert("필수 사항에 동의하셔야 결제 가능합니다");
    }else{
      paymentWidget.requestPayment({
            orderId: r.orders.orderId,
            orderName: orderName,
            successUrl: window.location.origin+"/pay/success",
            failUrl: window.location.origin+"/pay/fail",
          });
    }
  });
});





exitBtn.addEventListener("click",function(){
  if(confirm("결제를 취소하시겠습니까?")){
    window.close();
  };
});