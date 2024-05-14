package com.uptc.frm.rediscache.controller;


import com.uptc.frm.rediscache.jpa.entity.Interview;
import com.uptc.frm.rediscache.jpa.repository.InterviewRepository;
import com.uptc.frm.rediscache.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviewService.findAll();
    }

    @GetMapping("/{idInterview}")
    public Interview getByIdInterview(@PathVariable int idInterview) {
        return interviewService.findById(idInterview);
    }

    @PostMapping
    public Interview createInterview(@RequestBody Interview interview) {
        return interviewService.saveInterview(interview);
    }

    @PutMapping("/{idInterview}")
    public Interview updateInterview(@PathVariable int idInterview, @RequestBody Interview interview) {
        return interviewService.update(idInterview, interview);
    }

    @DeleteMapping("/{idInterview}")
    public void deleteInterview(@PathVariable int idInterview) {
        interviewService.delete(idInterview);
    }

}
