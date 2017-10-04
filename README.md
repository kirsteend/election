# Election
Sample project that uses Spring framework and demonstrates REST api.

## Demonstrates
- Spring REST api (GET, POST, PUT)
- mongo repository
- code coverage with jacoco
- sample jenkins pipeline

## Election Concepts
The following concepts will be used in this sample.
- Voters - People who are registered to vote.
- Voting Locations - Pre-populated list of locations where voting takes place. Voters are allocated to a location based on their postal code.
- Riding - A collection of voting locations.
- Candidates - What candidates can be voted for in a particular riding.
- Parties - Parties that candidates belong to.
- Results - High level information of votes cast.  e.g. which Candidate won in the riding.  Percentage of voters that voted.

## Supported Operations
- Add Voters to the list of Electors
- Retrieve a voters information (based on name)
- Tell Voters where they should vote [WIP]
- Add Candidates to the ballot [WIP]
- Tell Voters who they can vote for [WIP]

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
$ curl -X POST http://localhost:8080/voters --header "Content-Type: application/json" --header "Accept: application/json" -d "{\"name\": \"Kirsteen\", \"postcode\": \"M2P 2H1\" }"
{"id":"59d4e3bf54405e0443ba500a","name":"Kirsteen","postCode":"M2P 2H1"}
```

### Retrieve a voter based on name
```
$ curl -X GET http://localhost:8080/voters?name=Kirsteen
[{"id":"59d4e39554405e0443ba5009","name":"Kirsteen","postCode":"M2P 2H1"}]
```

### Retrieve all voters
```
$ curl -X GET http://localhost:8080/voters
[{"id":"59d4e39554405e0443ba5009","name":"Kirsteen","postCode":"M2P 2H1"},{"id":"59d4e3bf54405e0443ba500a","name":"John","postCode":"M3C 0C1"}]
```

## Future Considerations 
- Dockerise
- static code analysis
- add cucumber tests
