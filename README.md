# Selenium

# selenium-webdriver

Selenium is a browser automation library. Most often used for testing
web-applications, Selenium may be used for any task that requires automating
interaction with the browser.

## Installation

Selenium may be installed via npm with

    npm install selenium-webdriver

You will need to download additional components to work with each of the major
browsers. The drivers for Chrome, Firefox, and Microsoft's IE and Edge web
browsers are all standalone executables that should be placed on your system
[PATH]. Apple's safaridriver is shipped with Safari 10 for OS X El Capitan and
macOS Sierra. You will need to enable Remote Automation in the Develop menu of
Safari 10 before testing.


| Browser           | Component                          |
| ----------------- | ---------------------------------- |
| Chrome            | [chromedriver(.exe)][chrome]       |
| Internet Explorer | [IEDriverServer.exe][release]      |
| Edge              | [MicrosoftWebDriver.msi][edge]     |
| Firefox           | [geckodriver(.exe)][geckodriver]   |
| Safari            | [safaridriver]                     |

## Usage

The sample below and others are included in the `example` directory. You may
also find the tests for selenium-webdriver informative.

```javascript
const {Builder, By, Key, until} = require('selenium-webdriver');

(async function example() {
  let driver = await new Builder().forBrowser('firefox').build();
  try {
    await driver.get('http://www.google.com/ncr');
    await driver.findElement(By.name('q')).sendKeys('webdriver', Key.RETURN);
    await driver.wait(until.titleIs('webdriver - Google Search'), 1000);
  } finally {
    await driver.quit();
  }
})();
```

### Using the Builder API

The `Builder` class is your one-stop shop for configuring new WebDriver
instances. Rather than clutter your code with branches for the various browsers,
the builder lets you set all options in one flow. When you call
`Builder#build()`, all options irrelevant to the selected browser are dropped:

```javascript
const webdriver = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');
const firefox = require('selenium-webdriver/firefox');

let driver = new webdriver.Builder()
    .forBrowser('firefox')
    .setChromeOptions(/* ... */)
    .setFirefoxOptions(/* ... */)
    .build();
```

Why would you want to configure options irrelevant to the target browser? The
`Builder`'s API defines your _default_ configuration. You can change the target
browser at runtime through the `SELENIUM_BROWSER` environment variable. For
example, the `example/google_search.js` script is configured to run against
Firefox. You can run the example against other browsers just by changing the
runtime environment

    # cd node_modules/selenium-webdriver
    node example/google_search
    SELENIUM_BROWSER=chrome node example/google_search
    SELENIUM_BROWSER=safari node example/google_search

### The Standalone Selenium Server

The standalone Selenium Server acts as a proxy between your script and the
browser-specific drivers. The server may be used when running locally, but it's
not recommend as it introduces an extra hop for each request and will slow
things down. The server is required, however, to use a browser on a remote host
(most browser drivers, like the IEDriverServer, do not accept remote
connections).

To use the Selenium Server, you will need to install the
[JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and
download the latest server from [Selenium][release]. Once downloaded, run the
server with

    java -jar selenium-server-standalone-2.45.0.jar

You may configure your tests to run against a remote server through the Builder
API:

```javascript
let driver = new webdriver.Builder()
    .forBrowser('firefox')
    .usingServer('http://localhost:4444/wd/hub')
    .build();
```
Or change the Builder's configuration at runtime with the `SELENIUM_REMOTE_URL`
environment variable:

    SELENIUM_REMOTE_URL="http://localhost:4444/wd/hub" node script.js

You can experiment with these options using the `example/google_search.js`
script provided with `selenium-webdriver`.

## Documentation

API documentation is available online from the [Selenium project][api].
Additional resources include

- the #selenium channel on freenode IRC
- the [selenium-users@googlegroups.com][users] list
- [SeleniumHQ](http://www.seleniumhq.org/docs/) documentation
