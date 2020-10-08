Feature("Login");

Scenario("test login scenario success", (I) => {
    I.amOnPage("/login");
    I.see("Sign in");
    I.fill("Username", "cosmicdarine");
    I.fill("Password", "lolilol");
    I.click("Login");
    I.amOnPage("/home");

    I.see("ask");
    I.click("ask");
    I.fill("Is Fanta better than sprite ?");
    I.click("submit");
    I.see("Is Fanta better than sprite ?");
    I.saveScreenshot("add_question_screenshot.png");
});
