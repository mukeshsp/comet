Web Scraping
=============
A simple Web Scraping SpringBoot application which scraps content from a site(https://medium.com) and stores in in-memory database(h2). This projects also exposed Rest APis to perform CRUD operations on Blog. Maven is used as build tool in this project.


Get Blogs by tag: 
  -To scraps blogs from a Medium, you need to input tag into the input box(http://localhost:8080) and press hit on scrap button. It will show the latest blog posts that blong to the inputed tag.


Instruction to run the project.

   1. Import the project as Maven project. Navigate to ../comet/ where pom.xml exists. 
   2. Build as mvn clean install (.jar will be created in target folder)
   3. Navigate to target folder and open cmd/terminal.
   4. Enter the command " java -jar filename.jar"   
   5. Enter "http://localhost:8080" on Browser.
   6. Enter tag name(ex- bitcoin) and click on scrap.
   7.) To see database console, please got to "http://localhost:8080/h2-console".
  You can also launch SpringBoot project from eclipse(Run CometApplication.java as java application) and access web pages from Browser.



