package com.yuanwj.batch.step;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

/**
 *  Copyright 天阳宏业科技股份有限公司 - All Rights Reserved
 *
 * @description:
 * @author: yuanwj
 * @date: 2020/09/28 18:12
 **/
@Component
public class BatchReader implements ItemReader<String > {

    private Integer count =0;

    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (count++ < 2) {
            return "success";
        }else {
            count = 0;
        }
        return null;
    }
}
