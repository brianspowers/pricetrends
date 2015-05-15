# PriceTrends

## Overview
PriceTrends is a web application that displays historical pricing data sourced from the [U.S. Bureau of Labor Statistics](http://www.bls.gov/) in a graphical format.
PriceTrends provides both line and bar graph visualizations as well as a standard tabular display.  

You can currently find a [working demo of PriceTrends](http://pricetrends.herokuapp.com) running on Heroku.  

## Technology & Motivation
PriceTrends is built with several different libraries and frameworks that I wanted to gain experience with.  

#### Server
  The server application is a Java backend, utilizing [Spring Boot](http://projects.spring.io/spring-boot/) and [Jersey](http://jersey.java.net) to provide the MVC and web services framework.
Google [Guava](http://code.google.com/p/guava-libraries/) was used to provide local caching for web service calls.  [Jackson](http://jackson.codehaus.org/) was used to convert between Java objects and their JSON representations.

#### Client
  The client-side is a single-page application in [Ember](http://emberjs.com/) and [Ember CLI](http://www.ember-cli.com/). Graphing is done with [Flot](http://www.flotcharts.org/) with help from [Select2](http://select2.github.io/) for enhanced drop-down support, and [Bootstrap](http://getbootstrap.com/) for the CSS framework.
  
## Implementation
The server-side application provides three web service endpoints.  Two endpoints expose lists of valid Areas and Items that the user can pick from.  A third endpoint accepts an Area and an Item, returning average pricing data gathered from the BLS public API.  This data is cached in memory on the server in order to minimize repeat requests to the BLS API.

## Developing / Running
#### Server
The following dependencies are necessary to develop on and run PriceTrends from source:  
* Java 1.8
* Maven  

PriceTrends is a Spring Boot application and includes an embedded version of Tomcat.  It can be run directly from maven with the command: `mvn spring-boot:run`.  Additionally, running the main method on the BlsDataViewerApplication class will also start the server.  

#### Client
Running the client side application from source requires Node.js, npm, bower, and ember-cli to be installed and present.  [This guide](http://www.ember-cli.com/#getting-started) has instructions to install these.

From the `src/main/js/avgprices` directory, install application dependencies:
```
npm install
bower install
```
When finished, the application may be run with this command:
```
ember s --proxy http://127.0.0.1:8080
```
This will start a local Ember server and will proxy all web service requests to a running instance of the server back-end.  The application should now be available on port 4200: `http://localhost:4200`

## Configuration
By default, PriceTrends will talk to the BLS API in unauthenticated mode and will be limited to only 25 requests in a 24-hour period.  To increase this number to 500 requests per day, an API key needs to be provided.  An API key can be requested [here](http://data.bls.gov/registrationEngine/).  
Once you have an API key, either set it in an environment variable named `APIKEY`, or place the following lines in an `application.properties` file in any of [these locations](http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html#boot-features-external-config-application-property-files).
```
apiKey = xxx[YOUR_API_KEY]xxx
```

## Deployment
#### Local
To deploy PriceTrends, download this release jar from Github: [Download Release v0.1.0](https://github.com/brianspowers/pricetrends/releases/download/v.0.1.0/pricetrends.jar).
Run it from the command line
```
java -jar pricetrends.jar
```

#### Local (Built from source)
To build from source, first build the Ember application:
```
cd src/main/js/avgprices
ember build --environment=production
```
Copy all files just generated from `dist/assets` into `$PROJECT_ROOT/src/main/resources/static/assets`.
Open `$PROJECT_ROOT/src/main/js/avgprices/dist/index.html` and make sure that the CSS and JS file hashes are copied over to `$PROJECT_ROOT/src/resources/templates/index.html`.  Now you're ready to build the "fat jar" containing the backend server as well as the compiled client code.
From the project root:
```
mvn clean install
```
Once you have the jar, it can be run from the command line:
```
java -jar pricetrends.jar
```
By default the server will run on port 8080, but this can be changed by setting a `PORT` environment variable to a different desired port.
#### Heroku
PriceTrends can be deployed to Heroku by simply creating a new application and pushing this repository.  If deploying to Heroku, make sure to set the APIKEY environment variable in the Heroku app.

## Final Thoughts
* Spring Boot did turn out to be a great way to scaffold a web application really quickly.  The integration with Jersey was painless, and the dependency injection system worked well once I learned a few of its quirks.
* Currently the list of Areas and Items that the server provides are stored internally as plain Lists.  I would like to move these either into an embedded or standalone database instance.
* Developing the client app with Ember CLI was a good experience, mainly due to its use of Babel, making a lot of the new ES6 syntax available as well as code organization with modules.
* I used Ember Data as the client-side data store.  While this worked great once it was properly configured, it took a little more wrangling than I would have liked to get it playing nice with the back-end.  If I did this over again, I would either drop Ember Data entirely, or I would have designed the web service to more exactly match the JSON response format that Ember Data was looking for.
* To serve the Ember application from the Spring back-end, I ultimately had to build the Ember app and copy the compiled assets into the server's resources folder by hand.  I would like to make this process smoother using something like Grunt or Gulp.
* While I designed the site using Bootstrap with responsiveness in mind, it still has some issues on mobile phones.  (Possibly due to my use of CSS Flexbox Layout, which isn't fully supported in all browsers yet).  While it's still usable, with more time I would work on improving the mobile experience.


