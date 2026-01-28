package com.thethirdswan.thethirdswan_subsidiaries.setup;

import java.util.function.Consumer;

import blusunrize.immersiveengineering.api.crafting.builders.ArcFurnaceRecipeBuilder;
import com.thethirdswan.thethirdswan_subsidiaries.Registrate;
import me.desht.pneumaticcraft.common.PneumaticCraftTags;
import mekanism.api.datagen.recipe.builder.ChemicalCrystallizerRecipeBuilder;
import mekanism.api.datagen.recipe.builder.FluidSlurryToSlurryRecipeBuilder;
import mekanism.api.datagen.recipe.builder.ItemStackChemicalToItemStackRecipeBuilder;
import mekanism.api.datagen.recipe.builder.ItemStackToItemStackRecipeBuilder;
import mekanism.api.recipes.ingredients.creator.IngredientCreatorAccess;
import mekanism.common.registries.MekanismGases;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;


public class Recipes extends RecipeProvider {
    public Recipes(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(Registrate.TEMPERATURE_REGULATOR_UPGRADE.get())
                .pattern("cpc")
                .pattern("vav")
                .pattern("cpc")
                .define('p', PneumaticCraftTags.Items.INGOTS_COMPRESSED_IRON)
                .define('c', PneumaticCraftTags.Items.UPGRADE_COMPONENTS)
                .define('v', new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("pneumaticcraft", "vortex_tube"))).getItem())
		        .define('a', new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("compressedcreativity", "industrial_air_blower"))).getItem())
                .group("thethirdswan_subsidiaries")
                .unlockedBy("upgrades", InventoryChangeTrigger.TriggerInstance.hasItems(Items.LAPIS_LAZULI))
                .save(consumer);
        buildMekOreProcessingRecipes(consumer);
        buildArcFurnaceRecipes(consumer);
    }

    protected void buildMekOreProcessingRecipes(Consumer<FinishedRecipe> consumer) {
        ItemStackToItemStackRecipeBuilder.enriching(IngredientCreatorAccess.item().from(Registrate.NICKEL_DUST_DIRTY.get()), Registrate.NICKEL_DUST.getItemStack()).build(consumer, new ResourceLocation("thethirdswan_subsidiaries:dust/from_dirty_dust"));
        ItemStackToItemStackRecipeBuilder.crushing(IngredientCreatorAccess.item().from(Registrate.NICKEL_CLUMP.get()), Registrate.NICKEL_DUST_DIRTY.getItemStack()).build(consumer, new ResourceLocation("thethirdswan_subsidiaries:dirty_dust/from_clump"));
        ItemStackChemicalToItemStackRecipeBuilder.purifying(
                IngredientCreatorAccess.item().from(Registrate.NICKEL_SHARD.get()),
                IngredientCreatorAccess.gas().from(MekanismGases.OXYGEN, 1),
                Registrate.NICKEL_CLUMP.getItemStack()
        ).build(consumer, new ResourceLocation("thethirdswan_subsidiaries:clump/from_shard"));
        ItemStackChemicalToItemStackRecipeBuilder.injecting(
                IngredientCreatorAccess.item().from(Registrate.NICKEL_CRYSTAL.get()),
                IngredientCreatorAccess.gas().from(MekanismGases.HYDROGEN_CHLORIDE, 1),
                Registrate.NICKEL_SHARD.getItemStack()
        ).build(consumer, new ResourceLocation("thethirdswan_subsidiaries:shard/from_crystal"));
        ChemicalCrystallizerRecipeBuilder.crystallizing(IngredientCreatorAccess.slurry().from(Registrate.NICKEL_SLURRY.getCleanSlurry(), 200), Registrate.NICKEL_CRYSTAL.getItemStack()).build(consumer, new ResourceLocation("thethirdswan_subsidiaries:crystal/from_slurry"));
        FluidSlurryToSlurryRecipeBuilder.washing(
                IngredientCreatorAccess.fluid().from(FluidTags.WATER, 5),
                IngredientCreatorAccess.slurry().from(Registrate.NICKEL_SLURRY.getDirtySlurry(), 1),
                Registrate.NICKEL_SLURRY.getCleanSlurry().getStack(1)
        ).build(consumer, new ResourceLocation("thethirdswan_subsidiaries:slurry/clean_slurry"));
    }

    // unfinished, hangs the game upon world load
    protected void buildArcFurnaceRecipes(Consumer<FinishedRecipe> consumer) {
        ArcFurnaceRecipeBuilder.builder(ItemTags.NICKEL_INGOT, 1)
                .addIngredient("input", Registrate.NICKEL_DUST)
                .setTime(200)
                .setEnergy(51200)
                .build(consumer, new ResourceLocation("thethirdswan_subsidiaries:arc_furnace/nickel"));
    }
}