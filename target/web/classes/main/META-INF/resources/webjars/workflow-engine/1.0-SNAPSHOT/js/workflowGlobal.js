function wkflwDeleteUser(userkey) {
	window.location.href = '/deleteuser/' + userkey;
}

function wkflwDeleteProfile(thiskey) {
	window.location.href = '/deletecard/' + thiskey;
}

function wkflwFilterProfileView(fieldName, filterType) {
	var e = document.getElementById(fieldName);
	var fieldValue = e.options[e.selectedIndex].value;
	console.log(fieldName + " Field Value = " + fieldValue);
	window.location.href = "/wkflwfilterview?type=" + filterType + "&value=" + fieldValue;	
}

function wkflwSearchRecords() {
	var e = document.getElementById("searchText");
	var fieldValue = e.value;
	if (fieldValue != "") {
		console.log("value 1 = " + fieldValue);
		window.location.href = "/mainsearch/" + fieldValue;	
	}
}
