package com.example.election.web;

import com.example.election.domain.Voter;
import com.example.election.service.VoterService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VoterControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private VoterService service;

    private final Voter testVoter = new Voter("John","M3C 0C1");
    private final Voter testUpdatedVoter = new Voter("James","M3C 0C1");

    @Test
    public void getVoter() {
        final List<Voter> voters = Collections.synchronizedList(new ArrayList<Voter>());
        voters.add(testVoter);
        when(service.getVoters("John")).thenReturn(voters);
        ResponseEntity<List> response = this.restTemplate.getForEntity("/voters?name=John", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(service).getVoters("John");
    }

    @Test
    public void getVoterNotFound() {
        when(service.getVoters(null)).thenReturn(Collections.synchronizedList(new ArrayList<>()));
        ResponseEntity<List> response = this.restTemplate.getForEntity("/voters", List.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(service).getVoters(null);
    }

    @Test
    public void addVoter() {
        when(service.addVoter(any(Voter.class))).thenReturn(testVoter);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> requestEntity = new HttpEntity<>("{\"name\": \"John\", \"postcode\": \"M3C 0C1\" }", headers);

        ResponseEntity<Voter> response = restTemplate.exchange("/voters", HttpMethod.POST, requestEntity, Voter.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(service).addVoter(any(Voter.class));
    }

    @Test
    public void addVoterError() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<Voter> response = this.restTemplate.postForEntity("/voters", requestEntity, Voter.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void updateVoterOk() {
        when(service.updateVoter("John","James")).thenReturn(testUpdatedVoter);
        ResponseEntity<Voter> response = this.restTemplate.exchange("/voters?name=John&newName=James", HttpMethod.PUT,
                null, Voter.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(service).updateVoter("John","James");
    }

    @Test
    public void updateVoterBadRequest() {
        when(service.updateVoter("John","James")).thenReturn(null);
        ResponseEntity<Voter> response = this.restTemplate.exchange("/voters?name=John&newName=James", HttpMethod.PUT,
                null, Voter.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(service).updateVoter("John","James");
    }

}