package io.github.midnightdoom.mcutils.datagen;

import java.util.ArrayList;

import io.github.midnightdoom.template.Template;
import io.github.midnightdoom.template.blocks.ModBlocks;
import io.github.midnightdoom.template.items.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.model.BlockStateModelGenerator;
import net.minecraft.data.client.model.ModelIds;
import net.minecraft.data.client.model.Models;
import net.minecraft.data.client.model.Texture;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class AutoModelGenerator extends FabricModelProvider
{
    public AutoModelGenerator(FabricDataOutput output)
    {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator)
    {
        ArrayList<AnnotationHelper.ValueAnnotationPair<Block, GenerateItemModel>> items = AnnotationHelper.getFieldsWithAnnotation(GenerateItemModel.class, ModBlocks.class, Block.class);
        for (var itemData : items)
        {
            blockStateModelGenerator.registerParentedItemModel(itemData.value, ModelIds.getBlockModelId(itemData.value));
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator)
    {
        ArrayList<AnnotationHelper.ValueAnnotationPair<Item, GenerateItemModel>> items = AnnotationHelper.getFieldsWithAnnotation(GenerateItemModel.class, ModItems.class, Item.class);
        for (var itemData : items)
        {
            generateItemModel(itemData.value, itemModelGenerator);
        }
    }

    private void generateItemModel(Item item, ItemModelGenerator generator)
    {
        generator.register(item, Models.SINGLE_LAYER_ITEM);
    }
}
