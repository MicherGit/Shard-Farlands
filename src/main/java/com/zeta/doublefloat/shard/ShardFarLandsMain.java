package com.zeta.doublefloat.shard;

import com.thistestuser.farlands.FarLandsTransformer;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.Map;

@Mod(modid = ShardFarLandsMain.MODID, name = ShardFarLandsMain.NAME, version = ShardFarLandsMain.VERSION)
public class ShardFarLandsMain implements IFMLLoadingPlugin
{
    public static final String MODID = "doublefloat";
    public static final String NAME = "Shard Farlands";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{ShardFarLandsTransformer.class.getName()};
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
