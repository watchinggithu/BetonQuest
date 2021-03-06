package pl.betoncraft.betonquest.compatibility.mmogroup.mmoitems;

import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.Type;
import net.Indyuce.mmoitems.manager.TypeManager;
import net.mmogroup.mmolib.api.item.NBTItem;
import org.bukkit.inventory.ItemStack;
import pl.betoncraft.betonquest.Instruction;
import pl.betoncraft.betonquest.api.Condition;
import pl.betoncraft.betonquest.exceptions.InstructionParseException;
import pl.betoncraft.betonquest.exceptions.QuestRuntimeException;
import pl.betoncraft.betonquest.utils.PlayerConverter;

import java.util.ArrayList;

public class MMOItemsItemCondition extends Condition {

    private final Type itemType;
    private final String itemID;
    private int amount = 1;

    public MMOItemsItemCondition(final Instruction instruction) throws InstructionParseException {
        super(instruction, true);

        final TypeManager typeManager = MMOItems.plugin.getTypes();
        itemType = typeManager.get(instruction.next());
        itemID = instruction.next();

        final ArrayList<Integer> potentialAmount = instruction.getAllNumbers();
        if (!potentialAmount.isEmpty()) {
            amount = potentialAmount.get(0);
        }
    }

    @Override
    protected Boolean execute(final String playerID) throws QuestRuntimeException {
        final ItemStack[] inventoryItems = PlayerConverter.getPlayer(playerID).getInventory().getContents();

        int counter = 0;
        for (final ItemStack item : inventoryItems) {
            if (item == null) {
                continue;
            }
            final NBTItem realItemNBT = NBTItem.get(item);
            final String realItemType = realItemNBT.getString("MMOITEMS_ITEM_TYPE");
            final String realItemID = realItemNBT.getString("MMOITEMS_ITEM_ID");

            if (realItemID.equalsIgnoreCase(itemID) && realItemType.equalsIgnoreCase(itemType.getId())) {
                counter++;
            }
        }
        return counter == amount;
    }
}
