#login

## Login with valid username & password
* User clicks "sign-in-link" on "toolshop" page.
*User enters "login.standardUser" into "email" on "toolshop" page.
*User enters "login.password" into "password" on "toolshop" page.
*User clicks "log-in-button" on "toolshop" page.
*User should see "my-account" on "toolshop" page.

## Try to login with invalid username
* User clicks "sign-in-link" on "toolshop" page.
*User enters "invalid" into "email" on "toolshop" page.
*User enters "login.password" into "password" on "toolshop" page.
*User clicks "log-in-button" on "toolshop" page.
*User should see "my-account" on "toolshop" page.

## Try to login with invalid password
* User clicks "sign-in-link" on "toolshop" page.
*User enters "login.standardUser" into "email" on "toolshop" page.
*User enters "invalid" into "password" on "toolshop" page.
*User clicks "log-in-button" on "toolshop" page.
*User should see "my-account" on "toolshop" page.