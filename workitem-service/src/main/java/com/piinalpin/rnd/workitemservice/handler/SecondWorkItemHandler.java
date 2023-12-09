package com.piinalpin.rnd.workitemservice.handler;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.stereotype.Component;

@Slf4j
@Component("SecondWorkItemHandler")
public class SecondWorkItemHandler implements WorkItemHandler {
    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        log.info("Executing work item = [SecondWorkItemHandler]");
        workItemManager.completeWorkItem(workItem.getId(), null);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        log.info("Aborting work item = [SecondWorkItemHandler]");
        workItemManager.abortWorkItem(workItem.getId());
    }
}
