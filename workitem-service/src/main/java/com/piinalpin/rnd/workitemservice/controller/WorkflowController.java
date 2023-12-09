package com.piinalpin.rnd.workitemservice.controller;

import com.piinalpin.rnd.workitemservice.domain.dto.WorkflowDto;
import lombok.extern.slf4j.Slf4j;
import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.model.ProcessInstanceDesc;
import org.kie.server.springboot.jbpm.ContainerAliasResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/process")
public class WorkflowController {

    private final ProcessService processService;
    private final ContainerAliasResolver containerAliasResolver;
    private final RuntimeDataService runtimeDataService;

    @Value("${jbpm.container.alias}")
    private String alias;

    public WorkflowController(ProcessService processService, ContainerAliasResolver containerAliasResolver, RuntimeDataService runtimeDataService) {
        this.processService = processService;
        this.containerAliasResolver = containerAliasResolver;
        this.runtimeDataService = runtimeDataService;
    }

    @GetMapping("/{processId}/execute")
    public ResponseEntity<WorkflowDto> executeWorkflow(@PathVariable String processId) {
        log.info("REST execute workflow");
        String containerId = containerAliasResolver.latest(alias);
        log.info("Create process instance :: [{} | {}]", containerId, processId);

        Long processInstanceId = processService.startProcess(containerId, processId);
        ProcessInstanceDesc processInstance = runtimeDataService.getProcessInstanceById(processInstanceId);
        return ResponseEntity.ok(WorkflowDto.builder()
                        .status("00")
                        .message("Success")
                        .processInstance(processInstance)
                .build());
    }

}
