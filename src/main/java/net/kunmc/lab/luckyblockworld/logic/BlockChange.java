package net.kunmc.lab.luckyblockworld.logic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockChange {

    private static BlockState luckBlockState = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("lucky:lucky_block")).getDefaultState();

    public static boolean shouldChangeBlock(BlockState blockState) {
        // 変更しない対象
        if (blockState.equals(luckBlockState.getMaterial()) ||
                blockState.equals(Blocks.AIR.getDefaultState()) ||
                blockState.getMaterial().equals(Material.WATER) ||
                blockState.getMaterial().equals(Material.LAVA) ||
                blockState.getMaterial().equals(Material.PORTAL) ||
                blockState.equals(Blocks.OBSIDIAN.getDefaultState()) ||
                blockState.equals(Blocks.END_GATEWAY.getDefaultState()) ||
                blockState.equals(Blocks.END_PORTAL_FRAME.getDefaultState()) ||
                blockState.equals(Blocks.TNT.getDefaultState()) ||
                blockState.getMaterial().equals(Material.ANVIL) ||
                blockState.equals(Blocks.BLACK_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.BLUE_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.BROWN_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.CYAN_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.GRAY_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.GREEN_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.LIME_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.MAGENTA_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.ORANGE_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.PINK_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.PURPLE_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.RED_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.WHITE_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.YELLOW_GLAZED_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.DIAMOND_BLOCK.getDefaultState()) ||
                blockState.equals(Blocks.GOLD_BLOCK.getDefaultState()) ||
                blockState.equals(Blocks.LAPIS_BLOCK.getDefaultState()) ||
                blockState.equals(Blocks.EMERALD_BLOCK.getDefaultState()) ||
                blockState.getBlock() instanceof FenceBlock ||
                blockState.equals(Blocks.OAK_FENCE.getDefaultState()) ||
                blockState.equals(Blocks.SANDSTONE.getDefaultState()) ||
                blockState.equals(Blocks.SANDSTONE_STAIRS.getDefaultState()) ||
                blockState.equals(Blocks.COBBLESTONE.getDefaultState()) ||
                blockState.equals(Blocks.COBBLESTONE_STAIRS.getDefaultState()) ||
                blockState.equals(Blocks.COBBLESTONE_SLAB.getDefaultState()) ||
                blockState.equals(Blocks.STONE.getDefaultState()) ||
                blockState.equals(Blocks.CHEST.getDefaultState()) ||
                blockState.equals(Blocks.ENDER_CHEST.getDefaultState()) ||
                blockState.equals(Blocks.SLIME_BLOCK.getDefaultState()) ||
                blockState.equals(Blocks.ACACIA_SIGN.getDefaultState()) ||
                blockState.equals(Blocks.OAK_SIGN.getDefaultState()) ||
                blockState.getMaterial().equals(Material.GLASS) ||
                blockState.equals(Blocks.BEDROCK.getDefaultState()) ||
                blockState.equals(Blocks.YELLOW_WOOL.getDefaultState()) ||
                blockState.equals(Blocks.QUARTZ_BLOCK.getDefaultState()) ||
                blockState.equals(Blocks.REDSTONE_BLOCK.getDefaultState()) ||
                blockState.equals(Blocks.REDSTONE_LAMP.getDefaultState()) ||
                blockState.equals(Blocks.REDSTONE_TORCH.getDefaultState()) ||
                blockState.equals(Blocks.REDSTONE_WIRE.getDefaultState()) ||
                blockState.equals(Blocks.REDSTONE_WALL_TORCH.getDefaultState()) ||
                blockState.equals(Blocks.TORCH.getDefaultState()) ||
                blockState.equals(Blocks.LEVER.getDefaultState()) ||
                blockState.getMaterial().equals(Material.IRON) ||
                blockState.equals(Blocks.YELLOW_TERRACOTTA.getDefaultState()) ||
                blockState.equals(Blocks.CRAFTING_TABLE.getDefaultState())
        )
            return false;
        return true;
    }
}
