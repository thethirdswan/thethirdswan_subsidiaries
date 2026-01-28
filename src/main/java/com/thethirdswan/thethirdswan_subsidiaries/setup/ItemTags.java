package com.thethirdswan.thethirdswan_subsidiaries.setup;

import com.thethirdswan.thethirdswan_subsidiaries.Registrate;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ItemTags extends ItemTagsProvider {
	public ItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator, blockTags, "thethirdswan_subsidiaries", helper);
	}

	public static final TagKey<Item> PNC_UPGRADES = TagKey.create(Registry.ITEM_REGISTRY,
			new ResourceLocation("thethirdswan_subsidiaries", "pnc_upgrades"));
	public static final TagKey<Item> NICKEL_INGOT = TagKey.create(Registry.ITEM_REGISTRY,
			new ResourceLocation("forge", "ingot/nickel"));

	@Override
	protected void addTags() {
		tag(PNC_UPGRADES).add(Registrate.TEMPERATURE_REGULATOR_UPGRADE.get());
		// come on, you can do a little better than to reference an ingot with a custom tag
		tag(NICKEL_INGOT).add(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation("tfc", "metal/ingot/nickel"))));
	}
	
	@Override
	public String getName() {
		return "The Third Swan Subsidiaries Item Tags";
	}
}