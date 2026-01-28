package com.thethirdswan.thethirdswan_subsidiaries.mekanism.slurries.clean;

import mekanism.api.chemical.slurry.SlurryBuilder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
// do i really need to init my own class that extends slurrybuilder?
public class TTSSlurryBuilder extends SlurryBuilder {
    private TagKey<Item> oreTag;

    protected TTSSlurryBuilder(ResourceLocation texture) {
        super(texture);
    }

    public static SlurryBuilder builder(ResourceLocation texture) {
        return new TTSSlurryBuilder(Objects.requireNonNull(texture));
    }

    public SlurryBuilder ore(TagKey<Item> oreTag) {
        this.oreTag = oreTag;
        return this;
    }

    @Nullable
    public TagKey<Item> getOreTag() {
        return oreTag;
    }
}
