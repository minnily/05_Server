//console.log("signup.js loaded.");

//유효성 검사 객체
const checkObj= {
    "id" : false, //아이디
    "pw" : false, //비밀번호
    "pw2" : false, // 비밀번호 확인
    "nickName" : false, // 닉네임
};

// 아이디 유효성 검사
const id = document.getElementById("id");

// keyup (누를때 마다 유효성 검사) change(그 공간을 벗어나고 나서 유효성검사)
id.addEventListener("keyup",function(){

    const regExp = /^[a-z][\w!@#$%^&*_-]{5,13}$/;
    // 소문자 시작(1글자) + 나머지(5~13글자) =6~14글자

    if(regExp.test(this.value)){
        this.style.backgroundColor = "green";
        this.style.color ="white";
        checkObj.id = true;
    }else {
        this.style.backgroundColor = "red";
        this.style.color ="white";
        checkObj.id = false;
    }
});

const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");

pw2.addEventListener("keyup",function() {
    if(pw.value.length == 0){
        this.value = "";
        alert("비밀번호를 먼저 입력해주세요")
        pw.focus();
        checkObj.pw = false;
    }
});

const pwMessage = document.getElementById("pwMessage")
pw.addEventListener("keyup", function (){
    if((pw.value == pw2.value) && pw.value.lenghth !=0) {
        pwMessage.innerText ="비밀번호 일치";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.pw =true;
        checkObj.pw2 =true;
    }else{
        pwMessage.innerText ="비밀번호 불일치";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        checkObj.pw2 =false; 
    }

})

pw2.addEventListener("keyup", function (){
    if((pw.value == pw2.value) && pw.value.length !=0) {
        pwMessage.innerText ="비밀번호 일치";
        pwMessage.classList.add("confirm");
        pwMessage.classList.remove("error");
        checkObj.pw =true;
        checkObj.pw2 =true;
    }else{
        pwMessage.innerText ="비밀번호 불일치";
        pwMessage.classList.add("error");
        pwMessage.classList.remove("confirm");
        checkObj.pw2 =false; 
    }

})

// 닉네임 유효성 검사
// 2~5글자 한글만
const nickName = document.getElementById("nickName");

nickName.addEventListener("change", function(){
    const regExp = /^[가-힣]{2,5}$/;

    const nameMessage = document.getElementById("nameMessage");

    if(regExp.test(this.value)){
        nameMessage.innerText ="정상입력";
        nameMessage.classList.add("confirm");
        nameMessage.classList.remove("error");
        checkObj.nickName = true;    
    }else {
        nameMessage.innerText ="2글자에서 5글자 사이 한글만 입력하세요";
        nameMessage.classList.add("error");
        nameMessage.classList.remove("confirm");
        checkObj.nickName = false; 
    }   

});

// 최종적으로 유효성 검사 객체인 checkObj안에 있는 모든 value가 
// true 인지 확인해주는 함수
// 만약 모두 true다 -> 서버로 submit
// 만약 하나라도 false다 -> 유효성검사가 완료되지 않았습니다.
function validate(){

    for(let key in checkObj){
        if( !checkObj[key] ){
            alert("유효성검사가 완료되지 않았습니다.");
            return false;
        }
    }
    return true;
}