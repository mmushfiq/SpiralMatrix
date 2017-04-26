
//Jquery function
(function ($) {

    $("#run-spiral").click(function () {
        $('#matrix > tbody > tr > td').css('background-color', 'transparent');
        var row = $("input[name=row]").val();
        var column = $("input[name=column]").val();
        var myRadio = $('input[name=clockwise]');
        var clockwise = myRadio.filter(':checked').val();

//        var getUrl = window.location;
//        var baseUrl = getUrl.protocol + "//" + getUrl.host + "/" + getUrl.pathname.split('/')[1];
//        var url = baseUrl+"/spiral/elements?row=" + row + "&column=" + column + "&clockwise=" + clockwise;
        
        var url = "/SpiralMatrixSpringMVC/spiral/elements?row=" + row + "&column=" + column + "&clockwise=" + clockwise;


        var r = 255, b = 255, g = 255;
        var bgColors = [];
        for (var i = 0; i < 25; i++, b -= 15, g -= 15) {
            if (i < 18) {
                bgColors[i] = "rgb(255, " + b + ", " + g + ")";
            } else {
                r -= 15;
                bgColors[i] = "rgb(" + r + ", 0, 0)";
            }
            console.log('bgColors[' + i + ']=' + bgColors[i]);
        }
        for (var i = 25; i < 500; i++) {
            bgColors[i] = "rgb(150, 0, 0)";
        }
        
        var colors = [];
        for (var i = 0; i < 500; i++) {
            if(i<25) colors[i] = "blue";
            else colors[i] = "white";
        }

        $.get(url, function (data, status) {
            for (var x = 0, ln = data.length; x < ln; x++) {
                setTimeout(function (y) {
//                    console.log("%d => %d", y, $("#matrix.table tr:eq(" + data[y].row + ") td:eq(" + data[y].column + ")").css("background-color", bgColors[y]));
                    console.log("%d => %d", y, $("#matrix.table tr:eq(" + data[y].row + ") td:eq(" + data[y].column + ")").css({"background-color": bgColors[y],"color": colors[y]}));
                }, x * 300, x); // we're passing x
            }
        });
        
    });

})(jQuery);

