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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Number is a Data with a numeric format.
 *
 * @author Jakub Sapalski
 */
public class NumberData<T extends Number> implements Data {

    /**
     * Type of the number.
     */
    public enum Type {
        INTEGER,
        DECIMAL
    }

    protected List<Class<? extends Number>> integerList = Arrays.asList(Byte.class, Short.class, Integer.class, Long.class);
    protected List<Class<? extends Number>> decimalList = Arrays.asList(Float.class, Double.class);

    protected Optional<T> min = Optional.empty();
    protected Optional<T> max = Optional.empty();
    protected boolean canBeVariable = false;
    protected Type type;

    /**
     * Creates a new NumberData for specified number type.
     *
     * @param clazz the class object of the number type you want to represent in this Data.
     */
    public NumberData(Class<T> clazz) {
        if (integerList.contains(clazz)) {
            type = Type.INTEGER;
        } else if (decimalList.contains(clazz)) {
            type = Type.DECIMAL;
        } else {
            throw new IllegalArgumentException("Class " + clazz.getName() + " is not allowed");
        }
    };

    @Override
    public Data.Type getType() {
        return Data.Type.NUMBER;
    }

    /**
     * Sets the minimum value of the number.
     *
     * @param min minimum value (inclusive)
     * @return this object
     */
    public NumberData<T> setMin(T min) {
        this.min = Optional.of(min);
        return this;
    }

    /**
     * Sets the maximum value of the number.
     *
     * @param max maximum value (inclusive)
     * @return this object
     */
    public NumberData<T> setMax(T max) {
        this.max = Optional.of(max);
        return this;
    }

    /**
     * Makes this Data type accept variables instead of numbers.
     *
     * @return this object.
     */
    public NumberData<T> setCanBeVariable() {
        canBeVariable = true;
        return this;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<>();

        result.put("type", type.toString().toLowerCase());
        result.put("variable", canBeVariable);
        min.ifPresent(value -> result.put("minimum", value));
        max.ifPresent(value -> result.put("maximum", value));

        return result;
    }

}
