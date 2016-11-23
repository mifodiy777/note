package ru.innopolis.note.init;

import org.apache.ignite.Ignition;

/**
 * Created by Кирилл on 23.11.2016.
 */
public class IgniteInitializer {

    public IgniteInitializer() {
        Ignition.start("ignite-context.xml");
    }
}
