package com.haiyang.flowablespringboot.controller;

import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpenseControllerTest {

    @Mock
    private RuntimeService runtimeService;

    @Mock
    private TaskService taskService;

    @Mock
    private RepositoryService repositoryService;

    @Mock
    private ProcessEngine processEngine;

    @Mock
    private ProcessDiagramGenerator diagramGenerator;

    @InjectMocks
    private ExpenseController expenseController;

    @Test
    public void testAddExpense() {
        String userId = "user1";
        Integer money = 100;
        String descption = "test expense";

        HashMap<String, Object> map = new HashMap<>();
        map.put("taskUser", userId);
        map.put("money", money);

        expenseController.addExpense(userId, money, descption);
    }

    /*@Test
    public void testList() {
        String userId = "user1";

        Task task1 = new Task();
        task1.setId("taskId1");

        Task task2 = new Task();
        task2.setId("taskId2");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        Object result = expenseController.list(userId);
        System.out.println(JSON.toJSONString(result));

    }

    @Test
    public void testApply() {
        String taskId = "taskId";

        Task task = new Task();
        task.setId(taskId);

        when(taskService.createTaskQuery().taskId(taskId).singleResult()).thenReturn(task);

        expenseController.apply(taskId);

        verify(taskService, times(1)).complete(taskId, any(HashMap.class));
    }

    @Test
    public void testReject() {
        String taskId = "taskId";

        expenseController.reject(taskId);

        verify(taskService, times(1)).complete(taskId, any(HashMap.class));
    }

    @Test
    public void testGenProcessDiagram() throws IOException {
        String processId = "processId";

        ProcessInstance pi = new ProcessInstance();
        pi.setProcessInstanceId("instanceId");

        Task task = new Task();
        task.setProcessInstanceId("instanceId");

        when(runtimeService.createProcessInstanceQuery().processInstanceId(processId).singleResult()).thenReturn(pi);
        when(taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult()).thenReturn(task);

        List<Execution> executions = new ArrayList<>();
        Execution execution = new Execution();
        execution.setId("executionId");
        executions.add(execution);

        when(runtimeService.createExecutionQuery().processInstanceId(pi.getId()).list()).thenReturn(executions);

        BpmnModel bpmnModel = new BpmnModel();

        when(repositoryService.getBpmnModel(pi.getProcessDefinitionId())).thenReturn(bpmnModel);

        InputStream in = mock(InputStream.class);
        when(diagramGenerator.generateDiagram(bpmnModel, "png", new ArrayList<>(), new ArrayList<>(), "", "", "", null, 1.0)).thenReturn(in);

        MockHttpServletResponse response = new MockHttpServletResponse();

        expenseController.genProcessDiagram(response, processId);

        verify(response, times(1)).getOutputStream();
    }*/
}
