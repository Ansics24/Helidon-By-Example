package de.schulte.smartbar.backoffice.tables;

import java.util.List;

import de.schulte.smartbar.backoffice.SmartbarEntity;

public interface TablesService {

    List<SmartbarTable> listAll();

    SmartbarTable insertNew(SmartbarTable table);

    SmartbarTable update(int id, SmartbarTable table);

}
