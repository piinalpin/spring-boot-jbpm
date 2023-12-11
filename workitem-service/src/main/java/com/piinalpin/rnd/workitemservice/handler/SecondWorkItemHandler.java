package com.piinalpin.rnd.workitemservice.handler;

import com.piinalpin.rnd.workitemservice.domain.dto.TransactionDto;
import com.piinalpin.rnd.workitemservice.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component("SecondWorkItemHandler")
public class SecondWorkItemHandler implements WorkItemHandler {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        log.info("Executing work item = [SecondWorkItemHandler]");
        TransactionService transactionService = applicationContext.getBean(TransactionService.class);
        TransactionDto transaction = transactionService.save(new BigDecimal("67000000"), "SUCCESS");
        log.info("Transaction = {}", transaction);
        workItemManager.completeWorkItem(workItem.getId(), null);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        log.info("Aborting work item = [SecondWorkItemHandler]");
        workItemManager.abortWorkItem(workItem.getId());
    }
}
