package com.pczech.taskmanager.service;

import com.pczech.taskmanager.domain.MaintenanceTask;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MaintenanceTaskService {
    MaintenanceTask save(MaintenanceTask maintenanceTask);

    List<MaintenanceTask> findAll();

    void deleteById(long id);

    MaintenanceTask findById(long id);

    MaintenanceTask modify(MaintenanceTask maintenanceTask, long id);
}
