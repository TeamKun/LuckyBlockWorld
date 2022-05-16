package net.kunmc.lab.luckyblockworld.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class ServerConfig {
    public static final ServerConfig instance;
    private static final ForgeConfigSpec spec;

    // tomlファイルにシリアライズするためにはWrapperクラスを使わなければならない.
    public final ForgeConfigSpec.ConfigValue<Integer> replaceRange;
    public final ForgeConfigSpec.ConfigValue<Integer> replaceTick;
    public final ForgeConfigSpec.ConfigValue<Boolean> gameStatus;

    public ServerConfig(ForgeConfigSpec.Builder builder) {
        // ForgeConfigSpec.Builderを利用してWrapperクラスのインスタンスを生成することが出来る
        this.replaceRange = builder.comment("Replace Block Range")
                .defineInRange("replaceRange", 7, 1, 10);
        this.replaceTick = builder.comment("Replace Block Time(Tick)")
                .defineInRange("replaceTime", 10, 1, 20);
        this.gameStatus = builder.comment("Game Status(start/stop)")
                .define("gameStatus", false);
    }

    // staticイニシャライザ内で直接登録しようとしても上手く出来ないためModのメインクラスのコンストラクタからこの関数を呼び登録する.
    public static void register(ModLoadingContext ctx) {
        // 第1引数はコンフィグファイルが生成・読込されるのがクライアントのみか,サーバーのみか,両方かを選択する.
        ctx.registerConfig(ModConfig.Type.SERVER, spec);
    }

    static {
        Pair<ServerConfig, ForgeConfigSpec> p = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        instance = p.getLeft();
        spec = p.getRight();
    }
}