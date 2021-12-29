/*
 * Copyright (c) 2021 - present Pethum Jeewantha. All rights reserved.
 *  Licensed under the MIT License. See LICENSE.txt in the project root for license information.
 */

package com.pethumjeewantha.util;

public class NoSuchTableException extends Exception {
    public NoSuchTableException() {
        super();
    }

    public NoSuchTableException(String message) {
        super(message);
    }
}
