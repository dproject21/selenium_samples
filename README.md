## Selenium Sample Code

Selenium Sample Code, writing Java and Ruby.

In advance, install Selenium Webdriver.

https://gist.github.com/stoshiya/3dc36187ede3e6eee3e4

### Java

Test execute command.

```
mvn -DargLine="-Dwebdriver.chrome.driver=/path/to/chromedriver" test
```

### Ruby

Ruby using some gems.

* selenium-webdriver (https://rubygems.org/gems/selenium-webdriver/)
* page-object (https://rubygems.org/gems/page-object)
* turnip (https://rubygems.org/gems/turnip)

Not use this gem.

* capybara (https://rubygems.org/gems/capybara)

Setup command.

```
bundle install --path vendor/bundle
```

Test execute command.

```
bundle exec rspec spec
```
