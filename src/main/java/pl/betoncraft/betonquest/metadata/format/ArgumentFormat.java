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
package pl.betoncraft.betonquest.metadata.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Argument based implementation of the type Format. Contains an ordered list
 * of required Arguments and a string-Argument map of optional arguments.
 *
 * @author Jakub Sapalski
 */
public class ArgumentFormat implements Format {

    protected List<Argument> required = new ArrayList<>();
    protected Map<String, Argument> optional = new HashMap<>();

    @Override
    public Type getType() {
        return Format.Type.ARGUMENT_LIST;
    }

    /**
     * Adds a required Argument to this Format. Each invocation of this method will create another required argument.
     * The order of the arguments will follow the order of invocations.
     *
     * @param argument Argument to require next
     * @return this object
     */
    public ArgumentFormat require(Argument argument) {
        required.add(argument);
        return this;
    }

    /**
     * Adds an optional Argument with specified name.
     *
     * @param name name of the optional argument
     * @param argument optional Argument for this format
     * @return this object
     */
    public ArgumentFormat allow(String name, Argument argument) {
        optional.put(name, argument);
        return this;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<>();

        result.put("required", required.stream().map(arg -> arg.serialize()).collect(Collectors.toList()));
        result.put("optional", optional.entrySet().stream().collect(
                Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().serialize()
                )
        ));

        return result;
    }

}
