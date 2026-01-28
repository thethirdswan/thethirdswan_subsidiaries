package com.thethirdswan.thethirdswan_subsidiaries;

import com.mojang.logging.LogUtils;

import com.thethirdswan.thethirdswan_subsidiaries.mekanism.slurries.clean.TTSSlurryBuilder;
import com.thethirdswan.thethirdswan_subsidiaries.pnc.items.TemperatureRegulatorUpgrade;
import me.desht.pneumaticcraft.api.item.PNCUpgrade;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import mekanism.common.registration.impl.SlurryDeferredRegister;
import mekanism.common.registration.impl.SlurryRegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import org.slf4j.Logger;

import static me.desht.pneumaticcraft.api.PneumaticRegistry.RL;


public class Registrate {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "thethirdswan_subsidiaries");

    public static final DeferredRegister<PNCUpgrade> PNCUPGRADES = DeferredRegister.create(RL("upgrades"), "thethirdswan_subsidiaries");

    public static final ItemDeferredRegister MEKANISM_ITEMS = new ItemDeferredRegister("thethirdswan_subsidiaries");
    public static final SlurryDeferredRegister MEKANISM_SLURRIES = new SlurryDeferredRegister("thethirdswan_subsidiaries");

    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(eventBus);
        PNCUPGRADES.register(eventBus);
        MEKANISM_ITEMS.register(eventBus);
        MEKANISM_SLURRIES.register(eventBus);
    }

    public static final RegistryObject<PNCUpgrade> TEMPERATURE_REGULATOR = PNCUPGRADES
            .register("temperature_regulator", () ->
                    new PNCUpgrade(1));
    public static final RegistryObject<Item> TEMPERATURE_REGULATOR_UPGRADE = ITEMS
            .register("temperature_regulator_upgrade", () -> new TemperatureRegulatorUpgrade(new Item.Properties().tab(Main.ITEM_GROUP), TEMPERATURE_REGULATOR, 1));



    public static final ItemRegistryObject<Item> NICKEL_DUST = MEKANISM_ITEMS.register("dust_nickel");
    public static final ItemRegistryObject<Item> SILVER_DUST = MEKANISM_ITEMS.register("dust_silver");
    public static final ItemRegistryObject<Item> ZINC_DUST = MEKANISM_ITEMS.register("dust_zinc");
    public static final ItemRegistryObject<Item> BISMUTH_DUST = MEKANISM_ITEMS.register("dust_bismuth");
    public static final ItemRegistryObject<Item> ALUMINIUM_DUST = MEKANISM_ITEMS.register("dust_aluminium");
    public static final ItemRegistryObject<Item> CHROMIUM_DUST = MEKANISM_ITEMS.register("dust_chromium");

    public static final ItemRegistryObject<Item> NICKEL_DUST_DIRTY = MEKANISM_ITEMS.register("dust_dirty_nickel");
    public static final ItemRegistryObject<Item> SILVER_DUST_DIRTY = MEKANISM_ITEMS.register("dust_dirty_silver");
    public static final ItemRegistryObject<Item> ZINC_DUST_DIRTY = MEKANISM_ITEMS.register("dust_dirty_zinc");
    public static final ItemRegistryObject<Item> BISMUTH_DUST_DIRTY = MEKANISM_ITEMS.register("dust_dirty_bismuth");
    public static final ItemRegistryObject<Item> ALUMINIUM_DUST_DIRTY = MEKANISM_ITEMS.register("dust_dirty_aluminium");
    public static final ItemRegistryObject<Item> CHROMIUM_DUST_DIRTY = MEKANISM_ITEMS.register("dust_dirty_chromium");

    public static final ItemRegistryObject<Item> NICKEL_CLUMP = MEKANISM_ITEMS.register("clump_nickel");

    public static final ItemRegistryObject<Item> NICKEL_SHARD = MEKANISM_ITEMS.register("shard_nickel");

    public static final ItemRegistryObject<Item> NICKEL_CRYSTAL = MEKANISM_ITEMS.register("crystal_nickel");

    public static final SlurryRegistryObject<Slurry, Slurry> NICKEL_SLURRY = MEKANISM_SLURRIES.register("nickel", slurry -> TTSSlurryBuilder.builder(new ResourceLocation("thethirdswan_subsidiaries", "slurry/nickel_base_color")));
}