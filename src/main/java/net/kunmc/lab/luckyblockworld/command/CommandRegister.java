package net.kunmc.lab.luckyblockworld.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;

public class CommandRegister {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        // ここに処理を追加していく
        LiteralCommandNode<CommandSource> mainCommand = dispatcher.register(Commands.literal("lbw")
                .requires(cs -> cs.hasPermissionLevel(4)));
        mainCommand.addChild(SetRange.create());
    }

    private static class SetRange {
        public static CommandNode<CommandSource> create() {
            return Commands.literal("setRange")
                    .then(Commands.argument("rangeNum", IntegerArgumentType.integer(1))
                    .executes(ctx -> {
                        int num = ctx.getArgument("rangeNum", Integer.class);
                        //ctx.getSource().sendFeedback(new StringTextComponent(Integer.toString(num)), false);
                        return Command.SINGLE_SUCCESS;
                    })).build();
        }
    }
}