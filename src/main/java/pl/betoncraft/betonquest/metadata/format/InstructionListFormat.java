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

import java.util.Map;

/**
 * Instruction list format describes the string instruction found in the `run`
 * event and `check` condition.
 *
 * @author Jakub Sapalski
 */
public class InstructionListFormat implements Format {

    @Override
    public Type getType() {
        return Type.MESSAGE_LIST;
    }

    @Override
    public Map<String, Object> serialize() {
        return null; // because instruction list is a format in itself
    }

}