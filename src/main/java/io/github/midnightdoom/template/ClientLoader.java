package io.github.midnightdoom.template;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

import io.github.midnightdoom.mcutils.cadmium.Cadmium;
import io.github.midnightdoom.template.items.ModItems;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ClientLoader implements ClientModInitializer
{
    @Override
    public void onInitializeClient(ModContainer mod)
    {
        Template.LOGGER.info("Template Client Loaded!");
        Cadmium.initializeClient();
    }
}
