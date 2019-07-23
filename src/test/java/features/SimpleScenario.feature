Feature: Test the calculator subcration
 
 	@web
  Scenario Outline:
    Given I open a browser
    When I navigate to online Calculator page
    Then I navigate to canvas page
	  Then I have clicked two buttons "<number1>" and "<number2>" and "<operation>"
    Then I have to capture the image of result
    Then I have valided the test
    Then I have to compare with "<basefile>"
 
    Examples:
    |number1|number2|operation| basefile |
    |9|3|/|TC1|  
    |0|5|/|TC2|  
    |6|0|/|TC3|  
    |7|3|/|TC4|  
    
    |9|3|-|TC5|  
    |6|0|-|TC6|  
    |0|3|/|TC7|  
    |4|9|/|TC8|  
    
    
    # TC1: Positive integer divided by positive integer (9,3)
    # TC2: Validate  0 divided by some integer i-e 9 results 0 (0,5)
    # TC3: Validate  the calc output incase of dividing by zero 0 resulting in error message(negative test) (6,0)
    # TC4: when we use divide operation the example (like 7/3 then the answer should display quotient not a remainder)
    
    # TC5:Validate subtraction of large-small results in positive number(9,3)
    # TC6:Validate 0 is subtracted from a positive integer results in that integer (6,0) 
    # TC7:Validate positive integer subtracted from 0 results in that integer (0,6)
    # TC8:Validate subtraction of two integer small-large results in negative value(negative test) (4,9) 
    
    
    
 @web
  Scenario Outline:
    Given I open a browser
    When I navigate to online Calculator page
    Then I navigate to canvas page
	  Then I have clicked "<anynumber>" to test CE operation
    Then I have to capture the image of result
    Then I have valided the test
    Then I have to compare with "<basefile>"
 
    Examples:
    |anynumber| basefile |
    |9| TC9 | 
    |9| TC10 | 
    
    
    # TC9:Validate When we press the clear button then is the screen display reduced to "0" or not
    # TC10: Enter different keys and pres CE button the screen displayed 0
    
    

    
        
    
