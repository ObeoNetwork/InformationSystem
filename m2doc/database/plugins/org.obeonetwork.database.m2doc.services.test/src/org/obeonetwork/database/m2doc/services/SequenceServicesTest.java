package org.obeonetwork.database.m2doc.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.obeonetwork.database.m2doc.services.common.AbstractTest;
import org.obeonetwork.dsl.database.DataBase;
import org.obeonetwork.dsl.database.Sequence;

public class SequenceServicesTest extends AbstractTest {
	/**
	 * the test database model.
	 */
	private DataBase dataBase;

	@Before
	public void setUp() {
		dataBase = loadModel("model/serie-oracle.database");
	}

	private Sequence getGSSerieSequence() {
		List<Sequence> sequences = new ArrayList<Sequence>(new DataBaseServices().allSequences(dataBase));
		for (Sequence sequence : sequences) {
			if ("GS_SERIE_SEQ".equals(sequence.getName())) {
				return sequence;
			}
		}
		return null;
	}

	@Test
	public void nullSequenceColumnsTest() {
		assertEquals(0, new SequenceServices().columns(null).size());
	}

	@Test
	public void sequenceColumnsTest() {
		Sequence sequence = getGSSerieSequence();
		assertEquals(1, new SequenceServices().columns(sequence).size());
	}
}
