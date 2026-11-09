package com.dragonminez.common.network;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StatsDeltaSyncTest {
	@Test
	void dynamicGrowthChangesAreIncludedInTheGenericStatsDelta() {
		CompoundTag previous = new CompoundTag();
		previous.put("DynamicGrowth", new CompoundTag());

		CompoundTag current = previous.copy();
		ListTag disabledStats = new ListTag();
		disabledStats.add(StringTag.valueOf("STR"));
		current.getCompound("DynamicGrowth").put("DisabledStats", disabledStats);

		CompoundTag delta = StatsDeltaSync.diff(current, previous, Set.of());

		assertTrue(delta.contains("DynamicGrowth"));
		assertEquals(disabledStats, delta.getCompound("DynamicGrowth").getList("DisabledStats", 8));
	}
}
