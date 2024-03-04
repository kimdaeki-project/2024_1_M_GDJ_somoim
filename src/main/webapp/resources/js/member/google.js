console.log("구글로그인 확인");

function handleCredentialResponse(response) {
    const responsePayload = parseJwt(response.credential);
    console.log("ID: " + responsePayload.sub);
    console.log('Full Name: ' + responsePayload.name);
    console.log("Email: " + responsePayload.email);

    const formdata = new FormData();
    formdata.append("name",responsePayload.name);
    formdata.append("userName",responsePayload.email)

    fetch("/member/submitApp",{
        method:"POST",
        body:formdata,
        })
        .then(r => r.text())
        .then(d => {
            if(d == "success"){
                location.href = "/member/joinGoo"
            }else{
                location.href = "/"
            }
        })
}

function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
};





  
//   window.onload = function () {
//     google.accounts.id.initialize({
//       client_id: "412327098082-jo918jh8s5gmuiifhgsimmn6m4cgcif6.apps.googleusercontent.com",
//       callback: handleCredentialResponse
//     });
//     google.accounts.id.renderButton(
//       document.getElementById("buttonDiv"),
//       { theme: "outline", size: "large" }  // customization attributes
//     );
//     google.accounts.id.prompt(); // also display the One Tap dialog
//   }