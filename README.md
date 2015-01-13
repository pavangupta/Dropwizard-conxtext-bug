# Dropwizard 0.8 migration problem
## Intro
My current setup in Dropwizard 0.7.1 is to serve static content in my root ( / ) and my API under /api  
This does not seem to work in 0.8.0-rc1

## Usage

1. run this program (see running below)
2. You should see the text "Hello World!" and "Hello, successful Dropwizard User!"
3. edit pom.xml, line 22 from 0.7.1 to 0.8.0-rc1
4. run the program again, it will probably not work due to 2 resources being mapped to root

## Running
1. mvn clean package && java -jar target/dropwizard-1.0-SNAPSHOT.jar server target/classes/hello-world.yml
2. And go to [Main page](http://localhost:8080)

