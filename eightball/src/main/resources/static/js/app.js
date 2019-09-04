function clicked() {

	var input = document.getElementById('question').value;

	if (question == '') {
		alert('Please enter a question');
		return false;
	}

	window.localStorage.setItem('question', input);
	location.reload();
}

function insert(){
	var input = window.localStorage.getItem('question');
	ocument.getElementById('question').value = input;
}
