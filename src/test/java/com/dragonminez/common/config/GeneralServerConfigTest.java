package com.dragonminez.common.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralServerConfigTest {
	@Test
	void newServerConfigKeepsTheOneMillionStatCap() {
		assertEquals(1_000_000, new GeneralServerConfig().getGameplay().getMaxValue());
	}
}
