# Election
Sample project that uses Spring framework and demonstrates REST api.

## Demonstrates
- Spring REST api (GET, POST, PUT)
- jpa repository
- code coverage with jacoco
- jenkins pipeline

## Election Concepts
The following concepts will be used in this sample.
- Voters - People who are registered to vote.
- Poll - Pre-populated list of locations where voting takes place. Voters are allocated to a poll based on their postal code.
- Candidates - What candidates can be voted for at a particular poll.
- Parties - Group that candidates belong to.

## Supported Operations
- Add voters to the list of electors.
- Retrieve a voters information (based on name).
- Tell voters where they should vote.

## Usage
To build the project do the following:
```
./gradlew clean build jacocoTestReport
```
To launch the application:
```
./gradlew bootRun
```

## Test
Use curl to test the supported requests

### Add a voter
```
$  curl -X POST http://localhost:8080/voters --header "Content-Type: application/json" --header "Accept: application/json" -d "{\"name\": \"Kirsteen\", \"postCode\": \"M2P 2H1\" }"
  {"id":"1","name":"Kirsteen","postCode":"M2P 2H1","poll":{"id":"1","name":"main","address":"3 main street","postcode":"M2P 2H1"}}
```

### Retrieve a voter based on name
```
$ curl -X GET http://localhost:8080/voters?name=Kirsteen
[{"id":"1","name":"Kirsteen","postCode":"M2P 2H1"}]
```

### Retrieve all voters
```
$ curl -X GET http://localhost:8080/voters
[{"id":"1","name":"Kirsteen","postCode":"M2P 2H1"},{"id":"2","name":"John","postCode":"M3C 0C1"}]
```

## Future Considerations 
- Add candidates to the ballot using kafka [WIP]
- Query what candidates are on the ballot at a particular location [WIP]
- Dockerise
- Add cucumber tests
