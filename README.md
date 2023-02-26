# Overview of the framework

This Framework uses Maven Build Automation Tool And Maven Project Setup For Selenium. Eclipse which is a  integrated development environment (IDE) has been used for developing applications and java is used as a programming language.The Automation framework is a Page Object Model (POM) which is a design pattern,  that creates Object Repository for web UI elements.  For each web page in the application, there is a corresponding Page Class. This Page class will identify the WebElements of that web page and also contains Page methods which perform operations on those WebElements.Package for Page Object Classes are saved under 
C:\Users\aayan\final\restfulbooker\src\Aakanksha\pageobjects

Correspondingly, we are saving the test cases under a different package(Called test here)
C:\Users\aayan\final\restfulbooker\src\test

The framework implements The TestNG framework for generating reports and is integrated with Jenkins tool.

<br/>


### Pre-requisites

Java 11 or Java 17

# Execution steps


##   Setup Job to Run Automated Test with Jenkins



1.	Click on New Item in the Jenkins dashboard
2.	Next enter the Job name, Select Job type as Freestyle project, and click on OK button
3.	specify the git repo URL by selecting the Git radio button under the Source Code Management section           
4.	https://github.com/Aakanksha1411/com.org.restfulbooker.test.git
5.	Add Build Command and since the project used for this is of type Maven, hence selecting the Invoke top-level Maven targets option.
6.	Select the Maven version and enter the Maven command under Goals; in this case, it will be – test -PRegression
7.	To execute the job Click on Build Now, which will trigger a new build 
8.	Once the build is completed, you can see the console output or the HTML report (index.html) by clicking on the Build number






### Commands

<br/>

## Run on local 

### Pre-requisites


### Commands


<br/>

## Run via IDE 

### Pre-requisites

### Commands 



# Open issues

- ClicknHold on calendar not working as expected.. 


# Challenges faced 

- 
- 
- 