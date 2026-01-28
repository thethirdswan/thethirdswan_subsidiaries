package com.thethirdswan.thethirdswan_subsidiaries.setup;

import com.thethirdswan.thethirdswan_subsidiaries.Registrate;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class ItemModels extends ItemModelProvider {
	public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, "thethirdswan_subsidiaries", existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
        pncUpgradesModel(Registrate.TEMPERATURE_REGULATOR_UPGRADE.get());
		mekOreProcessingItemModels(Registrate.NICKEL_DUST.get(), "dust", false);
		mekOreProcessingItemModels(Registrate.NICKEL_DUST_DIRTY.get(), "dust", true);
		mekOreProcessingItemModels(Registrate.NICKEL_CLUMP.get(), "clump", false);
		mekOreProcessingItemModels(Registrate.NICKEL_SHARD.get(), "shard", false);
		mekOreProcessingItemModels(Registrate.NICKEL_CRYSTAL.get(), "crystal", false);
	}

	private ItemModelBuilder mekOreProcessingItemModels(Item item, String itemType, boolean dirty) {
		String textureLocation;
		if (dirty && Objects.equals(itemType, "dust")) {
			textureLocation = "dusts/dirty/";
		} else if (!dirty && Objects.equals(itemType, "dust")) {
			textureLocation = "dusts/clean/";
		} else {
			textureLocation = itemType + "/";
		}
		return withExistingParent(item.getRegistryName().getPath(),
				new ResourceLocation("item/generated")).texture("layer0",
				new ResourceLocation("thethirdswan_subsidiaries", "item/" + textureLocation + item.getRegistryName().getPath()));
	}

	private ItemModelBuilder pncUpgradesModel(Item item) {
		return withExistingParent(item.getRegistryName().getPath(),
				new ResourceLocation("item/generated")).texture("layer1",
				new ResourceLocation("thethirdswan_subsidiaries", "item/upgrades/" + item.getRegistryName().getPath()))
				.texture("layer0", new ResourceLocation("pneumaticcraft", "item/upgrade_matrix"));
    }
}