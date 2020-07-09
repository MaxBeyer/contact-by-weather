# Contact By Weather
 This app determines the best way to contact individuals depending on how the weather is that day, based on the following criteria:
* The best time to engage a customer via a text message is when it is sunny and warmer than 75 degrees Fahrenheit
* The best time to engage a customer via email is when it is between 55 and 75 degrees Fahrenheit
* The best time to engage a customer via a phone call is when it is less than 55 degrees or when it is raining.  

_Note: if the weather pattern returned does not match any of the above cases, the best outreach method is unknown._

# Running the App
* Clone this project into your favorite IDE (I used IntelliJ)
* launch the SpringBoot app internally from the IDE, or...
* run a gradle build
* run the resulting jar file from the build

# Usage
This is a console application, and therefore _"...it should print out each date and the best outreach method for that day on a new line"_, as per the requirements.

By starting the application, the console automatically prints the dates and corresponding outreach methods.
 
### Determining the "best" outreach method
There are several times that are returned each day, however we only want to know one outreach method per day.  In lieu of averaging out all of the outreach methods for each day (and accounting for ties, etc) I opted for selecting one time window for each day.  

I chose the time window of 11:00AM - 1:00PM as my desired window because most people take a lunch break during the day, and may find this time to be contacted fairly convenient. There should only ever be one item in the response object per day during this window since the API returns timestamps in 3 hour intervals.

# GET Endpoint- http://localhost:8080/outreach?city={city}
You may notice that when you start this application, it continues to run.  This is because I have also implemented a bonus GET endpoint.

If you hit this endpoint, you will be returned a response entity with the next 5 dates and outreach methods for a given city. If the query parameter is not included, the default city sent in the request is Minneapolis.

Any mis-spelled or invalid cities will yield a null response and will be logged to the console

# What I could have done differently, or would do with more time
* have written more thurough tests with more edge cases
* implemented the acceptance test
* cleaned up/ommitted the unused response objects. I just did a JsonToKotlinClass import and kept everything, which will make future implementations easier, but isn't MVP
* Used Docker (it's incompatible with my version of Windows)
* Determined a better contact method than "Unknown" for cases where the weather patterns don't match the criteria
* Configured the RestTemplate in a more customized way
* Introduced Thymeleaf and a simple HTTP page for an enhanced viewing experience
* Implemented Swagger-UI
* More comments throughout the code
* added validation for city query parameter
* added better error handling