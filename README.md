# Overview of the framework

This Framework uses Maven Build Automation Tool And Maven Project Setup For Selenium. Eclipse which is a  integrated development environment (IDE) has been used for developing applications and java is used as a programming language.The Automation framework is a Page Object Model (POM) which is a design pattern,  that creates Object Repository for web UI elements.  For each web page in the application, there is a corresponding Page Class. This Page class will identify the WebElements of that web page and also contains Page methods which perform operations on those WebElements.The framework implements The TestNG framework for generating reports and is integrated with Jenkins tool.
The Framework can be run in Chrome and Edge browsers

Package for Page Object Classes are saved under 
src\internal\pageobjects

Correspondingly, we are saving the test cases under a different package(Called test here)
src\test\features

Tested with:

JDK 10
Maven 3.6
Windows 10



<br/>

# Data Dependency

Need to feed the Month/Date before running the end to end test for booking rooms.


# Execution steps

##Pre-requisites

Java 11 or Java 17
Github Plugins in Jenkins


###  Setup Job to Run Automated Test with Jenkins tool(CI/CD)
  Ran the Jenkins dashboard by downloading .war file from jenkins and running on  http://localhost:8080/
  CMD Commands given to run .war file to run Jenkins on local host
  java -jar jenkins .war -httpPort=8080
  
After login/registering 
  
1.Clicked on New Item in the Jenkins dashboard

2.Next entered the Job name, Selected Job type as Freestyle project, and clicked on OK button

3.Specified the git repo URL by selecting the Git radio button under the Source Code Management section           
https://github.com/Aakanksha1411/com.org.restfulbooker.git

4.Added Branches to build - */main

5.Added Build Command under Build Steps and since the project used for this is of type Maven, hence selecting the Invoke top- level Maven targets option.

6.Added index.html for reporting under Index page[s] of Reports section

7.Selected the Maven version and entered the Maven command under Goals;
 in this case, it will be – test -PRegression -D Browser= chrome or edge 
 
8.Executed the job, Clicked on Build Now, which  triggered a new build 

9.Once the build is completed, viewed the console output or the HTML report (index.html) by clicking on the Build number



<br/>

## Run on command prompt through mvn command


### Prerequisite

Install Latest Maven and set the path in your system variables


1.opened cmd and went to the location where folder is saved

2.Ran the test by giving command-
mvn clean install test -PRegression DBrowser = chrome

mvn clean install test -PRegression DBrowser = edge

<br/>

 

## Prerequisites

Installed TestNg plugin via eclipseIDE workplace

### Run via EclipseIDE

Ran the test by going to testng.xml placed under path test/TestSuite/testng.xml

The test reports are  generated under test/reports/index



# Open issues/To be Discussed


-Selection of off range dates in the current month
-If Phone number takes characters and not numbers


Test Plan is attached in the folder Test Plan
Test Report for previous run is attached with in GITHub under Reports folder
- 
