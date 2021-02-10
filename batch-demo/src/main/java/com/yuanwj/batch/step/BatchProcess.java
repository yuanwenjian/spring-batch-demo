package com.yuanwj.batch.step;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: yuanwj
 * @date: 2020/09/28 18:16
 **/
@Component
public class BatchProcess implements ItemProcessor<String, String> {

    public String process(String s) throws Exception {
        return s + "=======";
    }
}
