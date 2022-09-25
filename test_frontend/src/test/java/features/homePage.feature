@TodoLy @Regression @SignUp
Feature: Todo.ly SignUp functionality
  Background:
    Given the user is on the Todo.ly landing page

  @smoke @selectAddButton
  Scenario Outline: TL01 - [Functional] A user select the Add New Project button
    When the user clicks on the Log In Free button
    And  enters a valid credential for the email: <email>
    And  enters a valid credential for the password: <password>
    And  clicks on the Login button in the popup window
    And  clicks the Add New Project button
    Then a text field to enter the project name should be displayed
    And  button to add the project should be displayed

    Examples:
      | email                   | password  |
      | "user01@mailinator.com" | "user_94" |

  @smoke @CreateANewProject
  Scenario Outline: TL01 - [Functional] A user select the Add New Project button
    When the user clicks on the Log In Free button
    And  enters a valid credential for the email: <email>
    And  enters a valid credential for the password: <password>
    And  clicks on the Login button in the popup window
    And  clicks the Add New Project button
    And  Enter a <project name> name for the project
    And  clicks the Add button
    Then a new project whit the <project name> name should be displayed

    Examples:
      | email                   | password  | project name |
      | "user01@mailinator.com" | "user_94" | "Project002" |

