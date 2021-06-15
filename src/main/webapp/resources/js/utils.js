// 자바스크립트의 정규식에서는 양 끝에 /를 넣어줘야함
function emailChk (email){
    const regex = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])/;
    return regex.test($.trim(email));
}

function phoneNumChk (phoneNum){
    const regex = /\d{2,3}[- .]\d{3,4}[- .]\d{4}/;
    return regex.test($.trim(phoneNum));
}

// 최소 8 자, 대문자 하나 이상, 소문자 하나, 숫자 하나 및 특수 문자 하나 이상
function pwdChk (pwd){
    const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}/;
    return regex.test($.trim(pwd));
}

function nameChk (name){
    const regex = /^[가-힣a-zA-Z]+$/;
    return regex.test($.trim(name));
}

function reset(obj){
	$(obj).val("");
	return $(obj);
}

function focus(obj){
	$(obj).focus();
	return $(obj);
}

