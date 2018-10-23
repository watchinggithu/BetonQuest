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
import java.util.Optional;

import pl.betoncraft.betonquest.metadata.format.Format;
import pl.betoncraft.betonquest.metadata.text.Text;

/**
 * Default implementation of the TypeMetadata interface.
 *
 * @author Jakub Sapalski
 */
public class DefaultTypeMetadata implements TypeMetadata {

    protected Optional<Text> name = Optional.empty();
    protected Optional<Text> desc = Optional.empty();
    protected Optional<Format> fmt = Optional.empty();

    /**
     * @param name Text containing the name of the type
     * @return this object
     */
    public DefaultTypeMetadata setName(Text name) {
        this.name = Optional.of(name);
        return this;
    }

    /**
     * @param description Text describing the type
     * @return this object
     */
    public DefaultTypeMetadata setDescription(Text description) {
        this.desc = Optional.of(description);
        return this;
    }

    /**
     * @param format Format of the type
     * @return this object
     */
    public DefaultTypeMetadata setFormat(Format format) {
        this.fmt = Optional.of(format);
        return this;
    }

    @Override
    public Optional<Text> getName() {
        return name;
    }

    @Override
    public Optional<Text> getDescription() {
        return desc;
    }

    @Override
    public Optional<Format> getFormat() {
        return fmt;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<>();

        name.ifPresent(value -> result.put("name", value.serialize()));
        desc.ifPresent(value -> result.put("description", value.serialize()));
        fmt.ifPresent(value -> {
            result.put("type", value.getType().toString().toLowerCase());
            result.put("format", value.serialize());
        });

        return result;
    }

}
