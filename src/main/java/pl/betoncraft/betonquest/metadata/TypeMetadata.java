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

import java.util.Optional;

import pl.betoncraft.betonquest.metadata.format.Format;
import pl.betoncraft.betonquest.metadata.text.Text;

/**
 * TypeMetadata stores information about a single type (i.e. the 'location' objective).
 *
 * @author Jakub Sapalski
 */
public interface TypeMetadata extends Serializable {

    /**
     * @return the translatable name of the type. This text will be displayed to the user.
     */
    public Optional<Text> getName();

    /**
     * @return the translatable description of the type. This text will be displayed to the user.
     */
    public Optional<Text> getDescription();

    /**
     * @return the type's format specification
     */
    public Optional<Format> getFormat();

}
