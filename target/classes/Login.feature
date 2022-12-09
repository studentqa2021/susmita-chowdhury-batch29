Feature:Login function testing
Scenario:Login with valid credential
Given open browser
And go to URL
When click sign in button
And put user
And put password
And click second sign in button
Then if sign out  button is there test passed
