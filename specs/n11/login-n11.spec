#N11 Login

## Gecerli kullanici adi ve sifre ile giris yap
*User clicks "loginLink" on "n11" page.
*User accepts cookies.
*User enters "n11login.email" into "emailInput" on "n11" page.
*User clicks "loginButton" on "n11" page.
*User enters "n11login.password" into "passwordInput" on "n11" and enter.
*User should see "homePage" on "n11" page.

## Gecersiz e-posta ile giris yapilmamali
*User clicks "loginLink" on "n11" page.
*User enters "invalid" into "emailInput" on "n11" page.
*User enters "n11login.password" into "passwordInput" on "n11" page.
*User clicks "loginButton" on "n11" page.

## Gecersiz sifre ile giris yapilmamali
*User clicks "loginLink" on "n11" page.
*User enters "n11login.email" into "emailInput" on "n11" page.
*User enters "invalid" into "passwordInput" on "n11" page.
*User clicks "loginButton" on "n11" page.
