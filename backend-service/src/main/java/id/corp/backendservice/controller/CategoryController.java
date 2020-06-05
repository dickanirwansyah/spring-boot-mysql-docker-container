package id.corp.backendservice.controller;

import id.corp.backendservice.entity.Category;
import id.corp.backendservice.repository.CategoryRepository;
import id.corp.backendservice.request.RequestCategory;
import id.corp.backendservice.response.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping(value = "/save-category")
    public ResponseApi saveCategory(@RequestBody RequestCategory requestCategory){

        Category category = Category.builder()
                .name(requestCategory.getName())
                .status(requestCategory.isStatus())
                .createdAt(new Date())
                .updatedAt(null)
                .build();

        Category resultCategory = categoryRepository.save(category);

        return ResponseApi.builder()
                .status(HttpStatus.OK.value())
                .timestamp(new Date())
                .data(resultCategory)
                .message("success")
                .build();
    }

    @GetMapping(value = "/list-category")
    public ResponseApi listCategory(){

        List<Category> categoryList = categoryRepository.findAll();
        ResponseApi responseApi = null;

        if (!categoryList.isEmpty() && categoryList != null){
            responseApi = ResponseApi
                    .builder()
                    .data(categoryList)
                    .message("success")
                    .timestamp(new Date())
                    .status(HttpStatus.OK.value())
                    .build();
        }else{
             responseApi = ResponseApi
                    .builder()
                    .data(categoryList)
                    .message("failed")
                    .timestamp(new Date())
                    .status(HttpStatus.NOT_FOUND.value())
                    .build();
        }

        return responseApi;
    }
}
