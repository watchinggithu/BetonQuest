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

import java.util.List;

/**
 * Main storage of the type metadata of the plugin.
 *
 * @author Jakub Sapalski
 */
public interface MetadataProvider extends Serializable {

    /**
     * @param type
     *                     name of the type metadata, the same as when registering
     *                     actual types
     * @param metadata
     *                     TypeMetadata instance with type specification
     */
    public void registerEventMetadata(String type, TypeMetadata metadata);

    /**
     * @param type
     *                     name of the type metadata, the same as when registering
     *                     actual types
     * @param metadata
     *                     TypeMetadata instance with type specification
     */
    public void registerConditionMetadata(String type, TypeMetadata metadata);

    /**
     * @param type
     *                     name of the type metadata, the same as when registering
     *                     actual types
     * @param metadata
     *                     TypeMetadata instance with type specification
     */
    public void registerObjectiveMetadata(String type, TypeMetadata metadata);

    /**
     * @param type
     *                     name of the type metadata, the same as when registering
     *                     actual types
     * @param metadata
     *                     TypeMetadata instance with type specification
     */
    public void registerVariableMetadata(String type, TypeMetadata metadata);

    /**
     * @param name
     *                     the name under which this list of variants should be
     *                     registered. Consecutive adding under the same name will
     *                     be ignored
     * @param variants
     *                     the list of variants to add
     */
    public void addVariants(String name, List<String> variants);

}
