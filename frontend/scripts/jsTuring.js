// Turing Machine Simulator Page Functionalities
// Author: Clara Moraes Dantas

var numberBox = document.getElementById('numbers'),
	textBox = document.getElementById('source');

function addLine()
{
	var textBoxValue = textBox.value;
	textBox.value.replace( /\r/g, "");
	textBox.value.split("\n");

	var lines = textBoxValue.length, n = 1, holder = '';

	for (n = 1; n <= lines; n++) {
		holder += '<div class="row">' + n + '.</div>';
	}

	if (lines === 0) {
		holder = '<div class="row">1.</div>';
	}

	numberBox.innerHTML = holder;
}
