Feature('login');

Scenario('testing login process', (I) => {
    //check the url
    I .amOnPage('/login.html');
    //fill the user name and password field
    I.fillField("username","admin");
    I.fillField("password","admin");
    
    I.click('Sign in');
    I.see('Incorrect try again');
    I.saveScreenshot("loginPage.jpg")

});
