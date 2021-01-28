package com.yuanwj.batch.step;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @description:
 * @author: yuanwj
 * @date: 2020/09/28 18:15
 **/
@Component
public class BatchWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> list) throws Exception {
        for (String message : list) {
            System.out.println(message);
        }
    }
}
