package net.kunmc.lab.luckyblockworld.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.kunmc.lab.luckyblockworld.config.ServerConfig;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;

public class CommandRegister {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        // ここに処理を追加していく
        LiteralCommandNode<CommandSource> mainCommand = dispatcher.register(Commands.literal("lbw")
                .requires(cs -> cs.hasPermissionLevel(4)));
        mainCommand.addChild(SetRange.create());
        mainCommand.addChild(SetTick.create());
        mainCommand.addChild(Start.create());
        mainCommand.addChild(Stop.create());
    }

    private static class SetRange {
        public static CommandNode<CommandSource> create() {
            return Commands.literal("setRange")
                    .then(Commands.argument("rangeNum", IntegerArgumentType.integer(1, 10))
                            .executes(ctx -> {
                                int num = ctx.getArgument("rangeNum", Integer.class);
                                ServerConfig.instance.replaceRange.set(num);
                                ctx.getSource().sendFeedback(new StringTextComponent("setRangeの値を" + num + "に変更しました"), false);
                                return Command.SINGLE_SUCCESS;
                            }))
                    .build();
        }
    }

    private static class SetTick {
        public static CommandNode<CommandSource> create() {
            return Commands.literal("setTick")
                    .then(Commands.argument("tickNum", IntegerArgumentType.integer(1, 20))
                            .executes(ctx -> {
                                int num = ctx.getArgument("tickNum", Integer.class);
                                ServerConfig.instance.replaceTick.set(num);
                                ctx.getSource().sendFeedback(new StringTextComponent("setTickの値を" + num + "に変更しました"), false);
                                return Command.SINGLE_SUCCESS;
                            }))
                    .build();
        }
    }

    private static class Start {
        public static CommandNode<CommandSource> create() {
            return Commands.literal("start")
                    .executes(ctx -> {
                        if (ServerConfig.instance.gameStatus.get()) {
                            ctx.getSource().sendFeedback(new StringTextComponent("すでに開始しています"), false);
                            return 0;
                        }

                        ServerConfig.instance.gameStatus.set(true);
                        ctx.getSource().sendFeedback(new StringTextComponent("startしました"), false);
                        return Command.SINGLE_SUCCESS;
                    })
                    .build();
        }
    }

    private static class Stop {
        public static CommandNode<CommandSource> create() {
            return Commands.literal("stop")
                    .executes(ctx -> {
                        if (!ServerConfig.instance.gameStatus.get()) {
                            ctx.getSource().sendFeedback(new StringTextComponent("開始されていません"), false);
                            return 0;
                        }

                        ServerConfig.instance.gameStatus.set(false);
                        ctx.getSource().sendFeedback(new StringTextComponent("stopしました"), false);
                        return Command.SINGLE_SUCCESS;
                    })
                    .build();
        }
    }
}
