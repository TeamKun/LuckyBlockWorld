package net.kunmc.lab.luckyblockworld.logic;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockChange {

    private static BlockState luckBlockState = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("lucky:lucky_block")).getDefaultState();

    public static boolean shouldChangeBlock(Material blockMaterial){
        // 変更しない対象
        if (blockMaterial.equals(Material.WATER))
            return false;
        return true;
    }
}
