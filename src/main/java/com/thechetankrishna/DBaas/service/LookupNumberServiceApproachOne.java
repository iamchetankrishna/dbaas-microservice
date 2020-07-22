package com.thechetankrishna.DBaas.service;

import com.thechetankrishna.DBaas.interfaces.LookupService;
import com.thechetankrishna.DBaas.mapper.LookUpNumberMapper;
import com.thechetankrishna.DBaas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LookupNumberServiceApproachOne implements LookupService {

    private LookUpNumberMapper lookUpNumberMapper;

    @Autowired
    public LookupNumberServiceApproachOne(LookUpNumberMapper lookUpNumberMapper) {
        this.lookUpNumberMapper = lookUpNumberMapper;
    }


    @Override
    public LookupNumberResponse searchNumber(long lookupNumber) {
        long startTime = System.currentTimeMillis();
        LookupNumber lookupNumberFromDB = lookUpNumberMapper.getByPhoneNumber(lookupNumber);
        LookupNumberResponse lookupNumberResponse = new LookupNumberResponse();
        lookupNumberResponse.setId(lookupNumberFromDB.getId());
        lookupNumberResponse.setPhoneNumber(lookupNumberFromDB.getPhoneNumber());
        lookupNumberResponse.setAction(lookupNumberFromDB.getAction());
        long endTime = System.currentTimeMillis();
        lookupNumberResponse.setResponseTime(endTime - startTime);
        return lookupNumberResponse;
    }

    @Override
    public LookupNumber addLookupNumber(LookupNumber lookupNumber) {
        lookUpNumberMapper.insert(lookupNumber);
        return null;
    }

    @Override
    public LookupNumberPattern addLookupPattern(LookNumberWithPattern lookupPattern) {
        lookUpNumberMapper.insertApproachThreePattern(lookupPattern);
        return null;
    }

    @Override
    public LookupNumberPattern addLookupPatternApproach4(LookNumberWithPattern lookNumberWithPattern) {
        if (lookNumberWithPattern.getPattern()) {
           //Wildcard
           lookUpNumberMapper.insertApproachFourPatternTrue(lookNumberWithPattern);
        }else {
           //Normal
           lookUpNumberMapper.insertApproachFourPatternFalse(lookNumberWithPattern);
        }
        return null;
    }
}
