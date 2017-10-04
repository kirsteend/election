# Election
Sample project that uses Spring framework and demonstrates REST api.

## Demonstrates
- Spring REST api (GET, POST, PUT)
- mongo repository

## Election Concepts
The following concepts will be used in this sample.
- Voters - People who are registered to vote.
- Voting Locations - Pre-populated list of locations where voting takes place. Voters are allocated to a location based on their postal code.
- Riding - A collection of voting locations.
- Candidates - What candidates can be voted for in a particular riding.
- Parties - Parties that candidates belong to.
- Results - High level information of votes cast.  e.g. which Candidate won in the riding.  Percentage of voters that voted.

## Currently Supported Operations
- Add a voter
- Retrieve a voters information (based on name)
- Update a voters information

## Usage
To build the project do the following:
```
./gradlew clean build bootRun
```

## Test
Use curl to test the supported requests

### Add a voter
```
 curl -X POST http://localhost:8080/voters?name=Kirsteen
{"id":"59d3b98754405e21d5a22e1e","firstName":"Kirsteen","lastName":"lastName"}
```

### Retrieve a voter based on name
```
$ curl -X GET http://localhost:8080/voters?name=Kirsteen
{"id":"59d3b98754405e21d5a22e1e","firstName":"Kirsteen","lastName":"lastName"}
```

## Future Considerations 
- Dockerise
- static code analysis
- add cucumber tests

## Operations to be Supported
- Associate a voter to a voting location based on postal code.
- Query all voters registered to vote at a particular location.
- See what candidates are running for election in a particular riding.


