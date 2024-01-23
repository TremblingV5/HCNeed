package org.hcneed.server.exceptions.position;

import org.hcneed.server.common.exception.BaseException;

public class PositionNotExists extends BaseException {

        public PositionNotExists() {
            this.code = 2001;
            this.msg = "Position not exist";
        }
    }

