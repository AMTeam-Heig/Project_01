Feature('HomePageNavigation');

Scenario('test home page Navigation', (I) => {
    I.amOnPage('/home');
    //I.click('Home'); one the navigation is ready
    //we can stop here but to make sure
    I.see('StackOverGoat');
    I.see('Search');
    //saving the result
    I.saveScreenshot("homePage.jpg");
 
});
