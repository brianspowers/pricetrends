# PriceTrends

## Overview
PriceTrends is a web application that displays historical pricing data sourced from the [U.S. Bureau of Labor Statistics](http://www.bls.gov/) in a graphical format.
PriceTrends provides both line and bar graph visualizations as well as a standard tabular display.  

You can currently find a [working demo of PriceTrends](http://pricetrends.herokuapp.com) running on Heroku.  

## Technology & Motivation
PriceTrends is built with several different libraries and frameworks that I wanted to gain experience with.  

#### Server
  The server application is a Java backend, utilizing [Spring Boot](http://projects.spring.io/spring-boot/) and [Jersey](http://jersey.java.net) to provide the MVC and web services framework.
Google [Guava](http://code.google.com/p/guava-libraries/) was used to provide local caching for web service calls.  

#### Client
  The client-side is a single-page application in [Ember](http://emberjs.com/) and [Ember CLI](http://www.ember-cli.com/). Graphing is done with [Flot](http://www.flotcharts.org/) with help from [Select2](http://select2.github.io/) for enhanced drop-down support, and [Bootstrap](http://getbootstrap.com/) for the CSS framework.
  
## Implementation
The server-side application provides three web service endpoints.  Two endpoints expose lists of valid Areas and Items that the user can pick from.  A third endpoint accepts an Area and an Item, returning average pricing data gathered from the BLS public API.  This data is cached in memory on the server in order to minimize repeat requests to the BLS API.

## Developing / Running

