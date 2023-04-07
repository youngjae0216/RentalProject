function checkValues(htmlForm){
	let url = "rental?";
	
	const name = document.getElementById("name").value;
	
	let check = true;

	if(name !== "")
		url += "&name=" + name;
	
	if(name === "") {
		alert('차종이 선택되지 않았습니다.');
		check = false;
	}
	
	if(check === true) {
		htmlForm.submit();			
	}
	else{
		location.href=url;
	}
	
	
	
}