package com.example.election.service;

import com.example.election.domain.Candidate;
import com.example.election.domain.Party;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CandidateServiceTest {

    @MockBean
    CandidateRepository mockCandidateRepo;

    @Autowired
    CandidateService service;

    private final Candidate testCandidate = new Candidate("Sam", new Party("fun"));

    @Test
    public void getCandidates() throws Exception {
        when(mockCandidateRepo.findByParty("fun")).thenReturn(Collections.singletonList(testCandidate));
        List<Candidate> candidates =  service.getCandidates("fun");
        assertNotNull(candidates);
        assertEquals(1, candidates.size());
        verify(mockCandidateRepo).findByParty("fun");
    }

    @Test
    public void getAllCandidates() throws Exception {
        when(mockCandidateRepo.findAll()).thenReturn(Collections.singletonList(testCandidate));
        List<Candidate> candidates =  service.getCandidates("");
        assertNotNull(candidates);
        Candidate candidate = candidates.get(0);
        assertNotNull(candidate);
        verify(mockCandidateRepo).findAll();
    }

    @Test
    public void getAllCandidatesNull() throws Exception {
        when(mockCandidateRepo.findAll()).thenReturn(null);
        List<Candidate> candidates =  service.getCandidates(null);
        assertNull(candidates);
        verify(mockCandidateRepo).findAll();
    }

    @Test
    public void addCandidate() throws Exception {
        when(mockCandidateRepo.findByName("Sam")).thenReturn(null);
        when(mockCandidateRepo.save(testCandidate)).thenReturn(testCandidate);
        Candidate candidate =  service.addCandidate(testCandidate);
        assertNotNull(candidate);
        verify(mockCandidateRepo).findByName("Sam");
        verify(mockCandidateRepo).save(testCandidate);
    }

    @Test
    public void addCandidateAlreadyExists() throws Exception {
        when(mockCandidateRepo.findByName("Sam")).thenReturn(testCandidate);
        Candidate candidate =  service.addCandidate(testCandidate);
        assertNotNull(candidate);
        verify(mockCandidateRepo).findByName("Sam");
    }

}