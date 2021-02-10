package com.yuanwj.batch.config;

import com.yuanwj.batch.step.BatchProcess;
import com.yuanwj.batch.step.BatchReader;
import com.yuanwj.batch.step.BatchWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @description:
 * @author: yuanwj
 * @date: 2020/09/28 18:20
 **/
@Configuration
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private BatchReader batchReader;

    @Autowired
    private BatchWriter batchWriter;

//    @Autowired
//    private DataSourceTransactionManager transactionManager;


//    @Bean
//    protected JobRepository createJobRepository(@Qualifier("batchDataSource") DataSource dataSource,
//                                                @Qualifier("batchTransactionManager") DataSourceTransactionManager transactionManager)
//            throws Exception {
//        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setTransactionManager(transactionManager);
//        factory.setIsolationLevelForCreate("ISOLATION_REPEATABLE_READ");
//        return factory.getObject();
//    }

//    @Bean
//    protected JobRepository createJobRepository(DataSource dataSource,
//                                                DataSourceTransactionManager transactionManager)
//            throws Exception {
//        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setTransactionManager(transactionManager);
//        factory.setIsolationLevelForCreate("ISOLATION_REPEATABLE_READ");
//        return factory.getObject();
//    }
//    @Bean
//    public BatchReader itemReader() {
//        return new BatchReader();
//    }
//
//    @Bean
//    public BatchWriter itemWriter() {
//        return new BatchWriter();
//    }
//
//    @Bean
//    public BatchProcess itemProcessor() {
//        return new BatchProcess();
//    }

    @Bean
    public Step step(ItemProcessor itemProcessor) {
        return stepBuilderFactory.get("batchJob")
                .chunk(2)
                .reader(batchReader)
                .processor(itemProcessor)
                .writer(batchWriter)
                .build();
    }

    @Bean
    public Job job(Step step) {
        return jobBuilderFactory.get("batchJob").start(step).build();
    }
}
