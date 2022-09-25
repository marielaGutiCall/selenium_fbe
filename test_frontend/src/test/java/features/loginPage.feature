@TodoLy @Regression @LogIn
Feature: Todo.ly SignUp functionality
  Background:
    Given the user is on the Todo.ly landing page

  @smoke @validLogIn
  Scenario Outline: TL01 - [Functional] A user log in in the Todo.ly system
    When the user clicks on the Log In Free button
    And  enters a valid credential for the email: <email>
    And  enters a valid credential for the password: <password>
    And  clicks on the Login button in the popup window
    Then The system should send the user to the home page titled: <home page title>

    Examples:
      | email                   | password  | home page title |
      | "user01@mailinator.com" | "user_94" | "Work"          |

  @invalidSignUp @emptyFields
  Scenario Outline: TL02 - [Functional] A user cannot log in if they do not enter their credentials
    When the user clicks on the Log In Free button
    And  clicks on the Login button in the popup window
    Then the system should display the error message about invalid credentials: <error message>
    Examples:
      | error message                                                                                                |
      | "Wrong email or password. Please try again. Forgot your password? You can retrieve it using the form below." |

