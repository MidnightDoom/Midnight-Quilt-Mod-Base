package io.github.midnightdoom.template.blocks;

import io.github.midnightdoom.mcutils.datagen.AutoTranslate;
import io.github.midnightdoom.mcutils.datagen.GenerateItemModel;
import io.github.midnightdoom.template.Template;
import io.github.midnightdoom.template.items.ModItems;
import io.github.midnightdoom.template.items.itemGroup.AutoItemGroup;
import io.github.midnightdoom.template.items.itemGroup.ModItemGroups;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class ModBlocks
{
    private static Block register(String name, Block block, boolean shouldMakeItem)
    {
        Identifier identifier = Template.id(name);

        if (shouldMakeItem)
        {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, identifier, blockItem);
			ModItems.BLOCK_ITEMS.put(block, blockItem);
        }

        return Registry.register(Registries.BLOCK, identifier, block);
    }

    public static void init()
    {
    }
}
