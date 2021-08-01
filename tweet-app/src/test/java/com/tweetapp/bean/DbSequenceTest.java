package com.tweetapp.bean;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DbSequenceTest {

	DbSequence dbSequence;

	@Before
	public void setup() {
		dbSequence = new DbSequence();
	}

	@Test
	public void dbSequenceTest() {
		dbSequence.setId(Mockito.anyString());
		dbSequence.setSeq(Mockito.anyInt());

		assertNotEquals("2", dbSequence.getId());
		assertNotEquals(1, dbSequence.getSeq());
	}
}
