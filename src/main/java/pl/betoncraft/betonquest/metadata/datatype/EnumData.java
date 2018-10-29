/**
 * BetonQuest - advanced quests for Bukkit
 * Copyright (C) 2018  Jakub "Co0sh" Sapalski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pl.betoncraft.betonquest.metadata.datatype;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pl.betoncraft.betonquest.BetonQuest;

/**
 * Enum data type allows one of specified variants to be used. Creating an enum
 * adds all its variants to a global list under a specific name. Creating an
 * enum with the same name second time will be ignored.
 *
 * @author Jakub Sapalski
 */
public class EnumData extends VariableData<EnumData> {

    public String name;
    public List<String> variants;

    /**
     * Creates a new enum data type out of a list of strings. The list will receive
     * specified name in the global list.
     *
     * @param name
     *                     name of the list
     * @param variants
     *                     list of variants
     */
    public EnumData(String name, List<String> variants) {
        this.variants = new ArrayList<>(variants);
        this.name = name;
        register();
    }

    /**
     * Creates a new enum data type out of an enum. Registers all enum values under
     * the enum's lowercase name.
     *
     * @param enuum
     *                  the class of the enum
     */
    public EnumData(Class<?> enuum) {
        this.variants = Stream.of(enuum.getEnumConstants())
                .map(value -> value.toString())
                .collect(Collectors.toList());
        this.name = "enum/" + enuum.getSimpleName().toLowerCase();
        register();
    }

    @Override
    public Type getType() {
        return Type.ENUM;
    }

    protected void register() {
        BetonQuest.getInstance().getMetadataProvider().addVariants(name, variants);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = super.serialize();

        result.put("name", name);

        return result;
    }

}