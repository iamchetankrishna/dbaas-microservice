package com.thechetankrishna.DBaas.interfaces;

import com.thechetankrishna.DBaas.model.LookNumberWithPattern;
import com.thechetankrishna.DBaas.model.LookupNumber;
import com.thechetankrishna.DBaas.model.LookupNumberPattern;
import com.thechetankrishna.DBaas.model.LookupNumberResponse;

public interface LookupService {

    public LookupNumberResponse searchNumber(long lookupNumber);
    public LookupNumber addLookupNumber(LookupNumber lookupNumber);
    public LookupNumberPattern addLookupPattern(LookNumberWithPattern lookupPattern);
    public LookupNumberPattern addLookupPatternApproach4(LookNumberWithPattern lookNumberWithPattern);
}
