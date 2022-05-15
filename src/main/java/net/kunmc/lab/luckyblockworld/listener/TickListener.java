package net.kunmc.lab.luckyblockworld.listener;

import net.kunmc.lab.luckyblockworld.logic.BlockChange;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.registries.ForgeRegistries;

public class TickListener {

    private static int cnt = 0;

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        if (cnt > 200) {
            cnt = 0;
        } else {
            cnt++;
            return;
        }

        String[] onlinePlayers = ServerLifecycleHooks.getCurrentServer().getOnlinePlayerNames();
        PlayerList playerList = ServerLifecycleHooks.getCurrentServer().getPlayerList();
        for (String playerName : onlinePlayers) {
            ServerPlayerEntity player = playerList.getPlayerByUsername(playerName);
            BlockPos playerPos = player.getPosition();

            World world = player.getServerWorld();

            for (int dx = -5; dx <= 5; dx++) {
                for (int dy = -5; dy <= 5; dy++) {
                    for (int dz = -5; dz <= 5; dz++) {
                        int x = playerPos.getX() + dx;
                        int y = playerPos.getY() + dy;
                        int z = playerPos.getZ() + dz;
                        double dist = Math.sqrt((x * x + y * y + z * z));
                        if (dist > 5.0) {
                            BlockPos blockPos = new BlockPos(x, y, z);
                            BlockState blockState = world.getBlockState(blockPos);
                            if (!BlockChange.shouldChangeBlock(blockState)) continue;

                            world.setBlockState(blockPos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("lucky:lucky_block")).getDefaultState());
                        }
                    }
                }
            }
        }
    }
}
