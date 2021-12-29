/*
 * Copyright (c) 2021 - present Pethum Jeewantha. All rights reserved.
 *  Licensed under the MIT License. See LICENSE.txt in the project root for license information.
 */

package com.pethumjeewantha.util;

public class NoSuchColumnException extends Exception {
    public NoSuchColumnException() {
        super();
    }

    public NoSuchColumnException(String message) {
        super(message);
    }
}
