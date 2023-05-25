# spring-cloud-gcp-pubsub-example
All the code developed in the "Creating Google Cloud Pub/Sub publishers and subscribers with Spring Cloud GCP" article I
published in the [QuintoAndar Tech Blog](https://medium.com/quintoandar-tech-blog).

## Articles

- [Part 1: Setup](https://medium.com/quintoandar-tech-blog/creating-google-cloud-pub-sub-publishers-and-subscribers-with-spring-cloud-gcp-part-1-setup-a96c53025fec)
- [Part 2: Implementation](https://medium.com/quintoandar-tech-blog/creating-google-cloud-pub-sub-publishers-and-subscribers-with-spring-cloud-gcp-part-2-362bd25eb03c)

## Steps
- Setup Gradle old version 7.3.2 as this uses spring 2.7.12
- Download gradle wrapper 
```
gradle wrapper
```
- set up Enviornment Variables GOOGLE_APPLICATION_CREDENTIALS/GCP_KEY_FILE_BASE64   ( Vscode you can use terminal.integrated.env.windows)
- ./gradlew clean build
- ./gradlew bootRun
- Refer the articles above for more details
```
curl -X POST   http://localhost:8080/hello/publish?[1-30]   -H 'Content-Type: text/plain'   -d 'Hello, Pub/Sub'
```
