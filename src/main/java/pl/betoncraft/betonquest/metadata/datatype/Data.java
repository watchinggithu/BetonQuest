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

import pl.betoncraft.betonquest.metadata.Serializable;

/**
 * Represents a data type of the Argument.
 *
 * @author Jakub Sapalski
 */
public interface Data extends Serializable {

    /**
     * Type of the Data object.
     */
    public enum Type {
        NUMBER
    }

    /**
     * @return the type of this Data.
     */
    public Type getType();

}
