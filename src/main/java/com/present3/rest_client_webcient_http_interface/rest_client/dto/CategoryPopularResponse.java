package com.present3.rest_client_webcient_http_interface.rest_client.dto;

import lombok.Builder;

@Builder
public record CategoryPopularResponse(

        String icon,

        String name,

        Long totalCourse
) {
}
