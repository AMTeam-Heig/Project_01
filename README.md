
##  User interface specification

This document introduce a brief description of different front end pages .Each description below contain a several markdown of informations and commands that should be displyed over the user end interface .The reason behind this first step description is to make a reference for our CodeceptJS tests .

The project cover about five pages of view (display answers,display results  ) and interaction (Authentification,filling out forms...).

### Home page :
This is the main page of our application .the front end development allow the user to use many future like research ,navigation to the profile page  and ask a question option .
by performing a specific action .
informations :
 top asked question.
 research bar .
 profile icon (or anno)
 notification icon
commands :
 research.
 ask question (fill).
 login/sign up
(not finished)
### The Login and registration page  :
informations :
pseudo .
email.
password
commands :
login
register

### The user profile page :
informations :
name 
pseudo
picture 
command :
logout
### Question page :
informations :
title (fill) 
body  (fill)
commands :
submit
### Results :
informations:
numbers of results 
tri
number of vote (+)

commands 
next page (navigation)
click question (navigation)

![ main description ](mainArch.PNG)

### Paths :
Project_01
    Docker
        images
            flow
                test.md
            glassfish
                drivers
                    mysql-connector-java-5.1.39-bin.jar
                Dockerfile
            payara
                artifact
                    Project_01.war
                drivers
                    mysql-connector-java-5.1.39-bin.jar
                Dockerfile
        topologies
            test
                docker-compose.yml
            docker-compose.yml
    e2e
        output
            test_home_page.failed.png
        ask_Question_test.js
        codecept.conf.js
        commands.txt
        HomeNavigation_test.js
        homepagetest.png
        jsconfig.json
        loginProcess_test.js
        mainArch.PNG
        navigation_test.js
        register_test.js
        search_test.js
        steps_file.js
    src
        main
            java
                ch.heigvd.amt.stackovergoat
                    model
                        Answer
                        Question
                    services
                        JsonManager
                        QuestionManager
                    web
                        HomeServlet
                        LoginServlet
                        RegisterServlet
            webapp
                assets
                    css
                        bootstrap.css
                        bootstrap-grid.css
                        bootstrap-reboot.css
                style
                    css
                        bootstrap.min.css
                        style.css
                    img
                        background.jpg
                    app.css
                    index.css
                    list-user.css
                    login.css
                WEB-INF
                    pages
                        home.jsp
                        login.jsp
                        register.jsp
                    web.xml