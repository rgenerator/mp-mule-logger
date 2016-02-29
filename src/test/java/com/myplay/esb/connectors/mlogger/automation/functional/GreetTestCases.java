package com.myplay.esb.connectors.mlogger.automation.functional;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.myplay.esb.connectors.mlogger.MloggerConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class GreetTestCases extends
		AbstractTestCase<MloggerConnector> {

	public GreetTestCases() {
		super(MloggerConnector.class);
	}

	@Before
	public void setup() {
		// TODO
	}

	@After
	public void tearDown() {
		// TODO
	}

	@Test
	public void verify() {
		assertEquals(1, 1);
	}

}