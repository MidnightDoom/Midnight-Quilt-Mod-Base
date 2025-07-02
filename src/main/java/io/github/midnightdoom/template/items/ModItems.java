package io.github.midnightdoom.template.items;

import java.util.HashMap;

import io.github.midnightdoom.mcutils.datagen.AutoTranslate;
import io.github.midnightdoom.mcutils.datagen.GenerateItemModel;
import io.github.midnightdoom.template.Template;
import io.github.midnightdoom.template.components.ModComponents;
import io.github.midnightdoom.template.items.itemGroup.AutoItemGroup;
import io.github.midnightdoom.template.items.itemGroup.ModItemGroups;

import net.minecraft.block.Block;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;

public final class ModItems
{
    public static final HashMap<Block, Item> BLOCK_ITEMS = new HashMap<>();


    public static void init()
    {
    }

    private static Item register(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Template.id(name), item);
    }
}
