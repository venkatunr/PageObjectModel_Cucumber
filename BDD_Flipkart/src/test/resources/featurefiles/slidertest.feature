Feature: validate the Slider functionality

  Background: 
    Given user clicks on slider link
    
@Current
  Scenario: Ensure Default slider functionalities
    When user landed on default functionality
    Then verify the default value of Details of Loan
    
@Current
  Scenario: Verify the Loan Amount functionality using slider
    Given ensure min value of loan amount
    When ensure max value of loan amount
    When ensure scroll step by step

   Scenario: Verify the Interest rate functionality using slider
		Given ensure current state of interest rate
		When ensure min value of interest rate
		Then ensure max value of interest rate