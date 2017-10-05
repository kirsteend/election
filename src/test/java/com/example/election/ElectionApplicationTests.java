package com.example.election;

import com.example.election.domain.Candidate;
import com.example.election.domain.Party;
import com.example.election.domain.Poll;
import com.example.election.domain.Voter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ElectionApplicationTests {

	@Test
	public void contextLoads() {
		ElectionApplication.main(new String[]{});
	}

	@Test
	public void testDomainModel() {
		Voter voter = new Voter("John", "M3C 0C1");
		assertEquals("Voter[id='null', name='John', postCode='M3C 0C1']", voter.toString());

		Party party = new Party("fun");
		String partyToString = "Party[id='null', name='fun']";
		assertEquals(partyToString, party.toString());

		Candidate candidate = new Candidate("Sam", new Party("fun"));
		assertEquals(String.format("Candidate[id='null', name='Sam', party='%s']",partyToString), candidate.toString());

		Poll poll = new Poll("main", "3 main street", "M2P 2H1");
		assertEquals("Poll[id='null', name='main', address='3 main street', postcode='M2P 2H1']", poll.toString());
	}

}
