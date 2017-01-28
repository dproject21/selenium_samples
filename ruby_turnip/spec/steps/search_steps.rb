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

step "リンク :url がある" do |url|
  elements = @result_page.get_elements(url)
  expect(elements.length).to be > 0
end
