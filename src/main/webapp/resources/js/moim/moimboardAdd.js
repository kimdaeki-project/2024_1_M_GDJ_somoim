//summernote
$('#boardText').summernote({
  placeholder: '내용을 입력하세요.',
  tabsize: 2,
  height: 250,
  toolbar: [
    ['style', ['style']],
    ['font', ['bold', 'underline', 'clear']],
    ['color', ['color']],
    ['para', ['ul', 'ol', 'paragraph']],
    ['table', ['table']],
    ['insert', ['link', 'picture', 'video']],
    ['view', ['fullscreen', 'codeview', 'help']]
  ]
});

//게시판 글 공백시
const submit = document.getElementById("submit");
let boardTitle = document.getElementById("boardTitle");
let boardText = document.getElementById("boardText");

document.addEventListener("DOMContentLoaded", function(){
  submit.addEventListener("click",(e)=>{
    console.log('연결')
    if(boardTitle.value === ''){
      alert('제목을 입력하세요.');
      e.preventDefault();
      //return false;
    }else if(boardText.value === ''){
      alert('내용을 입력하세요.');
      e.preventDefault();
      return false;
    }

    return true;
  })


  // $('#submit').click(function() {
  //   var value = document.getElementById('name').value;
  //   if (value === '') {
  //       alert('Enter your name');
  //   }
  // })
});
