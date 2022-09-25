@TodoLy @Regression @SignUp
Feature: Todo.ly SignUp functionality
 Background:
  Given the user is on the Todo.ly landing page

  @smoke @validSignUp
   Scenario Outline: TL01 - [Functional] A user can sign up in the Todo.ly system
   When the user clicks on the Sign Up Free button
   And  enters the valid data: <full name> in the Full Name text field
   And  enters the valid data: <email> in the Email text field
   And  enters the valid data: <password> in the Password text field
   And  selects the option: <timezone> from Timezone field
   And  marks the Terms of Service checkbox
   And  clicks on the SignUp button in the popup window
   Then The system should send the user to the home page titled: <home page title>

    Examples:
     | full name   | email                      | password  | timezone                                           | home page title |
     | "user TC01" | "userTC101@mailinator.com" | "user_94" | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Work"          |

 @invalidSignUp @emptyFields
  Scenario Outline: TL02 - [Functional] A user cannot register if he/her sends the empty form
  When the user clicks on the Sign Up Free button
  And  clicks on the SignUp button in the popup window
  Then the system should display the error message: <error message>

  Examples:
   | error message                               |
   | "Error. Please correct the missing fields." |

 @invalidSignUp @invalidEmail
 Scenario Outline: TL03 - [Functional]  The user cannot register if they enter invalid data for the email
  When the user clicks on the Sign Up Free button
  And  enters the valid data: <full name> in the Full Name text field
  And  enters the invalid data: <email> in the Email text field
  And  enters the valid data: <password> in the Password text field
  And  selects the option: <timezone> from Timezone field
  And  marks the Terms of Service checkbox
  And  clicks on the SignUp button in the popup window
  Then the system should display the error message: <error message>

  Examples:
   | full name   | email                   | password  | timezone                                           | error message                                            |
   | "user TC02" | ""                      | "user_94" | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Please correct the missing fields."              |
   | "user TC02" | "user@"                 | "user_94" | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Invalid Email Address!"                          |
   | "user TC02" | "user four@home.com"    | "user_94" | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Invalid Email Address!"                          |
   | "user TC02" | "user03@mailinator.com" | "user_94" | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Account with this email address already exists!" |

 @invalidSignUp @invalidPassword
 Scenario Outline: TL04 - [Functional] The user cannot register if they enter invalid data for the password
  When the user clicks on the Sign Up Free button
  And  enters the valid data: <full name> in the Full Name text field
  And  enters the valid data: <email> in the Email text field
  And  enters the invalid data: <password> in the Password text field
  And  selects the option: <timezone> from Timezone field
  And  marks the Terms of Service checkbox
  And  clicks on the SignUp button in the popup window
  Then the system should display the error message: <error message>

  Examples:
   | full name   | email                     | password | timezone                                           | error message                               |
   | "user TC03" | "userT005@mailinator.com" | ""       | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Please correct the missing fields." |
   | "user TC03" | "userT005@mailinator.com" | " "      | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Please correct the missing fields." |
   | "user TC03" | "userT035@mailinator.com" | "p"      | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Invalid Password!"                  |

 @invalidSignUp @invalidFullName
 Scenario Outline: TL05 - [Functional] The user cannot register if they enter invalid data for the Full Name
  When the user clicks on the Sign Up Free button
  And  enters the invalid data: <full name> in the Full Name text field
  And  enters the valid data: <email> in the Email text field
  And  enters the valid data: <password> in the Password text field
  And  selects the option: <timezone> from Timezone field
  And  marks the Terms of Service checkbox
  And  clicks on the SignUp button in the popup window
  Then the system should display the error message: <error message>

  Examples:
   | full name                                                                                                                                                | email                        | password | timezone                                           | error message                               |
   | ""                                                                                                                                                       | "userT008@mailinator.com"    | "user08" | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Please correct the missing fields." |
   | " "                                                                                                                                                      | "userT008@mailinator.com"    | "user08" | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Please correct the missing fields." |
   | "12345"                                                                                                                                                  | "userT118@mailinator.com"    | "user08" | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Invalid Full Name!"                 |
   | "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quis lorem ut libero malesuada feugiat Sed porttitor lectus nibh. Donec rutrum congue l" | "newUserT009@mailinator.com" | "user08" | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Invalid Full Name!"                 |

 @invalidSignUp @noMarksCheckbox
 Scenario Outline: TL06 - [Functional] The user cannot register if they don not mark the Terms of Service checkbox
  When the user clicks on the Sign Up Free button
  And  enters the valid data: <full name> in the Full Name text field
  And  enters the valid data: <email> in the Email text field
  And  enters the invalid data: <password> in the Password text field
  And  selects the option: <timezone> from Timezone field
  And  clicks on the SignUp button in the popup window
  Then the system should display the error message: <error message>

  Examples:
   | full name   | email                        | password | timezone                                           | error message                               |
   | "user TC04" | "newUserT010@mailinator.com" | "user04" | "(UTC-04:00) Georgetown, La Paz, Manaus, San Juan" | "Error. Please correct the missing fields." |

 @invalidSignUp @displaysUncheckedCheckbox
 Scenario: TL07 - [Functional] The Terms of Service box should be unchecked in the Sign Up popup
  When the user clicks on the Sign Up Free button
  Then the Terms of Service checkbox should not be checked



