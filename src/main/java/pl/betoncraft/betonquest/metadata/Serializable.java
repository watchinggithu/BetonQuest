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
package pl.betoncraft.betonquest.metadata;

import java.util.Map;

/**
 * Serializable allows objects to return a dynamic data structure representing their state.
 * To avoid problems only these types of values are allowed: String, Integer, Double, Boolean,
 * List of any of the allowed types, Map representing a nested object (with the same rules applying).
 * No nulls allowed - instead simply skip the key.
 *
 * @author Jakub Sapalski
 */
public interface Serializable {

    /**
     * @return a map representing the internal state of the object.
     */
    public Map<String, Object> serialize();

}
