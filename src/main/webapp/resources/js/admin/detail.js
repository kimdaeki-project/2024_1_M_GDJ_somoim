const del = document.getElementById("delete");
const frm = document.querySelector(".frm");

const updateButtons = document.querySelectorAll(".updateLink");
updateButtons.forEach((button) => {
    button.addEventListener("click", (e) => {
        e.preventDefault();
        const placeNum = button.getAttribute("data-place-num");
        console.log("update 버튼이 클릭되었습니다. 장소 번호:", placeNum);

        // form 생성
        const form = document.createElement("form");
        form.setAttribute("class", "frm updateForm");
        form.setAttribute("action", "./update");
        form.setAttribute("method", "get");
        // input 생성
        const input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "placeNum");
        input.setAttribute("value", placeNum);

        form.appendChild(input);

        document.body.appendChild(form); // 현재 페이지에 폼 추가
        form.submit(); // 폼 제출
    });
});

// 삭제 버튼 클릭 이벤트 처리
const deleteButtons = document.querySelectorAll(".del");
deleteButtons.forEach((button) => {
    button.addEventListener("click", (e) => {
        e.preventDefault();
        const placeNum = button.getAttribute("data-place-num");
        // 삭제를 위한 폼 생성
        const form = document.createElement("form");
        form.setAttribute("class", "frm deleteForm");
        form.setAttribute("action", "./delete");
        form.setAttribute("method", "post"); // 예시로 POST 메서드 사용

        // 삭제를 식별하기 위해 placeNum 값을 전송
        const input = document.createElement("input");
        input.setAttribute("type", "hidden");
        input.setAttribute("name", "placeNum");
        input.setAttribute("value", placeNum);

        form.appendChild(input);

        document.body.appendChild(form); // 현재 페이지에 폼 추가
        form.submit(); // 폼 제출
    });
});
