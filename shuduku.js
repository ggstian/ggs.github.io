function StringBuffer (str) {
	this.strings = new Array;
	if (null != str) {
		this.strings.push(str);
	}
}
StringBuffer.prototype.append = function(str) {
	this.strings.push(str);
	return this;
};
StringBuffer.prototype.toString = function() {
	return this.strings.join("");
};
StringBuffer.prototype.clear = function() {
	this.strings.length = 0;
};
function Square(x,y,s,v) {
	
}
function SquareGroup(squares) {

}
function Sudoku(matrix) {

}
Sudoku.prototype._prepareGame = function(contentId) {
	var sbd = new StringBuffer();
	//sbd.append("aefwefrewafwefwefew");
sbd.append('<div class="sudoku_panel">');
sbd.append('	<button type="button">Start</button>');
sbd.append('	<button type="button">Submit</button>');
sbd.append('	<button type="button">Stop</button>');
sbd.append('</div>');
sbd.append('<hr/>');
sbd.append('<div class="sudoku_info"></div>');
sbd.append('<div style="clear:both;"></div>');
sbd.append('<ul class="sudoku_matrix">');
for (var i = 0; i < 9; i++) {
	sbd.append("<li>");
	sbd.append("<ul class='sudoku_row'>");
	for (var i = 0; i < 9; i++) {
		sbd.append("<li>""</li>");
	};
	sbd.append("</li>");
	sbd.append("</ul>");
};
sbd.append('</ul>');
sbd.append('<div style="clear:both;"></div>');
sbd.append('<hr/>');
sbd.append('<ul class="sudoku_numbers">');
for (var i = 0; i < 9; i++) {
	sbd.append("<li>"+(i+1)+"</li>");
};
sbd.append('</ul>');

	return sbd.toString();
};
Sudoku.prototype.start = function() {

};
Sudoku.start = function(... ids) {
	var html = new Sudoku()._prepareGame();
	document.getElementById('sudoku1').innerHTML = html;
};
Sudoku.main = function(... ids) {
	var games = [
	    // game 1
	    [[0, 0, 0, 3, 9, 1, 0, 8, 0],
	     [9, 3, 1, 7, 8, 6, 4, 5, 2],
	     [0, 6, 8, 2, 4, 0, 0, 3, 1],
	     [8, 0, 7, 0, 3, 9, 5, 0, 0],
	     [3, 0, 5, 0, 0, 7, 1, 0, 0],
	     [6, 0, 9, 8, 0, 2, 3, 7, 4],
	     [0, 0, 0, 9, 2, 0, 0, 1, 3],
	     [1, 9, 2, 6, 7, 0, 0, 4, 5],
	     [4, 7, 0, 5, 0, 0, 2, 6, 0]],

	    // game 2
	    [[8, 0, 0, 0, 0, 0, 0, 0, 0],  
	     [0, 0, 3, 6, 0, 0, 0, 0, 0],  
	     [0, 7, 0, 0, 9, 0, 2, 0, 0],  
	     [0, 5, 0, 0, 0, 7, 0, 0, 0],  
	     [0, 0, 0, 0, 4, 5, 7, 0, 0],  
	     [0, 0, 0, 1, 0, 0, 0, 3, 0],  
	     [0, 0, 1, 0, 0, 0, 0, 6, 8],  
	     [0, 0, 8, 5, 0, 0, 0, 1, 0],  
	     [0, 9, 0, 0, 0, 0, 4, 0, 0]]
	  ];

	for (var i = 0; i < ids.length; i++) {
		if (i < games.length) {
			Sudoku.start();
		}
	}


};