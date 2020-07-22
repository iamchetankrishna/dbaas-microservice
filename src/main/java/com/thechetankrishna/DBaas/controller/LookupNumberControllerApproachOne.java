package com.thechetankrishna.DBaas.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.thechetankrishna.DBaas.model.Action;
import com.thechetankrishna.DBaas.model.LookNumberWithPattern;
import com.thechetankrishna.DBaas.model.LookupNumber;
import com.thechetankrishna.DBaas.model.LookupNumberResponse;
import com.thechetankrishna.DBaas.service.LookupNumberServiceApproachOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Random;

@RestController
@RequestMapping("/approach-1")
public class LookupNumberControllerApproachOne {

    private LookupNumberServiceApproachOne lookupNumberServiceApproachOne;

    @Autowired
    public LookupNumberControllerApproachOne(LookupNumberServiceApproachOne lookupNumberServiceApproachOne){
        this.lookupNumberServiceApproachOne = lookupNumberServiceApproachOne;
    }

    @GetMapping(value = "/{lookupNumber}")
    public ResponseEntity<LookupNumberResponse> searchForLookupNumber(@PathVariable ("lookupNumber") long lookupNumber) {
        LookupNumberResponse lookupNumberResponse = this.lookupNumberServiceApproachOne.searchNumber(lookupNumber);
        return new ResponseEntity<LookupNumberResponse>(lookupNumberResponse, null, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public void addLookUpNumber(@RequestBody HashMap<String, Object> lookupNumber) {
        LookupNumber lookupNumberToDB = new LookupNumber();
        lookupNumberToDB.setAction(Action.BLOCK);
        lookupNumberToDB.setPhoneNumber(Long.parseLong(lookupNumber.get("phoneNumber").toString()));
        lookupNumberServiceApproachOne.addLookupNumber(lookupNumberToDB);
    }

    @PostMapping(value ="/addDummyData")
    public void addDummyData(@RequestBody HashMap<String, Long> dummyData) {
        Long startEntry = dummyData.get("start");
        Long endEntry = dummyData.get("end");
        Long totalLength = endEntry - startEntry;
        System.out.println(totalLength);
        Random random = new Random();
        for (int i = 0; i < totalLength; i++) {
            LookupNumber lookupNumberToDB = new LookupNumber();
            int randInt = random.nextInt(2);
            System.out.println(randInt);
            if(randInt == 1) {
                lookupNumberToDB.setAction(Action.BLOCK);
            }else {
                lookupNumberToDB.setAction(Action.ALLOW);
            }
            lookupNumberToDB.setPhoneNumber(startEntry);
            startEntry++;
            lookupNumberServiceApproachOne.addLookupNumber(lookupNumberToDB);
        }
    }

    @PostMapping(value ="/addDummyDataWithPattern")
    public void addDummyDataWithPattern(@RequestBody HashMap<String, String> patternData) {
        Random random = new Random();
        Boolean containsPattern = Boolean.valueOf(patternData.get("isPattern").toString());
        if (containsPattern) {
            LookNumberWithPattern lookNumberWithPattern = new LookNumberWithPattern();
            if (random.nextInt(2) == 1) {
                lookNumberWithPattern.setAction(Action.BLOCK);
            } else {
                lookNumberWithPattern.setAction(Action.ALLOW);
            }
            lookNumberWithPattern.setPhoneNumber(patternData.get("phoneNumberPattern").toString());
            lookupNumberServiceApproachOne.addLookupPattern(lookNumberWithPattern);
        } else {
            Long startEntry = Long.parseLong(patternData.get("start").toString());
            Long endEntry = Long.parseLong(patternData.get("end").toString());
            Long totalLength = endEntry - startEntry;
            for (int i = 0; i < totalLength; i++) {
                LookNumberWithPattern lookNumberWithPattern = new LookNumberWithPattern();
                int randInt = random.nextInt(2);
                System.out.println(randInt);
                if (randInt == 1) {
                    lookNumberWithPattern.setAction(Action.BLOCK);
                } else {
                    lookNumberWithPattern.setAction(Action.ALLOW);
                }
                lookNumberWithPattern.setPhoneNumber(startEntry.toString());
                startEntry++;
                lookupNumberServiceApproachOne.addLookupPattern(lookNumberWithPattern);
            }
        }
    }

    @PostMapping(value ="/addDummyDataWithPatternApproach4")
    public void addDummyDataWithPatternApproach4(@RequestBody HashMap<String, String> patternData) {
        Random random = new Random();
        Boolean containsPattern = Boolean.valueOf(patternData.get("isPattern").toString());
        if (containsPattern) {
            LookNumberWithPattern lookNumberWithPattern = new LookNumberWithPattern();
            if (random.nextInt(2) == 1) {
                lookNumberWithPattern.setAction(Action.BLOCK);
            } else {
                lookNumberWithPattern.setAction(Action.ALLOW);
            }
            lookNumberWithPattern.setPhoneNumber(patternData.get("phoneNumberPattern").toString());
            lookNumberWithPattern.setPattern(true);
            lookupNumberServiceApproachOne.addLookupPatternApproach4(lookNumberWithPattern);
        } else {
            Long startEntry = Long.parseLong(patternData.get("start").toString());
            Long endEntry = Long.parseLong(patternData.get("end").toString());
            Long totalLength = endEntry - startEntry;
            for (int i = 0; i < totalLength; i++) {
                LookNumberWithPattern lookNumberWithPattern = new LookNumberWithPattern();
                int randInt = random.nextInt(2);
                System.out.println(randInt);
                if (randInt == 1) {
                    lookNumberWithPattern.setAction(Action.BLOCK);
                } else {
                    lookNumberWithPattern.setAction(Action.ALLOW);
                }
                lookNumberWithPattern.setPhoneNumber(startEntry.toString());
                startEntry++;
                lookNumberWithPattern.setPattern(false);
                lookupNumberServiceApproachOne.addLookupPatternApproach4(lookNumberWithPattern);
            }
        }
    }
}
