package com.present3.rest_client_webcient_http_interface.rest_client;

import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryPopularResponse;
import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryRequest;
import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryResponse;
import com.present3.rest_client_webcient_http_interface.rest_client.dto.CategoryUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class RestClientController {

    private final RestClientService restClientService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {

        restClientService.createCategory(categoryRequest);

    }

    @GetMapping
    public List<CategoryResponse> getAllCategories() {

        return restClientService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable String id) {

        return restClientService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryResponse updateCategoryById(@PathVariable String id,
                                               @Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        return restClientService.updateCategoryById(id, categoryUpdateRequest);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@PathVariable String id) {

        restClientService.deleteCategoryById(id);
    }

}
