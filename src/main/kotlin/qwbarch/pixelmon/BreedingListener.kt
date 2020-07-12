package qwbarch.pixelmon

import com.pixelmonmod.pixelmon.api.events.BreedEvent
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

object BreedingListener {

    @SubscribeEvent
    @JvmStatic
    fun onMakeEgg(event: BreedEvent.MakeEgg) {
        if (parentIsHoldingEverstone(event.parent1) &&
                parentIsHoldingEverstone(event.parent2)) {
            passRegionalFormToEgg(if ((0..1).random() == 0) event.parent1 else event.parent2, event.egg)
        } else if (parentIsHoldingEverstone(event.parent1)) {
            passRegionalFormToEgg(event.parent1, event.egg)
        } else if (parentIsHoldingEverstone(event.parent2)) {
            passRegionalFormToEgg(event.parent2, event.egg)
        }
    }

    private fun parentIsHoldingEverstone(parent: Pokemon): Boolean {
        return parent.heldItem.item.registryName.toString() == "pixelmon:ever_stone"
    }

    private fun passRegionalFormToEgg(parent: Pokemon, egg: Pokemon) {
        egg.form = parent.form
    }
}