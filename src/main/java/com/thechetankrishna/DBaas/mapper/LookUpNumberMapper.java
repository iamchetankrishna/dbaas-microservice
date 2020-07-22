package com.thechetankrishna.DBaas.mapper;

import com.thechetankrishna.DBaas.model.LookNumberWithPattern;
import com.thechetankrishna.DBaas.model.LookupNumber;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LookUpNumberMapper {

    @Select("Select * from sys.lookupNumber where phoneNumber=#{phoneNumber}")
    LookupNumber getByPhoneNumber(long phoneNumber);

    @Insert("Insert into sys.lookupNumber (phoneNumber, action) VALUES (#{phoneNumber}, #{action})")
    void insert(LookupNumber lookupNumber);

    @Insert("Insert into sys.lookupNumberApproachThree (phoneNumber, action) VALUES (#{phoneNumber}, #{action})")
    void insertApproachThreePattern(LookNumberWithPattern lookupNumberWithPattern);

    @Insert("Insert into sys.lookupNumberApproachFour (phoneNumber, action) VALUES (#{phoneNumber}, #{action})")
    void insertApproachFourPatternFalse(LookNumberWithPattern lookupNumberWithPattern);

    @Insert("Insert into sys.lookupNumberApproachFourWildCard (phoneNumber, action) VALUES (#{phoneNumber}, #{action})")
    void insertApproachFourPatternTrue(LookNumberWithPattern lookupNumberWithPattern);
}
