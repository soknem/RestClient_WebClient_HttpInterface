package com.present3.rest_client_webcient_http_interface.rest_client.dto;

public record CategoryResponse(

        String id,
        String title,

        String icon,

        String description,

        Boolean isDeleted
) {
}
