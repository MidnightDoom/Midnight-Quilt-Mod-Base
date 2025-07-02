package io.github.midnightdoom.template;

import io.github.midnightdoom.template.misc.ModParticles;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.midnightdoom.mcutils.cadmium.Cadmium;
import io.github.midnightdoom.template.blockentities.ModBlockEntities;
import io.github.midnightdoom.template.blocks.ModBlocks;
import io.github.midnightdoom.template.commands.ModCommands;
import io.github.midnightdoom.template.components.ModComponents;
import io.github.midnightdoom.template.events.ModEvents;
import io.github.midnightdoom.template.items.ModItems;
import io.github.midnightdoom.template.items.itemGroup.ModItemGroups;

import net.minecraft.util.Identifier;

public class Template implements ModInitializer
{
    public static final Logger LOGGER = LoggerFactory.getLogger("template");
    public static final String NAMESPACE = "template";

    @Override
    public void onInitialize(ModContainer mod)
    {
        Cadmium.initialize();
        
        ModParticles.init();
        ModBlocks.init();
        ModItems.init();
        ModComponents.init();
        ModBlockEntities.init();
        
        ModItemGroups.register();
        ModEvents.register();
        ModCommands.register();
    }

    public static Identifier id(String name)
    {
        return Identifier.of(NAMESPACE, name);
    }
}
