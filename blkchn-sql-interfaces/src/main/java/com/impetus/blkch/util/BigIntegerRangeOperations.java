/*******************************************************************************
* * Copyright 2018 Impetus Infotech.
* *
* * Licensed under the Apache License, Version 2.0 (the "License");
* * you may not use this file except in compliance with the License.
* * You may obtain a copy of the License at
* *
* * http://www.apache.org/licenses/LICENSE-2.0
* *
* * Unless required by applicable law or agreed to in writing, software
* * distributed under the License is distributed on an "AS IS" BASIS,
* * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* * See the License for the specific language governing permissions and
* * limitations under the License.
******************************************************************************/
package com.impetus.blkch.util;

import java.math.BigInteger;

public class BigIntegerRangeOperations extends RangeOperations<BigInteger> {

    @Override
    public BigInteger getValue(String valueString) {
        return new BigInteger(valueString);
    }

    @Override
    public BigInteger getMinValue() {
        return new BigInteger("0");
    }

    @Override
    public BigInteger getMaxValue() {
        return new BigInteger(Long.toString(Long.MAX_VALUE));
    }

    @Override
    public BigInteger add(BigInteger value, int step) {
        return value.add(new BigInteger(Integer.toString(step)));
    }

    @Override
    public BigInteger subtract(BigInteger value, int step) {
        return value.subtract(new BigInteger(Integer.toString(step)));
    }

}
