function checkValues(htmlForm){
	let url = "join?";
	
	const clientId = document.getElementById("clientId").value;
	const password = document.getElementById("password").value;
	const name = document.getElementById("name").value;
	
	let check = true;

	if(clientId !== "")
		url += "&clientId=" + clientId;
	if(password !== "")
		url += "&password=" + password;
	if(name !== "")
		url += "&name=" + name;
	
	if(clientId === "") {
		alert('아이디가 입력되지 않았습니다.');
		check = false;
	}
	else if(password === "") {
		alert('비밀번호가 입력되지 않았습니다.');
		check = false;
	}
	else if(name === "") {
		alert('이름이 입력되지 않았습니다.');
		check = false;
	}
	
	if(check === true) {
		htmlForm.submit();			
	}
	else{
		location.href=url;
	}
	
	
	
}