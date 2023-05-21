@TestUI
Feature: Login UI

  Scenario Outline: Check grammar / text of label
    Given I want close popup presentation if present
    Then I want check grammar / text  of label login have text with "<Login>"
    And I want check grammar / text  of label welcome back have text with "<WelcomeBack>"
    And I want check grammar / text  of placeholder phone have text with "<Phone>"
    And I want check grammar / text  of placeholder password have text with "<Password>"
    And I want check grammar / text  of button login have text with with "<LoginButton>"
    And I want check grammar / text  of label forget password have text with with "<ForgetPassword>"
    And I want check grammar / text  of label login 3third have text with with "<Login3Third>"
    And I want check grammar / text  of label register have text with with "<Register>"

    Examples:
      | Login     | WelcomeBack       | Phone            | Password              | LoginButton | ForgetPassword     | Login3Third  | Register                        |
      | Đăng nhập | Chào bạn quay lại | Nhập SĐT của bạn | Nhập mật khẩu của bạn | Đăng nhập   | Bạn quên mật khẩu? | hoặc sử dụng | Chưa có tài khoản? Đăng ký ngay |


  Scenario: Login with blank phone and input correct password
    Given I want open login page
    When I input to Password textbox with value "johndou"
    And I click to Login button
    Then I want show Message: "Vui lòng nhập Số điện thoại."

  Scenario: Login with wrong format phone field and incorrect password
    When I input to Phone and Password textbox with value "johndou" and value "johndou"
    And I click to Login button
    Then I want show Message: "Số điện thoại chỉ chứa dưới dạng số."

  Scenario: Login with input correct phone and blank password
    Given I want open login page
    When I input to Phone textbox with value "1234567890"
    And I click to Login button
    Then I want show Message: "Vui lòng nhập Mật khẩu."

  Scenario: Login with less than 10 characters phone field and correct password
    When I input to Phone textbox with value "123456789"
    And I input to Password textbox with value "@#OKRemaX123"
    And I click to Login button
    Then I want show Message: "Số điện thoại có ít nhất 10 kí tự."

  Scenario: Login with wrong format phone field
    Given I want open login page
    When I input to Phone textbox with value "janedou"
    And I click to Login button
    Then I want show Message: "Số điện thoại chỉ chứa dưới dạng số."

  Scenario: Login with more than 11 characters phone field and correct password
    When I input to Phone textbox with value "123456789101"
    And I input to Password textbox with value "@#OKRemaX123"
    And I click to Login button
    Then I want show Message: "Số điện thoại có nhiều nhất 11 kí tự."
