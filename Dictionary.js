$(document).ready(function() {
    $("#lookup").click(function(){
        var searchWord = $("#q").val();
        $.get("http://localhost:8080/online/servlet/servlet?q="+searchWord,
            function(data, status){

            var displayText = "";
                $.each(data, function(index, value) {
                    displayText +="<p>" + "<b>" + value.word +  ":  " + "</b>" + "<span style='color: #9dff9a; font-style: italic'>"+ value.wordtype.toUpperCase()+"</span>"+ ":   "+ value.definition+ "</p>"
                });
                $("#display").html(displayText);
        });
    });
});
