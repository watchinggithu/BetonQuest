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

import java.util.List;

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
        NUMBER, STRING, LOCATION, ENUM
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

    /**
     * This data type accepts locations. You should probably enable variables. If
     * you want your locations to include direction (yaw and pitch), there's a
     * method for that.
     *
     * @return the LocationData instance
     */
    public static LocationData location() {
        return new LocationData();
    }

    /**
     * This data type accepts an enum. You should use it if the argument will be
     * directly translated to a Java Enum instance. Otherwise use a version of this
     * method which accepts a List of Strings. Pass the class of that enum as an
     * argument.
     *
     * @param enum
     *            the class of an enum
     *
     * @return the EnumData instance
     */
    public static EnumData variant(Class<?> enuum) {
        return new EnumData(enuum);
    }

    /**
     * This data type accepts a variant from a list. You should use it if the
     * argument must be one of some specific words. If the list of words are all
     * values of a Java Enum then you can use a version of this method which accepts
     * an Enum class. Pass the name of your variant and the list of Strings as
     * arguments. The name must be unique, or your variants will get overriden by
     * something else!
     *
     * @param name
     *                     the unique name of this list
     * @param variants
     *                     a list of words to choose from
     *
     * @return the EnumData instance
     */
    public static EnumData variant(String name, List<String> variants) {
        return new EnumData(name, variants);
    }

}
