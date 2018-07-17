$(document).ready(function() {
	
	$(".form").slideDown(500);
	var change_msg = document.getElementById("change_msg").innerHTML;

	if(change_msg.length == 87 || change_msg.length == 91){
		$("#landing-content").hide(500);
		$("#registered-content").show(500);
		$("#registered").addClass("border-btn");
	}

	else{
		$("#landing").addClass("border-btn");
	}
	
	$("#registered").click(function() {
		$("#landing").removeClass("border-btn");
		$("#landing-content").hide(500);
		$(this).addClass("border-btn");
		$("#registered-content").show(500);
	})

	$("#landing").click(function() {
		$("#registered").removeClass("border-btn");
		$(this).addClass("border-btn");

		$("#landing-content").show(500);
		$("#registered-content").hide(500);
	})
});