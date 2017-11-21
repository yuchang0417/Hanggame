# Hangman Game
Spring MVC based Hanggame

Hanggame is buit based on the requirement of Hanman. The whole project is written  on Spring MVC Framework

For the JSP format : I use the BootStrap model, example's from https://mdbootstrap.com/css/bootstrap-background-image/

For the hangman picture: I sourced from http://www.thegamegal.com/

JS: Jquery is used to get JSON data from controller, auto clean, update condition after each guess, warning for illegal actions. 

Structure configuration：web.xml -- framework,  pom maven-packages 

DB:  The function can be implemented use cookies, http session, SQL DB, Memcached. I use fasted Memcached in this application.

Guess Logical: All action have been defined in Game.class. Guess action executed in the playController. Besides iMVC +Jquery version,  
I aslo designed a function to run the game with full backend, these code list in playController's annotaion part.

How to play:
Hangman has been built with Maven Plugin, I have already packaged the whole project into app.war files. Just run it on local machine. Since .war file must be deploy on the Server, Tomcat or other kinds of server have to be built at beginning. I have already published the game on my AWS S2 server, welcome to visit http://52.11.35.207:8080/app/.

Step1 : 
Configure Tomcat7 on linux, here is guidance for Ubuntu: http://www.vogella.com/tutorials/ApacheTomcat/article.html

Step2: Download Hangman file from GitHub: git clone https://github.com/yuchang0417/Hanggame.git

step3: Open and check Hangman file, find app.war ,execute command to move app.war into Tomcat7 or any server. 

Example on Ubuntu: mv Hanggame/app.war /var/lib/tomcat7/webapps/

step4: Open the browser with link: http://localhost:8080/app/

Enjoy. 






   
   















