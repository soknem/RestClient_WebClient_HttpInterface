package com.present3.rest_client_webcient_http_interface.rest_client;

import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryPopularResponse;
import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryRequest;
import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryResponse;
import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryUpdateRequest;

import java.util.List;

public interface RestClientService {

    void createCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> getAllCategories();

    CategoryResponse getCategoryById(String id);

    CategoryResponse updateCategoryById(String id, CategoryUpdateRequest categoryUpdateRequest);

    void deleteCategoryById(String id);
}


