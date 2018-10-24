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

import pl.betoncraft.betonquest.metadata.Serializable;

/**
 * Stores specification of the type's instruction string.
 *
 * @author Jakub Sapalski
 */
public interface Format extends Serializable {

    /**
     * Type of the Format.
     */
    public enum Type {
        ARGUMENT_LIST, MESSAGE_MAP, MESSAGE_LIST, INSTRUCTION_LIST,
    }

    /**
     * @return the Format's type.
     */
    public Type getType();

    /**
     * Argument-based format of the instruction string. Choose this format if your
     * instruction string consists of arguments separated by spaces (or dots in case
     * of a variable). Required arguments come first in a specified order, optional
     * arguments come next and are prefixed with their name.
     *
     * @return ArgumentFormat instance
     */
    public static ArgumentFormat argument() {
        return new ArgumentFormat();
    }

    /**
     * MessageMap format is a format where instruction string is taken literally as
     * a message. It is separated into a map of messages by inserting `{key}`
     * strings between them. This is done for example in the `message` event (which
     * allows the whole instruction to take a literal form without a key specified).
     *
     * @return MessageMapFormat instance
     */
    public static MessageMapFormat messageMap() {
        return new MessageMapFormat();
    }

    /**
     * MessageList format allows specifying a list of literal messages separated by
     * a string. An example is the `command` event which has a list of commands
     * separated by the `|` character.
     *
     * @return MessageListFormat instance
     */
    public static MessageListFormat messageList(String separator) {
        return new MessageListFormat(separator);
    }

    /**
     * InstuctionList is a list of instructions, the same as in `run` event and
     * `check` condition.
     *
     * @return InstructionListFormat instance
     */
    public static InstructionListFormat instructionList() {
        return new InstructionListFormat();
    }

}
