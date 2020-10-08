Feature('Login');

Scenario('test login scenario success', (I) => {
    I.amOnPage('/login');
    I.see('Sign in');
    I.fill('Username', 'cosmicdarine');
    I.fill('Password', 'lolilol');
    I.click('Login');
    I.amOnPage('/home');
    I.see('Welcome');
    I.saveScreenshot('login_success_screenshot.png');
});
