


function play (){
	
	var inputLetter = $("#letterInput").val();
	if (inputLetter.length == 0 ) {
        window.alert("please do not enter empty factor");
        return;
    }
	$.ajax({
		 url : "/app/guess",
		 type : "GET",
		 dataType : "JSON",
		 data : {"letterInput":inputLetter}, 
		 success : function (data) {
		  console.log(data);
		  
		  
		  if(Number(data.state)==1) {
			  alert('You have already win the game, Enter any character to restart');
		  } else if(Number(data.state) == -1) {
			  alert("Sorry, you have lose the game. Enter any character to restart");
		  }
		 
		  var caption = 'You have {10} tries. Guess still left {'+data.remain+'} letter word:';
		  var rate = 'Now totally {'+data.sucess+'} success, and totally {'+data.fail+'} fail';
		  $("#rate").text(rate); 
		  $("#caption").text(caption);
		  $("#currentGuess").text(data.CurrentString);
		  $("#letterInput").val('');
		  var imgNumber = 10 - Number(data.remain);
		  var imgSrc ='resources/img/'+imgNumber+'.png';
		  $("#hangmanImage").attr('src',imgSrc);
		  
		 },
		 error:function(err){
			 console.log(err)
		 }
		})

	
}

function showGame(){
	$("#gamePanel").show();
}


