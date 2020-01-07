Feature: Booking Plane Tickets

  @sanity
  Scenario: Sucessfully Login in MakeMyTrip
    Given I open MakeMyTrip website
    When enter userId and Password
    Then I click on login button
    
    
    # Select Source, Destination and Date
    Given I am on MakeMyTrip Home Page
    When I select Source and destination and date
    Then I got list of flights
    
    # Book Flight with Minimum Fare
    Given I am on list of flights page
    When I select minimum fare flight
    Then I am on flight booking page
    
    
