package qwbarch.pixelmon;

import com.pixelmonmod.pixelmon.Pixelmon;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RegionalEverstone.MOD_ID, name = RegionalEverstone.MOD_NAME, version = RegionalEverstone.VERSION,
        dependencies = "required-after:pixelmon", acceptableRemoteVersions = "*")
public class RegionalEverstone {

    public static final String MOD_ID = "regionaleverstone";
    public static final String MOD_NAME = "RegionalEverstone";
    public static final String VERSION = "1.2";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        event.getModLog().info("Loading v" + VERSION);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        Pixelmon.EVENT_BUS.register(BreedingListener.class);
    }
}