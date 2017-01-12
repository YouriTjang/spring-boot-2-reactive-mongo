package org.craftsmenlabs.reactivedashboard.core;

import org.craftsmenlabs.stories.api.models.StoriesRun;
import org.craftsmenlabs.stories.api.models.summary.Summary;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ReactiveSummaryRepository extends ReactiveMongoRepository<StoriesRun,String> {

    @Query(value="{ 'projectToken' : ?0 }", fields="{'summary' : 1, '_id':0 }")
    Flux<Summary> findByProjectToken(String projectToken);

}
