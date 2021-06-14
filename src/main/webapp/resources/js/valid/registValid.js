// 해당 소스 참고해서, 항목별 서버 valid 체크하는 로직 추가하여, 해당 모듈을 JSP에서 선언해서 사용할 수 있도록 구성
var registValid = (function (){
	// 1. Email 체크
	//  정규식 체크 후, 통과하면 서버에서 중복검사
	function emailValidChk(email){
		email = $.trim(email);
		if(emailChk(email)){
			fn_comAjax({'email': email}, 'emailDplChk',
				function(data){
					if(data > 0){
						alert("중복된 이메일 입니다.");
						focus(reset($("#cmEmail")));
						return false;	
					}
				},
				function(){
					alert("이메일을 다시 입력 해 주세요.");
					focus(reset($("#cmEmail")));
					return false;
				}
			);			
		}
	}
	
	// 2. Password 체크
	// 8자리 이상 혼합 체크
	function pwdValidChk(pwd){
		pwd = $.trim(pwd);
		if(!pwdChk(pwd)){
			alert("비밀번호를 다시 입력 해 주세요.");
			focus(reset($("#cmPwd")));
			return false;
		}
	}
	
	// 3. 이름 체크
	// 영문, 한글 체크
	function nameValidChk(name){
		name = $.trim(name);
		if(!nameChk(name)){
			alert("이름을 다시 입력 해 주세요.");
			focus(reset($("#cmName")));
			return false;
		}
	}
	
	// 4. 닉네임 체크
	// 서버에서 중복검사
	function nickValidChk(nickName){
		nickName = $.trim(nickName);
		fn_comAjax({'nickName': nickName}, 'nickNameDplChk',
			function(data){
				if(data > 0){
					alert("중복된 닉네임 입니다.");
					focus(reset($("#cmNick")));
					return false;	
				}
			},
			function(){
				alert("닉네임을 다시 입력 해 주세요.");
				focus(reset($("#cmNick")));
				return false;
			}
		);	
	}
	
	// 5. 전화번호 체크
	// 숫자 체크
	function phoneNumValidChk(phoneNum){
		phoneNum = $.trim(phoneNum);
		if(!phoneNumChk(phoneNum)){
			alert("전화번호를 다시 입력 해 주세요.");
			focus(reset($("#cmName")));
			return false;
		}
	}
	
	// 6. 개인정보 수집 체크
	// 체크박스 여부 체크
		function pcCheckValidChk(obj){
		phoneNum = $.trim(phoneNum);
		if(!$(obj).prop("checked")){
			alert("개인정보 수집 여부 동의가 필요합니다.");
			return false;
		}
	}
	
	return {
		emailValidChk : emailValidChk,
		pwdValidChk : pwdValidChk,
		nameValidChk : nameValidChk,
		nickValidChk : nickValidChk,
		phoneNumValidChk : phoneNumValidChk,
		pcCheckValidChk : pcCheckValidChk
	};
})();