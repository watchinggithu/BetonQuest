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
package pl.betoncraft.betonquest.metadata.text;

import java.util.HashMap;
import java.util.Map;

/**
 * A single string based implementation of Text. It will always translate to the same string
 * specified in the constructor.
 *
 * @author Jakub Sapalski
 */
public class StringText implements Text {

    protected String text;

    /**
     * Creates a new Text using specified string directly for all translations.
     *
     * @param text string to use as the Text
     */
    public StringText(String text) {
        this.text = text;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<>();

        result.put("default", text);

        return result;
    }

}
