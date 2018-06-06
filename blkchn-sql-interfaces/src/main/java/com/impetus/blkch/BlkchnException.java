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
package com.impetus.blkch;


public class BlkchnException extends RuntimeException {

    private static final long serialVersionUID = -5744699391802604922L;
    
    public BlkchnException(){
        super();
    }
    
    public BlkchnException(Throwable e) {
        super(e);
    }
    
    public BlkchnException(String message) {
        super(message);
    }
    
    public BlkchnException(String msg, Throwable e){
        super(msg, e);
    }

}
