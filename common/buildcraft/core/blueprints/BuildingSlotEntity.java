/**
 * Copyright (c) 2011-2014, SpaceToad and the BuildCraft Team
 * http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.core.blueprints;

import java.util.LinkedList;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import buildcraft.api.blueprints.IBuilderContext;
import buildcraft.api.blueprints.MappingRegistry;
import buildcraft.api.blueprints.SchematicEntity;
import buildcraft.api.core.Position;

public class BuildingSlotEntity extends BuildingSlot {

	public SchematicEntity schematic;

	@Override
	public void writeToWorld(IBuilderContext context) {
		schematic.writeToWorld(context);
	}

	@Override
	public Position getDestination () {
		NBTTagList nbttaglist = schematic.cpt.getTagList("Pos", 6);
		Position pos = new Position(nbttaglist.func_150309_d(0),
				nbttaglist.func_150309_d(1), nbttaglist.func_150309_d(2));

		return pos;
	}

	@Override
	public LinkedList<ItemStack> getRequirements (IBuilderContext context) {
		LinkedList<ItemStack> results = new LinkedList<ItemStack>();

		for (ItemStack s : schematic.storedRequirements) {
			results.add(s);
		}

		return results;
	}

	@Override
	public SchematicEntity getSchematic() {
		return schematic;
	}

	@Override
	public boolean isAlreadyBuilt(IBuilderContext context) {
		return schematic.isAlreadyBuilt(context);
	}

	@Override
	public void writeToNBT (NBTTagCompound nbt, MappingRegistry registry) {

	}

	@Override
	public void readFromNBT (NBTTagCompound nbt, MappingRegistry registry) {

	}
}