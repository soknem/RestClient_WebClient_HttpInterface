package com.present3.rest_client_webcient_http_interface.rest_client;

import com.present3.rest_client_webcient_http_interface.exception.MyCustomRuntimeException;
import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryRequest;
import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryResponse;
import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestClientServiceImpl implements  RestClientService{

    private  final RestClient restClient = RestClient.builder()
            .baseUrl("http://68.183.187.158:7070/api/v1")
            .build();


    @Override
    public void createCategory(CategoryRequest categoryRequest) {

        restClient.post()
                .uri("/categories")
                .body(categoryRequest)
                .retrieve();

    }

    @Override
    public List<CategoryResponse> getAllCategories() {

        return restClient.get().
                uri("/categories")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    @Override
    public CategoryResponse getCategoryById(String id) {

        return restClient.get()
                .uri("/categories/{id}",id)
                .retrieve()
                .body(CategoryResponse.class);
    }

    public CategoryResponse sendRequest(CategoryRequest categoryRequest) {
        return restClient.post()
                .uri("/api/v1/resource")
                .header("Authorization", "Bearer myToken")
                .body(categoryRequest)
                .retrieve()
                .body(CategoryResponse.class);
    }

    @Override
    public CategoryResponse updateCategoryById(String id, CategoryUpdateRequest categoryUpdateRequest) {
        return restClient.patch()
                .uri("/categories/{id}",id)
                .body(categoryUpdateRequest)
                .retrieve()
                .body(CategoryResponse.class);
    }


    @Override
    public void deleteCategoryById(String id) {

        restClient.delete()
                .uri("/categories/{id}",id)
                .retrieve()
                .toBodilessEntity();

    }

}
