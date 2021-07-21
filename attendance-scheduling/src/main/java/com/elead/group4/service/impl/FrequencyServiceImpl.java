package com.elead.group4.service.impl;

import com.elead.group4.mapper.FrequencyMapper;
import com.elead.group4.pojo.Frequency;
import com.elead.group4.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrequencyServiceImpl implements FrequencyService {
    @Autowired
    FrequencyMapper frequencyMapper;

    @Override
    public List<Frequency> getFrequency() {
        return frequencyMapper.selectAll();
    }
}
