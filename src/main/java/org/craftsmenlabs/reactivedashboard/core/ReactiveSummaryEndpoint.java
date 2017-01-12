package org.craftsmenlabs.reactivedashboard.core;


import lombok.RequiredArgsConstructor;
import org.craftsmenlabs.stories.api.models.summary.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(value = "/api/dashboard/v1/company")
public class ReactiveSummaryEndpoint {
    private final ReactiveSummaryService summaryService;

    @GetMapping(value = "/{projectId}/summary")
    public Flux<Summary> getCompanySummary(@PathVariable("projects") String projectId){

        return summaryService.getSummariesFromProjects(projectId);
    }
}
