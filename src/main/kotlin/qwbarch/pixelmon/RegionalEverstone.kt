package qwbarch.pixelmon

import com.pixelmonmod.pixelmon.Pixelmon
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger

@Mod(modid = RegionalEverstone.MOD_ID, name = RegionalEverstone.MOD_NAME, version = RegionalEverstone.VERSION,
        dependencies = "required-after:pixelmon", acceptableRemoteVersions = "*")
class RegionalEverstone {

    lateinit var logger: Logger private set

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger = event.modLog
        logger.info("Loading v$VERSION")
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent?) {
        Pixelmon.EVENT_BUS.register(BreedingListener::class.java)
    }

    companion object {
        const val MOD_ID = "regionaleverstone"
        const val MOD_NAME = "RegionalEverstone"
        const val VERSION = "1.1"

        @Mod.Instance(MOD_ID)
        lateinit var INSTANCE: RegionalEverstone
    }
} 