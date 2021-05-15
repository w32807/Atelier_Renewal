$(document).ready(function() {
    // 체크박스 전체 선택
	$("#allCheck").click(function() { //만약 전체 선택 체크박스가 체크된상태일경우 
		if ($("#allCheck").prop("checked")) { //해당화면에 전체 checkbox들을 체크해준다
			$("input[type=checkbox]").prop("checked", true);
		}
		// 전체선택 체크박스가 해제된 경우 
		else { //해당화면에 모든 checkbox들의 체크를해제시킨다. 
			$("input[type=checkbox]").prop("checked", false);
		}
	})
});

// String null Check
function isStrNull(str){
	return (!str || (str === 'null') || (str === 'undefined') || 
			(str === 'NaN') || (str === '0') || (str === 'false')) ? false : true;
}


function fn_comAjax(json, url, successCallback, errCallback){
	// dataType을 명시하지 않으면 모든 타입의 데이터를 서버로부터 가져올 수 있음
	$.ajax({
		url: url,
		type: "post",
		data: json,
		success: function(data) {
			console.log('success')
			successCallback(data);
		},
		error: function(error) {
			console.log('Error')
			errCallback();
		}
	})
}

function fn_formToJson(form){
	var formTag = $(form);
	return (formTag.prop('tagName') === 'FORM') ? formTag.serializeObject() : '';
}

/**
 * Usage: var json = $('#form-login').serializeObject();
 * Output: {username: "admin", password: "123456"}
 * Output: {username: "admin", password: "123456", subscription: ["news","offer"]}
 * */


//경로 src/main/webapp/resources/js/jquery.serializeObject.js
$.fn.serializeObject = function() {
    var obj = {};
    var arr = this.serializeArray();
    arr.forEach(function(item, index) {
        if (obj[item.name] === undefined) { // New
            obj[item.name] = item.value || '';
        } else {                            // Existing
            if (!obj[item.name].push) {
                obj[item.name] = [obj[item.name]];
            }
            obj[item.name].push(item.value || '');
        }
    });
    return obj;
};
