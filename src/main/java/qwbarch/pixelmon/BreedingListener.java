package qwbarch.pixelmon;

import com.pixelmonmod.pixelmon.api.events.BreedEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;
import java.util.Random;

public class BreedingListener {

    private static final Random random = new Random();

    @SubscribeEvent
    public static void onMakeEgg(BreedEvent.MakeEgg event) {
        if (parentIsHoldingEverstone(event.parent1) && parentIsHoldingEverstone(event.parent2)) {
            passRegionalFormToEgg(random.nextInt(2) == 0 ? event.parent1 : event.parent2, event.getEgg());
        } else if (parentIsHoldingEverstone(event.parent1)) {
            passRegionalFormToEgg(event.parent1, event.getEgg());
        } else if (parentIsHoldingEverstone(event.parent2)) {
            passRegionalFormToEgg(event.parent2, event.getEgg());
        }
    }

    private static boolean parentIsHoldingEverstone(Pokemon parent) {
        return Objects.requireNonNull(parent.getHeldItem().getItem().getRegistryName()).toString().equals("pixelmon:ever_stone");
    }

    private static void passRegionalFormToEgg(Pokemon parent, Pokemon egg) {
        egg.setForm(parent.getForm());
    }
}
