require 'page-object'

class TopPage

  include PageObject

  text_field(:search, :id => 'srchtxt')
  button(:submit, :id => 'srchbtn')


  def initialize(driver)
    super(driver)
    @driver = driver
    @url = "http://www.yahoo.co.jp"
  end

  def open
    @driver.get(@url)
  end

  def search_word(word)
    self.search = word
    self.submit

    result_page = ResultPage.new(@driver)
    return result_page
  end

end
