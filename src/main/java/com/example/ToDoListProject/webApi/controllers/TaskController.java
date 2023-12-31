package com.example.ToDoListProject.webApi.controllers;

import com.example.ToDoListProject.business.abstracts.TaskService;
import com.example.ToDoListProject.business.requests.tasks.CreatePageRequest;
import com.example.ToDoListProject.business.requests.tasks.CreateTaskRequest;
import com.example.ToDoListProject.business.requests.tasks.DeleteTaskRequest;
import com.example.ToDoListProject.business.requests.tasks.UpdateTaskRequest;
import com.example.ToDoListProject.business.responses.tasks.CreateTaskResponse;
import com.example.ToDoListProject.business.responses.tasks.GetByIdTaskResponse;
import com.example.ToDoListProject.business.responses.tasks.UpdateTaskResponse;
import com.example.ToDoListProject.core.results.DataResult;
import com.example.ToDoListProject.core.results.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController extends BaseController {
    private final TaskService _taskService;

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
        return GetDataResponseOnlyResultData(_taskService.getAll());
    }

    @GetMapping("getallsorted")
    public ResponseEntity<?> getAllSorted(@RequestBody CreatePageRequest createPageRequest
    ) {
        return GetDataResponseOnlyResultData(_taskService.getAllSorted(createPageRequest));
    }
    @GetMapping("search")
    public ResponseEntity<?> getAllSearch(@RequestParam("keyword") String keyword
    ) {
        return GetDataResponseOnlyResultData(_taskService.getAllSearch(keyword));
    }
    @GetMapping("getbyid/{id}")
    public DataResult<GetByIdTaskResponse> getById(@PathVariable int id) {
        return _taskService.getById(id);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody CreateTaskRequest request) {
        DataResult<CreateTaskResponse> result = _taskService.add(request);
        return GetDataResponseOnlyResultData(result);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateTaskRequest request) {
        DataResult<UpdateTaskResponse> result = _taskService.update(request);
        return GetDataResponseOnlyResultData(result);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@RequestBody @Valid DeleteTaskRequest request) {
        Result result = _taskService.delete(request);
        return GetDataResponseOnlyResult(result);
    }
}