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

import java.util.HashMap;
import java.util.Map;

import pl.betoncraft.betonquest.BetonQuest;

/**
 * Default implementation of the MetadataProvider.
 *
 * @author Jakub Sapalski
 */
public class DefaultMetadataProvider implements MetadataProvider {

    protected BetonQuest instance;

    protected Map<String, TypeMetadata> events = new HashMap<>();
    protected Map<String, TypeMetadata> conditions = new HashMap<>();
    protected Map<String, TypeMetadata> objectives = new HashMap<>();
    protected Map<String, TypeMetadata> variables = new HashMap<>();

    protected TypeMetadata item;

    public DefaultMetadataProvider(BetonQuest instance) {
        this.instance = instance;
    }

    @Override
    public void registerEventMetadata(String type, TypeMetadata metadata) {
        events.put(type, metadata);
    }

    @Override
    public void registerConditionMetadata(String type, TypeMetadata metadata) {
        conditions.put(type, metadata);
    }

    @Override
    public void registerObjectiveMetadata(String type, TypeMetadata metadata) {
        objectives.put(type, metadata);
    }

    @Override
    public void registerVariableMetadata(String type, TypeMetadata metadata) {
        variables.put(type, metadata);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<>();

        Map<String, Object> events = new HashMap<>();
        this.events.forEach((type, metadata) -> {
            events.put(type, metadata.serialize());
        });
        result.put("events", events);

        Map<String, Object> conditions = new HashMap<>();
        this.conditions.forEach((type, metadata) -> {
            conditions.put(type, metadata.serialize());
        });
        result.put("conditions", conditions);

        Map<String, Object> objectives = new HashMap<>();
        this.objectives.forEach((type, metadata) -> {
            objectives.put(type, metadata.serialize());
        });
        result.put("objectives", objectives);

        Map<String, Object> variables = new HashMap<>();
        this.variables.forEach((type, metadata) -> {
            variables.put(type, metadata.serialize());
        });
        result.put("variables", variables);

        // TODO add items

        // TODO add enums

        return result;
    }

}
