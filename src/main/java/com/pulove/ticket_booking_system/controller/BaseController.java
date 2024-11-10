package com.pulove.ticket_booking_system.controller;

import com.pulove.ticket_booking_system.dto.MasterResponse;

public abstract class BaseController {

    public MasterResponse getSuccessResponse(Integer responseCode, String message, Object response) {
        return MasterResponse.builder()
                .statusCode(responseCode)
                .message(message)
                .data(response)
                .build();
    }
}
