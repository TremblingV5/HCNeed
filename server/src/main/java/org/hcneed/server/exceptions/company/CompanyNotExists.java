package org.hcneed.server.exceptions.company;

import org.hcneed.server.common.exception.BaseException;

public class CompanyNotExists extends BaseException {

    public CompanyNotExists() {
        this.code = 3001;
        this.msg = "Company not exist";
    }
}

