package qwbarch.pixelmon

import com.pixelmonmod.pixelmon.Pixelmon
import net.minecraft.item.Item
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import net.minecraftforge.fml.common.registry.GameRegistry
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(modid = RegionalEverstone.MOD_ID, name = RegionalEverstone.MOD_NAME, version = RegionalEverstone.VERSION,
        dependencies = "required-after:pixelmon", acceptableRemoteVersions = "*")
class RegionalEverstone constructor(val logger: Logger = LogManager.getLogger("RegionalEverstone")) {

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger.info("Loading %s v%s".format(MOD_NAME, VERSION))
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent?) {
        Pixelmon.EVENT_BUS.register(BreedingListener())
    }

    companion object {
        const val MOD_ID = "regionaleverstone"
        const val MOD_NAME = "RegionalEverstone"
        const val VERSION = "1.0-SNAPSHOT"

        @Mod.Instance(MOD_ID)
        lateinit var INSTANCE: RegionalEverstone
    }
}