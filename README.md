# OwmAPI
CTK case - OpenWeatherMap API

Code is located in src\main\java\owmapi

# How to run:
This is a Maven project so first off you need Maven installed, if you don't : https://maven.apache.org/download.cgi
and https://maven.apache.org/install.html. 
After you've got Maven installed, simply clone this repo and then choose either to use IDE or a terminal.

# IDE
Import the project into your favourite IDE (I use eclipse) and through the IDE do a Maven clean install to get all the dependencies fixed.
Then either run the jar file that is located under the target folder or use the IDE to run the project as a Java Application or do Maven exec:java.

# Terminal
Locate the root folder in the terminal and then do mvn clean install. After that either run the jar file or do mvn exec:java and the application should run.
