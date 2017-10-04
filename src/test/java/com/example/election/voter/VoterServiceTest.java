package com.example.election.voter;

import com.example.election.poll.Poll;
import com.example.election.poll.PollRepository;
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
public class VoterServiceTest {

    @MockBean
    VoterRepository mockVoterRepo;

    @MockBean
    PollRepository mockPollRepo;

    @Autowired
    VoterService service;

    private final Voter testVoter = new Voter("John","M3C 0C1");
    private final Voter testVoterWithPoll = new Voter("John","M3C 0C1");
    private final Poll testPoll = new Poll("main", "2 main street", "M3C 0C1");

    @Test
    public void getVotersFound() throws Exception {
        when(mockVoterRepo.findByName("John")).thenReturn(testVoter);
        List<Voter> voters =  service.getVoters("John");
        assertNotNull(voters);
        Voter voter = voters.get(0);
        assertNotNull(voter);
        verify(mockVoterRepo).findByName("John");
    }

    @Test
    public void getVotersNotFound() throws Exception {
        when(mockVoterRepo.findByName("Sam")).thenReturn(null);
        List<Voter> voters =  service.getVoters("Sam");
        assertNotNull(voters);
        assertEquals(0, voters.size());
        verify(mockVoterRepo).findByName("Sam");
    }

    @Test
    public void getAllVoters() throws Exception {
        when(mockVoterRepo.findAll()).thenReturn(Collections.singletonList(testVoter));
        List<Voter> voters =  service.getVoters("");
        assertNotNull(voters);
        Voter voter = voters.get(0);
        assertNotNull(voter);
        verify(mockVoterRepo).findAll();
    }

    @Test
    public void getAllVotersNull() throws Exception {
        when(mockVoterRepo.findAll()).thenReturn(Collections.singletonList(testVoter));
        List<Voter> voters =  service.getVoters(null);
        assertNotNull(voters);
        Voter voter = voters.get(0);
        assertNotNull(voter);
        verify(mockVoterRepo).findAll();
    }

    @Test
    public void addNewVoter() throws Exception {
        when(mockVoterRepo.findByName("John")).thenReturn(null);
        when(mockPollRepo.findByPostCode("M3C 0C1")).thenReturn(testPoll);
        testVoterWithPoll.setPoll(testPoll);
        when(mockVoterRepo.save(testVoter)).thenReturn(testVoterWithPoll);
        Voter voter =  service.addVoter(testVoter);
        assertNotNull(voter);
        verify(mockVoterRepo).findByName("John");
        verify(mockPollRepo).findByPostCode("M3C 0C1");
        verify(mockVoterRepo).save(testVoter);
    }

    @Test
    public void addVoterAlreadyExists() throws Exception {
    }

    @Test
    public void updateVoter() throws Exception {
    }

}