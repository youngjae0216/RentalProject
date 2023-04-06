function checkValues(htmlForm){
	let url = "login?";
	
	const clientId = document.getElementById("clientId").value;
	const password = document.getElementById("password").value;
	
	let check = true;

	if(clientId !== "")
		url += "&clientId=" + clientId;
	if(password !== "")
		url += "&password=" + password;
	
	if(clientId === "") {
		alert('아이디가 입력되지 않았습니다.');
		check = false;
	}
	else if(password === "") {
		alert('비밀번호가 입력되지 않았습니다.');
		check = false;
	}
	else{
		htmlForm.submit();	
	}
	
	
	
}