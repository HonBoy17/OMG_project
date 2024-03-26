$(function(){
	
	$('#trigger').click(function(e){
		e.preventDefault();
		$(this).toggleClass('active');
		$('#main-menu').toggleClass('active');
	});
	
});