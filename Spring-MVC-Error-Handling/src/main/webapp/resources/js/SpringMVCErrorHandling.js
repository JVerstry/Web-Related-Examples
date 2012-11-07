
var prefix = "/spring-mvc-error-handling";

var ExceptionHandler = function() {
	
    $.ajax({
        type: 'GET',
        url:  prefix + "/throwCustomized4ExceptionHandler",
        dataType: 'json',
        async: true,
        success: function(result) {
			alert('Unexpected success !!!');
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + " " + jqXHR.responseText);
        }
    });
    
}
