package com.thethirdswan.thethirdswan_subsidiaries.mekanism;

import mekanism.common.resource.IResource;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public enum MiscOreResource implements IResource {
    // has no uses for now, was trying to register slurries in a different way
    NICKEL("nickel", 0xFF9D9D8B, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("tfc", "ores/nickel/normal"))),
    SILVER("silver", 0xFFE5DBDB, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("tfc", "ores/silver/normal"))),
    ZINC("zinc", 0xFFB6B4B7, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("tfc", "ores/zinc/normal"))),
    ALUMINUM("aluminum", 0xFFC3CBCE, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("immersiveengineering", "ores/aluminum"))),
    CHROMIUM("chromium", 0xFF908B81, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("firmalife", "ore_pieces"))),
    BISMUTH("bismuth", 0xFF4E6759, TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("tfc", "ores/bismuth/normal")));

    private final String name;
    private final int tint;
    private final Supplier<TagKey<Item>> oreTag;
//    private final nickel_tag = Tag

    MiscOreResource(String name, int tint, TagKey<Item> oreTag) {
        this(name, tint, () -> oreTag);
    }

    MiscOreResource(String name, int tint, Supplier<TagKey<Item>> oreTag) {
        this.name = name;
        this.tint = tint;
        this.oreTag = oreTag;
    }

    @Override
    public String getRegistrySuffix() {
        return name;
    }

    public int getTint() {
        return tint;
    }

    public TagKey<Item> getOreTag() {
        return oreTag.get();
    }
}
