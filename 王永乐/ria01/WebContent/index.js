function show() {
	for (var i = 0; i < 6; i++) {
		for (var j = 0; j < 6-i; j++) {
			document.write("*");
		}
		document.write("<br/>");
	}
}
function show1() {
	for (var i = 1; i < 10; i++) {
		for (var j = 1; j <= i; j++) {
			document.write(j+"*"+i+"="+(i*j)+"\t\t");
		}
		document.write("<br/>");
	}
}