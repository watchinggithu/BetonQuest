package pl.betoncraft.betonquest.compatibility.mmogroup.mmocore;

import pl.betoncraft.betonquest.BetonQuest;
import pl.betoncraft.betonquest.compatibility.Integrator;

public class MMOCoreIntegrator implements Integrator {

    public MMOCoreIntegrator() {}

    @Override
    public void hook() {
        MMOCoreUtils.loadMMOCoreAttributeConfig();
        final BetonQuest plugin = BetonQuest.getInstance();

        plugin.registerConditions("mmoclass", MMOCoreClassCondition.class);
        plugin.registerConditions("mmoattribute", MMOCoreAttributeCondition.class);
        plugin.registerConditions("mmoprofession", MMOCoreProfessionLevelCondition.class);
    }

    @Override
    public void reload() {

    }

    @Override
    public void close() {

    }
}
