Feature('register');

Scenario('test register process', (I) => {
    //the register and the sign in are in the same page 
    I .amOnPage('/login');
    I.click('Cliquez ici');
   // I.fillField("First name","Gandalf");
    //I.fillField("Last name","the gray");
    //I.fillField("Email address","walid.messaoudi10@gmail.com");
    //I.checkOption("male");
    I.fillField("Identifiant","admin");
    I.fillField("Mot de passe","admin");
    I.click("S'enregistrer");
    I.see("En phase d'implémentation admin admin");
    I.saveScreenshot("registerPage.jpg");
    //I.see('welcome')

});
