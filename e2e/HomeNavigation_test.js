Feature('HomePageNavigation');

Scenario('test home page Navigation', (I) => {
    I.click('Home');
    I.amOnPage('/')
    //we can stop here but to make sure
    I.see('StackOverGoat')
    I.see('search')
    //saving the result
    I.saveScreenshot("homePage.jpg")
 
});
