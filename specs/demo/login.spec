# login test -- demoblazer

## giriş yapma senaryosu
* User clicks "loginbutton" on "demohome" page.
* User enters "login.standardUser" into "usernameField" on "demohome" page.
* User enters "login.password" into "passwordField" on "demohome" page.
* User clicks "loginSubmitButton" on "demohome" page.
* User should see "welcomeMessage" on "demohome" page.

## hatalı giriş senaryosu
* User clicks "loginbutton" on "demohome" page.
* User enters "login.standardUser" into "usernameField" on "demohome" page.
* User enters "invalid" into "passwordField" on "demohome" page.
* User clicks "loginSubmitButton" on "demohome" page.
* User verifies alert message is "Wrong password." and accepts it