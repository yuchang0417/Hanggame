<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HangMan</title>

<script
	src="resources/js/jquery-3.2.1.min.js"></script>
<script src="resources/js/myhand.js"></script>

<link rel="stylesheet" href="resources/css/bootstrap.css" />
<link rel="stylesheet" href="resources/css/main.css" />


</head>
<body class='background'>

	<div class=row>

		<div class='col-md-6'>
			<section class="jumbotron">
			<h2>Please Read Rules Before Play</h2>
			<p>
				
- When the game is started, Plese fill word int the  empty field .</br>

- When the player guesses a letter correctly, letter will appear</br>

- When the player guesses a letter incorrectly, a piece of a gallow with a</br>
  hanging man is drawn.</br>

- After 10 incorrect guesses, the game is over and the player lost. </br>

- If all fields are filled with their letter before 10 incorrect guesses, the
  player has won the game.</br>
			</p>

			<p>
				<a id="newGameButton" class="btn btn-primary btn-lg"
					onclick='showGame()' >Let's have fun</a> <span
					id="stats"></span>
			</p>
			</section>
		</div>

		<div class='col-md-4'>
		<section id="gamePanel" class="panel hidePanel" >
	<div class="panel-body">

		<span id="caption">You have {10} tries. Guess still left {10}
			letter word:</span> <span id="rate">Now totally {0} success, and
			totally {0} fail</span>

		<div id="currentGuess">${String.valueOf(requestScope.game.getChars()) }</div>


		<div class="inputWrapper">
			<input id="letterInput" type="text"
				placeholder="Enter your letter here" /> <a id="guessButton"
				onclick='play()' class="btn btn-primary">Guess</a>
		</div>
	</div>





	<div>
		<p id="message"></p>
		<img id="hangmanImage" src="resources/img/0.png" alt="hangman image" />
		
	</div>
	</section>
		</div>

	</div>



	





</body>


</html>