Feature: Ensure the Cascading functionality from Listbox

Background: 
	Given user navigated to listbox control
	

Scenario: ensure checkbox selection for all options
	Given user clicks on checkbox control
	When all checkbox should be unselected
	Then ensure options are selectable
	

Scenario: ensure functionality of check all button
	Given user clicks on check all option
	When all options are should be selected
	Then ensure uncheck option


Scenario: ensure functionality of get values
	Given select options from list
	When clicks on get values
	Then options should be listed based on selected value
	
@Current
Scenario: ensure hide checkbox functionality
	Given click on hide check box option
	Then checkbox options should be disable
	When click on show check box option
	Then checkbox options should be enable




	

	
	