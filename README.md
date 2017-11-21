# Hangman Game
Spring MVC based Hanggame
Hanggame is buit based on the requerement of Hanman. The whole project is writen based on Spring MVC Framework

For the JSP format : I use the BootStrap model, example's from https://mdbootstrap.com/css/bootstrap-background-image/

For the hangmanpicture: I sourced from http://www.thegamegal.com/

JS: Jquery is used to get JSON data from controller, auto clean, update condition after each guess, warning for illegal actions. 

Structue configuration：web.xml -- framework,  pom maven-packages 

DB:  The fuction can be implemented use cookies, http session, SQL DB, Memcached. I use fasted Memcached in this application.

Guess Logical: All action have been defined in Game.class. Guess action executed in the playController. Exceptn for interacting with Jquery, 
I aslo designed a function to run the game with full backend, these code list in playController's annotaion part.

How to play:
Hangman has been built with Maven Plugin, I have already packaged the whole project into app.war files. But to run it on local machine. 
Tomcat or other kinds of server is necessay to build before deploy.

Step1 : 
Configure Tomcat7 on linux, here is guidance for Ubuntu: http://www.vogella.com/tutorials/ApacheTomcat/article.html

Step2: Download Hangman file from GitHub: git clone https://github.com/yuchang0417/Hanggame.git

step3: Open the Hangman file, execute command to move app.war into Tomcat7 or any server. 
Example on Ubuntu:mv app.war /var/lib/tomcat7/webapps/

step4: Open the browser with link: http://localhost:8080/app/

Enjoy. 




   
   















