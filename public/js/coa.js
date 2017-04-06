function checkPassword(str) {
	// http://www.the-art-of-web.com/javascript/validate-password/
	// at least one number, one lowercase and one uppercase letter
	// at least six characters that are letters, numbers or the underscore
	// Password must contain at least 6 characters, including UPPER/lowercase and numbers
	var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$/;
	return re.test(str);
}

function checkForm(form) {
	// <form method="POST" action="..." onsubmit="return checkForm(this);">
	if (form.username.value == "") {
		alert("Error: Username cannot be blank!");
		form.username.focus();
		return false;
	}
	re = /^\w+$/;
	if (!re.test(form.username.value)) {
		alert("Error: Username must contain only letters, numbers and underscores!");
		form.username.focus();
		return false;
	}
	if (form.pwd1.value != "" && form.pwd1.value == form.pwd2.value) {
		if (!checkPassword(form.pwd1.value)) {
			alert("The password you have entered is not valid!");
			form.pwd1.focus();
			return false;
		}
	} else {
		alert("Error: Please check that you've entered and confirmed your password!");
		form.pwd1.focus();
		return false;
	}
	return true;
}