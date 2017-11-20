<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="resources/js/myhand.js"></script>

<link rel="stylesheet" href="resources/css/bootstrap.css" />
<link rel="stylesheet" href="resources/css/main.css" />


</head>
<body class='background'>

	<div class=row>

		<div class='col-md-6'>
			<section class="jumbotron">
			<h1>Welcome to our HangGame!</h1>
			<p>
				This is very a game for Guess, you will have ten times to win </br> if
				you want to start, you can just click the "Start A New Game" to
				start
			</p>

			<p>
				<a id="newGameButton" class="btn btn-primary btn-lg"
					onclick='showGame()' >Start A New Game</a> <span
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
		<div>
			<small>Picture taken from http://www.thegamegal.com/ and
				modified for this app</small>
		</div>
	</div>
	</section>
		</div>

	</div>



	





</body>


</html>