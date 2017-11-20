<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="resources/css/bootstrap.css" />

<title>Have Fun with Hang Game</title>
</head>
<body>
     <section class="jumbotron">
		<h1>Welcome to our HangGame!</h1>
		<p>This is very a game for Guess, you will have ten times to win </br>
		   if you want to start, you can just click the "Start A New Game" to start </p>
     
		<p>
			<a id="newGameButton" class="btn btn-primary btn-lg"  href="games">Start A New Game</a>
			<span id="stats"></span>
		</p>
	</section>
	
	<section id="gamePanel" class="panel panel-default hidden">
		<div class="panel-body">
			<span id="caption">You have {10} tries. Guess this {7} letter word:</span> 
			<div id="currentGuess">G__GLE</div>
			
			<div class="inputWrapper">
				<input id="letterInput" type="text" placeholder="Enter your letter here"/>
				<a id="guessButton" class="btn btn-primary">Guess</a>
			</div>
		</div>
		
		<div>
			<p id="message"></p>
			<img id="hangmanImage" src="resources/img/0.png" alt="hangman image"/>
			<div><small>Picture taken from http://www.thegamegal.com/ and modified for this app</small></div>
		</div>
		
		
	</section>
	
	
	
</body>
</html>