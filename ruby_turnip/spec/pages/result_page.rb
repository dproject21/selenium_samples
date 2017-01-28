require 'page-object'

class ResultPage

  include PageObject

  def initialize(driver)
    super(driver)
    @driver = driver
  end

  def check_word(word)
    element = @driver.find_element(:xpath, '//a[contains(@href, "' + word + '")]')

    return element != nil
  end


end
