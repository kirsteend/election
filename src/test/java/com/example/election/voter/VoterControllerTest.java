package com.example.election.voter;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

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
        when(service.getVoter("John")).thenReturn(new Voter("John", "Smith"));
        ResponseEntity<Voter> response = this.restTemplate.getForEntity("/voters?name=John", Voter.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(service).getVoter("John");
    }

    @Test
    public void getVoterNotFound() {
        when(service.getVoter(null)).thenReturn(null);
        ResponseEntity<Voter> response = this.restTemplate.getForEntity("/voters", Voter.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(service).getVoter(null);
    }

    @Test
    public void addVoter() {
        when(service.addVoter("John")).thenReturn(new Voter("John", "Smith"));
        ResponseEntity<Voter> response = this.restTemplate.postForEntity("/voters?name=John", "", Voter.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(service).addVoter("John");
    }

    @Test
    public void addVoterError() {
        ResponseEntity<Voter> response = this.restTemplate.postForEntity("/voters", "", Voter.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    @Ignore
    public void updateVoter() {
        when(service.getVoter("")).thenReturn(null);
        //TODO - update put to take voter request entity
        ResponseEntity<Voter> response = this.restTemplate.exchange("/voters", HttpMethod.PUT, null, Voter.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}