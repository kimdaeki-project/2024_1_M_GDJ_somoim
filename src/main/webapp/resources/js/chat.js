/**
 * 
 */
// msg input

console.log('c js');

const sendMsg = document.getElementById('sendMsg');

const chat_record = document.getElementById('chat_record');
const userCh = document.getElementById('userCh');
const userNick = document.getElementById('userNick')

const msgForm = document.getElementById('msgForm');
const chat_message = document.querySelector('.chat-message');

let sock = new SockJS("http://localhost:80/chat");
const chatRoomNum = document.getElementById('chatRoomNum');

let chatHistory = document.getElementById('chat-history');
let scrollToBottom = chatHistory.scrollHeight - chatHistory.scrollTop === chatHistory.clientHeight;

// scroll 밑에 고정
function scroller(){
    if(scrollToBottom){
        chatHistory.scrollTo(0, chatHistory.scrollHeight);
    }
}

// 엔터하면 값을 서버로 보냄
sendMsg.addEventListener('keyup',(e) => {
    if(sendMsg.value != ""){
        if(e.key == 'Enter' || e.keyCode == '13'){
            const roomCh = chatRoomNum.getAttribute('data-chatRoom');
            console.log("roomCh : "+roomCh);
            
            const chatMessage = {
                "userName" : userCh.value,
                "chatText" : sendMsg.value,
                "chatRoomNum" : roomCh,
                "nickName" : userNick.value
            };
            
            console.log(chatMessage);

            sock.send(JSON.stringify(chatMessage));

            scroller();
        	sendMsg.value = '';
        }
	}
});

sock.onopen = function(){
    console.log('연결');
}

// 메세지를 정보를 서버로
sock.onmessage =  function (e){
    console.log("onmessage");
    const week = new Array('SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT');
    let today = new Date(e.timeStamp);

    const dayName = week[today.getDay()];
    const hours = today.getHours() % 12 ? today.getHours() % 12 : 12;
    const minutes = today.getMinutes() < 10 ? '0' + today.getMinutes() : today.getMinutes();
    const ampm = today.getHours() >= 12 ? 'PM' : 'AM';
    const date = `${hours}:${minutes} ${ampm}, ${dayName}`;

    let data = e.data;
    let jsonData = JSON.parse(data);
    
    console.log(jsonData);
    
    let user = jsonData.userName;
    let roomNumber = jsonData.chatRoomNum;
    // let str = jsonData.chatText;
    let nick = jsonData.nickName;
    
    if(roomNumber === chatRoomNum.getAttribute('data-chatRoom')){
        if(user === userCh.value){
            mySend(jsonData.chatText, date);
        }else{
            otherSend(nick, jsonData.chatText, date);
        }
    }
    
    
    scroller();

    console.log("onMessage : "+data);
}

sock.onerror = function(){
    console.log('error');
}

sock.onclose = function(){
    console.log('onClose');
}

// 내 채팅

function mySend(msg ,date){
    // 채팅형태로 Element 추가
    // chat-record add
    let li = document.createElement("li");
    li.classList.add('clearfix');
    chat_record.append(li);

    let div = document.createElement("div");
    div.classList.add('message');
    div.classList.add('my-message');
    div.classList.add('float-start');
    div.innerText = msg;
    li.append(div);

    div = document.createElement("div");
    div.classList.add('message-data');
    let span = document.createElement("span");
    span.classList.add('message-data-time');
    span.classList.add('mt-4');
    span.classList.add('pt-3');
    span.innerText = date;
    div.append(span);
    
    li.append(div);

}

// 타인의 채팅
function otherSend(nick, msg, date){
    let li = document.createElement("li");
    li.classList.add('clearfix');
    
    let div = document.createElement("div");
    div.classList.add('message-data');
    div.classList.add('text-right');
    div.classList.add('my-2');

    div.innerHTML = "<h6 class='my-3'>"+nick+"</h6>";
    chat_record.append(li);
    li.append(div);
    
    div = document.createElement("div");
    div.classList.add('message');
    div.classList.add('other-message');
    div.classList.add('float-right');
    div.innerText = msg;

    li.append(div);
    let br = document.createElement("br");
    li.append(br);
    
    div = document.createElement("div");
    div.classList.add('message-data');
    div.classList.add('text-right');
    div.classList.add('pt-3');
    let span = document.createElement("span");
    span.classList.add('message-data-time');
    span.classList.add('mx-1');
    span.innerText = date;
    div.append(span);
    
    li.append(div);
}

let chatRoom = document.querySelector(".chat-list");

// 채팅방을 클릭하면 DB에서 채팅기록 가져오기
chatRoom.addEventListener('click',(e)=>{
    chat_record.innerHTML = null;
    if(e.target.classList.contains('clearfix')){
        let n = e.target.getAttribute('data-roomNum');
        
        chatRoomNum.setAttribute('data-chatRoom',n);
        chat_record.style.visibility = 'visible';
        chat_message.style.visibility = 'visible';
        
            fetch("/chat/room?chatRoomNum="+n,{
                method:"GET"
            })
            .then(r => r.json())
            .then(r => {
                console.log(r);
                for(let i=0;i<r.record.length;i++){
                 let msg = r.record[i].chatText;
                 let date = r.record[i].chatTimeStamp;
                 let nick = r.record[i].memberDTO.nickName;

                 if(r.record[i].userName === userCh.value){
                     mySend(msg,date);
                 }else{
                     otherSend(nick,msg,date);
                 }
                }

                for(let i=0;i<r.chatUser.length;i++){
                    let user = r.chatUser[i].nickName;
                    getUserList(user)
                }
                
            scroller();
        });


    }
});

let searchChat = document.getElementById('searchChat');
searchChat.addEventListener("keyup",(e)=>{
    console.log(e.target.value);
    if(e.target.value != null){
        
    }
});

// userList modal
const closeBtn = document.getElementById('closeBtn');
const userListUl = document.getElementById('userListUl');
let userList = document.getElementById('userList');
userList.addEventListener('click',()=>{
    userModal.classList.add('d-block');
    userModal.classList.remove('d-none');
});

closeBtn.addEventListener('click',()=>{
    userModal.classList.add('d-none');
    userModal.classList.remove('d-block');
    userListUl.innerHTML = '';
});

function getUserList(user){
    let li = document.createElement('li');
    li.classList.add('list');
    li.classList.add('fw-bold');
    li.classList.add('fs-5');
    li.innerText = user;
    userListUl.append(li);
}