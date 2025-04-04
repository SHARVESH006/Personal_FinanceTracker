package com.example.project.service;

import com.example.project.entity.Goal;
import com.example.project.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> getAllGoals() {
        return goalRepository.findAll();
    }

    public Optional<Goal> getGoalById(Long id) {
        return goalRepository.findById(id);
    }

    public Goal saveGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }
    
    public Goal updateid(Long id, Goal goalDetails) {
        if (goalRepository.existsById(id)) {
            Goal obj = goalRepository.findById(id).get();
            obj.setId(id);
            obj.setName(goalDetails.getName());
            obj.setTargetAmount(goalDetails.getTargetAmount());
            obj.setCurrentAmount(goalDetails.getCurrentAmount());
            return goalRepository.save(obj);
        }
        return null;
    }

}
