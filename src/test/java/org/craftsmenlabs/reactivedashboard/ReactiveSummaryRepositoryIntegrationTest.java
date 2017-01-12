package org.craftsmenlabs.reactivedashboard;

import org.craftsmenlabs.stories.api.models.summary.Summary;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveSummaryRepositoryIntegrationTest {

    @Autowired
    ReactiveMongoTemplate template;

    @Before
    public void setUp() {

    }

    @Test
    public void retrieveSummary(){
        template.count(new Query(), Summary.class)
                .doOnNext(System.out::println);

    }
}
