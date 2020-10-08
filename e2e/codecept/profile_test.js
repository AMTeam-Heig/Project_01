Feature('Profile');

Scenario('test login scenario success', (I) => {
    I.amOnPage('/login');
    I.see('Sign in');
    I.fill('Username', 'cosmicdarine');
    I.fill('Password', 'lolilol');
    I.click('Login');
    I.amOnPage('/home');
    I.click('Profile');
    I.see('Firstname');
    I.saveScreenshot("login_success_screenshot.png");
});