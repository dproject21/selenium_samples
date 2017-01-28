# coding: utf-8

require 'pages/top_page'
require 'pages/result_page'

step "yahooにアクセス" do
  @top_page = TopPage.new(@driver)
  @top_page.open
end

step ":word を検索" do |word|
  @result_page = @top_page.search_word(word)
end

step ":word が出る" do |word|
  @result_page.check_word(word)
end
