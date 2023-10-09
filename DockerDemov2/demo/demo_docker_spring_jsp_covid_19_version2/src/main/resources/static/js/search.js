function myFunction() {
	var input = document.getElementById("Search");
	var filter = input.value.toLowerCase();
	var nodes = document.getElementsByClassName('card');

	for (i = 0; i < nodes.length; i++) {
		if (nodes[i].innerText.toLowerCase().includes(filter)) {
			nodes[i].style.display = "inline-block";
		} else {
			nodes[i].style.display = "none";
		}
	}
}
