/*
 * Copyright (c) 2021 - present Pethum Jeewantha. All rights reserved.
 *  Licensed under the MIT License. See LICENSE.txt in the project root for license information.
 */

package com.pethumjeewantha.util;

public class DuplicateIdException extends Exception {
    public DuplicateIdException() {
        super();
    }

    public DuplicateIdException(String message) {
        super(message);
    }
}
