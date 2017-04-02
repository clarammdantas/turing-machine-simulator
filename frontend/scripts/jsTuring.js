// Turing Machine Simulator Page Functionalities
// Author: Clara Moraes Dantas

var numberBox = document.getElementById('numbers'),
	textBox = document.getElementById('source'),
	inputField = document.getElementById('inputArea'),
	textAreaLines = -1;

function textAreaChanged()
{
	var newLines = (textBox.value.match(/\n/g) ? textBox.value.match(/\n/g).length : 0) + 1;

	if (newLines != textAreaLines) {
		textAreaLines = newLines;
		addLine();
	}
}

function addLine()
{
	var textBoxValue = textBox.value;
	textBox.value.replace( /\r/g, "");

	var lines = textBox.value.split("\n").length;

	var n = 1, holder = '';

	for (n = 1; n <= lines; n++) {
		holder += '<div class="row">' + n + '.</div>';
	}

	if (lines === 0) {
		holder = '<div class="row">1.</div>';
	}

	numberBox.innerHTML = holder;
	updateScroll();
}

function updateScroll()
{
	var backgroundDiv = document.getElementById('rows');
	backgroundDiv.value.css({'margin-top': (-1*$(textBox).value.scrollTop()) + "px"});
}

function clearInputField()
{
	var holder = '<input id="inputArea" type="text" name="palavra" value="maria" onclick="clearInputField()">';
	inputField.innerHTML = holder;
}
