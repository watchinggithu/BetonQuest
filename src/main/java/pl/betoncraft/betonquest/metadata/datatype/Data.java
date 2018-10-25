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
        NUMBER, STRING
    }

    /**
     * @return the type of this Data.
     */
    public Type getType();

    /**
     * This data type is a number. You can add constraints, make it accept variables
     * etc. Use it if you need a simple numeric argument.
     *
     * It takes a single argument - a number class. Usually it's enough to pass
     * `Integer.class` if you need integer values and `Float.class` if you need
     * decimals.
     *
     * @param clazz
     *                  the class of the number you want to use
     * @return the NumberData instance
     */
    public static <T extends Number> NumberData<T> number(Class<T> clazz) {
        return new NumberData<>(clazz);
    }

    /**
     * This data type is a string. Use it if your argument can be anything the user
     * enters or if validating this is too complex / requires runtime checks (i.e.
     * object names from another plugin). Remember to specify the character which
     * will be replaced with a space!
     *
     * @return the StringData instance
     */
    public static StringData string() {
        return new StringData();
    }

}
