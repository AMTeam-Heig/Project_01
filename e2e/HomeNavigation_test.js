Feature('HomePageNavigation');

Scenario('test home page', (I) => {
I.amOnPage('/')
I.see('StackOverGoat')
I.see('search')
});
