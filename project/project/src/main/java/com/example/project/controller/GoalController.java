package com.example.project.controller;

import com.example.project.entity.Goal;
import com.example.project.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping
    public List<Goal> getAllGoals() {
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public Optional<Goal> getGoalById(@PathVariable Long id) {
        return goalService.getGoalById(id);
    }

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return goalService.saveGoal(goal);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id);
    }
    
    @PutMapping("/updatee/{id}")
    public Goal updatebyid(@PathVariable Long id, @RequestBody Goal goalDetails) {
        return goalService.updateid(id, goalDetails);
    }

}
