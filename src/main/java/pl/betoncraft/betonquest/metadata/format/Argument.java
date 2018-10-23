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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import pl.betoncraft.betonquest.metadata.Serializable;
import pl.betoncraft.betonquest.metadata.datatype.Data;
import pl.betoncraft.betonquest.metadata.text.Text;

/**
 * Basic implementation of the Argument.
 *
 * @author Jakub Sapalski
 */
public class Argument implements Serializable {

    protected Optional<Text> name = Optional.empty();
    protected Optional<Text> desc = Optional.empty();
    protected Optional<Data> data = Optional.empty();

    /**
     * @param name the Text containing the name of this argument
     * @return this object
     */
    public Argument setName(Text name) {
        this.name = Optional.of(name);
        return this;
    }

    /**
     * @param name the Text describing this argument
     * @return this object
     */
    public Argument setDescription(Text description) {
        this.desc = Optional.of(description);
        return this;
    }

    /**
     * @param name the Data specification of this argument
     * @return this object
     */
    public Argument setData(Data data) {
        this.data = Optional.of(data);
        return this;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new HashMap<>();

        name.ifPresent(value -> result.put("name", value.serialize()));
        desc.ifPresent(value -> result.put("description", value.serialize()));
        data.ifPresent(value -> {
            result.put("type", value.getType().toString().toLowerCase());
            result.put("data", value.serialize());
        });

        return result;
    }

}
