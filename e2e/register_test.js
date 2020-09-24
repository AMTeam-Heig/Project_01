Feature('register');

Scenario('test register process', (I) => {
    //the register and the sign in are in the same page 
    I .amOnPage('/login.html');
    I.fillField("First name","Gandalf");
    I.fillField("Last name","the gray");
    I.fillField("Email address","walid.messaoudi10@gmail.com");
    I.checkOption("male");
    I.click('Sign up');
    I.saveScreenshot("registerPage.jpg")
    I.see('welcome')

});
