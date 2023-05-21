@TestAPI
Feature: Login API

  Scenario: Login with correct phone and password
    Given I URL operation for "https://id.chotot.com"
    When  I send POST request with path "/api/public/phone/login"
    Then I should be see the status code response is "400"
    And I should be see the message response is "Vui lòng nhập Số điện thoại."

  Scenario: Login with blank phone and input correct password
    Given I URL operation for "https://id.chotot.com"
    When I send POST request with path "/api/public/phone/login" and set the body request have Password with value "johndou"
    Then I should be see the status code response is "400"
    And I should be see the message response is "Vui lòng nhập Số điện thoại."

  Scenario: Login with wrong format phone field and incorrect password
    Given I URL operation for "https://id.chotot.com"
    When I send POST request with path "/api/public/phone/login" and set the body request have Phone and Password with value "johndou" and "johndou"
    Then I should be see the status code response is "400"
    And I should be see the message response is "Số điện thoại chỉ chứa dưới dạng số."

  Scenario: Login with input correct phone and blank password
    Given I URL operation for "https://id.chotot.com"
    When I send POST request with path "/api/public/phone/login" and set the body request have Phone with value "1234567890"
    Then I should be see the status code response is "400"
    And I should be see the message response is "Vui lòng nhập Mật khẩu."

  Scenario: Login with less than 10 characters phone field and correct password
    Given I URL operation for "https://id.chotot.com"
    When I send POST request with path "/api/public/phone/login" and set the body request have Phone and Password with value "123456789" and "@#OKRemaX123"
    Then I should be see the status code response is "400"
    And I should be see the message response is "Số điện thoại có ít nhất 10 kí tự."

  Scenario: Login with wrong format phone field
    Given I URL operation for "https://id.chotot.com"
    When I send POST request with path "/api/public/phone/login" and set the body request have Phone with value "janedou"
    Then I should be see the status code response is "400"
    And I should be see the message response is "Số điện thoại chỉ chứa dưới dạng số."

  Scenario: Login with more than 11 characters phone field and correct password
    Given I URL operation for "https://id.chotot.com"
    When I send POST request with path "/api/public/phone/login" and set the body request have Phone and Password with value "123456789101" and "@#OKRemaX123"
    Then I should be see the status code response is "400"
    And I should be see the message response is "Số điện thoại có nhiều nhất 11 kí tự."
