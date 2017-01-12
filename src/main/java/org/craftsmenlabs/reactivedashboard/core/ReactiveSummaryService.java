package org.craftsmenlabs.reactivedashboard.core;

import org.craftsmenlabs.stories.api.models.summary.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class ReactiveSummaryService {

    @Autowired
    private ReactiveSummaryRepository summaryRepository;


    public Flux<Summary> getSummariesFromProjects(String projectId) {
        return summaryRepository.findByProjectToken(projectId);
    }
}
