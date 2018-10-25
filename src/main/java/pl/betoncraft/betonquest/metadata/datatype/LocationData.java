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

import java.util.Map;

/**
 * Data format which accepts location in the Location Format.
 *
 * @author Jakub Sapalski
 */
public class LocationData extends VariableData<LocationData> {

    protected boolean canHaveDirection = false;

    @Override
    public Type getType() {
        return Type.LOCATION;
    }

    /**
     * Allows adding direction information to the location (yaw and pitch).
     *
     * @return this object
     */
    public LocationData allowDirection() {
        canHaveDirection = true;
        return this;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = super.serialize();

        result.put("direction", canHaveDirection);

        return result;
    }

}