require 'rubygems'
require 'bundler/setup'
require 'turnip'
require 'turnip/rspec'
require 'selenium-webdriver'

Dir.glob("spec/steps/**/*steps.rb") { |f| load f, true }




RSpec.configure do |config|
  config.before(:each) {
    # exec browser
    @driver = Selenium::WebDriver.for :chrome

    # access google
    #@driver.navigate.to "http://google.com"
  }

  config.after(:each) {
    # close browser
    @driver.quit
  }
end
