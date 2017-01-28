require 'page-object'

class ResultPage

  include PageObject

  def initialize(driver)
    super(driver)
    @driver = driver
  end

  def get_elements(url)
    return elements = @driver.find_elements(:xpath, "//a[(@href='" + url + "')]")
  end


end
