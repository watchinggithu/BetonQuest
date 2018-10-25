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

import java.util.HashMap;
import java.util.Map;

/**
 * Base class for all data types which can be replaced with a variable.
 *
 * @param <T> the subclass type (this is important)
 */
public abstract class VariableData<T extends VariableData<T>> implements Data {

    protected boolean canBeVariable = false;

    /**
     * Makes this data type accept variables instead of a concrete type.
     *
     * @return this object
     */
    @SuppressWarnings("unchecked")
    public T allowVariable() {
        canBeVariable = true;
        return (T) this;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<>();

        result.putIfAbsent("variable", canBeVariable);

        return result;
    }

}