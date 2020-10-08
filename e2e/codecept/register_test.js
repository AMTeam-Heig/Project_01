Feature("register");

Scenario("test register process", (I) => {
    I .amOnPage("/login");
    I.fill("Prénom", "Olivier");
    I.fill("Nom", "Liechti");
    I.fill("E-mail", "o.liechti@example.com");
    I.fill("Identifiant", "wasadigi");
    I.fill("Mot de passe", "lolilol");
    I.click("Validate");
    I.saveScreenshot("register_test.png");
});
