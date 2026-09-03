#Login 

## Login with valid username & password
*User enters "login.standardUser" into "username" on "login" page.
*User enters "login.password" into "password" on "login" page.
*User clicks "loginButton" on "login" page.
*User should see "productsTitle" on "inventory" page.


## Try to login with invalid username
*User enters "invalid" into "username" on "login" page.
*User enters "login.password" into "password" on "login" page.
*User clicks "loginButton" on "login" page.
*User should see "productsTitle" on "inventory" page.

## Try to login with invalid password
*User enters "login.standardUser" into "username" on "login" page.
*User enters "invalid" into "password" on "login" page.
*User clicks "loginButton" on "login" page.
*User should see "productsTitle" on "inventory" page.