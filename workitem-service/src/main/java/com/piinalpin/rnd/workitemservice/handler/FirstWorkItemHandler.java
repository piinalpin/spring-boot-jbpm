package com.piinalpin.rnd.workitemservice.handler;

import com.piinalpin.rnd.workitemservice.domain.dto.FinancingDto;
import com.piinalpin.rnd.workitemservice.service.FinancingService;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component("FirstWorkItemHandler")
public class FirstWorkItemHandler implements WorkItemHandler {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        log.info("Executing work item = [FirstWorkItemHandler]");
        FinancingService financingService = applicationContext.getBean(FinancingService.class);
        FinancingDto financing = financingService.save(FinancingDto.builder()
                        .amount(new BigDecimal("2200000"))
                        .type("ANY")
                .build());
        log.info("Financing :: {}", financing);
        workItemManager.completeWorkItem(workItem.getId(), null);
    }

    @Override
    public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
        log.info("Aborting work item = [FirstWorkItemHandler]");
        workItemManager.abortWorkItem(workItem.getId());
    }

}
