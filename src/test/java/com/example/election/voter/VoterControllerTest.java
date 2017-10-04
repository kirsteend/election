package com.example.election.voter;

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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VoterControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private VoterService service;

    @Test
    public void getVoter() {
        final List<Voter> voters = Collections.synchronizedList(new ArrayList<Voter>());
        voters.add(new Voter("John", "Smith", "M3C 0C1"));
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
    @Ignore
    public void addVoter() {
        Voter voter = new Voter("John", "Smith", "M3C 0C1");
        when(service.addVoter(voter)).thenReturn(voter);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Voter> entity = new HttpEntity<>(voter, headers);

        ResponseEntity<Voter> response = restTemplate.exchange("/voters", HttpMethod.POST, entity, Voter.class);
        //ResponseEntity<Voter> response = this.restTemplate.postForEntity("/voters", voter, Voter.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(service).addVoter(voter);
    }

    @Test
    @Ignore
    public void addVoterError() {
        ResponseEntity<Voter> response = this.restTemplate.postForEntity("/voters", null, Voter.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @Ignore
    public void updateVoter() {
        when(service.getVoters("")).thenReturn(null);
        //TODO - update put to take voter request entity
        ResponseEntity<Voter> response = this.restTemplate.exchange("/voters", HttpMethod.PUT, null, Voter.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}