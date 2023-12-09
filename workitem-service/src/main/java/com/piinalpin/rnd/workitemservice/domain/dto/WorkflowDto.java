package com.piinalpin.rnd.workitemservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jbpm.services.api.model.ProcessInstanceDesc;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowDto {

    private String status;
    private String message;
    private ProcessInstanceDesc processInstance;

}
